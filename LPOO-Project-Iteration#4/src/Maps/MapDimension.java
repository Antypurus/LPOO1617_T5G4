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
    /*
 		* return the x size of the map
 	*/
    public int getxSize() {
        return xSize;
    }
    /*
 		*return the y size of the map 
 	*/
    public int getySize() {
        return ySize;
    }
}
