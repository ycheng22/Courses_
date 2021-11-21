
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {

    public String findSimpleGene(String dna) {
        String result = "";
        
        int begIndex = dna.indexOf("ATG");
        if (begIndex == -1) {
            return "Invalid start codon";
        }
        
        int endIndex = dna.indexOf("TAA", begIndex + 3);
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
        String[] test = {"ATGATATAA", "TAGGCATT", "AATGTGACAGTAA", "TTAGTTGCGACTACATT", "CGATGATGGGCATAAA"};
        for (int i = 0; i < test.length; i++) {
            String result = findSimpleGene(test[i]);
            System.out.println(result);
        }
    }
    
    public static void main (String[] args) {
        Part1 dna = new Part1();
        dna.testSimpleGene();
        
    }
}
