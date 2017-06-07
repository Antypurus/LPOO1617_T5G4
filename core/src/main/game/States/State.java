package game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

import main.game.MyGdxGame;


public abstract class State {
    protected GameStateManager gsm;

    protected State(GameStateManager gsm)
    {
        this.gsm = gsm;
    }

    protected abstract void handleInput();
    public abstract void update(float dt);
    public abstract void render(SpriteBatch sb);
    public abstract void dispose();

    public boolean handleBtn(int CenterX, int YCoord, int BtnHeight)
    {
       if(Gdx.input.getX() >= ((MyGdxGame.centerXCoord) - (CenterX))
                && Gdx.input.getX() <= ((MyGdxGame.centerXCoord) + (CenterX))
                && (MyGdxGame.HEIGHT  - Gdx.input.getY()) >= ((YCoord))
                && (MyGdxGame.HEIGHT  - Gdx.input.getY()) <= ((YCoord) + (BtnHeight)))
           return true;
        else
            return false;
    }
    public boolean handleEscapeKey()
    {
        if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)){
            return true;
        }
        return false;
    }

    public boolean handleFacebookBtn(int facebookXCoord, int facebookYCoord, int facebookBtnWidth, int facebookBtnHeight)
    {
        if(Gdx.input.getX() >= (facebookXCoord)
                && Gdx.input.getX() <= (facebookXCoord + (facebookBtnWidth))
                && (MyGdxGame.HEIGHT  - Gdx.input.getY()) >= ((facebookYCoord))
                && (MyGdxGame.HEIGHT  - Gdx.input.getY()) <= ((facebookYCoord) + (facebookBtnHeight)))
            return true;
        else
            return false;
    }

}
