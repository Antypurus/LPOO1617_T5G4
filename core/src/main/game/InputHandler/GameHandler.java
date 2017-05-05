package main.game.InputHandler;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class GameHandler extends InputHandler{

    public GameHandler(main.game.MyGdxGame game){
        super(game);
    }

    public MovementDelta update(){
        if(Gdx.input.isKeyJustPressed(Input.Keys.UP)){
            return new MovementDelta(0,1);
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)){
            return new MovementDelta(0,-1);
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.LEFT)){
            return new MovementDelta(-1,0);
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)){
            return new MovementDelta(1,0);
        }
        return null;
    }

}
