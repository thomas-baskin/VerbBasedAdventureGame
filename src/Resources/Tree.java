package Resources;

public class Tree {
    String wholeSentence;
    String otherArguments;
    String noun;
    public Tree(String wholeSentence, String noun){
        this.wholeSentence = wholeSentence;
        this.noun = noun;
        otherArguments = wholeSentence.replace(noun,"");
        StringBuilder args = otherArguments.split(" ");
        System.out.println(":" + otherArguments + ":");
        if(otherArguments.equals("cut down")){
            System.out.println("you cut down this mighty tree");
        }
    }
}
