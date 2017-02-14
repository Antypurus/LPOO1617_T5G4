import java.util.Scanner;

public class Map {
	private int playerXPos;
	private int playerYPos;
	private boolean leverPress = false;
	
	private String[][] map=new String[10][10];
	
	public Map(){
		playerXPos=1;
		playerYPos=1;
		for(int i=0;i<10;i++){
			map[0][i]="X";
		}
		for(int i=0;i<10;i++){
			map[9][i]="X";
		}
		for(int i=0;i<10;i++){
			map[i][9]="X";
		}
		for(int i=0;i<10;i++){
			map[i][0]="X";
			if(i==6||i==5){
				map[i][0]="I";
			}
		}
		map[1][1]=" ";
		map[1][2]=" ";
		map[1][3]=" ";
		map[1][4]="I";
		map[1][5]=" ";
		map[1][6]="X";
		map[1][7]=" ";
		map[1][8]="G";
		map[2][1]="X";
		map[2][2]="X";
		map[2][3]=" ";
		map[2][4]="X";
		map[2][5]="X";
		map[2][6]="X";
		map[2][7]="X";
		map[2][8]=" ";
		map[2][5]=" ";
		map[3][1]=" ";
		map[3][2]="I";
		map[3][3]=" ";
		map[3][4]="I";
		map[3][5]=" ";
		map[3][6]="X";
		map[3][7]=" ";
		map[3][8]=" ";
		map[4][1]="X";
		map[4][2]="X";
		map[4][3]=" ";
		map[4][4]="X";
		map[4][5]="X";
		map[4][6]="X";
		map[4][7]=" ";
		map[4][8]=" ";
		map[5][1]=" ";
		map[5][2]=" ";
		map[5][3]=" ";
		map[5][4]=" ";
		map[5][5]=" ";
		map[5][6]=" ";
		map[5][7]=" ";
		map[5][8]=" ";
		map[6][1]=" ";
		map[6][2]=" ";
		map[6][3]=" ";
		map[6][4]=" ";
		map[6][5]=" ";
		map[6][6]=" ";
		map[6][7]=" ";
		map[6][8]=" ";
		map[7][1]="X";
		map[7][2]="X";
		map[7][3]=" ";
		map[7][4]="X";
		map[7][5]="X";
		map[7][6]="X";
		map[7][7]="X";
		map[7][8]=" ";
		map[8][1]=" ";
		map[8][2]="I";
		map[8][3]=" ";
		map[8][4]="I";
		map[8][5]=" ";
		map[8][6]="X";
		map[8][7]="K";
		map[8][8]=" ";
		map[playerYPos][playerXPos]="H";
	}
	
	public void drawMap(){
		for(int j=0;j<10;j++){
			for(int i=0;i<10;i++){
				System.out.print("|"+map[j][i]+"|");
			}
			System.out.print("\n");
		}
	}
	
	private void updateMap(){
		for(int i=0;i<10;i++){
			map[0][i]="X";
		}
		for(int i=0;i<10;i++){
			map[9][i]="X";
		}
		for(int i=0;i<10;i++){
			map[i][9]="X";
		}
		for(int i=0;i<10;i++){
			map[i][0]="X";
			if(i==6||i==5){
				map[i][0]="I";
			}
		}
		map[1][1]=" ";
		map[1][2]=" ";
		map[1][3]=" ";
		map[1][4]="I";
		map[1][5]=" ";
		map[1][6]="X";
		map[1][7]=" ";
		map[1][8]="G";
		map[2][1]="X";
		map[2][2]="X";
		map[2][3]=" ";
		map[2][4]="X";
		map[2][5]="X";
		map[2][6]="X";
		map[2][7]="X";
		map[2][8]=" ";
		map[2][5]=" ";
		map[3][1]=" ";
		map[3][2]="I";
		map[3][3]=" ";
		map[3][4]="I";
		map[3][5]=" ";
		map[3][6]="X";
		map[3][7]=" ";
		map[3][8]=" ";
		map[4][1]="X";
		map[4][2]="X";
		map[4][3]=" ";
		map[4][4]="X";
		map[4][5]="X";
		map[4][6]="X";
		map[4][7]=" ";
		map[4][8]=" ";
		map[5][1]=" ";
		map[5][2]=" ";
		map[5][3]=" ";
		map[5][4]=" ";
		map[5][5]=" ";
		map[5][6]=" ";
		map[5][7]=" ";
		map[5][8]=" ";
		map[6][1]=" ";
		map[6][2]=" ";
		map[6][3]=" ";
		map[6][4]=" ";
		map[6][5]=" ";
		map[6][6]=" ";
		map[6][7]=" ";
		map[6][8]=" ";
		map[7][1]="X";
		map[7][2]="X";
		map[7][3]=" ";
		map[7][4]="X";
		map[7][5]="X";
		map[7][6]="X";
		map[7][7]="X";
		map[7][8]=" ";
		map[8][1]=" ";
		map[8][2]="I";
		map[8][3]=" ";
		map[8][4]="I";
		map[8][5]=" ";
		map[8][6]="X";
		map[8][7]="K";
		map[8][8]=" ";
		map[playerYPos][playerXPos]="H";
	}
	
	
	private boolean canMove(){
		return false;
	}
	
	public void MoveHero(){
		Scanner input = new Scanner(System.in);
		System.out.print("Dire�ao:");
		String Direction = input.next();
		System.out.println(Direction);
		System.out.print("\n");
		while(!(Direction.equals("end"))){
			if(Direction.equals("Up")){
				playerYPos--;
			}
			if(Direction.equals("Down")){
				playerYPos++;
			}
			if(Direction.equals("Right")){
				playerXPos++;
			}
			if(Direction.equals("Left")){
				playerXPos--;
			}
			this.updateMap();
			this.drawMap();
			System.out.println(playerXPos+" "+playerYPos);
			System.out.print("Dire�ao:");
			Direction = input.next();
			System.out.print("\n");
		}
		input.close();
	}
}
