
public class WordGram {
    private String[] myWords;
    private int myHash;

    public WordGram(String[] source, int start, int size) {
        myWords = new String[size];
        System.arraycopy(source, start, myWords, 0, size);
    }

    public String wordAt(int index) {
        if (index < 0 || index >= myWords.length) {
            throw new IndexOutOfBoundsException("bad index in wordAt "+index);
        }
        return myWords[index];
    }

    public int length(){
        // TODO: Complete this method
        return myWords.length;
    }

    public String toString(){
        String ret = "";
        // TODO: Complete this method

        for (String s: myWords) {
            ret += s + " ";
        }
        return ret.trim();
    }

    public boolean equals(Object o) {
        WordGram other = (WordGram) o;
        // TODO: Complete this method
        
        if (this.length() != other.length()) {
            return false;
        }
        for (int k = 0; k < this.length(); k++) {
            if (!other.wordAt(k).equals(this.wordAt(k))) {
                return false;
            }
        }
        return true;

    }

    public WordGram shiftAdd(String word) { 
        String[] out = new String[myWords.length];
        // shift all words one towards 0 and add word at the end. 
        // you lose the first word
        // TODO: Complete this method
        if (myWords.length == 0) {
            return new WordGram(out, 0, out.length);
        }
        for (int k = 0; k < out.length-1; k++) {
            out[k] = myWords[k+1];
        }
        out[out.length-1] = word;
        return new WordGram(out, 0, out.length);
    }
    
    public int hashCode() {
        String stringWG = this.toString();
        return stringWG.hashCode();
    }

}