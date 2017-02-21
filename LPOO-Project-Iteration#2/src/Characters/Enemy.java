package Characters;

public abstract class Enemy {
	int xPos;
	int yPos;
	String type;
	String subType;
	char representation;
	public abstract void move();
	public abstract void attack();
	public abstract String type();
	public abstract String subType();
	public abstract char representation();
}
