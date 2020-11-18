/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *ink
 * @author binh3920
 */

import java.io.*;
import java.util.List;
        
public class SlangWords {
    public static void main(String args[]) {
        Dictionary myDict = new Dictionary("../slang.txt");
        //System.out.println(myDict.getKey("money"));
        System.out.println(myDict.getKeyByDef("money"));
    }
  
}
