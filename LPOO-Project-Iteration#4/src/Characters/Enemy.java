package Characters;

import java.io.Serializable;

import Weapons.Weapon;

public abstract class Enemy extends Character implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String[][] map;
	protected int xPos;
	protected int yPos;
	protected String type;
	protected String subType;
	protected String representation;
	protected Weapon[] weapons = null;
	protected int StunCounter=0;
	protected boolean isStuned=false;
	//not used
	public int getStunCounter() {
		return StunCounter;
	}
	/*
	 	*allows to set the ammount of turns an enemy will be stuned for
	 *@param stunCounter ammount of turns to be stuned 
	 */
	public void setStunCounter(int stunCounter) {
		StunCounter = stunCounter;
	}
	/*
	 	* returns if this enemy is stuned
	 */
	public boolean isStuned() {
		return isStuned;
	}
	/*
 		* allows to set if this enemy is stuned
 	*@param stuned wheter or not this enemy is stuned 
 	*/
	public void setStuned(boolean stuned) {
		isStuned = stuned;
	}
	/*
		*return the arrays of weapons of this enemy 
	*/
	public Weapon[] getWeapons(){
		return this.weapons;
	}
	/*
		* allows to set he array of weapons of this enemy
	*@param weponons array of weapons that make up this enemies array of weapons 
	*/
	public void setWeapons(Weapon[] weapons){
		this.weapons=weapons;
	}

	public abstract void move();

	public abstract void attack();

	public abstract String type();

	public abstract String subType();
	/*
		* return this enemys x positions
	*/
	public int getXPos(){
		return xPos;
	}
	/*
		*returns this enemies y position 
	*/
	public int getYPos(){
		return yPos;
	}
	/*
		*return the type of this enemy 
	*/
	public String getType(){
		return type;
	}
	/*
		*return the subtype of this enemy 
	*/
	public String getSubType(){
		return subType;
	}
	/*
		*return the representation of this enemy 
	*/
	public String getRepresentation(){
		return representation;
	}
	/*
		*return wheter the hero can be caught by this enemy
	*@param hero hero to be checked 
	*/
	public boolean heroDetection(Hero hero){
		if(hero.getXPos()==this.xPos){
			if(hero.getYPos()==this.yPos){
				if(!hero.getHasClub()){
					return true;
				}else{
					if(this.type.equals("Ogre")){
						this.isStuned=true;
						this.StunCounter=2;
						return false;
					}
				}
				return true;
			}
		}
		if(hero.getXPos()+1==this.xPos){
			if(hero.getYPos()==this.yPos){
				if(!hero.getHasClub()){

					if(!hero.getHasClub()){
						return true;}else{
						if(this.type.equals("Ogre")){
							this.isStuned=true;
							this.StunCounter=2;
							return false;
						}
					}
					return true;}
			}
		}
		if(hero.getXPos()==this.xPos){
			if(hero.getYPos()+1==this.yPos){
				if(!hero.getHasClub()){

					if(!hero.getHasClub()){
						return true;}else{
						if(this.type.equals("Ogre")){
							this.isStuned=true;
							this.StunCounter=2;
							return false;
						}
					}
					return true;}
			}
		}
		if(hero.getXPos()-1==this.xPos){
			if(hero.getYPos()==this.yPos){
				if(!hero.getHasClub()){

					if(!hero.getHasClub()){
						return true;}else{
						if(this.type.equals("Ogre")){
							this.isStuned=true;
							this.StunCounter=2;
							return false;
						}
					}
					return true;}
			}
		}
		if(hero.getXPos()==this.xPos){
			if(hero.getYPos()-1==this.yPos){
				if(!hero.getHasClub()){

					if(!hero.getHasClub()){
						return true;}else{
						if(this.type.equals("Ogre")){
							this.isStuned=true;
							this.StunCounter=2;
							return false;
						}
					}
					return true;}
			}
		}

		if(this.weapons!=null){
			for(int i=0;i<weapons.length;i++){
				if(hero.getYPos()==this.weapons[i].getyPos()){
					if(hero.getXPos()==this.weapons[i].getxPos()){
						return true;
					}
				}
				if(hero.getYPos()+1==this.weapons[i].getyPos()){
					if(hero.getXPos()==this.weapons[i].getxPos()){
						return true;
					}
				}
				if(hero.getYPos()==this.weapons[i].getyPos()){
					if(hero.getXPos()+1==this.weapons[i].getxPos()){
						return true;
					}
				}
				if(hero.getYPos()-1==this.weapons[i].getyPos()){
					if(hero.getXPos()==this.weapons[i].getxPos()){
						return true;
					}
				}
				if(hero.getYPos()==this.weapons[i].getyPos()){
					if(hero.getXPos()-1==this.weapons[i].getxPos()){
						return true;
					}
				}
			}
		}

		return false;
	}
}
