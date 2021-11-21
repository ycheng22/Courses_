
/**
 * Write a description of WordPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordPlay {

    public boolean isVowel(char ch) {
        char upperCh = Character.toUpperCase(ch);
        String vowel = "AEIOU";
        int index = vowel.indexOf(upperCh);
        if (index != -1) {
            return true;
        }
        return false;
    }
    
    public String replaceVowels (String phrase, char ch) {
        StringBuilder replacedPhrase = new StringBuilder(phrase);
        for (int i = 0; i < phrase.length(); i++) {
            char phraseCh = replacedPhrase.charAt(i);
            if (isVowel(phraseCh)) {
                replacedPhrase.setCharAt(i, ch);
            }
        }
        return replacedPhrase.toString();
    }
    
    public String emphasize (String phrase, char ch) {
        StringBuilder emphasizedPhrase = new StringBuilder(phrase);
        for (int i = 0; i < phrase.length(); i++) {
            char phraseCh = emphasizedPhrase.charAt(i);
            if (phraseCh == Character.toUpperCase(ch) || phraseCh == Character.toLowerCase(ch)) {
                if (i % 2 == 0) {
                    emphasizedPhrase.setCharAt(i, '*');
                } else {
                    emphasizedPhrase.setCharAt(i, '+');
                }
            }
        }
        return emphasizedPhrase.toString();
    }
    
    public void testIsVowel () {
        char ch = 'F';
        System.out.println("one char is " + ch);
        System.out.println("result is " + isVowel(ch));
        
        ch = 'f';
        System.out.println("one char is " + ch);
        System.out.println("result is " + isVowel(ch));
        
        ch = 'a';
        System.out.println("one char is " + ch);
        System.out.println("result is " + isVowel(ch));
        
        ch = ' ';
        System.out.println("one char is " + ch);
        System.out.println("result is " + isVowel(ch));
    }
    
    public void testReplaceVowels () {
        String phrase = "Hello World";
        char ch = '#';
        System.out.println("input phrase is " + phrase);
        System.out.println("vowels replaced by " + ch);
        System.out.println("replaced phrase is " + replaceVowels(phrase, ch));
        
        phrase = "HELLO WORLD!";
        ch = '*';
        System.out.println("input phrase is " + phrase);
        System.out.println("vowels replaced by " + ch);
        System.out.println("replaced phrase is " + replaceVowels(phrase, ch));
    }
    
    public void testEmphasize () {
        String phrase = "dna ctgaaactga";
        char ch = 'a';
        System.out.println("input phrase is " + phrase);
        System.out.println("vowels replaced by " + ch);
        System.out.println("emphasized phrase is " + emphasize(phrase, ch));
        System.out.println("answer is            dn* ctg+*+ctg+");
        
        phrase = "Mary Bella Abracadabra";
        ch = 'a';
        System.out.println("input phrase is " + phrase);
        System.out.println("vowels replaced by " + ch);
        System.out.println("emphasized phrase is " + emphasize(phrase, ch));
        System.out.println("answer is            M+ry Bell+ +br*c*d*br+");
    }
}
