package Characters;

import java.util.Random;

public class Guard extends Enemy {
	private int guardMovStage = 0;
	private String awakeRep = "G";
	private String sleepRep = "g";
	private boolean isSleep = false;
	private boolean reverse = false;
	
	public Guard(String[][] map){
		type = "Guard";
		Random generator = new Random();
		int i=generator.nextInt(3);
		switch(i) {
			case(0):
				subType="rookie";
				break;
			case(1):
				subType="drunken";
				break;
			case(2):
				subType="drunken";
				break;
			default:break;
		}
		xPos = 8;
		yPos = 1;
		representation = "G";
		this.map=map;
	}

	public Guard(String[][] map,int x,int y){
		type = "Guard";
        subType = "";
		Random generator = new Random();
		int i=generator.nextInt(3);
		switch(i) {
            case(0):
                subType="rookie";
                break;
            case(1):
                subType="drunken";
                break;
            case(2):
                subType="drunken";
                break;
            default:break;
        }
		xPos = x;
		yPos = y;
		representation = "O";
		this.map=map;
	}
	
	private void rookieMoveGuard() {
		if (guardMovStage == 0) {
			xPos--;
			guardMovStage = 1;
			return;
		}
		if (guardMovStage == 1) {
			yPos++;
			guardMovStage = 2;
			return;
		}
		if (guardMovStage == 2) {
			yPos++;
			guardMovStage = 3;
			return;
		}
		if (guardMovStage == 3) {
			yPos++;
			guardMovStage = 4;
			return;
		}
		if (guardMovStage == 4) {
			yPos++;
			guardMovStage = 5;
			return;
		}
		if (guardMovStage == 5) {
			xPos--;
			guardMovStage = 6;
			return;
		}
		if (guardMovStage == 6) {
			xPos--;
			guardMovStage = 7;
			return;
		}
		if (guardMovStage == 7) {
			xPos--;
			guardMovStage = 8;
			return;
		}
		if (guardMovStage == 8) {
			xPos--;
			guardMovStage = 9;
			return;
		}
		if (guardMovStage == 9) {
			xPos--;
			guardMovStage = 10;
			return;
		}
		if (guardMovStage == 10) {
			xPos--;
			guardMovStage = 11;
			return;
		}
		if (guardMovStage == 11) {
			yPos++;
			guardMovStage = 12;
			return;
		}
		if (guardMovStage == 12) {
			xPos++;
			guardMovStage = 13;
			return;
		}
		if (guardMovStage == 13) {
			xPos++;
			guardMovStage = 14;
			return;
		}
		if (guardMovStage == 14) {
			xPos++;
			guardMovStage = 15;
			return;
		}
		if (guardMovStage == 15) {
			xPos++;
			guardMovStage = 16;
			return;
		}
		if (guardMovStage == 16) {
			xPos++;
			guardMovStage = 17;
			return;
		}
		if (guardMovStage == 17) {
			xPos++;
			guardMovStage = 18;
			return;
		}
		if (guardMovStage == 18) {
			xPos++;
			guardMovStage = 19;
			return;
		}
		if (guardMovStage == 19) {
			yPos--;
			guardMovStage = 20;
			return;
		}
		if (guardMovStage == 20) {
			yPos--;
			guardMovStage = 21;
			return;
		}
		if (guardMovStage == 21) {
			yPos--;
			guardMovStage = 22;
			return;
		}
		if (guardMovStage == 22) {
			yPos--;
			guardMovStage = 23;
			return;
		}
		if (guardMovStage == 23) {
			yPos--;
			guardMovStage = 0;
			return;
		}
	}

	private void reverseMovement(){
		switch(guardMovStage){
			case(0):
				guardMovStage=23;
				yPos++;
				return;
			case(1):
				guardMovStage=0;
				xPos++;
				return;
			case(2):
				guardMovStage=1;
				yPos--;
				return ;
			case(3):
				guardMovStage=2;
				yPos--;
				return ;
			case(4):
				guardMovStage=3;
				yPos--;
				return ;
			case(5):
				guardMovStage=3;
				yPos--;
				return;
			case(6):
				guardMovStage=5;
				xPos++;
				return ;
			case(7):
				guardMovStage=6;
				xPos++;
				return ;
			case(8):
				guardMovStage=7;
				xPos++;
				return ;
			case (9):
				guardMovStage=8;
				xPos++;
				return ;
			case(10):
				guardMovStage=9;
				xPos++;
				return ;
			case(11):
				guardMovStage=10;
				xPos++;
				return ;
			case(12):
				guardMovStage=11;
				yPos--;
				return ;
			case(13):
				guardMovStage=12;
				xPos--;
				return ;
			case(14):
				guardMovStage=13;
				xPos--;
				return ;
			case(15):
				guardMovStage=14;
				xPos--;
				return ;
			case(16):
				guardMovStage=15;
				xPos--;
				return ;
			case(17):
				guardMovStage=16;
				xPos--;
				return ;
			case(18):
				guardMovStage=17;
				xPos--;
				return ;
			case(19):
				guardMovStage=18;
				xPos--;
				return;
			case(20):
				guardMovStage=19;
				yPos++;
				return;
			case(21):
				guardMovStage=20;
				yPos++;
				return;
			case(22):
				guardMovStage=21;
				yPos++;
				return;
			case(23):
				guardMovStage=22;
				yPos++;
				return;
			default:return;
		}
	}

	private void drunkenMoveGuard(){
		if(isSleep){
			isSleep=false;
			representation=awakeRep;
			Random generator = new Random();
			int i=generator.nextInt(3);
			if(i==1){
				if(!reverse){
				reverse=true;}else{
					reverse=false;
				}
			}
		}else{
			if(reverse){
			this.reverseMovement();
			}else{
			this.rookieMoveGuard();}
			Random generator = new Random();
			int test = generator.nextInt(3);
			if(test==1){
				this.isSleep=true;
				representation=sleepRep;
			}
		}
	}

	public void move() {

	    if(this.subType.equals("rookie")){
		    rookieMoveGuard();}// move calls the method specific to the guards movement
        if(this.subType.equals("drunken")){
	        drunkenMoveGuard();
        }
	}

	public void attack() {
		return ;
	}

	public String type() {
		return type;
	}
	
	public String subType(){
		return subType;
	}

	public String getRepresentation(){
		return representation;
	}
}
