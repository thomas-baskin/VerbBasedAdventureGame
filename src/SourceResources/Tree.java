package SourceResources;

import java.io.*;
import java.util.HashMap;

public class Tree {
    String wholeSentence;
    String otherArguments;
    String noun;
    String reaction;
    public Tree(String wholeSentence, String noun){
        this.wholeSentence = wholeSentence;
        this.noun = noun;
        otherArguments = wholeSentence.replace(noun,"");
        // otherArguments = "cut down the "
        this.reaction = Tree();
    }
    private String Tree(){
        otherArguments = otherArguments.replace(" ","");
        File file = new File(System.getProperty("user.dir") + "\\Resources\\TreeVerbs.csv");
        HashMap<String,String> verbsToReaction = new HashMap<>();
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = bufferedReader.readLine();
            String[] partsOfLine;
            while(line != null){
                partsOfLine = line.split(",");
                verbsToReaction.put(partsOfLine[0] + partsOfLine[1],partsOfLine[2]);
                line = bufferedReader.readLine();
            }
        }catch(FileNotFoundException ex){
            System.out.println("File not found!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(verbsToReaction.containsKey(otherArguments)){
            return verbsToReaction.get(otherArguments);
        }
        return "Nothing happens.";
    }

    public String getReaction() {
        return reaction;
    }
}
