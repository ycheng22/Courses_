
/**
 * Write a description of WordsInFiles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import java.io.File;
import edu.duke.*;
public class WordsInFiles {

    private HashMap<String, ArrayList<String>> wordsInFilesMap; //word: ArrayList of filenames
    
    public WordsInFiles() { 
        wordsInFilesMap = new HashMap<String, ArrayList<String>>();
    }
    
    private void addWordsFromFile(File f) {
        FileResource fr = new FileResource(f);
        for (String word: fr.words()) {
            //if keys include word 
            if (wordsInFilesMap.containsKey(word)) {
                int index = wordsInFilesMap.get(word).indexOf(f.getName());
                if (index == -1) {
                    wordsInFilesMap.get(word).add(f.getName());
                }
            } else {
                wordsInFilesMap.put(word, new ArrayList<String>());
                wordsInFilesMap.get(word).add(f.getName());
            }
        }
    }
    
    private void buildWordFileMap() {
        wordsInFilesMap.clear();
        
        DirectoryResource dr = new DirectoryResource();
        for (File f: dr.selectedFiles()) {
            addWordsFromFile(f);
        }
    }
    
    private int maxNumber() {
        int maxNum = 0;
        for (ArrayList<String> als: wordsInFilesMap.values()) {
            if (als.size() > maxNum) {
                maxNum = als.size();
            }
        }
        return maxNum;
    }
    
    private ArrayList<String> wordsInNumFiles(int number) {
        ArrayList<String> wordsInNumFiles = new ArrayList<String>();
        for (String s: wordsInFilesMap.keySet()) {
            if (wordsInFilesMap.get(s).size() == number) {
                wordsInNumFiles.add(s);
            }
        }
        return wordsInNumFiles;
    }
    
    private void printFilesIn(String word) {
        for (String s: wordsInFilesMap.keySet()) {
            if (s.equals(word)) {
                ArrayList<String> fileNamesOfWord = wordsInFilesMap.get(s);
                for (String fileName: fileNamesOfWord) {
                    System.out.println("word " + word + "appears in files: " + fileName);
                }
            }
        }
    }
    
    public void tester () {
        // call buildWordFileMap to select a group of files and build a
        // HashMap of words
        buildWordFileMap();
        
        // determine the maximum number of files any word is in
        int maxNumber = maxNumber();
        System.out.println("The greatest number of files a word appears in is "
                            + maxNumber);
        // determine all the words that are in the maximum number of files
        // and for each such word
        ArrayList<String> wordsInNumFiles = wordsInNumFiles(maxNumber);
        System.out.print("and there are "
                            + wordsInNumFiles.size()
                            + " such words: \n");
        for (String s : wordsInNumFiles) {
            System.out.print(" \"" + s + "\" ");
        }
        System.out.print("\n");
        /* comment outed
        // print the filenames of the files it is in
        for (String s : wordsInNumFiles) {
            System.out.println(" \"" + s + "\" " + " appears in the files: ");
            printFilesIn(s);
            System.out.print("\n");
        }
        */
       
        // How many words are there that each appear in four of the five files?
        wordsInNumFiles = wordsInNumFiles(7);
        System.out.print("and there are "
                            + wordsInNumFiles.size()
                            + " such words, number=4 \n");
        for (String s : wordsInNumFiles) {
            System.out.print(" \"" + s + "\" ");
        }
        System.out.print("\n");
        // print the filenames of the files it is in
        for (String s : wordsInNumFiles) {
            if (s.equals("sea")) {
                System.out.println(" \"" + s + "\" " + " appears in the files: ");
                printFilesIn(s);
                System.out.print("\n");
            }
        }
        
        // (optional) print out the complete map, all the keys, and for
        // each key its ArrayList
        /* comment outed
        for (String s : wordsInFilesMap.keySet()) {
            System.out.println("Key: " + "\"" + s + "\" ");
            System.out.print("File Names: ");
            for (String fileName : wordsInFilesMap.get(s)) {
                System.out.print(" \"" + fileName + "\" ");
            }
            System.out.print("\n\n");
        } 
        */
    }
    
}
