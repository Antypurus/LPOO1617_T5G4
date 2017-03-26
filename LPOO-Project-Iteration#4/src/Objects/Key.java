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

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public boolean isPicked() {
        return wasPicked;
    }

    public void detectPickup(Hero hero){
        if(hero.getYPos()==this.yPos){
            if(hero.getXPos()==this.xPos){
                this.wasPicked=true;
            }
        }
    }

    public void setWasPicked(boolean wasPicked) {
        this.wasPicked = wasPicked;
    }

    public String getRep(){
        return this.Representation;
    }
}
