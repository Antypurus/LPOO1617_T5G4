package inputs;

import java.util.*;


public class TextInput {

    String input;
    Scanner inputreader;

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

}
