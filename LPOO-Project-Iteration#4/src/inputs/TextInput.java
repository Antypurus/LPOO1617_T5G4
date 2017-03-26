package inputs;

import java.io.Serializable;
import java.util.*;

public class TextInput implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String input;
    private Scanner inputreader;

    public TextInput(){
        inputreader=new Scanner(System.in);
    }
    /*
 		*closes the scaner 
 	*/
    public void close(){
        inputreader.close();
    }
    /*
 		*reads input from the keyboard 
 	*/
    private String read(){
        input=inputreader.next();
        return input;
    }
    /*
 		*return the input as an int if it corresponds to a direction 
 	*/
    public int getNextStep(){

    	System.out.print(" \n Direcção em que se pretende mover:");
		String check = read();
    	
    	if(check.equals("Up")||check.equals("up")||check.equals("w")){
    		return 1;
    	}
    	if(check.equals("Down")||check.equals("down")||check.equals("s")){
    		return 2;
    	}
    	if(check.equals("left")||check.equals("Left")||check.equals("a")){
    		return 3;
    	}
    	if(check.equals("Right")||check.equals("right")||check.equals("d")){
    		return 4;
    	}

    	System.out.print("\n");
    	
    	return 0;
    }

}
