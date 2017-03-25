package Characters;

import Objects.Key;
import Objects.Lever;

import java.util.Scanner;

public class Hero extends Character {
    private int yPos;
    private int xPos;
    private boolean hasKey=false;
    private boolean pressedLever=false;
    private String representation = "H";
    private String clubRep = "A";
    private String KeyRep = "K";
    private String[][] map;
    private boolean hasClub = false;

    public boolean getHasClub(){
        return this.hasClub;
    }

    public void setHasClub(boolean value){
        this.hasClub=value;
    }

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

    public String getRepresentation(Key[] keys){
        for(int i=0;i<keys.length;i++){
            if(this.xPos==keys[i].getxPos()){
                if(this.yPos==keys[i].getyPos()){
                    if(!keys[i].isPicked())
                    return this.KeyRep;
                }
            }
        }
        if(this.hasClub){
            return this.clubRep;
        }
        return representation;
    }

    public String getRepresentation(Lever[] keys){
        for(int i=0;i<keys.length;i++){
            if(this.xPos==keys[i].getxPos()){
                if(this.yPos==keys[i].getyPos()){
                    return this.KeyRep;
                }
            }
        }
        if(this.hasClub){
            return this.clubRep;
        }
        return representation;
    }

    public Hero(String[][] map, int x, int y) {
        this.map = map;
        this.xPos=x;
        this.yPos=y;

    }
    
    public void setMap(String[][] map){
    	this.map = map;
    }
    
    public Hero(int x,int y){
    	this.xPos = x;
    	this.yPos = y;
    }

    public void moveHero(int x,int y) {
       this.yPos+=y;
       this.xPos+=x;
    }
}