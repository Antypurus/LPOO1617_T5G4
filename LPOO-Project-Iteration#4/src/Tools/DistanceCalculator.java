package Tools;

import java.io.Serializable;

import Characters.Enemy;
import Characters.Hero;


public class DistanceCalculator implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int xPos1,yPos1;
    public int xPos2,yPos2;
    public double distance;

    public DistanceCalculator(Hero hero, Enemy enemie){
        this.xPos1=hero.getXPos();
        this.yPos1=hero.getYPos();
        this.xPos2=enemie.getXPos();
        this.yPos2=enemie.getYPos();
    }

    private double calculateDistance(){
        distance=Math.sqrt(Math.pow((xPos1-xPos2),2)+Math.pow((yPos1-yPos2),2));
        return distance;
    }
    /*
 		* return the distance between the specified hero and enemy
 	*/
    public double getDistance(){
        this.calculateDistance();
        return this.distance;
    }
}
