package game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

import main.game.MyGdxGame;


public abstract class State {
    protected GameStateManager gsm;

    /**
     *
     * Constructor for the State , superClass of the different game states
     *
     * @param gsm a gamestatemanager that will handle
     *            the different states set's and pop's
     */
    protected State(GameStateManager gsm)
    {
        this.gsm = gsm;
    }

    /**
     *
     * Handles user input
     *
     */
    protected abstract void handleInput();

    /**
     *
     * Calls that need to be updated to check changes, or user input
     *
     * @param dt time to update
     */
    public abstract void update(float dt);

    /**
     *
     * Renders information to the screen
     *
     * @param sb batch containing sprites to be drawn
     */
    public abstract void render(SpriteBatch sb);

    /**
     *
     * Deletes assets from memory
     *
     */
    public abstract void dispose();

    /**
     *
     * Checks user mouse click to know which button it wanted to press
     *
     * @param CenterX x coordinate so that the button image is drawn in the center
     * @param YCoord  button image y coordinate
     * @param BtnHeight  height of the button image
     */
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

    /**
     *
     * returns true if the user pressed the escape key
     *
     * @return true if escaped key pressed, false if not
     *
     */
    public boolean handleEscapeKey()
    {
        if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)){
            return true;
        }
        return false;
    }


    /**
     *
     * Checks user mouse click to know if the user pressed the share to facebook button
     *
     * @param facebookXCoord facebook share  image x coordinate to be drawn
     * @param facebookYCoord  facebook share image y coordinate to be drawn
     * @param facebookBtnWidth  width of the facebook button image
     * @param facebookBtnHeight height of the facebook button image
     */
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

    /**
     *
     * Clears everything on screen and draws a black background
     *
     */
    public void clearScreen()
    {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

}
