package Maps;

public interface GameMap {
	boolean moveTo(int x,int y);
	char[][] getMap();
	GameMap nextMap();
}
