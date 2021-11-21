
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
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
        int TAAIndex = findStopCodon(dna, firstStartCodonIndex, "TAA");
        int TAGIndex = findStopCodon(dna, firstStartCodonIndex, "TAG");
        int TGAIndex = findStopCodon(dna, firstStartCodonIndex, "TGA");
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
    
    public int countGenes(String dna) {
        int startIndex = 0;
        int count = 0;
        while (true) {
            String currentGene = findGene(dna, startIndex);
            if (currentGene.isEmpty()) {
                break;
            }
            System.out.println("gene is " + currentGene);
            count++;
            startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
        }
        return count;
    }
    
    public void testCountGenes() {
        // This method calls countGenes with many example strings and 
        // prints the result for each.
        String dna = "ATGxxxTAAxxxATGxxxyyyzzzTGAxxx";
        System.out.println("Testing countGenes on " + dna);
        System.out.println("The number of genes is " + countGenes(dna));
        
        dna = "";
        System.out.println("Testing countGenes on " + dna);
        System.out.println("The number of genes is " + countGenes(dna));
        
        dna = "ATGxxxyyyzzzTAGxxxyyyATGxxTAAxyyyzzzATGTAA";
        System.out.println("Testing countGenes on " + dna);
        System.out.println("The number of genes is " + countGenes(dna));
        
        dna = "ATGTAAGATGCCCTAGTCCATGCGCTGACCC";
        System.out.println("Testing countGenes on " + dna);
        System.out.println("The number of genes is " + countGenes(dna));
    }
}
