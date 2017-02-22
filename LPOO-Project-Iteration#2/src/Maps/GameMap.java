package Maps;

public interface GameMap {
	boolean moveTo(int x,int y);
	String[][] getMap();
	GameMap nextMap();
}
