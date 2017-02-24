package Maps;

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


    public Map(String[][] map, Hero hero, Enemy[] enemies, Key[] key){
        this.map=map;
        this.enemies=enemies;
        this.hero=hero;
        this.keys=key;
    }

    public Map(String[][] map, Hero hero, Enemy[] enemies, Key[] key,GameMap nextMap){
        this.map=map;
        this.enemies=enemies;
        this.hero=hero;
        this.keys=key;
        this.hasNextMap=true;
        this.nextMap=nextMap;
    }

    public boolean moveTo(int x,int y){
        return false;
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

}
