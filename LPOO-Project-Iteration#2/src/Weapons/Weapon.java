package Weapons;

public abstract class Weapon {

    int xPos;
    int yPos;
    Character owner=null;
    String weaponName=null;

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public Character getOwner() {
        return owner;
    }

    public String getName(){
        return this.weaponName;
    }
}
