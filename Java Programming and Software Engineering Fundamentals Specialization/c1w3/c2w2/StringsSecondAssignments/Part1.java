
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
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
    
    
    public void testFindStopCodon() {
        System.out.println(findStopCodon("ATGTAA", 0,"TAA"));                       // Should return 3
        System.out.println(findStopCodon("ATGCGCTGCCAGGATTAA", 0,"TAA"));           // 15
        System.out.println(findStopCodon("ATGCGCTGCCAGGATTAGCGA", 0,"TAG"));        // 15
        System.out.println(findStopCodon("ATGTGAAATTTTATGGCGTGCTGAAGG", 6,"TGA"));  // 21
        System.out.println(findStopCodon("ATGTGAAATTTTATGGCGTGCTGAAGG", 5,"TGA"));  // 27
        System.out.println("------------END-----------");
    }

    public void testFindGene() {
        String dna = "ATGCCCGGGAAATAACCC";
        String gene = findGene(dna, 0);
        if (!gene.equals("ATGCCCGGGAAATAA")) {
            System.out.println("error");
        }
        System.out.println("tests complete");
        System.out.println("ATGCCCGGGAAATAA");
    }
    
    public void testprintAllGenes() {
        String gene1 = "ATGATCATAAGAAGATAATAGAGGGCCATGTAA";
        System.out.println("Testing on: " + gene1);
        printAllGenes(gene1);
        String gene2 = "";
        System.out.println("Testing on: " + gene2);
        printAllGenes(gene2);
    }
}
