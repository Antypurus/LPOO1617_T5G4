package com.mygdx.game.InputHandler;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.mygdx.game.MyGdxGame;

public abstract class InputHandler {

    private MyGdxGame game=null;

    public InputHandler(MyGdxGame game){
        this.game = game;
    }

}
