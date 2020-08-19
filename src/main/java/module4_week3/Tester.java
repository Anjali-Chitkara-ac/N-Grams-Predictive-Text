package module4_week3;

import edu.duke.FileResource;

import java.util.ArrayList;

public class Tester {

    public void testGetFollows(){
        MarkovOne m1 = new MarkovOne();
        m1.setTraining("this is a test yes this is a test.");
        ArrayList<String> follows = m1.getFollows("es");
        System.out.println(follows);
        System.out.println(follows.size() + " characters follow the keyword");
    }

    public void testGetFollowsWithFile(){
        MarkovOne m1 = new MarkovOne();
        FileResource fr = new FileResource();
        m1.setTraining(fr.asString());
        ArrayList<String> follows = m1.getFollows("th");
        System.out.println(follows);
        System.out.println(follows.size() + " characters follow the keyword");
    }

    public static void main(String[] args) {
        Tester driver = new Tester();
        //tester.testGetFollows();
        driver.testGetFollowsWithFile();

    }
}
