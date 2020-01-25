import java.util.ArrayList;

public class Location {
    private int xPos;
    private int yPos;
    public ArrayList<Entity> entities;
    public String message;

    /**
     * Constructor where this location copies
     * another location
     * @param location
     */
    Location(Location location){
        this.xPos = location.xPos;
        this.yPos = location.yPos;
        this.entities = location.entities;
        this.message = location.message;
    }

    Location(int xPos, int yPos, ArrayList<Entity> entities, String message){
        this.xPos = xPos;
        this.yPos = yPos;
        this.entities = entities;
        this.message = message;
    }
    public int getXPos(){
        return xPos;
    }
    public int getYPos(){
        return yPos;
    }
    public void printPositionOfLocation(){
        System.out.print("("+getXPos()+","+ getYPos()+")");
    }
    public void setxPos(int xPos){
        this.xPos = xPos;
    }
    public void setyPos(int yPos){
        this.yPos = yPos;
    }
    public void addEntity(Entity ent){
        entities.add(ent);
    }
    public void removeEntity(Entity ent){
        entities.remove(ent);
    }
}
