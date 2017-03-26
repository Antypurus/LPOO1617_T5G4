package Maps;

import Characters.Character;
import Characters.Hero;
import Characters.Enemy;
import Characters.Oggre;
import Objects.Door;
import Objects.Key;
import Objects.Lever;
import Objects.Wall;
import Tools.DistanceCalculator;
import Weapons.Club;
import Weapons.Weapon;
import inputs.TextInput;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Map implements GameMap, Serializable {
//
	/**
	 * 
	 */
	private static final long serialVersionUID = -5432316826595997002L;

	private String[][] map, resetMap;
	// private Enemy[] enemies = null;
	private Hero hero = null;
	private Key[] keys = null;
	private Lever[] levers = null;
	private Door[] doors = null;
	private boolean hasNextMap = false;
	private Map nextMap = null;
	private int height, width;
	private boolean imideateOpen = true;// represents weather or not the player
										// need to spend a movement action to
										// open the door
	private TextInput direction = new TextInput();
	private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	private ArrayList<Wall> nonStandardWall = new ArrayList<Wall>();
	private ArrayList<Door> nonStandardDoors = new ArrayList<Door>();
	private ArrayList<Lever> nonStandardLever = new ArrayList<Lever>();
	private ArrayList<Key> nonStandardKeys = new ArrayList<Key>();

	/*
	 	*allows to set the map that comes after this one in the logical flow of the game
	 *@param nextMap a map object that represents the map that comes next
	 */
	public void setNextMap(Map nextMap) {
		this.hasNextMap = true;
		this.nextMap = nextMap;
	}
	//do not use
	public void addDoor(Door door, Key associatedKey) {
		this.nonStandardDoors.add(door);
		this.nonStandardKeys.add(associatedKey);
	}
	//do not use
	public Door[] getNonStandardDoors() {
		return (Door[]) this.nonStandardDoors.toArray();
	}
	//do not use
	public Key[] getNonStandardKeys() {
		return (Key[]) this.nonStandardKeys.toArray();
	}
	//do not use
	public Lever[] getNonStandardLever() {
		return (Lever[]) this.nonStandardLever.toArray();
	}
	//do not use
	public void addDoor(Door door, Lever associatedLever) {
		this.nonStandardDoors.add(door);
		this.nonStandardLever.add(associatedLever);
	}
	//do not use
	public void addWall(Wall wall) {
		this.nonStandardWall.add(wall);
	}
	//do not use
	public void addWall(Wall[] walls) {
		for (int i = 0; i < walls.length; i++) {
			this.nonStandardWall.add(walls[i]);
		}
	}
	//do not use
	public Wall[] getWalls() {
		return (Wall[]) this.nonStandardWall.toArray();
	}
	/*
	 	*return a Map type object that represents the next map 
	 */
	public Map getNextMap() {
		return this.nextMap;
	}
	/*
	 	*returns the arraylist that holds all the enemis in this map 
	 */
	public ArrayList<Enemy> getEnemies() {
		return this.enemies;
	}
	/*
	 	*return this maps hero 
	 */
	public Hero getHero() {
		return this.hero;
	}
	/*
	 	*returns all the doors in the map 
	 */
	public Door[] getDoors() {
		return this.doors;
	}
	/*
 		*returns all the levers in the map 
 	*/
	public Lever[] getLevers() {
		return this.levers;
	}
	/*
		*returns all the keys in the map 
	*/
	public Key[] getKeys() {
		return this.keys;
	}
	/*
		*returns all the reference map in the map 
	*/
	public String[][] getReferenceMap() {
		return this.resetMap;
	}
	/*
		*returns the height of the map
	*/
	public int getHeight() {
		return this.height;
	}
	/*
		*returns the width of the map
	*/
	public int getWidth() {
		return this.width;
	}

	private void clearEnemies() {
		this.enemies.clear();
		if (this.keys != null) {
			keys = null;
		}
		if (this.levers != null) {
			levers = null;
		}
	}
	/*
		*Map constructor
	*@param map map to be edited
	*@param referenceMap map that will be used to reset the previous parameter
	*@param dimensions object of type MapDimension that represents the dimensions of the map
	*@param hero hero of this map
	*@param enemies enemies for this map
	*@param key keys or levers for this map
	*/
	public Map(String[][] map, String[][] referenceMap, MapDimension dimensions, Hero hero, Enemy[] enemies,
			Key[] key) {
		this.map = map;
		this.resetMap = referenceMap;
		this.hero = hero;
		this.keys = key;
		this.height = dimensions.getySize();
		this.width = dimensions.getxSize();
		for (int i = 0; i < enemies.length; i++) {
			this.enemies.add(enemies[i]);
		}
	}

	public Map(String[][] map, String[][] referenceMap, MapDimension dimensions, Hero hero, Enemy[] enemies, Key[] key,
			boolean hasNextMap) {
		this.map = map;
		this.hero = hero;
		this.keys = key;
		this.height = dimensions.getySize();
		this.width = dimensions.getxSize();
		this.hasNextMap = hasNextMap;
		this.resetMap = referenceMap;
		for (int i = 0; i < enemies.length; i++) {
			this.enemies.add(enemies[i]);
		}
	}

	public void bld(String[][] map, String[][] referenceMap, MapDimension dimensions, Hero hero, Enemy[] enemies,
			Key[] key, boolean hasNextMap) {
		this.map = map;
		this.hero = hero;
		this.keys = key;
		this.height = dimensions.getySize();
		this.width = dimensions.getxSize();
		this.resetMap = referenceMap;
		for (int i = 0; i < enemies.length; i++) {
			this.enemies.add(enemies[i]);
		}
		this.hasNextMap = hasNextMap;
	}

	public Map(String[][] map, String[][] referenceMap, MapDimension dimensions, Hero hero, Enemy[] enemies,
			Lever[] levers) {
		this.map = map;
		this.resetMap = referenceMap;
		this.hero = hero;
		this.levers = levers;
		this.height = dimensions.getySize();
		this.width = dimensions.getxSize();
		for (int i = 0; i < enemies.length; i++) {
			this.enemies.add(enemies[i]);
		}
	}

	public void bld(String[][] map, String[][] referenceMap, MapDimension dimensions, Hero hero, Enemy[] enemies,
			Lever[] levers, boolean hasNextMap) {
		this.map = map;
		this.resetMap = referenceMap;
		this.hero = hero;
		this.levers = levers;
		this.height = dimensions.getySize();
		this.width = dimensions.getxSize();
		for (int i = 0; i < enemies.length; i++) {
			this.enemies.add(enemies[i]);
		}
		this.hasNextMap = hasNextMap;
	}

	public Map(String[][] map, String[][] referenceMap, MapDimension dimensions, Hero hero, Enemy[] enemies,
			Lever[] levers, boolean hasNextMap) {
		this.map = map;
		this.hero = hero;
		this.levers = levers;
		this.height = dimensions.getySize();
		this.width = dimensions.getxSize();
		this.hasNextMap = hasNextMap;
		this.resetMap = referenceMap;
		for (int i = 0; i < enemies.length; i++) {
			this.enemies.add(enemies[i]);
		}
	}

	public Map(String[][] map, String[][] referenceMap, MapDimension dimensions, Hero hero, Enemy[] enemies, Key[] key,
			Map nextMap) {
		this.map = map;
		this.hero = hero;
		this.keys = key;
		this.hasNextMap = true;
		this.height = dimensions.getySize();
		this.width = dimensions.getxSize();
		this.nextMap = nextMap;
		this.resetMap = referenceMap;
		for (int i = 0; i < enemies.length; i++) {
			this.enemies.add(enemies[i]);
		}
	}

	public Map(String[][] map, String[][] referenceMap, MapDimension dimensions, Hero hero, Enemy[] enemies, Key[] key,
			Map nextMap, boolean hasNextMap) {
		this.map = map;
		this.hero = hero;
		this.keys = key;
		this.hasNextMap = true;
		this.height = dimensions.getySize();
		this.width = dimensions.getxSize();
		this.nextMap = (Map) nextMap;
		this.hasNextMap = hasNextMap;
		this.resetMap = referenceMap;
		for (int i = 0; i < enemies.length; i++) {
			this.enemies.add(enemies[i]);
		}
	}
	/*
		*allows to set the doors present in this map
	*@param doors the doors that will be present in this map
	*/
	public void setDoor(Door[] doors) {
		this.doors = doors;
	}
	/*
		*allows to add enemies to the map
	*@param enemies array of enemies to be added to the map
	*/
	public void addEnemies(Enemy[] enemies) {
		for (int i = 0; i < enemies.length; i++) {
			this.enemies.add(enemies[i]);
		}
	}
	/*
		*allows to add one enemy to the map
	*@param enemie enemy object to be added to the map
	*/
	public void addEnemy(Enemy enemie) {
		this.enemies.add(enemie);
	}
	//do not use
	public void generateRandomOgres(int n_oggre) {
		Random generator = new Random();
		Weapon[] add = new Club[1];
		Enemy[] send = new Enemy[n_oggre];
		for (int i = 0; i < n_oggre; i++) {
			Oggre send_ = new Oggre(this.map);
			DistanceCalculator calc = new DistanceCalculator(this.hero, send_);
			add[0] = new Club(send_);
			send_.setWeapons(add);
			if (calc.getDistance() < 2) {
				i--;
			} else {
				send[i] = send_;
			}
		}
		this.addEnemies(send);
	}
	/*
		*returns if a given characters position is allowed to be changed by the passed offset
	*@param x offset to the characters x position
	*@param y offset to the characters y position
	*@param character character whose movement will be tested 
	*/
	public boolean moveTo(int x, int y, Character character) {
		int intX = character.getXPos() + x;
		int intY = character.getYPos() + y;
		System.out.print("\n Atempting to move to : (" + intX + "," + intY + ")\n");
		if (intX < 0 || intX > this.width) {
			return false;
		}
		if (intY < 0 || intY > this.height) {
			return false;
		}
		String check = map[intY][intX];
		if (check.equals("X") || check.equals("I") || check.equals("H") || check.equals("O") || check.equals("G")) {
			return false;
		}
		return true;
	}

	public void setNextMap_(Map nextMap) {
		this.hasNextMap = true;
		this.nextMap = nextMap;
	}
	/*
		*returns a 2D array that constain the map 
	*/
	public String[][] getMap() {
		return map;
	}

	public GameMap nextMap() {
		if (hasNextMap) {
			return nextMap;
		} else {
			return null;
		}
	}
	/*
		*returns if the player has passed the level and can either win or move to the next map
	*/
	public boolean hasWon() {
		int x = hero.getXPos();
		int y = hero.getYPos();
		String check = map[y][x];
		if (doors != null) {
			for (int i = 0; i < doors.length; i++) {
				if (doors[i].getIsOpen()) {
					if (x == doors[i].getxPos()) {
						if (y == doors[i].getyPos()) {
							return true;
						}
					}
				}
			}
		}
		for(int i=0;i<this.nonStandardDoors.size();i++){
			if (nonStandardDoors.get(i).getIsOpen()) {
				if (x == nonStandardDoors.get(i).getxPos()) {
					if (y == nonStandardDoors.get(i).getyPos()) {
						return true;
					}
				}
			}
		}
		return false;
	}
	/*
		*returns if the player has been caught
	*/
	public boolean hasLost() {
		for (int i = 0; i < enemies.size(); i++) {
			if (enemies.get(i).heroDetection(this.hero)) {
				return true;
			}
		}
		return false;
	}
	/*
		*returns if there is a next map in the logical flow of the game
	*/
	public boolean hasNextMap() {
		return this.hasNextMap;
	}
	/*
		*resets the map
	*/
	private void resetMap(String[][] map) {
		for (int i = 0; i < this.height; i++) {
			for (int j = 0; j < this.width; j++) {
				this.map[i][j] = map[i][j];
			}
		}
	}
	/*
		*draws to the map the keys in the map
	*/
	private void drawkeys() {
		if (keys != null) {
			for (int i = 0; i < keys.length; i++) {
				if (!keys[i].isPicked()) {
					map[keys[i].getyPos()][keys[i].getxPos()] = this.keys[i].getRep();
				}
			}
		}

		for (int i = 0; i < this.nonStandardKeys.size(); i++) {
			if (!nonStandardKeys.get(i).isPicked()) {
				map[nonStandardKeys.get(i).getyPos()][nonStandardKeys.get(i).getxPos()] = this.nonStandardKeys.get(i)
						.getRep();
			}
		}
	}
	/*
		*draws to the map the levers in the map
	*/
	private void drawLevers() {
		if (levers != null) {
			for (int i = 0; i < levers.length; i++) {
				map[levers[i].getyPos()][levers[i].getxPos()] = this.levers[i].getRepresentation();
			}
		}

		for (int i = 0; i < this.nonStandardLever.size(); i++) {
			map[nonStandardLever.get(i).getyPos()][nonStandardLever.get(i).getxPos()] = this.nonStandardLever.get(i)
					.getRepresentation();
		}
	}
	/*
		*draws to the map the doors in the map
	*/
	private void drawDoors() {
		if (doors != null) {
			for (int i = 0; i < doors.length; i++) {
				map[doors[i].getyPos()][doors[i].getxPos()] = this.doors[i].getRepresentation();
			}
		}

		for (int i = 0; i < this.nonStandardDoors.size(); i++) {
			map[nonStandardDoors.get(i).getyPos()][nonStandardDoors.get(i).getxPos()] = this.nonStandardDoors.get(i)
					.getRepresentation();
		}
	}
	/*
		*draws to the map all the enemies in the map
	*/
	private void drawEnemies() {
		for (int i = 0; i < enemies.size(); i++) {
			map[enemies.get(i).getYPos()][enemies.get(i).getXPos()] = enemies.get(i).getRepresentation();
			if (enemies.get(i).getWeapons() != null) {
				for (int j = 0; j < enemies.get(i).getWeapons().length; j++) {
					map[enemies.get(i).getWeapons()[j].getyPos()][enemies.get(i).getWeapons()[j]
							.getxPos()] = enemies.get(i).getWeapons()[j].getRep(this.keys, this.levers);
				}
			}
		}
	}
	/*
		*draws the map to the console
	*/
	public void drawMap() {
		this.resetMap(this.resetMap);// we must reset the map before drawing it
										// , this mustnt be done after drawing
										// as we need to check certain
										// conditions trough looking
		// at the maps current state with the new positions for certain not
		// native objects
		this.drawkeys();
		this.drawLevers();
		this.drawDoors();
		this.drawEnemies();
		if (keys != null) {
			map[hero.getYPos()][hero.getXPos()] = hero.getRepresentation(this.keys);
		} else {
			map[hero.getYPos()][hero.getXPos()] = hero.getRepresentation(this.levers);
		}
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				System.out.print("|" + map[i][j] + "|");
			}
			System.out.print("\n");
		}
	}
	/*
		*draws the map to a swing gui
	*@param textArea swing guy JTextArea to draw the map on
	*/
	public void SwingDrawMap(JTextArea textArea) {
		textArea.setText("");
		this.resetMap(this.resetMap);// we must reset the map before drawing it
										// , this mustnt be done after drawing
										// as we need to check certain
										// conditions trough looking
		// at the maps current state with the new positions for certain not
		// native objects
		this.drawkeys();
		this.drawLevers();
		this.drawDoors();
		this.drawEnemies();
		if (keys != null) {
			map[hero.getYPos()][hero.getXPos()] = hero.getRepresentation(this.keys);
		} else {
			map[hero.getYPos()][hero.getXPos()] = hero.getRepresentation(this.levers);
		}

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				textArea.append(map[i][j]);
			}
			textArea.append("\n");
		}
	}
	/*
		*draws the map using sprites
	*/
	public void SwingDrawMap() {
		this.resetMap(this.resetMap);// we must reset the map before drawing it
										// , this mustnt be done after drawing
										// as we need to check certain
										// conditions trough looking
		// at the maps current state with the new positions for certain not
		// native objects
		this.drawkeys();
		this.drawLevers();
		this.drawDoors();
		this.drawEnemies();
	}
	/*
		*interprets a characters movement given the direction in wich the character should move
	*@param movement direction to move the character
	*/
	private void movementInterpreter(int movement){
		switch (movement) {
		case (1):
			if (this.moveTo(0, -1, this.hero)) {
				this.hero.moveHero(0, -1);
				break;
			} else {
				for (int i = 0; i < doors.length; i++) {
					if (hero.getYPos() - 1 == doors[i].getyPos()) {
						if (hero.getXPos() == doors[i].getxPos()) {
							doors[i].setOpen(true);
						}
					}
				}
				for(int i=0;i<this.nonStandardDoors.size();i++){
					if (hero.getYPos() - 1 == nonStandardDoors.get(i).getyPos()) {
						if (hero.getXPos() == nonStandardDoors.get(i).getxPos()) {
							nonStandardDoors.get(i).setOpen(true);
						}
					}
				}
				break;
			}
		case (2):
			if (this.moveTo(0, 1, this.hero)) {
				this.hero.moveHero(0, 1);
				break;
			} else {
				for (int i = 0; i < doors.length; i++) {
					if (hero.getYPos() + 1 == doors[i].getyPos()) {
						if (hero.getXPos() == doors[i].getxPos()) {
							doors[i].setOpen(true);
						}
					}
				}
				for(int i=0;i<this.nonStandardDoors.size();i++){
					if (hero.getYPos() + 1 == nonStandardDoors.get(i).getyPos()) {
						if (hero.getXPos() == nonStandardDoors.get(i).getxPos()) {
							nonStandardDoors.get(i).setOpen(true);
						}
					}
				}
				break;
			}
		case (3):
			if (this.moveTo(-1, 0, this.hero)) {
				this.hero.moveHero(-1, 0);
				break;
			} else {
				for (int i = 0; i < doors.length; i++) {
					if (hero.getYPos() == doors[i].getyPos()) {
						if (hero.getXPos() - 1 == doors[i].getxPos()) {
							doors[i].setOpen(true);
						}
					}
				}
				for(int i=0;i<this.nonStandardDoors.size();i++){
					if (hero.getYPos() == nonStandardDoors.get(i).getyPos()) {
						if (hero.getXPos()-1 == nonStandardDoors.get(i).getxPos()) {
							nonStandardDoors.get(i).setOpen(true);
						}
					}
				}
				break;
			}
		case (4):
			if (this.moveTo(1, 0, this.hero)) {
				this.hero.moveHero(1, 0);
				break;
			} else {
				for (int i = 0; i < doors.length; i++) {
					if (hero.getYPos() == doors[i].getyPos()) {
						if (hero.getXPos() + 1 == doors[i].getxPos()) {
							doors[i].setOpen(true);
						}
					}
				}
				for(int i=0;i<this.nonStandardDoors.size();i++){
					if (hero.getYPos() == nonStandardDoors.get(i).getyPos()) {
						if (hero.getXPos()+1 == nonStandardDoors.get(i).getxPos()) {
							nonStandardDoors.get(i).setOpen(true);
						}
					}
				}
				break;
			}
		default:
			break;
		}
	}
	/*
		*runs the logic associated the keys
	*/
	private void keyLogic(){
		if (keys != null) {
			for (int i = 0; i < keys.length; i++) {
				this.keys[i].detectPickup(this.hero);
			}
		}
		for(int i=0;i<this.nonStandardKeys.size();i++){
			this.nonStandardKeys.get(i).detectPickup(this.hero);
		}
	}
	/*
		*runs the logic associated to the levers in the map
	*/
	private void leverLogic(){
		if (levers != null) {
			for (int i = 0; i < levers.length; i++) {
				this.levers[i].detectPress(this.hero);
			}
		}
		for(int i=0;i<this.nonStandardLever.size();i++){
			this.nonStandardLever.get(i).detectPress(this.hero);
		}
	}
	/*
		*runs the map logic in the console
	*/
	public boolean mapLogic() {
		int movement;
		while (!hasWon() && !hasLost()) {
			this.drawMap();
			movement = direction.getNextStep();
			this.movementInterpreter(movement);
			if (this.hasLost()) {
				System.out.println("\nYou Have Ben Caught !\n YOU LOSE!\n");
				direction.close();
				return false;
			}
			this.keyLogic();
			this.leverLogic();
			for (int i = 0; i < enemies.size(); i++) {
				this.enemies.get(i).move();
				if (!this.enemies.get(i).isStuned()) {
					this.enemies.get(i).attack();
				}
			}
			if (this.hasLost()) {
				System.out.println("\nYou Have Ben Caught !\n YOU LOSE!\n");
				direction.close();
				return false;
			}
			if (hasWon() && (keys == null)) {
				System.out.println("\nCongratulations you have won\n");
				this.clearEnemies();
				return true;
			}
		}
		direction.close();
		return false;
	}
	/*
		*runs the map logic using a swing gui
	*@param movements direction in wich to move
	*/
	public boolean SwingmapLogic(int movement) {
		this.movementInterpreter(movement);
		this.SwingDrawMap();
		if (this.hasLost()) {
			return false;
		}
		this.keyLogic();
		this.leverLogic();
		this.enemies.get(0).move();
		if (!this.enemies.get(0).isStuned()) {
			this.enemies.get(0).attack();
		}
		if (this.hasLost()) {
			return false;
		}
		if (hasWon() && (keys == null)) {
			this.clearEnemies();
			return true;
		}
		this.SwingDrawMap();
		return false;
	}
}
