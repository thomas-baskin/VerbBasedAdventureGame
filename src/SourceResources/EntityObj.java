package SourceResources;

public class EntityObj{
    private String name;
    private String description;
    private boolean packable; // Can it go into the player's pack?
    EntityObj(String name, String description, boolean packable){
        this.name = name;
        this.description = description;
        this.packable = packable;
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
