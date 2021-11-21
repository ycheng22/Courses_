
/**
 * Write a description of WordLengths here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class WordLengths {

    public void countWordLengths (FileResource resource, int[] counts) {
        for (String word: resource.words()) {
            StringBuilder sb = new StringBuilder(word);
            int len = sb.length();
            
            if (!Character.isLetter(sb.charAt(0))) {
                sb.deleteCharAt(0);
            } else if (!Character.isLetter(sb.charAt(len - 1))) {
                sb.deleteCharAt(len - 1);
            }
            
            len = sb.length();
            if (len >= counts.length) {
                counts[counts.length - 1] += 1;
            } else {
                counts[len] += 1;
            }
        }
        for (int i = 0; i < counts.length; i++) {
            System.out.println(counts[i] + " words of length " + i);
        }
        
    }
    
    public int maxIndex (int [] vals) {
        int maxIdx = 0;
        for (int k=0; k<vals.length; k++) {
            if (vals[k] > vals[maxIdx]) {
                maxIdx = k;
            }
        }
        return maxIdx;
    }
    
    public void testCountWordLengths () {
        FileResource resource = new FileResource();
        int[] counts = new int[31];
        countWordLengths(resource, counts);
        
        int mostCommonLen = maxIndex(counts);
        System.out.println("Most common word length: " + mostCommonLen);
    }
}
