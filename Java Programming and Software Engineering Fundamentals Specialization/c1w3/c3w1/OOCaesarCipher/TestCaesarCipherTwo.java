
/**
 * Write a description of TestCaesarCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class TestCaesarCipherTwo {
    
    private String halfOfString (String message, int start) {
        String answer = "";
        for (int k = start; k< message.length() ; k+= 2) {
            answer = answer + message.charAt(k);    	
        }
        return answer;
    }
    
    private int[] countLetters (String message) {
        String alph = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        for(int k=0; k < message.length(); k++) {
            char ch = Character.toLowerCase(message.charAt(k));
            int dex = alph.indexOf(ch);
            if (dex != -1) {
                counts[dex] += 1;
            }
        }
        return counts;
    }
    
    private int getKey (String s) {
        int[] freqs = countLetters(s);
        int maxDex = maxIndex (freqs);
        int dkey = maxDex - 4;
        if (maxDex < 4) {
            dkey = 26 - (4 - maxDex);
        }
        
        return dkey;
    }
    
    private int maxIndex (int[] vals) {
        int maxIndex = 0;
        for (int k=0; k < vals.length; k++) {
            // consider maxIndex so vals[maxIndex] rather than maxIndex
            if (vals[maxIndex] < vals[k]) {
                // And k rather than vals[k]
                maxIndex = k;
            }
        }
        return maxIndex;
    }
    
    public String breakCaesarCipher(String input) {
        String firstHalfOfString = halfOfString(input, 0);
        String secondHalfOfString = halfOfString(input, 1);
        int firstDKey = getKey(firstHalfOfString);
        int secondDKey = getKey(secondHalfOfString);
        System.out.println("Found keys are " + firstDKey + ", " + secondDKey);
        CaesarCipherTwo cct = new CaesarCipherTwo(firstDKey, secondDKey);
        String decrypted = cct.decrypt(input);
        return decrypted;
    }
    
    public void simpleTests () {
        // read in a file as a String
        FileResource fr = new FileResource();
        String input = fr.asString();
        // create a CaesarCipherTwo object with keys 17 and 3
        CaesarCipherTwo cct = new CaesarCipherTwo(17, 3);
        // encrypt the String using the CaesarCipherTwo object
        String encrypted = cct.encrypt(input);
        // print the encrypted String
        System.out.println("encrypted: \n" + encrypted);
        // decrypt the encrypted String using the decrypt method.
        String decrypted = cct.decrypt(encrypted);
        // print the decrypted String
        System.out.println("decrypted: \n" + decrypted);
        // add a call to breakCaesarCipher on the encrypted String to decrypt it
        // automatically by determining the keys
        decrypted = breakCaesarCipher(encrypted);
        // print the decrypted String.
        System.out.println("decrypted with breakCaesarCipher \n" + decrypted);
        
        cct = new CaesarCipherTwo(8, 7);
        
        System.out.println("\n\n\n");
        decrypted = breakCaesarCipher(input);
        System.out.println("decrypted: " + decrypted);
        
        // review quiz 2
        input = "Can you imagine life WITHOUT the internet AND computers in your pocket?";
        cct = new CaesarCipherTwo(21, 8);
        encrypted = cct.encrypt(input);
        System.out.println("input: \n"+ input);
        System.out.println("encrypted: \n" + encrypted);
        
        // review quiz 6
        encrypted = "Hfs cpwewloj loks cd Hoto kyg Cyy.";
        cct = new CaesarCipherTwo(14, 24);
        decrypted = cct.decrypt(encrypted);
        System.out.println("encrypted: \n"+ encrypted);
        System.out.println("decrypted: \n" + decrypted);
        
        // review quiz 7
        encrypted = "Aal uttx hm aal Qtct Fhljha pl Wbdl. Pvxvxlx!";
        decrypted = breakCaesarCipher(encrypted);
        System.out.println(decrypted);
        System.out.println("encrypted: \n"+ encrypted);
        System.out.println("decrypted: \n" + decrypted);
    }
}
