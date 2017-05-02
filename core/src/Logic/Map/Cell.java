package Logic.Map;

import Logic.Unit.Unit;

public class Cell {
    private int xPos=0;
    private int yPos=0;

    private boolean isWalckable = true;

    private Unit unit = null;

    private Map belongingMap=null;

    private Cell Left=null;
    private Cell Right=null;
    private Cell Top=null;
    private Cell Bottom = null;

    public Cell(int x,int y){
        this.xPos=x;
        this.yPos=y;
    }

    public void setWalckable(boolean value){
        this.isWalckable=value;
    }

    public void setLeft(Cell left){
        this.Left=left;
    }

    public void setRight(Cell right){
        this.Right = right;
    }

    public void setTop(Cell top){
        this.Top=top;
    }

    public void setBottom(Cell bottom){
        this.Bottom=bottom;
    }

    public void setMap(Map map){
        this.belongingMap = map;
    }

    public Map getMap(){
        return this.belongingMap;
    }

    public int getxPos(){
        return this.xPos;
    }

    public int getyPos(){
        return this.yPos;
    }

    public boolean isWalckable() {
        return isWalckable;
    }

    public Cell getLeft() {
        return Left;
    }

    public Cell getRight() {
        return Right;
    }

    public Cell getTop() {
        return Top;
    }

    public Cell getBottom() {
        return Bottom;
    }

    public Unit getUnit(){
        return this.unit;
    }

    public void setUnit(Unit unit){
        this.unit=unit;
    }
}
