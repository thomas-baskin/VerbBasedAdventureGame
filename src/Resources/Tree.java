package Resources;

public class Tree {
    String wholeSentence;
    String otherArguments;
    String noun;
    String treeReaction;
    public Tree(String wholeSentence, String noun){
        this.wholeSentence = wholeSentence;
        this.noun = noun;
        otherArguments = wholeSentence.replace(noun,"");
        this.treeReaction = Tree();
    }
    private String Tree(){
        String[] splitArgs = otherArguments.split(" ");
        for(int i = 0; i < splitArgs.length; i++){
            System.out.println("Other Arg " + i + " " + splitArgs[i]);
        }
        // remove white space at beginning and end of otherArguments :cut down :
        otherArguments = otherArguments.replace(" ","");
        System.out.println(":" + otherArguments + ":");
        if(otherArguments.equals("cutdown")){
            return "You cut down this mighty tree.";
        }else if(otherArguments.equals("chopdown")){
            return "You chop down this mighty tree.";
        }else if(otherArguments.equals("axedown")){
            return "You axe down this mighty tree.";
        }else if(otherArguments.equals("slicedown")){
            return "You slice down this mighty tree.";
        }else if(otherArguments.equals("takedown")){
            return "You take down this mighty tree.";
        }
        return "Nothing happens.";
    }

    public String getTreeReaction() {
        return treeReaction;
    }
}
