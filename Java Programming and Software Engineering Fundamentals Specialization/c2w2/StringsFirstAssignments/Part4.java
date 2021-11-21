
/**
 * Write a description of Part4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class Part4 {
    
    public void FindWebLink() {
        // Use URLResource to read the file at 
        // http://www.dukelearntoprogram.com/course2/data/manylinks.html 
        // word by word
        String youtube = "youtube.com";
        String youtubeLink = "";
        int beginQuote;
        int endQuote;
        URLResource manylinks = new URLResource("https://www.dukelearntoprogram.com//course2/data/manylinks.html");
        int numYoutubelink = 0;
        // For each word, check to see if “youtube.com” is in it.
        for (String singleUrl : manylinks.words()) {
            String lowUrl = singleUrl.toLowerCase();
            int youtubeOccurrence = lowUrl.indexOf(youtube);
            // If it is, find the double quote to the left and right of 
            // the occurrence of “youtube.com” to identify the beginning 
            // and end of the URL.
            if (youtubeOccurrence != -1) {
                
                System.out.println("singleUrl is " + singleUrl);
                beginQuote = lowUrl.lastIndexOf("\"", youtubeOccurrence);
                endQuote = lowUrl.indexOf("\"", beginQuote + 1);
                youtubeLink = singleUrl.substring(beginQuote + 1, endQuote);
                System.out.println("Youtube lick is " + youtubeLink);
                numYoutubelink++;
            }
        }
        System.out.println("The number of links is " + numYoutubelink);
        
    }

}
