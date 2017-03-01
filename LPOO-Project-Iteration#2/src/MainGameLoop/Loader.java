package MainGameLoop;

import Characters.Enemy;
import Characters.Guard;
import Characters.Hero;
import Characters.Oggre;
import Maps.Map;
import Maps.MapDimension;
import Objects.Door;
import Objects.Key;
import Objects.Lever;

public class Loader {

    private String[][] map1=new String[][]{
        {"X","X","X","X","X","X","X","X","X","X"},
        {"X"," "," "," ","I"," ","X"," "," ","X"},
        {"X","X","X"," ","X","X","X"," "," ","X"},
        {"X"," ","I"," ","I"," ","X"," "," ","X"},
        {"X","X","X"," ","X","X","X"," "," ","X"},
        {" "," "," "," "," "," "," "," "," ","X"},
        {" "," "," "," "," "," "," "," "," ","X"},
        {"X","X","X"," ","X","X","X","X"," ","X"},
        {"X"," ","I"," ","I"," ","X"," "," ","X"},
        {"X","X","X","X","X","X","X","X","X","X"}
    };
    private String[][] referenceMap1=new String[][]{
            {"X","X","X","X","X","X","X","X","X","X"},
            {"X"," "," "," ","I"," ","X"," "," ","X"},
            {"X","X","X"," ","X","X","X"," "," ","X"},
            {"X"," ","I"," ","I"," ","X"," "," ","X"},
            {"X","X","X"," ","X","X","X"," "," ","X"},
            {" "," "," "," "," "," "," "," "," ","X"},
            {" "," "," "," "," "," "," "," "," ","X"},
            {"X","X","X"," ","X","X","X","X"," ","X"},
            {"X"," ","I"," ","I"," ","X"," "," ","X"},
            {"X","X","X","X","X","X","X","X","X","X"}
    };
    private MapDimension map1Dimension=new MapDimension(10,10);


    private String[][] map2=new String[][]{
            {"X","X","X","X","X","X","X","X","X","X"},
            {" "," "," "," "," "," "," "," "," ","X"},
            {"X"," "," "," "," "," "," "," "," ","X"},
            {"X"," "," "," "," "," "," "," "," ","X"},
            {"X"," "," "," "," "," "," "," "," ","X"},
            {"X"," "," "," "," "," "," "," "," ","X"},
            {"X"," "," "," "," "," "," "," "," ","X"},
            {"X"," "," "," "," "," "," "," "," ","X"},
            {"X"," "," "," "," "," "," "," "," ","X"},
            {"X","X","X","X","X","X","X","X","X","X"}
    };

    private String[][] referenceMap2=new String[][]{
            {"X","X","X","X","X","X","X","X","X","X"},
            {" "," "," "," "," "," "," "," "," ","X"},
            {"X"," "," "," "," "," "," "," "," ","X"},
            {"X"," "," "," "," "," "," "," "," ","X"},
            {"X"," "," "," "," "," "," "," "," ","X"},
            {"X"," "," "," "," "," "," "," "," ","X"},
            {"X"," "," "," "," "," "," "," "," ","X"},
            {"X"," "," "," "," "," "," "," "," ","X"},
            {"X"," "," "," "," "," "," "," "," ","X"},
            {"X","X","X","X","X","X","X","X","X","X"}
    };

    private MapDimension map2Dimension=new MapDimension(10,10);

    private Hero ma1Hero= new Hero(map1,2,1);
    private Hero map2Hero=new Hero(map2,1,8);

    private Guard map1Guard = new Guard(map1);
    private Oggre map2Oggre = new Oggre(map2);

    private Lever map1Lever = new Lever(7,8);
    private Key map2Key = new Key(8,8);

    private Enemy[] map1Enemies=new Enemy[1];
    private Enemy[] map2Enemies = new  Enemy[1];

    private Lever[] map1Levers=new Lever[1];

    private Key[] map2Keys = new Key [1];

    private Door[] map1Doors = new Door[2];
    private Door[] map2Doors = new Door[1];

    public Loader(){

        map1Enemies[0]=map1Guard;
        map1Levers[0]=map1Lever;
        map1Doors[0]=new Door(0,5,map1Lever);
        map1Doors[1]=new Door(0,6,map1Lever);
        map2Enemies[0]= map2Oggre;
        map2Keys[0]=map2Key;
        map2Doors[0]=new Door(0,1,map2Key);


        Map map1 = new Map(this.map1,this.referenceMap1,map1Dimension,ma1Hero,map1Enemies,map1Levers,true);
        map1.setDoor(map1Doors);
        if(map1.mapLogic()){
            this.ma1Hero.setXPos(1);
            this.ma1Hero.setYPos(8);
            Map map2 = new Map(this.map2,this.referenceMap2,map2Dimension,ma1Hero,map2Enemies,map2Keys,false);
            map2.setDoor(map2Doors);
            map2.mapLogic();
        }
    }


}
