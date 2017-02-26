package Characters;

import java.util.Random;

public class Oggre extends Enemy{
	
	private int clubYPos = 1;
	private int clubXPos = 4;
	
	public Oggre(String[][] map){
		type = "Ogre";
		subType = "Crazy";
		xPos = 4;
		yPos = 1;
		representation = "O";
		this.map=map;
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

	public void ogreAttack() {
		Random rand = new Random();
		int randomClub = rand.nextInt((4 - 1) + 1) + 1;
		clubYPos = yPos;
		clubXPos = xPos;
		if (randomClub == 1) {
			if ((!(map[clubYPos - 1][clubXPos].equals("X"))) && (!(map[clubYPos - 1][clubXPos].equals("I")))) {
				{
					clubYPos = yPos - 1;
				}
			}
		}
		if (randomClub == 2) {
			if ((!(map[clubYPos + 1][clubXPos].equals("X"))) && (!(map[clubYPos + 1][clubXPos].equals("I")))) {
				{
					clubYPos = yPos + 1;
				}
			}
		}
		if (randomClub == 3) {
			if ((!(map[clubYPos][clubXPos + 1].equals("X"))) && (!(map[clubYPos][clubXPos + 1].equals("I")))) {
				{
					clubXPos = xPos + 1;
				}
			}
		}
		if (randomClub == 4) {
			if ((!(map[clubYPos][clubXPos - 1].equals("X"))) && (!(map[clubYPos][clubXPos - 1].equals("I")))) {
				{
					clubXPos = xPos - 1;
				}
			}
		}
		if (clubYPos == yPos) {
			if (clubXPos == xPos) {
				this.ogreAttack();
			}
		}
	}
	
	public void attack(){
		ogreAttack();
	}

	public String type() {
		return type ;
	}
	
	public String subType(){
		return subType;
	}
	
	public String getRepresentation(){
		return representation;
	}
	
}
