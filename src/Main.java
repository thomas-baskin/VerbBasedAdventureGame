import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.HashMap;

public class Main extends Application {
//    public static void main(String[] args) {
//        gamePreset();
//    }
    private static void gamePreset(){
        //Initializing the Player
        Player player1 = new Player(0,0,null);

        //Making lists of entities for each location and adding entities to those entity lists
        ArrayList<Entity> entities00 = new ArrayList<>();
        ArrayList<Entity> entities01 = new ArrayList<>();

        Entity mailbox = new Entity("mailbox",
                "This metal mailbox with chipping" +
                " white paint sits firmly atop an old, white, wooden post.",
                false);
        entities00.add(mailbox);

        Entity tree = new Entity("tree",
                "This is a tall, oak tree with thick branches." +
                        " The branches lean to one side, likely to the constant wind...",
                false);
        entities01.add(tree);

        Entity bottle = new Entity("empty bottle",
                "This old, brown, glass beer bottle was tossed aside long ago...",
                true);
        entities01.add(bottle);

        /** Creating Locations
         * It is important to note that the yPos starts in the left corner of the map and increases southward.
         * (0,0)|(1,0)|(2,0)
         * -----------------
         * (0,1)|(1,1)|(2,1)
         * -----------------
         * (0,2)|(1,2)|(2,2)
         */
        Location location00 = new Location(0,0,entities00,"This is location 00. Welcome to the map.");
        Location location01 = new Location(0,1,entities01,"This is location 01. You are south of location 00.");
        Location location11 = new Location(1,1,entities01,"This is location 11. You are southeast of location 00.");
        Location location10 = new Location(1,0,entities01,"This is location 10. You are east of location 00.");

        //Adding Locations to the Map Array
        Map mainMap = new Map(2,2);
        mainMap.setLocation(location00);
        mainMap.setLocation(location01);
        mainMap.setLocation(location11);
        mainMap.setLocation(location10);

        System.out.println(mainMap.returnMap());

        System.out.println(mainMap.getLocation(0,0).message);
        System.out.println(mainMap.getLocation(0,0).entities.get(0).getName());
        System.out.println(mainMap.getLocation(0,0).entities.get(0).getDescription());
        player1.moveDirection(mainMap,'S');
        player1.moveDirection(mainMap,'E');

//        System.out.println(mainMap.getLocation(0,1).message);
//        System.out.println(mainMap.getLocation(0,1).entities.get(0).getName());
//        System.out.println(mainMap.getLocation(0,1).entities.get(0).getDescription());
    }

    String newWords;
    public void start(Stage primaryStage){
        //GUI Setup
        BorderPane textPane = new BorderPane();
        TextField textField = new TextField();
        ScrollPane scrollPane = new ScrollPane();
        VBox innerVBox = new VBox();
        textPane.setBottom(textField);
        textPane.setCenter(scrollPane);
        scrollPane.setContent(innerVBox);

        //Read in a file to make this better
        HashMap<String,String> dictionary = new HashMap<>();
        dictionary.put("tree","Tree.java");
        dictionary.put("trees","Tree.java");
        dictionary.put("oak", "Tree.java");
//        dictionary.put("oak tree", "Tree.java");

        ParserTool thisParser = new ParserTool(dictionary);
//        thisParser.Parse("word");
//        System.out.println(dictionary.get("key"));

        //Intro
        innerVBox.getChildren().add(new Label("\tYou are in a large field with a single large oak tree." +
                " What do you do?"));

        //Get text in textField, clear textField, add text as a new label
        textField.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode() == KeyCode.ENTER){
                    newWords = textField.getText();
                    innerVBox.getChildren().add(new Label(newWords));
                    textField.clear();
//                    System.out.println("Typed words: " + newWords);
                    String reaction = thisParser.Parse(newWords);
                    System.out.println(reaction);
                    innerVBox.getChildren().add(new Label("\t" + reaction));
                }
            }
        });
        Scene scene = new Scene(textPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Verb Based Adventure");
        primaryStage.show();
    }
    public static boolean hasLocation(Location[][] map, int xPos, int yPos){
        if(map[xPos][yPos]!=null){
            return true;
        }
        return false;
    }

}
