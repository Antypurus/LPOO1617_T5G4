package Maps;

import Characters.Character;

public interface GameMap {
	boolean moveTo(int x, int y,Character character);
	String[][] getMap();
	GameMap nextMap();
	boolean hasWon();
	void drawMap();
}
