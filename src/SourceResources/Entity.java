package SourceResources;

import java.io.*;
import java.util.HashMap;

public class Entity{
    private String name;
    private String description;
    private boolean packable; // Can it go into the player's pack?

    String wholeSentence;
    String otherArguments;
    String noun;
    String reaction;
    public Entity(String wholeSentence, String noun, String fileNoun, String name, String description, boolean packable){
        this.name = name;
        this.description = description;
        this.packable = packable;
        this.wholeSentence = wholeSentence;
        this.noun = noun;
        otherArguments = wholeSentence.replace(noun,"");
        // otherArguments = "cut down the "
        this.reaction = Reaction(fileNoun);
    }

    public String Reaction(String entName){
        otherArguments = otherArguments.replace(" ","");
        File file = new File(System.getProperty("user.dir") + "\\Resources\\" + entName + "Verbs.csv");
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
    public void setName(String newName){
        this.name = newName;
    }
    public String getName(){
        return name;
    }
    public void setDescription(String newDescription){
        this.description = newDescription;
    }
    public String getDescription(){
        return description;
    }
    public void setPackable(boolean packable){
        this.packable = packable;
    }
    public boolean getPackable(){
        return packable;
    }
}
