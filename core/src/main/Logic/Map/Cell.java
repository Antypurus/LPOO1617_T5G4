package main.Logic.Map;

import main.Logic.Unit.Unit;

public class Cell {
    private int xPos=0;
    private int yPos=0;

    private boolean isWalkable = true;

    private Unit unit = null;

    private Map belongingMap=null;

    private Cell Left=null;
    private Cell Right=null;
    private Cell Top=null;
    private Cell Bottom = null;

    /**
     *
     * @param x
     * @param y
     */
    public Cell(int x,int y){
        this.xPos=x;
        this.yPos=y;
    }

    /**
     *
     * @param value
     */
    public void setWalkable(boolean value){
        this.isWalkable=value;
    }

    /**
     *
     * @param left
     */
    public void setLeft(Cell left){
        this.Left=left;
    }

    /**
     *
     * @param right
     */
    public void setRight(Cell right){
        this.Right = right;
    }

    /**
     *
     * @param top
     */
    public void setTop(Cell top){
        this.Top=top;
    }

    /**
     *
     * @param bottom
     */
    public void setBottom(Cell bottom){
        this.Bottom=bottom;
    }

    /**
     *
     * @param map
     */
    public void setMap(Map map){
        this.belongingMap = map;
    }

    /**
     *
     * @return
     */
    public Map getMap(){
        return this.belongingMap;
    }

    /**
     *
     * @return
     */
    public int getxPos(){
        return this.xPos;
    }

    /**
     *
     * @return
     */
    public int getyPos(){
        return this.yPos;
    }

    /**
     *
     * @return
     */
    public boolean isWalkable() {
        return isWalkable;
    }

    /**
     *
     * @return
     */
    public Cell getLeft() {
        return Left;
    }

    /**
     *
     * @return
     */
    public Cell getRight() {
        return Right;
    }

    /**
     *
     * @return
     */
    public Cell getTop() {
        return Top;
    }

    /**
     *
     * @return
     */
    public Cell getBottom() {
        return Bottom;
    }

    /**
     *
     * @return
     */
    public Unit getUnit(){
        return this.unit;
    }

    /**
     *
     * @param unit
     */
    public void setUnit(Unit unit){
        this.unit=unit;
    }

    /**
     *
     */
    public void update(){
        if(this.unit!=null){
            this.isWalkable=false;
        }
    }

    /**
     *
     * @param cell
     * @return
     */
    public double distanceToCell(Cell cell){
        if(cell!=null) {
            int x1 = this.xPos;
            int y1 = this.yPos;
            int x2 = cell.getxPos();
            int y2 = cell.getyPos();
            double res = 0;
            int yd = y2 - y1;
            int xd = x2 - x1;
            double toSqrt = Math.pow(xd, 2) + Math.pow(yd, 2);
            res = Math.sqrt(toSqrt);
            return res;
        }
        return -1;
    }
}
