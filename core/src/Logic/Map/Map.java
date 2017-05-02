package Logic.Map;

public class Map {

    private Cell[][] map = new Cell[100][100];

    private String name=null;

    public Map(String name){

        this.name=name;

        for(int i=0;i<100;++i){
            for(int j=0;j<100;++j){
                this.map[i][j]=null;
            }
        }
    }

    public String getName(){
        return this.name;
    }


}
