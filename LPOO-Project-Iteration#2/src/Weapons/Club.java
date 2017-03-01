package Weapons;

import Characters.Character;
import Characters.Enemy;

public class Club extends Weapon {

    public Club(Character owner){
        this.xPos=owner.getXPos();
        this.yPos=owner.getYPos();
        this.weaponName="Club";
        this.Representation="*";
    }
}
