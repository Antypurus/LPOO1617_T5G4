package Objects;

public class Lever {

	private int xPos;
	private int yPos;
	private boolean wasPressed=false;
	private String Representation = "k";
	
	public Lever(int x,int y){
		this.yPos=y;
		this.xPos=x;
	}


	
	public boolean getState(){
		return wasPressed;
	}

	public void setState(boolean state){
		this.wasPressed=state;
	}

	public int getxPos() {
		return xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public String getRepresentation(){
		return this.Representation;
	}
}
