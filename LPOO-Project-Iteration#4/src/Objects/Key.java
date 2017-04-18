package Objects;

import java.io.Serializable;

import Characters.Hero;

public class Key extends Object implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int xPos;
    private int yPos;
    private String Representation = "k";
    private boolean wasPicked=false;

    public Key(int x,int y){
        xPos=x;
        yPos=y;
    }
    /*
 		* return this keys x position
 	*/
    public int getxPos() {
        return xPos;
    }
    /*
 		*return this keys y position 
 	*/
    public int getyPos() {
        return yPos;
    }
    /*
 		*return if this key is picked 
 	*/
    public boolean isPicked() {
        return wasPicked;
    }
    /*
 		*detects if a key was picked up by the hero
 	*@param hero the hero to be checked 
 	*/
    public void detectPickup(Hero hero){
        if(hero.getYPos()==this.yPos){
            if(hero.getXPos()==this.xPos){
                this.wasPicked=true;
            }
        }
    }
    /*
 		* sets if this key as been picked
 	*@param wasPicked wheter or not the key has been picked 
 	*/
    public void setWasPicked(boolean wasPicked) {
        this.wasPicked = wasPicked;
    }
    /*
 		* return the representation for this key
 	*/
    public String getRep(){
        return this.Representation;
    }
}
