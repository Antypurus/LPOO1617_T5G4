package Characters;

public class Guard extends Enemy {
	private int guardMovStage = 0;
	
	public Guard(String[][] map){
		type = "Guard";
		subType = "";
		xPos = 8;
		yPos = 1;
		representation = "O";
		this.map=map;
	}
	
	private void moveGuard() {
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
			yPos++;
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

	public void move() {
		moveGuard();// move calls the method specific to the guards movement
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
