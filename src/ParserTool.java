import SourceResources.*;

import java.util.ArrayList;
import java.util.HashMap;

public class ParserTool {
    HashMap<String, String> hashMap;
    // constructor: takes dictionary with word to file associations
    ParserTool(HashMap<String, String> hashMap){
        this.hashMap = hashMap;
    }
    public String Parse(String phrase){
//        System.out.println("Parser Parse: " + phrase);
        //"cut down the tree"
        String[] words = phrase.split(" ");
        ArrayList<String> cleanedWords = new ArrayList<>();
        //["cut","down","the","tree"]
        //check for extra words like "the"
        for(String word : words){
            if(!word.equals("the")){
                cleanedWords.add(word);
            }
        }
        int numOfWords = words.length;
        String cleanedString = String.join("",cleanedWords);
        // look for noun
        for(String word : cleanedWords){
//            System.out.println("This word: " + i);
            if(hashMap.containsKey(word)){
//                System.out.println(word + " is in the dictionary");
                String value = hashMap.get(word);
                System.out.println(word + "'s value is : " + value);
                if(value.equals("Tree.java")){
                    Tree tree = new Tree(cleanedString,word);
                    return tree.getReaction();
                }
            }
        }return "No nouns identified.";
    }
}
