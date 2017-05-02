package Logic.Map;

public class Map {

    private Cell[][] map = null;

    public int width;
    public int height;

    private String name=null;

    private void setCellSurroundings(int x,int y){
        if(x+1>=width){
            this.map[x][y].setRight(null);
        }else{
            this.map[x][y].setRight(this.map[x+1][y]);
        }
        if(x-1<0){
            this.map[x][y].setLeft(null);
        }else{
            this.map[x][y].setLeft(this.map[x-1][y]);
        }
        if(y+1>=height){
            this.map[x][y].setTop(null);
        }else{
            this.map[x][y].setTop(this.map[x][y+1]);
        }
        if(y-1<0){
            this.map[x][y].setBottom(null);
        }else{
            this.map[x][y].setBottom(this.map[x][y-1]);
        }
        return;
    }

    public Map(String name,int width,int height){

        this.name=name;

        this.width = width;
        this.height = height;

        this.map = new Cell[width][height];

        for(int i=0;i<this.height;++i){
            for(int j=0;j<this.width;++j){
                this.map[j][i]= new Cell(j,i);
                this.setCellSurroundings(j,i);
            }
        }
    }

    public String getName(){
        return this.name;
    }


}
