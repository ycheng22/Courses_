
/**
 * Write a description of CharactersInPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.*;
public class CharactersInPlay {
    
    private ArrayList<String> namesOfCharacters;
    private ArrayList<Integer> countsOfCharacter;
    
    public CharactersInPlay() {
        namesOfCharacters = new ArrayList<String>();
        countsOfCharacter = new ArrayList<Integer>();
    }
    
    public void update(String person) {
        int index = namesOfCharacters.indexOf(person);
        if (index == -1) {
            namesOfCharacters.add(person);
            countsOfCharacter.add(1);
        } else {
            int value = countsOfCharacter.get(index);
            countsOfCharacter.set(index, value + 1);
        }
    }
    
    public void findAllCharacters() {
        namesOfCharacters.clear();
        countsOfCharacter.clear();
        FileResource fr = new FileResource();
        
        for (String ln: fr.lines()) {
            int indexOfPeriod = ln.indexOf(".");
            if (indexOfPeriod != -1) {
                String name = ln.substring(0, indexOfPeriod).trim();
                update(name);
            }
        }
    }
    
    public void charactersWithNumParts(int num1, int num2) {
        for (int k = 0; k < namesOfCharacters.size(); k++) {
            int count = countsOfCharacter.get(k);
            if (count >= num1 && count <= num2) {
                System.out.println(namesOfCharacters.get(k) + " "
                            + countsOfCharacter.get(k));
            }
        }
    }
    
    public int findIndexOfMax() {
        int maxFreq = 0;
        int maxIndex = 0;
        for (int k = 0; k < countsOfCharacter.size(); k++) {
            if (maxFreq < countsOfCharacter.get(k)) {
                maxFreq = countsOfCharacter.get(k);
                maxIndex = k;
            }
        }
        return maxIndex;
    }
    
    public void tester() {
        findAllCharacters();
        for (int k = 0; k < namesOfCharacters.size(); k++) {
            if (countsOfCharacter.get(k) > 1) {
                System.out.println(namesOfCharacters.get(k) + " "
                            + countsOfCharacter.get(k));
            }
        }
        System.out.println("-------------------\n");
        int indexOfMax = findIndexOfMax();
        System.out.println(namesOfCharacters.get(indexOfMax) + " speaks most " + countsOfCharacter.get(indexOfMax));
        System.out.println("-------------------\n");
        System.out.println("charactersWithNumParts \n");
        charactersWithNumParts(10, 15);
    }

}
