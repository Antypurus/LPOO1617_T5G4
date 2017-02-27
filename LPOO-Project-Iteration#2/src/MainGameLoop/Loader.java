package MainGameLoop;

import Characters.Enemy;
import Characters.Guard;
import Characters.Hero;
import Characters.Oggre;
import Maps.Map;
import Maps.MapDimension;
import Objects.Key;

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
    private MapDimension map2Dimension=new MapDimension(10,10);

    private Hero ma1Hero= new Hero(map1,2,1);
    private Hero map2Hero=new Hero(map2,1,8);

    private Guard map1Guard = new Guard(map1);
    private Oggre map2Oggre = new Oggre(map2);

    private Enemy[] map1Enemies=new Enemy[1];
    private Key[] map1Keys=new Key[1];

    public Loader(){
        map1Enemies[0]=map1Guard;
        map1Keys[0]=new Key(7,8);

        Map map1 = new Map(this.map1,map1Dimension,ma1Hero,map1Enemies,map1Keys,true);
        map1.drawMap();
    }


}
