package Maps;

import java.io.Serializable;

public class MapDimension implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int xSize;
    private int ySize;

    public MapDimension(int width_x,int height_y){

        this.xSize=width_x;
        this.ySize=height_y;

    }

    public int getxSize() {
        return xSize;
    }

    public int getySize() {
        return ySize;
    }
}
