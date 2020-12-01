package mypackage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *ink
 * @author binh3920
 */

public class SlangWords {
    public static void main(String args[]) {    
        Dictionary myDict = new Dictionary("./data.txt");
        JFrame mainFrame = new JFrame(myDict);
        mainFrame.show();
        
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                myDict.saveDictionary("./data.txt");
                System.out.println("Program exitted.");
            }
        }));
        
    }
}
