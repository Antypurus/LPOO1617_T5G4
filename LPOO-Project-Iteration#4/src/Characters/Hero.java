package Characters;

import Objects.Key;
import Objects.Lever;

import java.io.Serializable;
import java.util.Scanner;

public class Hero extends Character implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int yPos;
    private int xPos;
    private boolean hasKey=false;
    private boolean pressedLever=false;
    private String representation = "H";
    private String clubRep = "A";
    private String KeyRep = "K";
    private String[][] map;
    private boolean hasClub = false;
	/*
		*return is the hero has a club equiped 
	*/
    public boolean getHasClub(){
        return this.hasClub;
    }
	/*
		*sets if the hero has a club
	*@param value sets if the hero has a club 
	*/
    public void setHasClub(boolean value){
        this.hasClub=value;
    }
	/*
		*returns the hero y position 
	*/
    public int getYPos() {
        return yPos;
    }
	/*
		* return the hero x position
	*/
    public int getXPos() {
        return xPos;
    }
	/*
		*sets the hero y position
	*@param y hero y position 
	*/
    public void setYPos(int y){
        this.yPos=y;
    }
	/*
		* sets the hero x position
	*@param x hero x position 
	*/
    public void setXPos(int x){
        this.xPos=x;
    }
	/*
		* return the hero representation
	*@param keys keys to verify the heros representation with 
	*/
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
	/*
	 * return the hero representation
	*@param  keys levers to verify the heros representation with 
	*/
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
    /*
 		*sets the heroes map
 	*@param map map to be set 
 	*/
    public void setMap(String[][] map){
    	this.map = map;
    }
    
    public Hero(int x,int y){
    	this.xPos = x;
    	this.yPos = y;
    }
    /*
     	*allows to move a hero by a given offset
     *@param x x offset to move the hero by
     *@param y y offset to move the hero by
     */
    public void moveHero(int x,int y) {
       this.yPos+=y;
       this.xPos+=x;
    }
}