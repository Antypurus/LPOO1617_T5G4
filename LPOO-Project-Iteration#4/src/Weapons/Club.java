package Weapons;

import java.io.Serializable;

import Characters.Character;
import Characters.Enemy;

public class Club extends Weapon implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Club(Character owner){
        this.xPos=owner.getXPos();
        this.yPos=owner.getYPos();
        this.weaponName="Club";
        this.Representation="*";
    }
}
