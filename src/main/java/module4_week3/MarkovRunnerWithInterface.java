package module4_week3;
/**
 * Write a description of class MarkovRunner here.
 * 
 * @author Duke Software
 * @version 1.0
 */

import edu.duke.*; 

public class MarkovRunnerWithInterface {
    public void runModel(IMarkovModel markov, String text, int size) {
        markov.setTraining(text);
        System.out.println("running with " + markov);
        for(int k=0; k < 3; k++){
			String st= markov.getRandomText(size);
			printOut(st);
		}
    }
    
    public void runMarkov() {
        FileResource fr = new FileResource();
		String st = fr.asString();
		st = st.replace('\n', ' ');
		int size = 200;
		
        MarkovZero_2 mz = new MarkovZero_2();
        runModel(mz, st, size);
    
        MarkovOne_2 mOne = new MarkovOne_2();
        runModel(mOne, st, size);
        
        MarkovModel_2 mThree = new MarkovModel_2(3);
        runModel(mThree, st, size);
        
        MarkovFour_2 mFour = new MarkovFour_2();
        runModel(mFour, st, size);

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

	public static void main(String[] args) {
		MarkovRunnerWithInterface mI = new MarkovRunnerWithInterface();
		mI.runMarkov();
	}
	
}
