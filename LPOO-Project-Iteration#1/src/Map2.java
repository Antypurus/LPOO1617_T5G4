import java.util.Scanner;

public class Map2 {
	private int playerXPos = 1;
	private int playerYPos = 8;
	private int ogredXPos = 4;
	private int ogreYPos = 1;
	private int keyXPos = 8;
	private int keyYPos = 1;
	private int ogreMoveStage = 0;
	private boolean leverPress = false;

	private String[][] map = new String[10][10];

	public Map2() {
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
		for (int i = 1; i < 9; i++) {
			for (int j = 1; j < 9; j++) {
				map[i][j] = " ";
			}
		}
		map[playerYPos][playerXPos] = "H";
		map[ogreYPos][ogredXPos] = "O";
		map[keyYPos][keyXPos] = "K";
	}

	public void drawMap() {
		for (int j = 0; j < 10; j++) {
			for (int i = 0; i < 10; i++) {
				System.out.print("|" + map[j][i] + "|");
			}
			System.out.print("\n");
		}
	}

	public void updateMap() {
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
		for (int i = 1; i < 9; i++) {
			for (int j = 1; j < 9; j++) {
				map[i][j] = " ";
			}
		}
		map[ogreYPos][ogredXPos] = "O";
		map[keyYPos][keyXPos] = "K";
		map[playerYPos][playerXPos] = "H";
	}

	public void moveHero() {
		Scanner input = new Scanner(System.in);
		System.out.print("Direçao(Up/Down/Left/Right):");
		String Direction = input.next();
		System.out.println(Direction);
		System.out.print("\n");

		while (!(Direction.equals("end"))) {

			if (Direction.equals("Up")) {
				if ((!(map[playerYPos - 1][playerXPos].equals("X"))) && (!(map[playerYPos - 1][playerXPos].equals("I")))
						&& (!(map[playerYPos - 1][playerXPos].equals("O")))) {
					playerYPos--;
				}
			}

			if (Direction.equals("Down")) {
				if ((!(map[playerYPos + 1][playerXPos].equals("X"))) && (!(map[playerYPos + 1][playerXPos].equals("I")))
						&& (!(map[playerYPos + 1][playerXPos].equals("O")))) {
					playerYPos++;
				}
			}

			if (Direction.equals("Right")) {
				if ((!(map[playerYPos][playerXPos + 1].equals("X"))) && (!(map[playerYPos][playerXPos + 1].equals("I")))
						&& (!(map[playerYPos][playerXPos + 1].equals("O")))) {
					playerXPos++;
				}
			}

			if (Direction.equals("Left")) {
				if ((!(map[playerYPos][playerXPos - 1].equals("X"))) && (!(map[playerYPos][playerXPos - 1].equals("I")))
						&& (!(map[playerYPos][playerXPos - 1].equals("O")))) {
					playerXPos--;
				}
			}
			
			this.updateMap();
			this.drawMap();
			
			System.out.print("Direçao(Up/Down/Left/Right):");

			Direction = input.next();

			System.out.print("\n");
		}
		input.close();
	}
}
