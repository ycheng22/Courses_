
/**
 * Write a description of WordFrequencies here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.*;
public class WordFrequencies {
    
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    
    public WordFrequencies() {
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
        
    }
    
    public void findUnique() {
        myWords.clear();
        myFreqs.clear();
        FileResource resource = new FileResource();
        for (String word: resource.words()) {
            word = word.toLowerCase();
            int index = myWords.indexOf(word);
            if (index == -1) {
                myWords.add(word);
                myFreqs.add(1);
            } else {
                int freq = myFreqs.get(index);
                myFreqs.set(index, freq + 1);
            }
        }
    }
    
    public int findIndexOfMax() {
        int maxFreq = 0;
        int maxIndex = 0;
        for (int k = 0; k < myFreqs.size(); k++) {
            if (maxFreq < myFreqs.get(k)) {
                maxFreq = myFreqs.get(k);
                maxIndex = k;
            }
        }
        return maxIndex;
    }
    
    public void tester() {
        findUnique();
        for (int k = 0; k < myFreqs.size(); k++) {
            System.out.println(myFreqs.get(k) + " : " + myWords.get(k));
        }
        System.out.println("Num of unique words " + myWords.size());
        int indexOfMax = findIndexOfMax();
        System.out.println(myWords.get(indexOfMax) + " has highest frequency " + myFreqs.get(indexOfMax));
    }
    
}
