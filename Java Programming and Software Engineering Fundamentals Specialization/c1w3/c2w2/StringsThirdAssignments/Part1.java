
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class Part1 {
    
    public int findStopCodon (String dna, int startIndex, String stopCodon) {
        int currentIndex = dna.indexOf(stopCodon, startIndex + 3);
        while (currentIndex != -1) {
            int diff = currentIndex - startIndex;
            if (diff % 3 == 0) {
                return currentIndex;
            } else {
                currentIndex = dna.indexOf(stopCodon, currentIndex + 1);
            }
        }
        return dna.length();
    }
    
    public String findGene(String dna, int startIndex) {
        int firstStartCodonIndex = dna.indexOf("ATG", startIndex); 
        if (firstStartCodonIndex == -1) {
            return "";
        }
        int TAAIndex = findStopCodon(dna, firstStartCodonIndex , "TAA");
        int TAGIndex = findStopCodon(dna, firstStartCodonIndex , "TAG");
        int TGAIndex = findStopCodon(dna, firstStartCodonIndex , "TGA");
        int minIndex = Math.min(Math.min(TAAIndex, TAGIndex), TGAIndex);
        if (minIndex == dna.length()) {
            return "";
        }
        return dna.substring(firstStartCodonIndex, minIndex + 3);
    }
    
    public void printAllGenes(String dna) {
        int startIndex = 0;
        while (true) {
            String currentGene = findGene(dna, startIndex);
            if (currentGene.isEmpty()) {
                break;
            }
            System.out.println("gene is " + currentGene);
            startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
        }
    }
    
    public StorageResource getAllGenes(String dna) {
        StorageResource geneList = new StorageResource();
        int startIndex = 0;
        while (true) {
            String currentGene = findGene(dna, startIndex);
            if (currentGene.isEmpty()) {
                break;
            }
            //System.out.println("gene is " + currentGene);
            geneList.add(currentGene);
            startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
        }
        return geneList;
    }
    
    public void testGetAllGenes() {
        StorageResource dnaStrings = new StorageResource();
        dnaStrings.add("ATGTAAGATGCCCTAGT");                            // 2 
        dnaStrings.add("ATGTAAGATGCCCTAGTCCATGCGCTGACCC");              // 3
        dnaStrings.add("ATGTAAGATGCCCTAGTCCATGCGCTGACCCATGCACTAG");     // 4
        dnaStrings.add("ATGATCATAAGAAGATAATAGAGGGCCATGTAA");            // 2
        for (String dna : dnaStrings.data()) {
            System.out.println("Testing getAllGenes on: " + dna);
            StorageResource genes = getAllGenes(dna);
            for (String g : genes.data()) {
                System.out.println(g);
            }
            System.out.println("-----------------------------");
        }
    }
    
}
