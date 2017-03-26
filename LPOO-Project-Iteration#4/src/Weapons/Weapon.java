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

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setxPos(int x){
        this.xPos=x;
    }

    public void setyPos(int y){
        this.yPos=y;
    }

    public Character getOwner() {
        return owner;
    }

    public String getName(){
        return this.weaponName;
    }

    public boolean hitDetection(Hero hero){// very rough still being worked on and is meant to be used as a wraper class
        if(hero.getXPos()==this.xPos){
            if(hero.getYPos()==this.yPos){
                return true;
            }
        }
        return false;
    }
}
