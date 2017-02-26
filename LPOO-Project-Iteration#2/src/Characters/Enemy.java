package Characters;

public abstract class Enemy extends Character {
	
	protected String[][] map;
	protected int xPos;
	protected int yPos;
	protected String type;
	protected String subType;
	protected String representation;

	public abstract void move();

	public abstract void attack();

	public abstract String type();

	public abstract String subType();
	
	public int getXPos(){
		return xPos;
	}
	
	public int getYPos(){
		return yPos;
	}
	
	public String getType(){
		return type;
	}
	
	public String getSubType(){
		return subType;
	}
	
	public String getRepresentation(){
		return representation;
	}
}
