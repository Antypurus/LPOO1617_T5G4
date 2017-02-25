package Objects;

public class Key {

    private int xPos;
    private int yPos;
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

    public boolean isWasPicked() {
        return wasPicked;
    }

    public void setWasPicked(boolean wasPicked) {
        this.wasPicked = wasPicked;
    }
}
