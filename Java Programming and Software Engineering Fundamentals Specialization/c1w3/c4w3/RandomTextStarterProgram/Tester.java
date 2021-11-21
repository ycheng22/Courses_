
/**
 * Write a description of Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import edu.duke.*;

public class Tester {
    public void testGetFollows() {
        MarkovOne markov = new MarkovOne();
        String trainingText = "this is a test yes this is a test.";
        markov.setTraining(trainingText);
        // test1
        String key = "t";
        ArrayList<String> follows = markov.getFollows(key);
        System.out.println(follows.size() + " " + follows);
        // test2
        key = "e";
        follows = markov.getFollows(key);
        System.out.println(follows.size() + " " + follows);
        // test3
        key = "es";
        follows = markov.getFollows(key);
        System.out.println(follows.size() + " " + follows);
        // test4
        key = ".";
        follows = markov.getFollows(key);
        System.out.println(follows.size() + " " + follows);
        // test5
        key = "t.";
        follows = markov.getFollows(key);
        System.out.println(follows.size() + " " + follows);
    }

    public void testGetFollowsWithFile() {
        // FileResource fr = new FileResource("data/melville.txt"); // practice quiz: 3, 4
        FileResource fr = new FileResource("data/confucius.txt"); // graded quiz: 3, 4
        String trainingText = fr.asString();
        trainingText = trainingText.replace('\n', ' ');
        MarkovOne markov = new MarkovOne();
        markov.setTraining(trainingText);
        // test
        //String key = "t";
        //ArrayList<String> follows = markov.getFollows(key);
        //System.out.println(follows.size() + " " + follows);
        // practice quiz: 3
        //String key = "o";
        // String key = "th"; // practice quiz: 4
        // ArrayList<String> follows = markov.getFollows(key);
        // System.out.println(follows.size() + " " + follows);

        // graded quiz: 3
        //String key = "o";
        //ArrayList<String> follows = markov.getFollows(key);
        //System.out.println(follows.size() + " " + follows);

        // graded quiz: 4
        String key = "he";
        ArrayList<String> follows = markov.getFollows(key);
        System.out.println(follows.size() + " " + follows);
    }
}

