package com.mygdx.game.InputHandler;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.mygdx.game.MyGdxGame;

public class InputHandler {
    private MyGdxGame game=null;

    public InputHandler(MyGdxGame game){
        this.game = game;
    }

    public void update(){
        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            //make current character go up;
            //move menu
        }
        //same for other buttons
    }
}
