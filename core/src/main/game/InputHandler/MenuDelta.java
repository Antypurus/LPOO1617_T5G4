package main.game.InputHandler;

public class MenuDelta {
    public int deltaX=0;
    public int deltaY=0;

    public boolean confirmSelection=false;
    public boolean backSelection=false;

    public int increaseValue=0;
    public int decreaseValue=0;

    public void setDeltaX(int deltaX) {
        this.deltaX = deltaX;
    }

    public void setDeltaY(int deltaY) {
        this.deltaY = deltaY;
    }

    public void setConfirmSelection(boolean confirmSelection) {
        this.confirmSelection = confirmSelection;
    }

    public void setBackSelection(boolean backSelection) {
        this.backSelection = backSelection;
    }

    public void setIncreaseValue(int increaseValue) {
        this.increaseValue = increaseValue;
    }

    public void setDecreaseValue(int decreaseValue) {
        this.decreaseValue = decreaseValue;
    }
}
