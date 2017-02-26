package Characters;

import java.util.Scanner;

public class Hero extends Character {
    private int yPos;
    private int xPos;
    private boolean hasKey=false;
    private boolean pressedLever=false;
    private String representation = "H";
    private String[][] map;

    public int getyPos() {
        return yPos;
    }
    public int getxPos() {
        return xPos;
    }

    public String getRepresentation(){
        return representation;
    }

    public Hero(String[][] map, int x, int y) {
        this.map = map;
        this.xPos=x;
        this.yPos=y;

    }


    private void moveHero() {
        Scanner input = new Scanner(System.in);
        System.out.print("Direção(Up/Down/Left/Right):");
        String Direction = input.next();
        System.out.println(Direction);
        System.out.print("\n");

        while (!(Direction.equals("end"))) {

            if (Direction.equals("Up")) {
                if ((!(map[yPos - 1][xPos].equals("X"))) && (!(map[yPos - 1][xPos].equals("I")))
                        && (!(map[yPos - 1][xPos].equals("G")))) {
                    yPos--;
                }
            }

            if (Direction.equals("Down")) {
                if ((!(map[yPos + 1][xPos].equals("X"))) && (!(map[yPos + 1][xPos].equals("I")))
                        && (!(map[yPos + 1][xPos].equals("G")))) {
                    yPos++;
                }
            }

            if (Direction.equals("Right")) {
                if ((!(map[yPos][xPos + 1].equals("X"))) && (!(map[yPos][xPos + 1].equals("I")))
                        && (!(map[yPos][xPos + 1].equals("G")))) {
                    xPos++;
                }
            }

            if (Direction.equals("Left")) {
                if ((!(map[yPos][xPos - 1].equals("X"))) && (!(map[yPos][xPos - 1].equals("I")))
                        && (!(map[yPos][xPos - 1].equals("G")))) {
                    xPos--;
                }
            }
        }
    }
}