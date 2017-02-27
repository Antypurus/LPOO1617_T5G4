package Objects;

public class Lever {

	private int xPos;
	private int yPos;
	private boolean wasPressed=false;
	
	public Lever(int x,int y){
		this.yPos=y;
		this.xPos=x;
	}
	
	public boolean getState(){
		return wasPressed;
	}
	
}
