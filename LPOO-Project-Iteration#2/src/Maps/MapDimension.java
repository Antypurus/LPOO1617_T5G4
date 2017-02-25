package Maps;

public class MapDimension {
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
