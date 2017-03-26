package Weapons;

import java.io.Serializable;

import Characters.Hero;
import Objects.Key;
import Objects.Lever;

public abstract class Weapon implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int xPos;
    int yPos;
    Character owner=null;
    String weaponName=null;
    String Representation;
    /*
 		* return the representation of this weapon given an array of keys and levers
 	*@param keys keys to be checked
 	*@param levers levers to be checked 
 	*/
    public String getRep(Key[] keys, Lever[] levers){
        if(keys!=null){
            for(int i=0;i<keys.length;i++){
                if(keys[i].getxPos()==this.xPos){
                    if(keys[i].getyPos()==this.yPos){
                        return "$";
                    }
                }
            }
        }
        if(levers!=null){
            for(int i=0;i<levers.length;i++){
                if(levers[i].getxPos()==this.xPos){
                    if(levers[i].getyPos()==this.yPos){
                        return "$";
                    }
                }
            }
        }
        return this.Representation;
    }
    /*
 		* return this weapons x position
 	*/
    public int getxPos() {
        return xPos;
    }
    /*
 		*returns this weapons y postion  
 	*/
    public int getyPos() {
        return yPos;
    }
    /*
 		*sets this weapons x position
 	*@param x x coordinate to set the weapon to 
 	*/
    public void setxPos(int x){
        this.xPos=x;
    }
    /*
 		*sets this weapons y position
 	*@param y y coordinate to set this weapon to 
 	*/
    public void setyPos(int y){
        this.yPos=y;
    }
    /*
 		* returns the owner of this weapon
 	*/
    public Character getOwner() {
        return owner;
    }
    /*
 		* returns the name of the weapon
 	*/
    public String getName(){
        return this.weaponName;
    }
    /*
 		* return if the hero was caught by this weapon
 	*@param hero to be checked 
 	*/
    public boolean hitDetection(Hero hero){// very rough still being worked on and is meant to be used as a wraper class
        if(hero.getXPos()==this.xPos){
            if(hero.getYPos()==this.yPos){
                return true;
            }
        }
        return false;
    }
}
