public class Map {
    public Location[][] map;
    Map(int xHeight, int yHeight){
        this.map = new Location[xHeight][yHeight];
    }
    public Location getLocation(int x, int y){
        return this.map[x][y];
    }

    public void setLocation(Location location){
        this.map[location.getXPos()][location.getYPos()] = new Location(location);
    }

    public String returnMap(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[i].length; j++){
                sb.append("(" + map[i][j].getXPos() + "," + map[i][j].getYPos() + ")");
                sb.append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public boolean isPosInMap(int x, int y){
        if(x < 0 || y < 0 || this.map[x][y] == null){
            return false;
        }
        return true;
    }
}
