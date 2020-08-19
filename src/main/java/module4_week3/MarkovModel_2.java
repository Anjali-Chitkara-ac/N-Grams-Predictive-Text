package module4_week3;

import java.util.ArrayList;
import java.util.Random;

public class MarkovModel_2 extends AbstractMarkovModel /*implements IMarkovModel*/ {
    //private String myText;
    //private Random myRandom;
    private int number;

    public MarkovModel_2(int n) {
        myRandom = new Random();
        number = n;
    }

    public void setRandom(int seed){
        myRandom = new Random(seed);
    }

    public void setTraining(String s){
        myText = s.trim();
    }

    /*
    In the class MarkovOne modify the method getRandomText so that it works for the way it should for MarkovOne.
    It should predict the next character, by finding all the characters that follow the current character in the
    training text, and then randomly picking one of them as the next character.
     */
    public String getRandomText(int numChars){
        if (myText == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length() - number);
        String key = myText.substring(index, index + number);
        sb.append(key);

        for(int k=0; k < numChars - number; k++){
            ArrayList<String> follows = getFollows(key);

            if(follows.size() == 0)
                break;
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            key = key.substring(1) + next;
            //System.out.println("key is " + key);
        }

        return sb.toString();
    }

//    protected ArrayList<String> getFollows(String key){
//        ArrayList<String> follows = new ArrayList<>();
//        for(int i=0;i<myText.length()-key.length();i++){
//            String s = myText.substring(i,i+key.length());
//            if(s.equals(key)){
//                String f = myText.substring(i+key.length(),i+key.length()+1);
//                follows.add(f);
//            }
//        }
//        return follows;
//    }
}
