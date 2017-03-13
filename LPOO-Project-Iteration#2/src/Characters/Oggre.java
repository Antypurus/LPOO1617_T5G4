package Characters;

import Weapons.Club;

import java.util.Random;

public class Oggre extends Enemy{
	
	private int clubYPos = this.yPos;
	private int clubXPos = this.xPos;
	
	public Oggre(String[][] map){
		type = "Ogre";
		subType = "Crazy";
		xPos = 4;
		yPos = 1;
		representation = "O";
		this.map=map;
	}

	public Oggre(String[][] map,int x,int y){
		type = "Ogre";
		subType = "Crazy";
		xPos = x;
		yPos = y;
		representation = "O";
		this.map=map;
		this.weapons[0]=new Club(this);
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
		if(!this.isStuned) {
			moveOgre();
		}else{
			this.StunCounter--;
			if(StunCounter==0){
				this.isStuned=false;
			}
		}
	}

	public void ogreAttack() {
		if(weapons!=null){
		Random generator = new Random();
		int direction = generator.nextInt(4);
		switch(direction){
			case(0):
				weapons[0].setxPos(this.xPos+1);
				weapons[0].setyPos(this.yPos);
				break;
			case(1):
				weapons[0].setxPos(this.xPos-1);
				weapons[0].setyPos(this.yPos);
				break;
			case(2):
				weapons[0].setxPos(this.xPos);
				weapons[0].setyPos(this.yPos+1);
				break;
			case(3):
				weapons[0].setxPos(this.xPos);
				weapons[0].setyPos(this.yPos-1);
				break;
			default:break;
		}
		if(map[weapons[0].getyPos()][weapons[0].getxPos()].equals("X")||map[weapons[0].getyPos()][weapons[0].getxPos()].equals("I")||map[weapons[0].getyPos()][weapons[0].getxPos()].equals("O")||map[weapons[0].getyPos()][weapons[0].getxPos()].equals("*")){
			this.ogreAttack();
		}}
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
