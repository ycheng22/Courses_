
/**
 * Write a description of class MarkovRunner here.
 * 
 * @author Duke Software
 * @version 1.0
 */

import edu.duke.*; 

public class MarkovRunnerWithInterface {
    public void runModel(IMarkovModel markov, String text, int size, int seed) {
        markov.setTraining(text);
        markov.setRandom(seed);
        System.out.println("running with " + markov);
        for(int k=0; k < 3; k++){
			String st= markov.getRandomText(size);
			printOut(st);
		}
    }
    
    public void runMarkov() {
        // practice quiz: 3, 4 (romeo.txt)
        // Graded quiz: 2, 9 (confucius.txt)
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        int size = 200;
        int seed = 615; // practice quiz: 3, 4
        
        //MarkovZero mz = new MarkovZero();
        //runModel(mz, st, size, seed);
    
        // MarkovOne mOne = new MarkovOne();
        // runModel(mOne, st, size, seed);
        
        // MarkovModel mThree = new MarkovModel(3);
        // runModel(mThree, st, size, seed);
        
        // MarkovFour mFour = new MarkovFour();
        // runModel(mFour, st, size, seed);

        // EfficientMarkovModel emm = new EfficientMarkovModel(5);
        // runModel(emm, st, size, seed);

        // Graded quiz: 2
        // MarkovZero mz = new MarkovZero();
        // runModel(mz, st, 100, 1024);
        
        // Graded quiz: 9
        //EfficientMarkovModel emm = new EfficientMarkovModel(6);
        //runModel(emm, st, 100, 792);

        // Graded quiz: 10
        EfficientMarkovModel emm = new EfficientMarkovModel(5);
        runModel(emm, st, 100, 531);
    }
    
    public void testHashMap() {
        String st = "yes-this-is-a-thin-pretty-pink-thistle";
        int size = 50;
        int seed = 42;

        EfficientMarkovModel emm = new EfficientMarkovModel(2);
        runModel(emm, st, size, seed);
    }
    
    public void compareMethods() {
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        int size = 1000;
        int seed = 42;

        long nano_startTime = System.nanoTime();
        MarkovModel mm = new MarkovModel(2);
        runModel(mm, st, size, seed);
        System.out.println((double)(System.nanoTime()-nano_startTime)/1000000000);

        nano_startTime = System.nanoTime();
        EfficientMarkovModel emm = new EfficientMarkovModel(2);
        runModel(emm, st, size, seed);
        System.out.println((double)(System.nanoTime()-nano_startTime)/1000000000);
    }


    private void printOut(String s){
    	String[] words = s.split("\\s+");
    	int psize = 0;
    	System.out.println("----------------------------------");
    	for(int k=0; k < words.length; k++){
    		System.out.print(words[k]+ " ");
    		psize += words[k].length() + 1;
    		if (psize > 60) {
    			System.out.println();
    			psize = 0;
    		}
    	}
    	System.out.println("\n----------------------------------");
    }
	
}
