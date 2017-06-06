package game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import main.game.MyGdxGame;


public class DifficultyStage extends State
{
    private final int easyBtnYCoord = 400;
    private final int hardBtnYCoord = 250;
    private final int quitYCoord = 100;

    private int easyBtnCenterX;
    private int hardBtnCenterX;
    private int quitBtnCenterX;

    private Texture easyBtn;
    private Texture hardBtn;
    private Texture quitBtn;

    private static final int EASY = 0, HARD = 1;

    public DifficultyStage(GameStateManager gsm) {
        super(gsm);

        easyBtn = new Texture("MenusImages/EasyImage.png");
        hardBtn = new Texture("MenusImages/HardImage.png");
        quitBtn = new Texture("MenusImages/QuitImage.png");

        this.easyBtnCenterX = easyBtn.getWidth() / 2;
        this.hardBtnCenterX = hardBtn.getWidth() / 2;
        this.quitBtnCenterX = quitBtn.getWidth() / 2;

    }

    @Override
    protected void handleInput() {

        if(Gdx.input.justTouched())
        {
            if (Gdx.input.getX() >= ((MyGdxGame.centerXCoord) - (easyBtnCenterX))
                    && Gdx.input.getX() <= ((MyGdxGame.centerXCoord) + (easyBtnCenterX))
                    && (MyGdxGame.HEIGHT - Gdx.input.getY()) >= ((easyBtnYCoord))
                    && (MyGdxGame.HEIGHT - Gdx.input.getY()) <= ((easyBtnYCoord) + (easyBtn.getHeight())))
            {
                this.dispose();
                gsm.set(new PlayState(gsm, EASY));
            }

            else if (Gdx.input.getX() >= ((MyGdxGame.centerXCoord) - (hardBtnCenterX))
                    && Gdx.input.getX() <= ((MyGdxGame.centerXCoord) + (hardBtnCenterX))
                    && (MyGdxGame.HEIGHT - Gdx.input.getY()) >= ((hardBtnYCoord))
                    && (MyGdxGame.HEIGHT - Gdx.input.getY()) <= ((hardBtnYCoord) + (hardBtn.getHeight())))
            {
                this.dispose();
                gsm.set(new PlayState(gsm ,HARD));
            }

            else if (Gdx.input.getX() >= ((MyGdxGame.centerXCoord) - (quitBtnCenterX))
                    && Gdx.input.getX() <= ((MyGdxGame.centerXCoord) + (quitBtnCenterX))
                    && (MyGdxGame.HEIGHT  - Gdx.input.getY()) >= ((quitYCoord))
                    && (MyGdxGame.HEIGHT  - Gdx.input.getY()) <= ((quitYCoord) + (quitBtn.getHeight())))
            {
                this.dispose();
                gsm.set(new MenuState(gsm));
            }
        }

        if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)){
            this.dispose();
            gsm.set(new MenuState(gsm));
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
        sb.draw(easyBtn,
                (MyGdxGame.centerXCoord) - (easyBtnCenterX), easyBtnYCoord);
        sb.draw(hardBtn,
                (MyGdxGame.centerXCoord) - (hardBtnCenterX), hardBtnYCoord);
        sb.draw(quitBtn,
                (MyGdxGame.centerXCoord) - (quitBtnCenterX), quitYCoord);
        sb.end();
    }

    @Override
    public void dispose()
    {
        hardBtn.dispose();
        easyBtn.dispose();
        quitBtn.dispose();
    }
}
