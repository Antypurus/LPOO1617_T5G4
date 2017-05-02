package Logic.Map;

public class Map {

    private Cell[][] map = null;

    public int width;
    public int height;

    private String name=null;

    public Map(String name,int width,int height){

        this.name=name;

        this.width = width;
        this.height = height;

        this.map = new Cell[width][height];

        for(int i=0;i<this.height;++i){
            for(int j=0;j<this.width;++j){
                this.map[j][i]=null;
            }
        }
    }

    public String getName(){
        return this.name;
    }


}
