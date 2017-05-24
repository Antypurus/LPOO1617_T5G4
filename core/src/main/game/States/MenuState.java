package game.States;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import main.game.MyGdxGame;

public class MenuState extends State
{
    private Texture background;
    private Texture optionsBtn;
    private Texture playBtn;
    private Texture quitBtn;


    public MenuState(GameStateManager gsm) {
        super(gsm);
        background = new Texture("black.png");
        playBtn = new Texture("SinglePlayer.png");
        optionsBtn = new Texture("Options.png");
        quitBtn = new Texture("quit.png");
    }

    @Override
    protected void handleInput()
    {
        if(Gdx.input.justTouched())
        {
            if (Gdx.input.getX() >= ((this.screenWidth / 2) - (playBtn.getWidth() / 2))
                    && Gdx.input.getX() <= ((screenWidth / 2) + (playBtn.getWidth()/2))
                    && (screenHeight - Gdx.input.getY()) >= ((400))
                    && (screenHeight - Gdx.input.getY()) <= ((400) + (playBtn.getHeight())))
            {
                gsm.set(new DifficultyStage(gsm));
            }
            else if(Gdx.input.getX() >= ((screenWidth / 2) - (optionsBtn.getWidth() / 2))
                    && Gdx.input.getX() <= ((screenWidth / 2) + (optionsBtn.getWidth()/2))
                    && (screenHeight - Gdx.input.getY()) >= ((250))
                    && (screenHeight - Gdx.input.getY()) <= ((250) + (optionsBtn.getHeight())))
            {
                gsm.set(new OptionsState(gsm));
            }

            else if (Gdx.input.getX() >= ((this.screenWidth / 2) - (quitBtn.getWidth() / 2))
                    && Gdx.input.getX() <= ((screenWidth / 2) + (quitBtn.getWidth() / 2))
                    && (screenHeight - Gdx.input.getY()) >= ((100))
                    && (screenHeight - Gdx.input.getY()) <= ((100) + (quitBtn.getHeight())))
            {
                Gdx.app.exit();
            }
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
        sb.draw(background, 0, 0);
        sb.draw(playBtn, (screenWidth/2)- (playBtn.getWidth()/2), 400);
        sb.draw(optionsBtn, (screenWidth/2)- (playBtn.getWidth()/2), 250);
        sb.draw(quitBtn, (screenWidth/2)- (playBtn.getWidth()/2), 100);
        sb.end();
    }

    @Override
    public void dispose()
    {
        quitBtn.dispose();
        optionsBtn.dispose();
        playBtn.dispose();
        background.dispose();
    }
}
