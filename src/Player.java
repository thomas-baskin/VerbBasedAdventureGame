import SourceResources.Entity;

import java.util.ArrayList;

public class Player{
    private int xPos;
    private int yPos;
    private ArrayList<Entity> pack;
    Player(int xPos, int yPos, ArrayList<Entity> pack){
        this.xPos = xPos;
        this.yPos = yPos;
        this.pack = pack;
    }

    public String putInPack(Map mainMap, Entity ent){
        if(ent.getPackable()){
            pack.add(ent);
            mainMap.getLocation(xPos,yPos).removeEntity(ent);
            return ent.getName() + " added to your pack.";
        }else{
            return "You cannot add " + ent.getName() + " to your pack.";
        }
    }

    public void moveDirection(Map mainMap, char direction){
        switch(direction){
            case 'N':
                if(mainMap.isPosInMap(this.xPos,this.yPos-1)){
                    this.yPos -= 1;
                    System.out.println(mainMap.getLocation(this.xPos,this.yPos).message);
                }
                break;
            case 'S':
                if(mainMap.isPosInMap(this.xPos,this.yPos+1)){
                    this.yPos += 1;
                    System.out.println(mainMap.getLocation(this.xPos,this.yPos).message);
                }
                break;
            case 'E':
                if(mainMap.isPosInMap(this.xPos+1,this.yPos)){
                    this.xPos += 1;
                    System.out.println(mainMap.getLocation(this.xPos,this.yPos).message);
                }
                break;
            case 'W':
                if(mainMap.isPosInMap(this.xPos-1,this.yPos)){
                    this.xPos -= 1;
                    System.out.println(mainMap.getLocation(this.xPos,this.yPos).message);
                }
                break;
        }
    }

}
