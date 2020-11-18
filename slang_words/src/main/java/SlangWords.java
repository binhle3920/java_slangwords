/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author binh3920
 */

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ArrayList;
        
public class SlangWords {
    public static void main(String args[]) {
        LinkedHashMap<String, List<String>> dictionary = new LinkedHashMap<String, List<String>>();
        try {
            FileInputStream fin = new FileInputStream("../slang.txt");
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
        
        System.out.println(dictionary);
    }
    private static String getSlang(String line) {
        int pos = line.indexOf("`");
        if (pos != -1) {
            return line.substring(0, pos);
        } else {
            System.out.println(line);
            return "";
        }
    }
    private static List<String> getWords(String line) {
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
    
}
