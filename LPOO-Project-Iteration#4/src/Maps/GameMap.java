package Maps;

import java.io.Serializable;

import Characters.Character;

public interface GameMap extends Serializable{
	boolean moveTo(int x, int y,Character character);
	String[][] getMap();
	GameMap nextMap();
	boolean hasWon();
	void drawMap();
	boolean mapLogic();
}
