
/**
 * Write a description of CodonCount here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import edu.duke.*;
public class CodonCount {
    
    private HashMap<String, Integer> dnaCodonCount;
    
    public CodonCount() {
        dnaCodonCount = new HashMap<String, Integer>();
        
    }
    
    public void buildCodonMap(int start, String dna) {
        dnaCodonCount.clear();
        for (int k = start; k + 2 < dna.length(); k += 3) {
            String codon = dna.substring(k, k + 3);
            if (dnaCodonCount.containsKey(codon)) {
                dnaCodonCount.put(codon, dnaCodonCount.get(codon) + 1);
            } else {
                dnaCodonCount.put(codon, 1);
            }
        }
    }
    
    public String getMostCommonCodon() {
        int maxCount = 0;
        String maxKey = "";
        for (String s: dnaCodonCount.keySet()) {
            if (maxCount < dnaCodonCount.get(s)) {
                maxCount = dnaCodonCount.get(s);
                maxKey = s;
            }
        }
        return maxKey;
    }
    
    public void printCodonCounts(int start, int end) {
        for (String s: dnaCodonCount.keySet()) {
            int count = dnaCodonCount.get(s);
            if (count >= start && count <= end) {
                System.out.println(s + " : " + count);
            }
        }
    }
    
    public void tester () {
        // prompts the user for a file that contains a DNA strand.
        FileResource fr = new FileResource();
        
        int start = 7;
        // int end = 5;
        int end = 7;
        
        for (String s : fr.lines()) {
            String dna = s.toUpperCase().trim();
            // for each of the three possible reading frames, 
            for (int k=0; k<3; k++) {
                // builds a HashMap of codons to their number of occurrences
                // in the DNA strand
                buildCodonMap(k, dna);
                // prints the total number of unique codons in the reading
                // frame
                System.out.println("Reading frame starting with "
                                    + k
                                    + " results in "
                                    + " " + dnaCodonCount.size()
                                    + " unique codons");
                // prints the most common codon and its count
                String largestKey = getMostCommonCodon();
                System.out.println("and most common codon is "
                                    + largestKey +" with count "
                                    + dnaCodonCount.get(largestKey));
                // prints the codons and their number of occurrences for
                // those codons whose number of occurrences in this reading
                // frame are between two numbers inclusive.
                System.out.println("Counts of codons between "
                                    + start + " and "
                                    + end + " inclusive are:");
                printCodonCounts(start, end);
                System.out.println("\n");
            }
        }
    }
    
}
