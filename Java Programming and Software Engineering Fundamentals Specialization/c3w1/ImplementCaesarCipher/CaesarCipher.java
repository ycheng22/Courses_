
/**
 * Write a description of CaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;

public class CaesarCipher {
    public String encrypt(String input, int key) {
        StringBuilder encrypted = new StringBuilder(input);
        String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabets = alphabets.substring(key) + alphabets.substring(0, key);
        for (int i = 0; i < input.length(); i++) {
            char currentChar = encrypted.charAt(i);
            int index = alphabets.indexOf(Character.toUpperCase(currentChar));
            if (index != -1) {
                if (Character.isUpperCase(currentChar)) {
                    encrypted.setCharAt(i, shiftedAlphabets.charAt(index));
                } else {
                    encrypted.setCharAt(i, shiftedAlphabets.toLowerCase().charAt(index));
                }
            }
        }
        return encrypted.toString();
    }

    public String encryptTwoKeys(String input, int key1, int key2) {
        StringBuilder encryptedTwoKeys = new StringBuilder(input);
        String encryptedKey1 = encrypt(encryptedTwoKeys.toString(), key1);
        String encryptedKey2 = encrypt(encryptedTwoKeys.toString(), key2);
        for (int i = 0; i < input.length(); i++) {
            if (i % 2 == 0) {
                char encryptedKey1Char = encryptedKey1.charAt(i);
                encryptedTwoKeys.setCharAt(i, encryptedKey1Char);
            } else {
                char encryptedKey2Char = encryptedKey2.charAt(i);
                encryptedTwoKeys.setCharAt(i, encryptedKey2Char);
            }
        }
        return encryptedTwoKeys.toString();
    }
    
    
    public void testCaesar () {
        //FileResource fr = new FileResource();
        //String message = fr.asString();
        String message = "At noon be in the conference room with your hat on for a surprise party. YELL LOUD!";
        int key = 15;
        String encrypted = encrypt(message, key);
        System.out.println("key is " + key + "\n" + encrypted);
    }
    
    public void testEncryptTwoKeys () {
        String input = "First Legion";
        int key1 = 23;
        int key2 = 17;
        System.out.println("input is " + input);
        System.out.println("key1 is " + key1);
        System.out.println("key2 is " + key2);
        System.out.println("encryption is " + encryptTwoKeys(input, key1, key2));
        System.out.println("answer is     Czojq Ivdzle");
        
        // quiz
        input = "At noon be in the conference room with your hat on for a surprise party. YELL LOUD!";
        key1 = 8;
        key2 = 21;
        System.out.println("input is " + input);
        System.out.println("key1 is " + key1);
        System.out.println("key2 is " + key2);
        System.out.println("encryption is " + encryptTwoKeys(input, key1, key2));
    }
}
