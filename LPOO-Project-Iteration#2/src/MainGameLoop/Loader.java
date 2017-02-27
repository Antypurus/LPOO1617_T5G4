package MainGameLoop;

import Characters.Guard;
import Characters.Hero;
import Characters.Oggre;
import Maps.MapDimension;

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


    Hero ma1Hero= new Hero(map1,2,1);
    Hero map2Hero=new Hero(map2,1,8);

    Guard map1Guard = new Guard(map1);
    Oggre map2Oggre = new Oggre(map2);



}
