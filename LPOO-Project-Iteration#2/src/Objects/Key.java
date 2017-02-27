package Objects;

public class Key extends Object {

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

    public void setWasPicked(boolean wasPicked) {
        this.wasPicked = wasPicked;
    }

    public String getRep(){
        return this.Representation;
    }
}
