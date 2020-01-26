package Resources;

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
        this.reaction = Tree();
    }
    private String Tree(){
//        String[] splitArgs = otherArguments.split(" ");
//        for(int i = 0; i < splitArgs.length; i++){
//            System.out.println("Other Arg " + i + ": " + splitArgs[i]);
//        }
        // remove white space at beginning and end of otherArguments :cut down :
        otherArguments = otherArguments.replace(" ","");
//        otherArguments = otherArguments.substring(0,otherArguments.length() - 1);
        System.out.println(":" + otherArguments + ":");
        String workingDir = System.getProperty("user.dir");
        System.out.println("Working Dir: " + workingDir);
        File file = new File(System.getProperty("user.dir") + "\\Resources\\TreeVerbs.csv");
        HashMap<String,String> verbsToReaction = new HashMap<>();
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = bufferedReader.readLine();
            String[] partsOfLine;
            while(line != null){
                partsOfLine = line.split(",");
//                for(String part : partsOfLine){
//                    System.out.print(part);
//                }
                verbsToReaction.put(partsOfLine[0] + partsOfLine[1],partsOfLine[2]);
//                System.out.println(line);
                line = bufferedReader.readLine();
            }
        }catch(FileNotFoundException ex){
            System.out.println("File not found!");
        } catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.println("Here we see:" + otherArguments + ":");
//        System.out.println(verbsToReaction);
        System.out.println(verbsToReaction.keySet());
        if(verbsToReaction.containsKey(otherArguments)){
            System.out.println("it worked!");
            return verbsToReaction.get(otherArguments);
        }
//        if(otherArguments.equals("cutdown")){
//            return "You cut down this mighty tree.";
//        }else if(otherArguments.equals("chopdown")){
//            return "You chop down this mighty tree.";
//        }else if(otherArguments.equals("axedown")){
//            return "You axe down this mighty tree.";
//        }else if(otherArguments.equals("slicedown")){
//            return "You slice down this mighty tree.";
//        }else if(otherArguments.equals("takedown")){
//            return "You take down this mighty tree.";
//        }
        return "Nothing happens.";
    }

    public String getReaction() {
        return reaction;
    }
}
