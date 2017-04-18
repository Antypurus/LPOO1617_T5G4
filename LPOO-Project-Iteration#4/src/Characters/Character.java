package Characters;

import java.io.Serializable;

public abstract class Character implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int xPos;
    private int yPos;
	/*
		*returns the current y position of the character
	*/
    public int getYPos() {
        return yPos;
    }
	/*
		*returns the current x position of the character 
	*/
    public int getXPos() {
        return xPos;
    }
}
