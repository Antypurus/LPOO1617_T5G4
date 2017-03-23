package Maps;

import Characters.Character;
import Characters.Hero;
import Characters.Enemy;
import Characters.Oggre;
import Objects.Door;
import Objects.Key;
import Objects.Lever;
import Tools.DistanceCalculator;
import Weapons.Club;
import Weapons.Weapon;
import inputs.TextInput;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Map implements GameMap {

	private String[][] map, resetMap;
	// private Enemy[] enemies = null;
	private Hero hero = null;
	private Key[] keys = null;
	private Lever[] levers = null;
	private Door[] doors = null;
	private boolean hasNextMap = false;
	private GameMap nextMap = null;
	private int height, width;
	private boolean imideateOpen = true;// represents weather or not the player
										// need to spend a movement action to
										// open the door
	private TextInput direction = new TextInput();
	private ArrayList<Enemy> enemies = new ArrayList<Enemy>();

	private void clearEnemies(){
		this.enemies.clear();
		if(this.keys!=null){
			keys=null;
		}
		if(this.levers!=null){
			levers=null;
		}
	}
	
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
			GameMap nextMap) {
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
			GameMap nextMap, boolean hasNextMap) {
		this.map = map;
		this.hero = hero;
		this.keys = key;
		this.hasNextMap = true;
		this.height = dimensions.getySize();
		this.width = dimensions.getxSize();
		this.nextMap = nextMap;
		this.hasNextMap = hasNextMap;
		this.resetMap = referenceMap;
		for (int i = 0; i < enemies.length; i++) {
			this.enemies.add(enemies[i]);
		}
	}

	public void setDoor(Door[] doors) {
		this.doors = doors;
	}

	public void addEnemies(Enemy[] enemies) {
		for (int i = 0; i < enemies.length; i++) {
			this.enemies.add(enemies[i]);
		}
	}

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

	public void setNextMap(GameMap nextMap) {
		this.hasNextMap = true;
		this.nextMap = nextMap;
	}

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
		return false;
	}

	public boolean hasLost() {
		for (int i = 0; i < enemies.size(); i++) {
			if (enemies.get(i).heroDetection(this.hero)) {
				return true;
			}
		}
		return false;
	}

	public boolean hasNextMap() {
		return this.hasNextMap;
	}

	private void resetMap(String[][] map) {
		for (int i = 0; i < this.height; i++) {
			for (int j = 0; j < this.width; j++) {
				this.map[i][j] = map[i][j];
			}
		}
	}

	public void drawMap() {

		this.resetMap(this.resetMap);// we must reset the map before drawing it
										// , this mustnt be done after drawing
										// as we need to check certain
										// conditions trough looking
		// at the maps current state with the new positions for certain not
		// native objects

		if (keys != null) {
			for (int i = 0; i < keys.length; i++) {
				if (!keys[i].isPicked()) {
					map[keys[i].getyPos()][keys[i].getxPos()] = this.keys[i].getRep();
				}
			}
		}

		if (levers != null) {
			for (int i = 0; i < levers.length; i++) {
				map[levers[i].getyPos()][levers[i].getxPos()] = this.levers[i].getRepresentation();
			}
		}

		if (doors != null) {
			for (int i = 0; i < doors.length; i++) {
				map[doors[i].getyPos()][doors[i].getxPos()] = this.doors[i].getRepresentation();
			}
		}

		for (int i = 0; i < enemies.size(); i++) {
			map[enemies.get(i).getYPos()][enemies.get(i).getXPos()] = enemies.get(i).getRepresentation();
			if (enemies.get(i).getWeapons() != null) {
				for (int j = 0; j < enemies.get(i).getWeapons().length; j++) {
					map[enemies.get(i).getWeapons()[j].getyPos()][enemies.get(i).getWeapons()[j]
							.getxPos()] = enemies.get(i).getWeapons()[j].getRep(this.keys, this.levers);
				}
			}
		}
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

	public void SwingDrawMap(JTextArea textArea) {

		textArea.setText("");

		this.resetMap(this.resetMap);// we must reset the map before drawing it
										// , this mustnt be done after drawing
										// as we need to check certain
										// conditions trough looking
		// at the maps current state with the new positions for certain not
		// native objects

		if (keys != null) {
			for (int i = 0; i < keys.length; i++) {
				if (!keys[i].isPicked()) {
					map[keys[i].getyPos()][keys[i].getxPos()] = this.keys[i].getRep();
				}
			}
		}

		if (levers != null) {
			for (int i = 0; i < levers.length; i++) {
				map[levers[i].getyPos()][levers[i].getxPos()] = this.levers[i].getRepresentation();
			}
		}

		if (doors != null) {
			for (int i = 0; i < doors.length; i++) {
				map[doors[i].getyPos()][doors[i].getxPos()] = this.doors[i].getRepresentation();
			}
		}

		for (int i = 0; i < enemies.size(); i++) {
			map[enemies.get(i).getYPos()][enemies.get(i).getXPos()] = enemies.get(i).getRepresentation();
			if (enemies.get(i).getWeapons() != null) {
				for (int j = 0; j < enemies.get(i).getWeapons().length; j++) {
					map[enemies.get(i).getWeapons()[j].getyPos()][enemies.get(i).getWeapons()[j]
							.getxPos()] = enemies.get(i).getWeapons()[j].getRep(this.keys, this.levers);
				}
			}
		}
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

	public boolean mapLogic() {
		int movement;

		while (!hasWon() && !hasLost()) {

			this.drawMap();

			movement = direction.getNextStep();

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
					break;
				}
			default:
				break;
			}

			if (this.hasLost()) {
				System.out.println("\nYou Have Ben Caught !\n YOU LOSE!\n");
				direction.close();
				return false;
			}

			if (keys != null) {
				for (int i = 0; i < keys.length; i++) {
					this.keys[i].detectPickup(this.hero);
				}
			}

			if (levers != null) {
				for (int i = 0; i < levers.length; i++) {
					this.levers[i].detectPress(this.hero);
				}
			}

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

	public boolean SwingmapLogic(int movement) {
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
				break;
			}
		default:
			break;
		}

		if (this.hasLost()) {
			return false;
		}

		if (keys != null) {
			for (int i = 0; i < keys.length; i++) {
				this.keys[i].detectPickup(this.hero);
			}
		}

		if (levers != null) {
			for (int i = 0; i < levers.length; i++) {
				this.levers[i].detectPress(this.hero);
			}
		}

		for (int i = 0; i < enemies.size(); i++) {
			this.enemies.get(i).move();
			if (!this.enemies.get(i).isStuned()) {
				this.enemies.get(i).attack();
			}
		}

		if (this.hasLost()) {
			return false;
		}

		if (hasWon() && (keys == null)) {
			this.clearEnemies();
			return true;
		}
//
		//this.SwingDrawMap(textArea);
		return false;
	}
}
