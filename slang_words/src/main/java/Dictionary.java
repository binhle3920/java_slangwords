/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author binh3920
 */
public class Dictionary {
    private LinkedHashMap<String, ArrayList<String>> dictionary = new LinkedHashMap<>();
    private LinkedHashMap<String, ArrayList<String>> revDict = new LinkedHashMap<>();
    private ArrayList<String> history = new ArrayList<String>();
    
    public Dictionary (String file_path) {
        try {
            FileInputStream fin = new FileInputStream(file_path);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fin));
            
            while(reader.ready()) {
                String line = reader.readLine();
                String slang = getSlang(line).toLowerCase();
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
        String words = line.substring(pos+1).toLowerCase();
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
    public List<String> getValue(String key) {
        history.add(key);
        return dictionary.get(key);
    }
    public List<String> getKey(String value) {
        history.add(value);
        return revDict.get(value);
    }
    public List<String> getKeyByDef(String value) {
        List<String> listVal = new ArrayList<>();
        for (String key : revDict.keySet()) {
            if (key.contains(value)) {
                System.out.println(key);
                for (String val : revDict.get(key)) {
                    listVal.add(val);
                }
            }
        }
        return listVal;
    }
    public ArrayList<String> getHistory() {
        return history;
    }
}
