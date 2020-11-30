/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author binh3920
 */
public class Dictionary {
    private LinkedHashMap<String, ArrayList<String>> dictionary = new LinkedHashMap<>();
    private LinkedHashMap<String, ArrayList<String>> revDict = new LinkedHashMap<>();
    
    public Dictionary (String file_path) {
        readFile(file_path);
    }
    
    private void readFile(String file_path) {
        try {
            FileInputStream fin = new FileInputStream(file_path);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fin));
            
            while(reader.ready()) {
                String line = reader.readLine().toLowerCase();
                String slang = getSlang(line);
                ArrayList<String> words = new ArrayList<String>();
                words = getWords(line);
                dictionary.put(slang, words);
                reverseDictionary(slang, words);
            }
        } catch (IOException ex) {
            Logger.getLogger(SlangWords.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private String getSlang(String line) {
        int pos = line.indexOf("`");
        if (pos != -1) {
            return line.substring(0, pos);
        } else {
            System.out.println(line);
            return "";
        }
    }
    private ArrayList<String> getWords(String line) {
        int pos = line.indexOf("`");
        String words = line.substring(pos+1);
        ArrayList<String> listWords = new ArrayList<String>();
        while(true) {
            pos = words.indexOf("|");
            if (pos == -1) {
                listWords.add(words);
                return listWords;
            } else {
                listWords.add(words.substring(0, pos));
                words = words.substring(pos+2);
            }
        }
    }
    
    private void reverseDictionary(String slang, List<String> words) {
        words.forEach(temp -> {
            if (revDict.containsKey(temp)) {
                List<String> tempList = revDict.get(temp);
                if (!tempList.contains(slang)) {
                    tempList.add(slang);
                }
            } else {
                ArrayList<String> listWords = new ArrayList<>();
                listWords.add(slang);
                revDict.put(temp, listWords);
            }
        });
    }
    
    private void removeKeyInReverseDict(String slang, String val) {
        ArrayList<String> listVal = revDict.get(val);
        if (listVal.contains(slang)) {
            if (listVal.size() == 1) {
                revDict.remove(val);
            } else {
                listVal.remove(slang);

            }
        }
    }
    
    public boolean contains(String key) {
        if (dictionary.containsKey(key)) {
            return true;
        }
        return false;
    }
    
    //Find slang or definition
    public List<String> getValue(String key) {
        return dictionary.get(key);
    }
    public List<String> getKey(String value) {
        return revDict.get(value);
    }
    public List<String> getKeyByDef(String value) {
        List<String> listVal = new ArrayList<>();
        for (String key : revDict.keySet()) {
            if (key.contains(value)) {
                revDict.get(key).forEach(val -> {
                    listVal.add(val);
                });
            }
        }
        return listVal;
    }
    
    //Add slang to dictionary
    public void addSlangDuplicate(String slang, ArrayList<String> definition) {
        ArrayList<String> listVal = dictionary.get(slang);
        definition.forEach(val -> {
            if (!listVal.contains(val)) {
                listVal.add(val);
            }
        });
        reverseDictionary(slang, definition);
    }
    
    public void addSlangOverwrite(String slang, ArrayList<String> definition) {
        ArrayList<String> listVal = dictionary.get(slang);
        listVal.forEach(val -> {
            removeKeyInReverseDict(slang, val);
        });
        dictionary.replace(slang, definition);
        reverseDictionary(slang, definition);
    }
    
    public void addSlang(String slang, ArrayList<String> definition) {
        dictionary.put(slang, definition);
        reverseDictionary(slang, definition);
    }
    
    //Edit slang
    public boolean addDef(String slang, String def) {
        if (!dictionary.containsKey(slang)) {
            return false;
        }
        dictionary.get(slang).add(def);
        if (revDict.containsKey(def)) {
            if (!revDict.get(def).contains(slang)) {
                revDict.get(def).add(slang);
            }
        } else {
            ArrayList<String> listWords = new ArrayList<>();
            listWords.add(slang);
            revDict.put(def, listWords);
        }
        return true;
    }
    
    public boolean removeDef(String slang, String def) {
        if (!dictionary.containsKey(slang)) {
            return false;
        }
        if (dictionary.get(slang).contains(def)) {
            dictionary.get(slang).remove(def);
            removeKeyInReverseDict(slang, def);
        } else {
            return false;
        }
        return true;
    }
    public boolean editSlang(String slang, String newSlang) {
        if (!dictionary.containsKey(slang)) {
            return false;
        } else {
            dictionary.put(newSlang, dictionary.get(slang));
            dictionary.remove(slang);
            dictionary.get(newSlang).forEach(val -> {
                revDict.get(val).remove(slang);
                revDict.get(val).add(newSlang);
            });
            return true;
        }
    }
    
    //Delete a slang word
    public boolean deleteSlang(String slang) {
        if (!dictionary.containsKey(slang)) {
            return false;
        } else {
            dictionary.get(slang).forEach(val -> {
                removeKeyInReverseDict(slang, val);
            });
            dictionary.remove(slang);
            return true;
        }
    }
    
    //Random slang
    public String randomSlang() {
        List<String> list = new ArrayList<>(dictionary.keySet());
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }
    
    //Reset
    public boolean resetDictionary() {
        dictionary.clear();
        readFile("../slang.txt");
        return true;
    }
    
    //Save data
    public void saveDictionary(String file_path) {
        FileWriter fout;
      
        try {
            fout = new FileWriter(file_path);
            
            dictionary.forEach((key, value) -> {
                try {
                    fout.write(key + "`");
                    if (value.size()>1) {
                        value.forEach(val -> {
                            try {
                                if (val.equals(value.get(value.size() - 1))) {
                                    fout.write(val);
                                } else {
                                    fout.write(val + "| ");
                                }
                            } catch (IOException ex) {
                                Logger.getLogger(Dictionary.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        });
                    } else {
                        fout.write(value.get(0));
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Dictionary.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    fout.write(System.getProperty("line.separator"));
                    fout.flush();
                } catch (IOException ex) {
                    Logger.getLogger(Dictionary.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        } catch (IOException ex) {
            Logger.getLogger(SlangWords.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}