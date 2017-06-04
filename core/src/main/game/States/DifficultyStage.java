package game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Diogo on 24/05/2017.
 */

public class DifficultyStage extends State
{
    private Texture background;
    private Texture easyBtn;
    private Texture hardBtn;
    private static final int EASY = 0;
    private static final int HARD = 1;

    public DifficultyStage(GameStateManager gsm) {
        super(gsm);
        easyBtn = new Texture("easy.png");
        hardBtn = new Texture("hard.png");
        background = new Texture("black.png");
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched())
        {
            if (Gdx.input.getX() >= ((this.screenWidth / 2) - (easyBtn.getWidth() / 2))
                    && Gdx.input.getX() <= ((screenWidth / 2) + (easyBtn.getWidth() / 2))
                    && (screenHeight - Gdx.input.getY()) >= ((400))
                    && (screenHeight - Gdx.input.getY()) <= ((400) + (easyBtn.getHeight())))
            {
                gsm.set(new PlayState(gsm, EASY));
            }

            else if (Gdx.input.getX() >= ((screenWidth / 2) - (hardBtn.getWidth() / 2))
                    && Gdx.input.getX() <= ((screenWidth / 2) + (hardBtn.getWidth() / 2))
                    && (screenHeight - Gdx.input.getY()) >= ((250))
                    && (screenHeight - Gdx.input.getY()) <= ((250) + (hardBtn.getHeight())))
            {
                gsm.set(new PlayState(gsm ,HARD));
            }
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background, 0, 0);
        sb.draw(easyBtn, (screenWidth/2)- (easyBtn.getWidth()/2), 400);
        sb.draw(hardBtn, (screenWidth/2)- (hardBtn.getWidth()/2), 250);
        sb.end();
    }

    @Override
    public void dispose()
    {
        hardBtn.dispose();
        easyBtn.dispose();
        background.dispose();
    }
}
