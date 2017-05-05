package main.game.InputHandler;

import main.game.MyGdxGame;

public abstract class InputHandler {

    private MyGdxGame game=null;

    public InputHandler(MyGdxGame game){
        this.game = game;
    }

}
