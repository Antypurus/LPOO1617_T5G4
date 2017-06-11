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
     * creates a cell with x y coordinates
     * @param x x coordinate
     * @param y y coordinate
     */
    public Cell(int x,int y){
        this.xPos=x;
        this.yPos=y;
    }

    /**
     * sets wheter or not a unit can walk into this cell
     * @param value walckability value
     */
    public void setWalkable(boolean value){
        this.isWalkable=value;
    }

    /**
     * sets what cell is to the left of this one
     * @param left cell to the left
     */
    public void setLeft(Cell left){
        this.Left=left;
    }

    /**
     * sets what cell is to the right of thi sone
     * @param right cell to the right
     */
    public void setRight(Cell right){
        this.Right = right;
    }

    /**
     *sets what cell is to the top of this one
     * @param top cell to the top
     */
    public void setTop(Cell top){
        this.Top=top;
    }

    /**
     * sets what cell is bellow this one
     * @param bottom cell bellow
     */
    public void setBottom(Cell bottom){
        this.Bottom=bottom;
    }

    /**
     *  sets the map this cell inserts itself into
     * @param map
     */
    public void setMap(Map map){
        this.belongingMap = map;
    }

    /**
     *
     * @return the map this cell is in
     */
    public Map getMap(){
        return this.belongingMap;
    }

    /**
     *
     * @return the x coordinate of this cell
     */
    public int getxPos(){
        return this.xPos;
    }

    /**
     *
     * @return the y coordinate of this cell
     */
    public int getyPos(){
        return this.yPos;
    }

    /**
     *
     * @return is the cell is walckable or not
     */
    public boolean isWalkable() {
        return isWalkable;
    }

    /**
     *
     * @return cell to the left
     */
    public Cell getLeft() {
        return Left;
    }

    /**
     *
     * @return cell to the right
     */
    public Cell getRight() {
        return Right;
    }

    /**
     *
     * @return cell on top
     */
    public Cell getTop() {
        return Top;
    }

    /**
     *
     * @return cell on bottom
     */
    public Cell getBottom() {
        return Bottom;
    }

    /**
     *
     * @return unit in the cell
     */
    public Unit getUnit(){
        return this.unit;
    }

    /**
     * sets the unit that is in this cell
     * @param unit unit in the cell
     */
    public void setUnit(Unit unit){
        this.unit=unit;
    }

    /**
     *updates the cells various values
     */
    public void update(){
        if(this.unit!=null){
            this.isWalkable=false;
        }
    }

    /**
     * returns the distance from this cell to the specified one
     * @param cell cell to mesure distance to
     * @return distance to cell
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
