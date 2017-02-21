package Characters;

import java.util.Random;

public class Oggre extends Enemy{

	public Oggre(){
		type = "Ogre";
		subType = "Crazy";
		xPos = 4;
		yPos = 1;
		representation = 'O';
	}
	
	public void moveOgre() {
		Random generator = new Random();
		int movement = generator.nextInt(4);
		if (movement == 0) {
			if ((!(map[yPos + 1][xPos].equals("X"))) && (!(map[yPos + 1][xPos].equals("I")))
					&& (!(map[yPos + 1][xPos].equals("H")))) {
				yPos++;
			} else {
				moveOgre();
			}
		}
		if (movement == 1) {
			if ((!(map[yPos - 1][xPos].equals("X"))) && (!(map[yPos - 1][xPos].equals("I")))
					&& (!(map[yPos - 1][xPos].equals("H")))) {
				yPos--;
			} else {
				moveOgre();
			}
		}
		if (movement == 2) {
			if ((!(map[yPos][xPos + 1].equals("X"))) && (!(map[yPos][xPos + 1].equals("I")))
					&& (!(map[yPos][xPos + 1].equals("H")))) {
				xPos++;
			} else {
				moveOgre();
			}
		}
		if (movement == 3) {
			if ((!(map[yPos][xPos - 1].equals("X"))) && (!(map[yPos][xPos - 1].equals("I")))
					&& (!(map[yPos][xPos - 1].equals("H")))) {
				xPos--;
			} else {
				moveOgre();
			}
		}
		
	}
	
	public void move(){
		moveOgre();
	}

	public void attack() {
		// TODO Auto-generated method stub
		
	}

	public String type() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String subType(){
		return subType;
	}
	
	public char representation(){
		return representation;
	}
	
}
