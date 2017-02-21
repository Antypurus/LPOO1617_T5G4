import java.util.Scanner;

public class Map {
	private int playerXPos;
	private int playerYPos;
	private int guardXPos;
	private int guardYPos;
	private int guardMovStage = 0;
	private boolean leverPress = false;

	private String[][] map = new String[10][10];

	private void moveGuard() {
		if (guardMovStage == 0) {
			guardXPos--;
			guardMovStage = 1;
			return;
		}
		if (guardMovStage == 1) {
			guardYPos++;
			guardMovStage = 2;
			return;
		}
		if (guardMovStage == 2) {
			guardYPos++;
			guardMovStage = 3;
			return;
		}
		if (guardMovStage == 3) {
			guardYPos++;
			guardMovStage = 4;
			return;
		}
		if (guardMovStage == 4) {
			guardYPos++;
			guardMovStage = 5;
			return;
		}
		if (guardMovStage == 5) {
			guardXPos--;
			guardMovStage = 6;
			return;
		}
		if (guardMovStage == 6) {
			guardXPos--;
			guardMovStage = 7;
			return;
		}
		if (guardMovStage == 7) {
			guardXPos--;
			guardMovStage = 8;
			return;
		}
		if (guardMovStage == 8) {
			guardXPos--;
			guardMovStage = 9;
			return;
		}
		if (guardMovStage == 9) {
			guardXPos--;
			guardMovStage = 10;
			return;
		}
		if (guardMovStage == 10) {
			guardXPos--;
			guardMovStage = 11;
			return;
		}
		if (guardMovStage == 11) {
			guardYPos++;
			guardMovStage = 12;
			return;
		}
		if (guardMovStage == 12) {
			guardXPos++;
			guardMovStage = 13;
			return;
		}
		if (guardMovStage == 13) {
			guardXPos++;
			guardMovStage = 14;
			return;
		}
		if (guardMovStage == 14) {
			guardXPos++;
			guardMovStage = 15;
			return;
		}
		if (guardMovStage == 15) {
			guardXPos++;
			guardMovStage = 16;
			return;
		}
		if (guardMovStage == 16) {
			guardXPos++;
			guardMovStage = 17;
			return;
		}
		if (guardMovStage == 17) {
			guardXPos++;
			guardMovStage = 18;
			return;
		}
		if (guardMovStage == 18) {
			guardXPos++;
			guardMovStage = 19;
			return;
		}
		if (guardMovStage == 19) {
			guardYPos--;
			guardMovStage = 20;
			return;
		}
		if (guardMovStage == 20) {
			guardYPos--;
			guardMovStage = 21;
			return;
		}
		if (guardMovStage == 21) {
			guardYPos--;
			guardMovStage = 22;
			return;
		}
		if (guardMovStage == 22) {
			guardYPos--;
			guardMovStage = 23;
			return;
		}
		if (guardMovStage == 23) {
			guardYPos--;
			guardMovStage = 0;
			return;
		}
	}

	public Map() {
		playerXPos = 1;
		playerYPos = 1;
		guardYPos = 1;
		guardXPos = 8;
		for (int i = 0; i < 10; i++) {
			map[0][i] = "X";
		}
		for (int i = 0; i < 10; i++) {
			map[9][i] = "X";
		}
		for (int i = 0; i < 10; i++) {
			map[i][9] = "X";
		}
		for (int i = 0; i < 10; i++) {
			map[i][0] = "X";
			if (i == 1) {
				map[i][0] = "I";
				if (leverPress) {
					map[i][0] = "S";
				}
			}
		}
		map[1][1] = " ";
		map[1][2] = " ";
		map[1][3] = " ";
		map[1][4] = "I";
		map[1][5] = " ";
		map[1][6] = "X";
		map[1][7] = " ";
		map[1][8] = " ";
		map[2][1] = "X";
		map[2][2] = "X";
		map[2][3] = " ";
		map[2][4] = "X";
		map[2][5] = "X";
		map[2][6] = "X";
		map[2][7] = " ";
		map[2][8] = " ";
		map[3][1] = " ";
		map[3][2] = "I";
		map[3][3] = " ";
		map[3][4] = "I";
		map[3][5] = " ";
		map[3][6] = "X";
		map[3][7] = " ";
		map[3][8] = " ";
		map[4][1] = "X";
		map[4][2] = "X";
		map[4][3] = " ";
		map[4][4] = "X";
		map[4][5] = "X";
		map[4][6] = "X";
		map[4][7] = " ";
		map[4][8] = " ";
		map[5][1] = " ";
		map[5][2] = " ";
		map[5][3] = " ";
		map[5][4] = " ";
		map[5][5] = " ";
		map[5][6] = " ";
		map[5][7] = " ";
		map[5][8] = " ";
		map[6][1] = " ";
		map[6][2] = " ";
		map[6][3] = " ";
		map[6][4] = " ";
		map[6][5] = " ";
		map[6][6] = " ";
		map[6][7] = " ";
		map[6][8] = " ";
		map[7][1] = "X";
		map[7][2] = "X";
		map[7][3] = " ";
		map[7][4] = "X";
		map[7][5] = "X";
		map[7][6] = "X";
		map[7][7] = "X";
		map[7][8] = " ";
		map[8][1] = " ";
		map[8][2] = "I";
		map[8][3] = " ";
		map[8][4] = "I";
		map[8][5] = " ";
		map[8][6] = "X";
		map[8][7] = "K";
		map[8][8] = " ";
		map[playerYPos][playerXPos] = "H";
		map[guardYPos][guardXPos] = "G";
	}

	public void drawMap() {
		for (int j = 0; j < 10; j++) {
			for (int i = 0; i < 10; i++) {
				System.out.print("|" + map[j][i] + "|");
			}
			System.out.print("\n");
		}
	}

	private void updateMap() {
		for (int i = 0; i < 10; i++) {
			map[0][i] = "X";
		}
		for (int i = 0; i < 10; i++) {
			map[9][i] = "X";
		}
		for (int i = 0; i < 10; i++) {
			map[i][9] = "X";
		}
		for (int i = 0; i < 10; i++) {
			map[i][0] = "X";
			if (i == 6 || i == 5) {
				map[i][0] = "I";
				if (leverPress) {
					map[i][0] = "S";
				}
			}
		}
		map[1][1] = " ";
		map[1][2] = " ";
		map[1][3] = " ";
		map[1][4] = "I";
		map[1][5] = " ";
		map[1][6] = "X";
		map[1][7] = " ";
		map[1][8] = " ";
		map[2][1] = "X";
		map[2][2] = "X";
		map[2][3] = " ";
		map[2][4] = "X";
		map[2][5] = "X";
		map[2][6] = "X";
		map[2][7] = " ";
		map[2][8] = " ";
		map[3][1] = " ";
		map[3][2] = "I";
		map[3][3] = " ";
		map[3][4] = "I";
		map[3][5] = " ";
		map[3][6] = "X";
		map[3][7] = " ";
		map[3][8] = " ";
		map[4][1] = "X";
		map[4][2] = "X";
		map[4][3] = " ";
		map[4][4] = "X";
		map[4][5] = "X";
		map[4][6] = "X";
		map[4][7] = " ";
		map[4][8] = " ";
		map[5][1] = " ";
		map[5][2] = " ";
		map[5][3] = " ";
		map[5][4] = " ";
		map[5][5] = " ";
		map[5][6] = " ";
		map[5][7] = " ";
		map[5][8] = " ";
		map[6][1] = " ";
		map[6][2] = " ";
		map[6][3] = " ";
		map[6][4] = " ";
		map[6][5] = " ";
		map[6][6] = " ";
		map[6][7] = " ";
		map[6][8] = " ";
		map[7][1] = "X";
		map[7][2] = "X";
		map[7][3] = " ";
		map[7][4] = "X";
		map[7][5] = "X";
		map[7][6] = "X";
		map[7][7] = "X";
		map[7][8] = " ";
		map[8][1] = " ";
		map[8][2] = "I";
		map[8][3] = " ";
		map[8][4] = "I";
		map[8][5] = " ";
		map[8][6] = "X";
		map[8][7] = "K";
		map[8][8] = " ";
		map[playerYPos][playerXPos] = "H";
		map[guardYPos][guardXPos] = "G";
	}

	public boolean MoveHero() {

		Scanner input = new Scanner(System.in);
		System.out.print("Direçao(Up/Down/Left/Right):");
		String Direction = input.next();
		System.out.println(Direction);
		System.out.print("\n");

		while (!(Direction.equals("end"))) {

			if (Direction.equals("Up")) {
				if ((!(map[playerYPos - 1][playerXPos].equals("X"))) && (!(map[playerYPos - 1][playerXPos].equals("I")))
						&& (!(map[playerYPos - 1][playerXPos].equals("G")))) {
					playerYPos--;
				}
			}

			if (Direction.equals("Down")) {
				if ((!(map[playerYPos + 1][playerXPos].equals("X"))) && (!(map[playerYPos + 1][playerXPos].equals("I")))
						&& (!(map[playerYPos + 1][playerXPos].equals("G")))) {
					playerYPos++;
				}
			}

			if (Direction.equals("Right")) {
				if ((!(map[playerYPos][playerXPos + 1].equals("X"))) && (!(map[playerYPos][playerXPos + 1].equals("I")))
						&& (!(map[playerYPos][playerXPos + 1].equals("G")))) {
					playerXPos++;
				}
			}

			if (Direction.equals("Left")) {
				if ((!(map[playerYPos][playerXPos - 1].equals("X"))) && (!(map[playerYPos][playerXPos - 1].equals("I")))
						&& (!(map[playerYPos][playerXPos - 1].equals("G")))) {
					playerXPos--;
				}
			}

			if (playerXPos == 7) {
				if (playerYPos == 8) {
					leverPress = true;
				}
			}
			this.moveGuard();
			this.updateMap();

			if (map[playerYPos + 1][playerXPos].equals("G")) {
				System.out.println("You LOSE!");
				input.close();
				return false;
			}
			if (map[playerYPos - 1][playerXPos].equals("G")) {
				System.out.println("You LOSE!");
				input.close();
				return false;
			}
			if (map[playerYPos][playerXPos + 1].equals("G")) {
				System.out.println("You LOSE!");
				input.close();
				return false;
			}
			if (map[playerYPos][playerXPos - 1].equals("G")) {
				System.out.println("You LOSE!");
				input.close();
				return false;
			}
			if (map[playerYPos][playerXPos].equals("S")) {
				System.out.println("You WIN!\n ... \n Or Do You ? ");
				input.close();
				return true;
			}

			this.drawMap();

			System.out.print("Direçao(Up/Down/Left/Right):");

			Direction = input.next();

			System.out.print("\n");
		}
		input.close();
		return false;
	}
}
