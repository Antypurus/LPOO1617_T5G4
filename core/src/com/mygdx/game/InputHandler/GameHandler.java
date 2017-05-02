package com.mygdx.game.InputHandler;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.mygdx.game.MyGdxGame;

public class GameHandler extends InputHandler{

    public GameHandler(MyGdxGame game){
        super(game);
    }

    public MovementDelta update(){
        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            return new MovementDelta(0,1);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            return new MovementDelta(0,-1);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            return new MovementDelta(-1,0);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            return new MovementDelta(1,0);
        }
        return null;
    }

}
