import java.util.Random;
import java.util.Scanner;

public class Map2 {
	private int playerXPos = 1;
	private int playerYPos = 8;
	private int ogreXPos = 4;
	private int ogreYPos = 1;
	private int keyXPos = 8;
	private int keyYPos = 1;
	private int clubYPos = 1;
	private int clubXPos = 4;
	private boolean openDoor = false;
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
				if (leverPress && openDoor) {
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
		map[ogreYPos][ogreXPos] = "O";
		if (!leverPress) {
			map[keyYPos][keyXPos] = "k";
		} else {
			map[keyYPos][keyXPos] = " ";
		}
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
				if (leverPress && openDoor) {
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
		if (!leverPress) {
			map[keyYPos][keyXPos] = "k";
		}
		map[clubYPos][clubXPos] = "*";
		if (!leverPress) {
			if (keyYPos == clubYPos) {
				if (keyXPos == clubXPos) {
					map[clubYPos][clubXPos] = "$";
				}
			}
		}
		map[ogreYPos][ogreXPos] = "O";
	}

	private void ogreAttack() {
		Random rand = new Random();
		int randomClub = rand.nextInt((4 - 1) + 1) + 1;
		clubYPos = ogreYPos;
		clubXPos = ogreXPos;
		if (randomClub == 1) {
			if ((!(map[clubYPos - 1][clubXPos].equals("X"))) && (!(map[clubYPos - 1][clubXPos].equals("I")))) {
				{
					clubYPos = ogreYPos - 1;
				}
			}
		}
		if (randomClub == 2) {
			if ((!(map[clubYPos + 1][clubXPos].equals("X"))) && (!(map[clubYPos + 1][clubXPos].equals("I")))) {
				{
					clubYPos = ogreYPos + 1;
				}
			}
		}
		if (randomClub == 3) {
			if ((!(map[clubYPos][clubXPos + 1].equals("X"))) && (!(map[clubYPos][clubXPos + 1].equals("I")))) {
				{
					clubXPos = ogreXPos + 1;
				}
			}
		}
		if (randomClub == 4) {
			if ((!(map[clubYPos][clubXPos - 1].equals("X"))) && (!(map[clubYPos][clubXPos - 1].equals("I")))) {
				{
					clubXPos = ogreXPos - 1;
				}
			}
		}
		if (clubYPos == ogreYPos) {
			if (clubXPos == ogreXPos) {
				this.ogreAttack();
			}
		}
	}

	public void moveOgre() {
		Random generator = new Random();
		int movement = generator.nextInt(4);
		if (movement == 0) {
			if ((!(map[ogreYPos + 1][ogreXPos].equals("X"))) && (!(map[ogreYPos + 1][ogreXPos].equals("I")))
					&& (!(map[ogreYPos + 1][ogreXPos].equals("H")))) {
				ogreYPos++;
			} else {
				moveOgre();
			}
		}
		if (movement == 1) {
			if ((!(map[ogreYPos - 1][ogreXPos].equals("X"))) && (!(map[ogreYPos - 1][ogreXPos].equals("I")))
					&& (!(map[ogreYPos - 1][ogreXPos].equals("H")))) {
				ogreYPos--;
			} else {
				moveOgre();
			}
		}
		if (movement == 2) {
			if ((!(map[ogreYPos][ogreXPos + 1].equals("X"))) && (!(map[ogreYPos][ogreXPos + 1].equals("I")))
					&& (!(map[ogreYPos][ogreXPos + 1].equals("H")))) {
				ogreXPos++;
			} else {
				moveOgre();
			}
		}
		if (movement == 3) {
			if ((!(map[ogreYPos][ogreXPos - 1].equals("X"))) && (!(map[ogreYPos][ogreXPos - 1].equals("I")))
					&& (!(map[ogreYPos][ogreXPos - 1].equals("H")))) {
				ogreXPos--;
			} else {
				moveOgre();
			}
		}
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
				if ((!(map[playerYPos][playerXPos - 1].equals("X"))) && (!(map[playerYPos][playerXPos - 1].equals("X")))
						&& (!(map[playerYPos][playerXPos - 1].equals("O")))) {
					if (!openDoor) {
						boolean isMoving = true;
						if (!(map[playerYPos][playerXPos - 1].equals("I"))) {
							this.playerXPos--;
							isMoving = false;
						}
						if (this.playerXPos == 1) {
							if ((this.playerYPos == 1)) {
								if (isMoving) {
									openDoor = true;
								}
							}
						}
					} else {
						this.playerXPos--;
					}
				}
			}

			this.updateMap();
			this.moveOgre();
			this.updateMap();
			this.ogreAttack();
			this.updateMap();

			// representation checks
			if (!this.leverPress) {
				if (playerXPos == this.keyXPos) {
					if (this.playerYPos == this.keyYPos) {
						map[playerYPos][playerXPos] = "K";
						this.leverPress = true;
					}
				}

				if (this.ogreXPos == this.keyXPos) {
					if (this.ogreYPos == this.keyYPos) {
						map[ogreYPos][ogreXPos] = "$";
					}
				}
			}

			// Ogre collision checks
			if ((this.playerXPos + 1) == (this.ogreXPos)) {
				if (this.playerYPos == this.ogreYPos) {
					this.drawMap();
					System.out.println("You LOSE!");
					input.close();
					return;
				}
			}
			if ((this.playerXPos - 1) == (this.ogreXPos)) {
				if (this.playerYPos == this.ogreYPos) {
					this.drawMap();
					System.out.println("You LOSE!");
					input.close();
					return;
				}
			}
			if ((this.playerXPos) == (this.ogreXPos)) {
				if ((this.playerYPos + 1) == this.ogreYPos) {
					this.drawMap();
					System.out.println("You LOSE!");
					input.close();
					return;
				}
			}
			if ((this.playerXPos) == (this.ogreXPos)) {
				if ((this.playerYPos - 1) == this.ogreYPos) {
					this.drawMap();
					System.out.println("You LOSE!");
					input.close();
					return;
				}
			}
			if ((this.playerXPos) == (this.ogreXPos)) {
				if (this.playerYPos == this.ogreYPos) {
					this.drawMap();
					System.out.println("You LOSE!");
					input.close();
					return;
				}
			}

			// club colison check
			if ((this.playerXPos + 1) == (this.clubXPos)) {
				if (this.playerYPos == this.clubYPos) {
					this.drawMap();
					System.out.println("You LOSE!");
					input.close();
					return;
				}
			}
			if ((this.playerXPos - 1) == (this.clubXPos)) {
				if (this.playerYPos == this.clubYPos) {
					this.drawMap();
					System.out.println("You LOSE!");
					input.close();
					return;
				}
			}
			if ((this.playerXPos) == (this.clubXPos)) {
				if ((this.playerYPos + 1) == this.clubYPos) {
					this.drawMap();
					System.out.println("You LOSE!");
					input.close();
					return;
				}
			}
			if ((this.playerXPos) == (this.clubXPos)) {
				if ((this.playerYPos - 1) == this.clubYPos) {
					this.drawMap();
					System.out.println("You LOSE!");
					input.close();
					return;
				}
			}
			if ((this.playerXPos) == (this.clubXPos)) {
				if (this.playerYPos == this.clubYPos) {
					this.drawMap();
					System.out.println("You LOSE!");
					input.close();
					return;
				}
			}

			this.drawMap();

			if ((this.playerXPos == 0)) {
				input.close();
				System.out.println("\n Now You Have Trully Won Congratulation \n");
				return;
			}

			System.out.print("Direçao(Up/Down/Left/Right):");

			Direction = input.next();

			System.out.print("\n");
		}
		input.close();
	}
}
