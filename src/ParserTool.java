import Resources.*;

import java.util.HashMap;

public class ParserTool {
    HashMap<String, String> hashMap;
    // constructor: takes dictionary with word to file associations
    ParserTool(HashMap<String, String> hashMap){
        this.hashMap = hashMap;
    }
    public String Parse(String phrase){
//        System.out.println("Parser Parse: " + phrase);
        String[] words = phrase.split(" ");
        int numOfWords = words.length;
        for(String word : words){
//            System.out.println("This word: " + i);
            if(hashMap.containsKey(word)){
//                System.out.println(word + " is in the dictionary");
                String value = hashMap.get(word);
                System.out.println(word + "'s value is : " + value);
                if(value.equals("Tree.java")){
                    Tree tree = new Tree(phrase,word);
                    return tree.getTreeReaction();
                }
            }
        }return "No nouns identified.";
    }
}
