package Maps;

import Characters.Character;
import Characters.Hero;
import Characters.Enemy;
import Objects.Door;
import Objects.Key;
import Objects.Lever;
import inputs.TextInput;

public class Map implements GameMap {

    private String[][] map,resetMap;
    private Enemy[] enemies = null;
    private Hero hero;
    private Key[] keys=null;
    private Lever[] levers=null;
    private Door[] doors=null;
    private boolean hasNextMap=false;
    private GameMap nextMap=null;
    private int height,width;
    private boolean imideateOpen=true;//represents weather or not the player need to spend a movement action to open the door
    private TextInput direction = new TextInput();

    public Map(String[][] map,String[][] referenceMap,MapDimension dimensions, Hero hero, Enemy[] enemies, Key[] key){
        this.map=map;
        this.resetMap=referenceMap;
        this.enemies=enemies;
        this.hero=hero;
        this.keys=key;
        this.height=dimensions.getySize();
        this.width=dimensions.getxSize();
    }

    public Map(String[][] map,String[][] referenceMap,MapDimension dimensions, Hero hero, Enemy[] enemies, Key[] key,boolean imediateOpen){
        this.map=map;
        this.enemies=enemies;
        this.hero=hero;
        this.keys=key;
        this.height=dimensions.getySize();
        this.width=dimensions.getxSize();
        this.imideateOpen=imediateOpen;
        this.resetMap=referenceMap;
    }

    public Map(String[][] map,String[][] referenceMap,MapDimension dimensions, Hero hero, Enemy[] enemies, Lever[] levers){
        this.map=map;
        this.resetMap=referenceMap;
        this.enemies=enemies;
        this.hero=hero;
        this.levers=levers;
        this.height=dimensions.getySize();
        this.width=dimensions.getxSize();
    }

    public Map(String[][] map,String[][] referenceMap,MapDimension dimensions, Hero hero, Enemy[] enemies, Lever[] levers,boolean imediateOpen){
        this.map=map;
        this.enemies=enemies;
        this.hero=hero;
        this.levers=levers;
        this.height=dimensions.getySize();
        this.width=dimensions.getxSize();
        this.imideateOpen=imediateOpen;
        this.resetMap=referenceMap;
    }
    
    public Map(String[][] map,String[][] referenceMap,MapDimension dimensions, Hero hero, Enemy[] enemies, Key[] key,GameMap nextMap){
        this.map=map;
        this.enemies=enemies;
        this.hero=hero;
        this.keys=key;
        this.hasNextMap=true;
        this.height=dimensions.getySize();
        this.width=dimensions.getxSize();
        this.nextMap=nextMap;
        this.resetMap=referenceMap;
    }

    public Map(String[][] map,String[][] referenceMap,MapDimension dimensions, Hero hero, Enemy[] enemies, Key[] key,GameMap nextMap, boolean imeaditeOpen){
        this.map=map;
        this.enemies=enemies;
        this.hero=hero;
        this.keys=key;
        this.hasNextMap=true;
        this.height=dimensions.getySize();
        this.width=dimensions.getxSize();
        this.nextMap=nextMap;
        this.imideateOpen=imeaditeOpen;
        this.resetMap=referenceMap;
    }

    public void setDoor(Door[] doors){
        this.doors=doors;
    }

    public boolean moveTo(int x, int y,Character character){
        int intX=character.getXPos()+x;
        int intY=character.getYPos()+y;
        //System.out.print("\n Atempting to move to : ("+intX+","+intY+")\n");
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
        int x=hero.getXPos();
        int y=hero.getYPos();
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

    public boolean hasLost(){
        for(int i=0;i<enemies.length;i++){
            if(enemies[i].heroDetection(this.hero)){
                return true;
            }
        }
        return false;
    }

    private void resetMap(String[][] map){
        for(int i=0;i<this.height;i++){
            for(int j=0;j<this.width;j++){
                this.map[i][j]=map[i][j];
            }
        }
    }

    public void drawMap(){

        this.resetMap(this.resetMap);//we must reset the map before drawing it , this mustnt be done after drawing as we need to check certain conditions trough looking
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
            if(enemies[i].getWeapons()!=null){
            for(int j=0;j<enemies[i].getWeapons().length;j++){
                map[enemies[i].getWeapons()[j].getyPos()][enemies[i].getWeapons()[j].getxPos()]=enemies[i].getWeapons()[j].getRep();
            }}
        }

        map[hero.getYPos()][hero.getXPos()]=hero.getRepresentation();

        for(int i=0;i<height;i++) {
            for (int j = 0; j < width; j++) {
                System.out.print("|" + map[i][j] + "|");
            }
            System.out.print("\n");
        }
    }

    public boolean mapLogic(){
        int movement;

        while(!hasWon()&&!hasLost()){

            this.drawMap();

            movement = direction.getNextStep();

            switch (movement){
                case(1):
                    if(this.moveTo(0,-1,this.hero)){
                        this.hero.moveHero(0,-1);
                        break;
                    }else{
                        for(int i=0;i<doors.length;i++){
                            if(hero.getYPos()-1==doors[i].getyPos()){
                                if(hero.getXPos()==doors[i].getxPos()){
                                    doors[i].setOpen(true);
                                }
                            }
                        }
                        break;
                    }
                case(2):
                    if(this.moveTo(0,1,this.hero)){
                        this.hero.moveHero(0,1);
                        break;
                    }else{
                        for(int i=0;i<doors.length;i++){
                            if(hero.getYPos()+1==doors[i].getyPos()){
                                if(hero.getXPos()==doors[i].getxPos()){
                                    doors[i].setOpen(true);
                                }
                            }
                        }
                        break;
                    }
                case(3):
                    if(this.moveTo(-1,0,this.hero)){
                        this.hero.moveHero(-1,0);
                        break;
                    }else{
                        for(int i=0;i<doors.length;i++){
                            if(hero.getYPos()==doors[i].getyPos()){
                                if(hero.getXPos()-1==doors[i].getxPos()){
                                    doors[i].setOpen(true);
                                }
                            }
                        }
                        break;
                    }
                case(4):
                    if(this.moveTo(1,0,this.hero)){
                        this.hero.moveHero(1,0);
                        break;
                    }else{
                        for(int i=0;i<doors.length;i++){
                            if(hero.getYPos()==doors[i].getyPos()){
                                if(hero.getXPos()+1==doors[i].getxPos()){
                                    doors[i].setOpen(true);
                                }
                            }
                        }
                        break;
                    }
                default:
                    break;
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

            if(this.hasLost()){
                System.out.println("\nYou Have Ben Caught !\n YOU LOSE!\n");
                direction.close();
                return false;
            }

            if(hasWon()&&(keys==null)){
                System.out.println("\nCongratulations you have won\n");
                return true;
            }

        }

        direction.close();
        return false;

    }
}
