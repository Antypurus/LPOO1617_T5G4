package game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class DifficultyStage extends State
{
    private Texture easyBtn;
    private Texture hardBtn;
    private static final int EASY = 0;
    private static final int HARD = 1;

    public DifficultyStage(GameStateManager gsm) {
        super(gsm);
        easyBtn = new Texture("MenusImages/EasyImage.png");
        hardBtn = new Texture("MenusImages/HardImage.png");
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
                    && (screenHeight - Gdx.input.getY()) >= ((200))
                    && (screenHeight - Gdx.input.getY()) <= ((200) + (hardBtn.getHeight())))
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
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        sb.begin();
        sb.draw(easyBtn, (screenWidth/2)- (easyBtn.getWidth()/2), 400);
        sb.draw(hardBtn, (screenWidth/2)- (hardBtn.getWidth()/2), 200);
        sb.end();
    }

    @Override
    public void dispose()
    {
        hardBtn.dispose();
        easyBtn.dispose();
    }
}
