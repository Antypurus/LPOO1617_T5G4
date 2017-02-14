
public class main {

	public static void main(String[] args) {
		int playerXPos=1;
		int playerYPos=1;
		
		String[][] map=new String[10][10];
		
		map[1][1]="H";
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

	}

}
