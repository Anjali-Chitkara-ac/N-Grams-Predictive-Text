package module4_week3;
/**
 * Abstract class AbstractMarkovModel - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */

import java.util.*;

public abstract class AbstractMarkovModel implements IMarkovModel {
    protected String myText;
    protected Random myRandom;
    
    public AbstractMarkovModel() {
        myRandom = new Random();
    }
    
    public void setTraining(String s) {
        myText = s.trim();
    }
 
    abstract public String getRandomText(int numChars);

    protected ArrayList<String> getFollows(String key){
        ArrayList<String> follows = new ArrayList<>();
        for(int i=0;i<myText.length()-key.length();i++){
            String s = myText.substring(i,i+key.length());
            if(s.equals(key)){
                String f = myText.substring(i+key.length(),i+key.length()+1);
                follows.add(f);
            }
        }
        return follows;
    }

}
