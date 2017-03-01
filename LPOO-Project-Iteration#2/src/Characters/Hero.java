package Characters;

import java.util.Scanner;

public class Hero extends Character {
    private int yPos;
    private int xPos;
    private boolean hasKey=false;
    private boolean pressedLever=false;
    private String representation = "H";
    private String[][] map;

    public int getYPos() {
        return yPos;
    }
    public int getXPos() {
        return xPos;
    }

    public void setYPos(int y){
        this.yPos=y;
    }

    public void setXPos(int x){
        this.xPos=x;
    }

    public String getRepresentation(){
        return representation;
    }

    public Hero(String[][] map, int x, int y) {
        this.map = map;
        this.xPos=x;
        this.yPos=y;

    }


    public void moveHero(int x,int y) {
       this.yPos+=y;
       this.xPos+=x;
    }
}