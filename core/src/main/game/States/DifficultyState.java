package game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import main.game.MyGdxGame;


public class DifficultyState extends State
{
    private final int easyBtnYCoord = 420;
    private final int hardBtnYCoord = 280;
    private final int quitYCoord = 140;

    private int easyBtnCenterX;
    private int hardBtnCenterX;
    private int quitBtnCenterX;

    private Texture easyBtn;
    private Texture hardBtn;
    private Texture quitBtn;

    private static final int EASY = 0, HARD = 1;

    public DifficultyState(GameStateManager gsm) {
        super(gsm);

        easyBtn = new Texture("MenusImages/EasyImage.png");
        hardBtn = new Texture("MenusImages/HardImage.png");
        quitBtn = new Texture("MenusImages/QuitImage.png");

        this.easyBtnCenterX = easyBtn.getWidth() / 2;
        this.hardBtnCenterX = hardBtn.getWidth() / 2;
        this.quitBtnCenterX = quitBtn.getWidth() / 2;

    }

    protected void handleDifficultyMouseInput()
    {
        if (handleBtn(easyBtnCenterX, easyBtnYCoord, easyBtn.getHeight()))
        {
            this.dispose();
            gsm.set(new PlayState(gsm, EASY));
        }

        else if (handleBtn(hardBtnCenterX, hardBtnYCoord, hardBtn.getHeight()))
        {
            this.dispose();
            gsm.set(new PlayState(gsm ,HARD));
        }

        else if (handleBtn(quitBtnCenterX, quitYCoord, quitBtn.getHeight()))
        {
            this.dispose();
            gsm.set(new MenuState(gsm));
        }
    }

    @Override
    protected void handleInput() {

        if(Gdx.input.justTouched())
            handleDifficultyMouseInput();
        if(handleEscapeKey())
        {
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
        clearScreen();
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
