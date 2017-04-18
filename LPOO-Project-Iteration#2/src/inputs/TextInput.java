package inputs;

import java.util.*;

public class TextInput {

    private String input;
    private Scanner inputreader;

    public TextInput(){
        inputreader=new Scanner(System.in);
    }

    public void close(){
        inputreader.close();
    }

    private String read(){
        input=inputreader.next();
        return input;
    }
    
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
