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

	public int getStunCounter() {
		return StunCounter;
	}

	public void setStunCounter(int stunCounter) {
		StunCounter = stunCounter;
	}

	public boolean isStuned() {
		return isStuned;
	}

	public void setStuned(boolean stuned) {
		isStuned = stuned;
	}

	public Weapon[] getWeapons(){
		return this.weapons;
	}

	public void setWeapons(Weapon[] weapons){
		this.weapons=weapons;
	}

	public abstract void move();

	public abstract void attack();

	public abstract String type();

	public abstract String subType();
	
	public int getXPos(){
		return xPos;
	}
	
	public int getYPos(){
		return yPos;
	}
	
	public String getType(){
		return type;
	}
	
	public String getSubType(){
		return subType;
	}
	
	public String getRepresentation(){
		return representation;
	}

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
