
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {

    public String findSimpleGene(String dna, String startCodon, String stopCodon) {
        
        dna = dna.toUpperCase();
        String result = "";
        
        int begIndex = dna.indexOf(startCodon);
        if (begIndex == -1) {
            return "Invalid start codon";
        }
        
        int endIndex = dna.indexOf(stopCodon, begIndex + 3);
        if (endIndex == -1) {
            return "Invalid stop codon";
        }
        
        if ((endIndex + 3 - begIndex) % 3 == 0) {
            result = dna.substring(begIndex, endIndex + 3);
            return result;
        } else {
            return "Invalid gene length";
        }

    }
    
    public void testSimpleGene() {
        // Create an array of dna strings for testing our code
        String[] test = {"ATGATATAA", "TAGGCATT", "AATGTGACAGTAA", "TTAGTTGCGACTACATT", "CGATGATGGGCATAAA", "taatgcgaacctaacaa"};
        String startCodon = "ATG";
        String stopCodon = "TAA";
        // Iterate through the strings in the array
        for (int i = 0; i < test.length; i++) {
            // Return a result string for each dna string
            String result = findSimpleGene(test[i], startCodon, stopCodon);
            System.out.println(result);
        }
    }
    
    public static void main (String[] args) {
        Part2 dna = new Part2();
        dna.testSimpleGene();
        
    }
}
