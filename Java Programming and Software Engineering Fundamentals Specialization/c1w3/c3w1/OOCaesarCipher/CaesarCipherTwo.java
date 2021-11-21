
/**
 * Write a description of CaesarCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarCipherTwo {
    
    private CaesarCipher cc1;
    private CaesarCipher cc2;
    
    public CaesarCipherTwo (int key1, int key2) {
        cc1 = new CaesarCipher(key1);
        cc2 = new CaesarCipher(key2);
    }
    
    public String encrypt(String input) {
        StringBuilder encryptedTwoKeys  = new StringBuilder(input);
        String encryptedKey1 = cc1.encrypt(input);
        String encryptedKey2 = cc2.encrypt(input);
        for (int i = 0; i < input.length(); i++) {
            if (i % 2 == 0) {
                char encryptedKey1Char = encryptedKey1.charAt(i);
                encryptedTwoKeys.setCharAt(i, encryptedKey1Char); 
            }
            else {
                char encryptedKey2Char = encryptedKey2.charAt(i);
                encryptedTwoKeys.setCharAt(i, encryptedKey2Char); 
            }
        }
        return encryptedTwoKeys.toString();
    }
    
    public String decrypt(String input) {
        StringBuilder decryptedTwoKeys  = new StringBuilder(input);
        String decryptedKey1 = cc1.decrypt(input);
        String decryptedKey2 = cc2.decrypt(input);
        for (int i = 0; i < input.length(); i++) {
            if (i % 2 == 0) {
                char decryptedKey1Char = decryptedKey1.charAt(i);
                decryptedTwoKeys.setCharAt(i, decryptedKey1Char); 
            }
            else {
                char decryptedKey2Char = decryptedKey2.charAt(i);
                decryptedTwoKeys.setCharAt(i, decryptedKey2Char); 
            }
        }
        return decryptedTwoKeys.toString();
    }
    
    
}
