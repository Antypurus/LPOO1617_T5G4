package Maps;

import Characters.Character;
import Characters.Hero;
import Characters.Enemy;
import Objects.Key;
import Objects.Lever;
import inputs.TextInput;

public class Map implements GameMap {

    private String[][] map,resetMap;
    private Enemy[] enemies = null;
    private Hero hero;
    private Key[] keys=null;
    private Lever[] levers=null;
    private boolean hasNextMap=false;
    private GameMap nextMap=null;
    private int height,width;
    private boolean imideateOpen=true;//represents weather or not the player need to spend a movement action to open the door


    public Map(String[][] map,MapDimension dimensions, Hero hero, Enemy[] enemies, Key[] key){
        this.map=map;
        this.resetMap=map;
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

    public Map(String[][] map,MapDimension dimensions, Hero hero, Enemy[] enemies, Lever[] levers){
        this.map=map;
        this.resetMap=map;
        this.enemies=enemies;
        this.hero=hero;
        this.levers=levers;
        this.height=dimensions.getySize();
        this.width=dimensions.getxSize();
    }

    public Map(String[][] map,MapDimension dimensions, Hero hero, Enemy[] enemies, Lever[] levers,boolean imediateOpen){
        this.map=map;
        this.enemies=enemies;
        this.hero=hero;
        this.levers=levers;
        this.height=dimensions.getySize();
        this.width=dimensions.getxSize();
        this.imideateOpen=imediateOpen;
    }
    
    public Map(String[][] map,MapDimension dimensions, Hero hero, Enemy[] enemies, Key[] key,GameMap nextMap){
        this.map=map;
        this.enemies=enemies;
        this.hero=hero;
        this.keys=key;
        this.hasNextMap=true;
        this.height=dimensions.getySize();
        this.width=dimensions.getxSize();
        this.nextMap=nextMap;
    }

    public Map(String[][] map,MapDimension dimensions, Hero hero, Enemy[] enemies, Key[] key,GameMap nextMap, boolean imeaditeOpen){
        this.map=map;
        this.enemies=enemies;
        this.hero=hero;
        this.keys=key;
        this.hasNextMap=true;
        this.height=dimensions.getySize();
        this.width=dimensions.getxSize();
        this.nextMap=nextMap;
        this.imideateOpen=imeaditeOpen;
    }

    public boolean moveTo(int x, int y,Character character){
        int intX=character.getXPos()+x;
        int intY=character.getYPos()+y;
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

    private void resetMap(){
        this.map=this.resetMap;
    }

    public void drawMap(){

        for(int i=0;i<keys.length;i++){
            if(!keys[i].isPicked()) {
                map[keys[i].getyPos()][keys[i].getxPos()] = this.keys[i].getRep();
            }
        }

        for(int i=0;i<enemies.length;i++){
            map[enemies[i].getYPos()][enemies[i].getXPos()]=enemies[i].getRepresentation();
        }

        map[hero.getyPos()][hero.getyPos()]=hero.getRepresentation();

        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                System.out.print("|"+map[i][j]+"|");
            }
            System.out.print("\n");
        }

        System.out.println("Enemy is is position: ("+enemies[0].getXPos()+","+enemies[0].getYPos()+")");

        resetMap();

    }

    public boolean mapLogic(){

        TextInput direction = new TextInput();
        int movement;

        while(!hasWon()){
            movement = direction.getNextStep();

            this.drawMap();

            switch (movement){
                case(1):
                    if(this.moveTo(0,-1,this.hero)){

                    }
            }

        }


        return false;

    }
}
