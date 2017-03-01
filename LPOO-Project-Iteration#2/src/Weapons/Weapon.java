package Weapons;

public abstract class Weapon {

    int xPos;
    int yPos;
    Character owner=null;
    String weaponName=null;
    String Representation;

    public String getRep(){
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
}
