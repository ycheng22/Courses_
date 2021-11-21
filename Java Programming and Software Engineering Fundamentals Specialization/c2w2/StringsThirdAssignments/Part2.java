
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class Part2 {

    public float cgRatio(String dna) {
        int indexC = 0;
        int indexG = 0;
        int cCount = 0;
        int gCount = 0;
        String DNA = dna.toUpperCase();
        while(true) {
            indexC = DNA.indexOf("C", indexC);
            if (indexC == -1) {
                break;
            }
            cCount++;
            indexC++;
        }
        
        while(true) {
            indexG = DNA.indexOf("G", indexG);
            if (indexG == -1) {
                break;
            }
            gCount++;
            indexG++;
        }
        
        float cgR = ((float)cCount + gCount) / dna.length();
        return cgR;
    }
    
    public int countCTG(String dna) {
        int count = 0;
        int startIndex = 0;
        String DNA = dna.toUpperCase();
        while (true) {
            int currentIndex = DNA.indexOf("CTG", startIndex);
            if(currentIndex == -1) {
                break;
            }
            count++;
            startIndex = currentIndex + 3;
        }
        return count;
    }
    
    public void testCGRatio() {
        String dna = "ATGCCATAG"; // 4/9=0.4444
        System.out.println("Testing dna is " + dna);
        float cgR = cgRatio(dna);
        System.out.println("CGs ratio is " + cgR);
    }
    
    public void testCountCTG() {
        String dna = "ATGCCATAG";
        System.out.println("Testing dna is " + dna);
        int countCTG = countCTG(dna);
        System.out.println("the number of CTG is " + countCTG);
        
        dna = "";
        System.out.println("Testing dna is " + dna);
        countCTG = countCTG(dna);
        System.out.println("the number of CTG is " + countCTG);
        
        dna = "ATGxxxCTGxxxyyyzzzCTG";
        System.out.println("Testing dna is " + dna);
        countCTG = countCTG(dna);
        System.out.println("the number of CTG is " + countCTG);
    }
}
