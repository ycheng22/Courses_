
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    
    public int howMany(String stringa, String stringb) {
        int count = 0;
        int startIndex = 0;
        while (true) {
            int currentIndex = stringb.indexOf(stringa, startIndex);
            if (currentIndex == -1) {
                break;
            }
            count++;
            startIndex = currentIndex + stringa.length();
        }
        return count;
    }
    
    public void testHowMany() {
        System.out.println(howMany("GAA", "ATGAACGAATTGAATC")); // 3
        System.out.println(howMany("AA", "ATAAAA"));            // 2
        System.out.println(howMany("DAN", "DAN DAN THE NISSAN MAN IS DAN")); // 3
    }
}
