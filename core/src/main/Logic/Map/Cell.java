package main.Logic.Map;

import main.Logic.Unit.Unit;

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

    public void update(){
        if(this.unit!=null){
            this.isWalckable=false;
        }
    }

    public double distanceToCell(Cell cell){
        int x1 = this.xPos;
        int y1 = this.yPos;
        int x2 = cell.getxPos();
        int y2 = cell.getyPos();
        double res = 0;
        int yd = y2-y1;
        int xd = x2-x1;
        double toSqrt = Math.pow(xd,2) + Math.pow(yd,2);
        res = Math.sqrt(toSqrt);
        return res;
    }
}
