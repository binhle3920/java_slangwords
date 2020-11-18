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
    LinkedHashMap<String, List<String>> dictionary = new LinkedHashMap<>();
    public Dictionary (String file_path) {
        try {
            FileInputStream fin = new FileInputStream(file_path);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fin));
            
            while(reader.ready()) {
                String line = reader.readLine();
                String slang = getSlang(line);
                List<String> words = new ArrayList<String>();
                words = getWords(line);
                dictionary.put(slang, words);
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
    private List<String> getWords(String line) {
        int pos = line.indexOf("`");
        String words = line.substring(pos+1);
        List<String> listWords = new ArrayList<String>();
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
    public List<String> getValue(String key) {
        return dictionary.get(key);
    }
    public String getKey(List<String> value) {
        return dictionary.getKey(value);
    }
}
