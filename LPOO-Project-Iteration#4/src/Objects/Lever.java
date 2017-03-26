package Objects;

import java.io.Serializable;

import Characters.Hero;

public class Lever implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int xPos;
	private int yPos;
	private boolean wasPressed=false;
	private String Representation = "k";
	
	public Lever(int x,int y){
		this.yPos=y;
		this.xPos=x;
	}


	
	public boolean getState(){
		return wasPressed;
	}

	public void setState(boolean state){
		this.wasPressed=state;
	}

	public void detectPress(Hero hero){
		if(hero.getXPos()==this.xPos){
			if(hero.getYPos()==this.yPos){
				this.wasPressed=true;
			}
		}
	}

	public int getxPos() {
		return xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public String getRepresentation(){
		return this.Representation;
	}
}
