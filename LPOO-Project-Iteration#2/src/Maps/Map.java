package Maps;

import Characters.Character;
import Characters.Hero;
import Characters.Enemy;
import Objects.Door;
import Objects.Key;
import Objects.Lever;
import inputs.TextInput;

public class Map implements GameMap {

    private String[][] map=new String[10][10],resetMap=new String[10][10];
    private Enemy[] enemies = null;
    private Hero hero;
    private Key[] keys=null;
    private Lever[] levers=null;
    private Door[] doors=null;
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
        this.resetMap=map;
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
        this.resetMap=map;
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
        this.resetMap=map;
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
        this.resetMap=map;
    }

    public void setDoor(Door[] doors){
        this.doors=doors;
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
        if(doors!=null){
        for(int i=0;i<doors.length;i++){
            if(doors[i].getIsOpen()){
                if(x==doors[i].getxPos()){
                    if(y==doors[i].getyPos()){
                        return true;
                    }
                }
            }
        }}
        return false;
    }

    private void resetMap(){
        this.map=this.resetMap;
    }

    public void drawMap(){

        resetMap();//we must reset the map before drawing it , this mustnt be done after drawing as we need to check certain conditions trough looking
        // at the maps current state with the new positions for certain not native objects

        if(keys!=null){
        for(int i=0;i<keys.length;i++){
            if(!keys[i].isPicked()) {
                map[keys[i].getyPos()][keys[i].getxPos()] = this.keys[i].getRep();
            }
        }}

        if(levers!=null){
            for(int i=0;i<levers.length;i++){
                map[levers[i].getyPos()][levers[i].getxPos()]=this.levers[i].getRepresentation();
            }
        }

        if(doors!=null){
            for(int i=0;i<doors.length;i++){
                map[doors[i].getyPos()][doors[i].getxPos()]=this.doors[i].getRepresentation();
            }
        }

        for(int i=0;i<enemies.length;i++){
            map[enemies[i].getYPos()][enemies[i].getXPos()]=enemies[i].getRepresentation();
        }

        map[hero.getyPos()][hero.getyPos()]=hero.getRepresentation();

        for(int i=0;i<height;i++) {
            for (int j = 0; j < width; j++) {
                System.out.print("|" + map[i][j] + "|");
            }
            System.out.print("\n");
        }
    }

    public boolean mapLogic(){

        TextInput direction = new TextInput();
        int movement;

        while(!hasWon()){

            this.drawMap();

            movement = direction.getNextStep();

            switch (movement){
                case(1):
                    if(this.moveTo(0,-1,this.hero)){
                        this.hero.moveHero(0,-1);
                    }
                case(2):
                    if(this.moveTo(0,1,this.hero)){
                        this.hero.moveHero(0,1);
                    }
                case(3):
                    if(this.moveTo(-1,0,this.hero)){
                        this.hero.moveHero(-1,0);
                    }
                case(4):
                    if(this.moveTo(1,0,this.hero)){
                        this.hero.moveHero(1,0);
                    }
            }

            if(keys!=null){
                for(int i=0;i<keys.length;i++){
                    this.keys[i].detectPickup(this.hero);
                }
            }

            if(levers!=null){
                for(int i=0;i<levers.length;i++){
                    this.levers[i].detectPress(this.hero);
                }
            }

            for(int i = 0 ;i<enemies.length;i++){
                this.enemies[i].move();
                this.enemies[i].attack();
            }

            if(hasWon()){
                System.out.println("Congratulations you have won");
            }

        }

        direction.close();
        return false;

    }
}
