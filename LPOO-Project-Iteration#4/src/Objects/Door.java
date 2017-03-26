package Objects;

import java.io.Serializable;

public class Door extends Object implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int xPos;
    private int yPos;
    private boolean isOpean=false;
    private String openRep="S";
    private String closedRep="I";
    private Key associatedKey=null;
    private Lever associatedLever=null;

    public Door(int xPos,int yPos,Lever associatedLever){
    	this.xPos=xPos;
    	this.yPos=yPos;
    	this.associatedLever=associatedLever;
    }
    
    public Door(int xPos,int yPos,Key associatedkey){
    	this.xPos=xPos;
    	this.yPos=yPos;
    	this.associatedKey=associatedkey;
    }

    public void setOpen(boolean state){
    	this.isOpean=state;
	}

	public boolean getIsOpen(){
    	return this.isOpean;
	}
    
    public String getRepresentation(){
    	if(this.associatedKey==null){
    		if(this.associatedLever.getState()){
    			this.isOpean=true;
    			return openRep;
    		}else{
    			return closedRep;
    		}
    	}else{
    		if(this.associatedKey.isPicked()&&this.isOpean){
    			this.isOpean=true;
    			return openRep;
    		}else{
    			return closedRep;
    		}
    	}
    }

	public int getxPos() {
		return xPos;
	}

	public int getyPos() {
		return yPos;
	}
}
