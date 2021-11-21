
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class Part3 {
    
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
    
    public void processGenes(StorageResource sr) {
        int count9C = 0;
        int countCG = 0;
        int LongestGeneLength = 0;
        int countGene = 0;
        
        for (String gene: sr.data()) {
            countGene++;
            if (gene.length() > 60) {
                System.out.println("String that are longer than 60 characters is " + gene);
                count9C++;
            }
            
            if (gene.length() > LongestGeneLength) {
                LongestGeneLength = gene.length();
            }
        }
        System.out.println("Number of string that are longer than 60 characters is " + count9C);
        System.out.println("----------------------------------------------------------");
        
        for (String gene: sr.data()) {
            float cgR = cgRatio(gene);
            if (cgR > 0.35) {
                System.out.println("String that cgRatio are higher than 0.35 is " + gene);
                countCG++;
            }
        
        }
        System.out.println("Number of string that are C-G-ratio is higher than 0.35 is " + countCG);
        System.out.println("----------------------------------------------------------");

        System.out.println("Length of longest Gene is " + LongestGeneLength);
        
        System.out.println("Number of genes in the file " + countGene);
        
    }
    
    public void testProcessGenesWithFile() {
        // Call Part1 class
        Part1 part1 = new Part1();
        Part2 part2 = new Part2();
        // You can use a FileResource to open the file and the
        // FileResource method asString to convert the contents of
        // the file to a single string so that you can use it
        FileResource fr = new FileResource("GRch38dnapart.fa");
        String dna = fr.asString();
        dna = dna.toUpperCase();
        System.out.println("Testing dna is " + dna);
        StorageResource store = part1.getAllGenes(dna);
        processGenes(store);
        
        System.out.println("Number of CTG in the file " + part2.countCTG(dna));
    }
}
