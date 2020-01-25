import Resources.*;

import java.util.HashMap;

public class ParserTool {
    HashMap<String, String> hashMap;
    ParserTool(HashMap<String, String> hashMap){
        this.hashMap = hashMap;
    }
    public void Parse(String phrase){
//        System.out.println("Parser Parse: " + phrase);
        String[] words = phrase.split(" ");
        int numOfWords = words.length;
        for(String word : words){
//            System.out.println("This word: " + i);
            if(hashMap.containsKey(word)){
//                System.out.println(word + " is in the dictionary");
                String value = hashMap.get(word);
                System.out.println(word + "'s value is : " + value);
                if(value == "Tree.java"){
                    Tree tree = new Tree(phrase,word);
                }
            }
        }
    }
}
