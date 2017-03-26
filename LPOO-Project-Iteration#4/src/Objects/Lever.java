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
    /*
 		*return if the lever has been pressed 
 	*/
	public boolean getState(){
		return wasPressed;
	}
    /*
 		*sets the press state of the lever
 	* @param state state of the lever
 	*/
	public void setState(boolean state){
		this.wasPressed=state;
	}
    /*
 		*detects if the lever has been pressed
 	*@param hero hero to be checked 
 	*/
	public void detectPress(Hero hero){
		if(hero.getXPos()==this.xPos){
			if(hero.getYPos()==this.yPos){
				this.wasPressed=true;
			}
		}
	}
    /*
 		* return this levers x position
 	*/
	public int getxPos() {
		return xPos;
	}
    /*
 		*return this levers y position 
 	*/
	public int getyPos() {
		return yPos;
	}
    /*
 		* returns this levers representation
 	*/
	public String getRepresentation(){
		return this.Representation;
	}
}
