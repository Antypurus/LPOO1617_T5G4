package Characters;

import java.io.Serializable;

public abstract class Character implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int xPos;
    private int yPos;

    public int getYPos() {
        return yPos;
    }
    public int getXPos() {
        return xPos;
    }
}
