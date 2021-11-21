
/**
 * Write a description of CaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarCipher {
    
    private String alphabet;
    private String shiftedAlphabet;
    private int mainKey;
    
    public CaesarCipher(int key) {
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
        mainKey = key;
    }
    
    public String encrypt (String input) {
        StringBuilder encrypted = new StringBuilder(input);
        for (int i = 0; i < input.length(); i++) {
            char currentChar = encrypted.charAt(i);
            int index = alphabet.indexOf(Character.toUpperCase(currentChar));
            if (index != -1) {
                if (Character.isUpperCase(currentChar)) {
                    encrypted.setCharAt(i, shiftedAlphabet.charAt(index));
                }
                else {
                    encrypted.setCharAt(i, shiftedAlphabet.toLowerCase()
                                            .charAt(index));
                }
            }
        }
        return encrypted.toString();
        
    }
    
    public String decrypt(String encrypted) {
        CaesarCipher cc = new CaesarCipher(26 - mainKey);
        String decrypted = cc.encrypt(encrypted);
        return decrypted;
    }
}
