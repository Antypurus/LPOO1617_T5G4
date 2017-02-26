package Maps;

import Characters.Character;
import Characters.Hero;
import Characters.Enemy;
import Objects.Key;

public class Map implements GameMap {

    String[][] map;
    Enemy[] enemies;
    Hero hero;
    Key[] keys;
    boolean hasNextMap=false;
    GameMap nextMap;
    private int height,width;
    private boolean imideateOpen=true;//represents weather or not the player need to spend a movement action to open the door


    public Map(String[][] map,MapDimension dimensions, Hero hero, Enemy[] enemies, Key[] key){
        this.map=map;
        this.enemies=enemies;
        this.hero=hero;
        this.keys=key;
        this.height=dimensions.getySize();
        this.width=dimensions.getxSize();
    }

    public Map(String[][] map,MapDimension dimensions, Hero hero, Enemy[] enemies, Key[] key,boolean imediateOpen){
        this.map=map;
        this.enemies=enemies;
        this.hero=hero;
        this.keys=key;
        this.height=dimensions.getySize();
        this.width=dimensions.getxSize();
        this.imideateOpen=imediateOpen;
    }

    public Map(String[][] map, Hero hero, Enemy[] enemies, Key[] key,GameMap nextMap){
        this.map=map;
        this.enemies=enemies;
        this.hero=hero;
        this.keys=key;
        this.hasNextMap=true;
        this.nextMap=nextMap;
    }

    public Map(String[][] map, Hero hero, Enemy[] enemies, Key[] key,GameMap nextMap, boolean imeaditeOpen){
        this.map=map;
        this.enemies=enemies;
        this.hero=hero;
        this.keys=key;
        this.hasNextMap=true;
        this.nextMap=nextMap;
        this.imideateOpen=imeaditeOpen;
    }

    public boolean moveTo(int x, int y,Character character){
        int intX=character.getxPos()+x;
        int intY=character.getyPos()+y;
        String check = map[intY][intX];
        if(check.equals("X")||check.equals("I")||check.equals("H")||check.equals("O")||check.equals("G")){
            return false;
        }
        return true;
    }

    public void setNextMap(GameMap nextMap){
        this.hasNextMap=true;
        this.nextMap=nextMap;
    }

    public String[][] getMap(){
        return map;
    }

    public GameMap nextMap(){
        if(hasNextMap){
            return nextMap;
        }else{
            return null;
        }
    }

    public boolean hasWon(){
        int x=hero.getxPos();
        int y=hero.getyPos();
        String check=map[y][x];
        if(check.equals("S")){
            return true;
        }
        return false;
    }

    public void drawMap(){

        for(int i=0;i<keys.length;i++){
            if(keys[i].isPicked()){
                map[keys[i].getyPos()][keys[i].getxPos()]="k";
            }
        }

        for(int i=0;i<enemies.length;i++){
            map[enemies[i].getyPos()][enemies[i].getxPos()]=enemies[i].getRepresentation();
        }

        map[hero.getyPos()][hero.getyPos()]=hero.getRepresentation();

        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                System.out.print("|"+map[i][j]+"|");
            }
        }
    }

    public boolean mapLogic(){
        return false;
    }
}
