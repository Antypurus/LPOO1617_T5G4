package Objects;

import java.io.Serializable;

public class Wall implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int xPos;
	public int yPos;
	public String Representation = "X";
	
	public Wall(int x,int y){
		this.xPos = x;
		this.yPos = y;
	}
}
