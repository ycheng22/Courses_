
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    
    public boolean twoOccurrences(String stringa, String stringb) {
        int count = 0;
        int preIndex = 0;
        while (preIndex != -1) {
            preIndex = stringb.indexOf(stringa, preIndex);
            if (preIndex != -1) {
                count++;
                preIndex = preIndex + 3;
            }
        }
        
        if (count >= 2) {
            return true;
        } else {
            return false;
        }
    }
        
    public String lastPart(String stringa, String stringb) {
        String result ="";
        int firstIndex = stringb.indexOf(stringa);
        if (firstIndex == -1) {
            result = stringb;
        } else {
            result = stringb.substring(firstIndex + stringa.length(), stringb.length());
        }
        return result;
    }
    
    public void testing() {
        String stringa = "by";
        System.out.println("String A is " + stringa);
        String stringb = "A story by Abby Long";
        System.out.println("String B is " + stringb);
        boolean result = twoOccurrences(stringa, stringb);
        System.out.println("Result is " + result);
        
        stringa = "an";
        System.out.println("String A is " + stringa);
        stringb = "banana";
        System.out.println("String B is " + stringb);
        result = twoOccurrences(stringa, stringb);
        System.out.println("Result is " + result);
        String result2 = lastPart(stringa, stringb);
        System.out.println("Result is " + result2);
        
        stringa = "zoo";
        System.out.println("String A is " + stringa);
        stringb = "forest";
        System.out.println("String B is " + stringb);
        result2 = lastPart(stringa, stringb);
        System.out.println("Result is " + result2);
        
    }
        

}
