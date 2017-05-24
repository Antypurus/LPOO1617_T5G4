package game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Diogo on 24/05/2017.
 */

public class OptionsState extends State
{
    private Texture quitBtn;

    public OptionsState(GameStateManager gsm) {
        super(gsm);
        quitBtn = new Texture("quit.png");
    }

    @Override
    protected void handleInput()
    {
        if(Gdx.input.justTouched())
        {
            if (Gdx.input.getX() >= ((this.screenWidth / 2) - (quitBtn.getWidth() / 2))
                    && Gdx.input.getX() <= ((screenWidth / 2) + (quitBtn.getWidth() / 2))
                    && (screenHeight - Gdx.input.getY()) >= ((screenHeight / 4))
                    && (screenHeight - Gdx.input.getY()) <= ((screenHeight / 4) + (quitBtn.getHeight())))
            {
                gsm.set(new MenuState(gsm));
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
            Gdx.app.exit();
        }
    }

    @Override
    public void update(float dt)
    {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb)
    {
        sb.begin();
        sb.draw(quitBtn, (screenWidth/2) - (quitBtn.getWidth()/2), screenHeight/4);
        sb.end();
    }

    @Override
    public void dispose()
    {
        quitBtn.dispose();
    }
}
