package game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.FacebookType;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import game.Facebook.FacebookHandler;
import main.game.MyGdxGame;

public class MenuState extends State
{
    private final int titleYCoord = 580;
    private final int playBtnYCoord = 420;
    private final int InstructionsYCoord = 280;
    private final int quitYCoord = 140;
    private final int facebookYCoord = 50;
    private final int facebookXCoord = MyGdxGame.WIDTH - 200;

    private int playBtnCenterX;
    private int instructionsBtnCenterX;
    private int quitBtnCenterX;
    private int titleCenterX;

    private Texture instructionsBtn;
    private Texture playBtn;
    private Texture quitBtn;
    private Texture facebookBtn;
    private Texture gameTitle;

    private FacebookHandler facebookHandler;


    public MenuState(GameStateManager gsm) {
        super(gsm);

        gameTitle = new Texture("MenusImages/GameTitleImage.png");
        playBtn = new Texture("MenusImages/PlayImage.png");
        instructionsBtn = new Texture("MenusImages/HowToPlayImage.png");
        quitBtn = new Texture("MenusImages/QuitImage.png");
        facebookBtn = new Texture("FacebookImages/Facebook.png");

        this.playBtnCenterX = playBtn.getWidth() / 2;
        this.instructionsBtnCenterX = instructionsBtn.getWidth()/2;
        this.quitBtnCenterX = quitBtn.getWidth() / 2;
        this.titleCenterX = MyGdxGame.centerXCoord - gameTitle.getWidth()/2;
    }


    protected void handleMenuMouseInput()
    {
        if (handleBtn(playBtnCenterX, playBtnYCoord, playBtn.getHeight()))
        {
            this.dispose();
            gsm.set(new DifficultyState(gsm));
        }
        else if(handleBtn(instructionsBtnCenterX, InstructionsYCoord, instructionsBtn.getHeight()))
        {
            this.dispose();
            gsm.set(new InstructionsState(gsm));
        }

        else if (handleBtn(quitBtnCenterX, quitYCoord, quitBtn.getHeight()))
        {
            this.dispose();
            Gdx.app.exit();
        }

        else if (handleFacebookBtn(facebookXCoord, facebookYCoord, facebookBtn.getWidth(), facebookBtn.getHeight()))
        {
            facebookHandler = new FacebookHandler();
        }
    }

    @Override
    protected void handleInput()
    {
        if(Gdx.input.justTouched())
            handleMenuMouseInput();
        if(handleEscapeKey())
            Gdx.app.exit();
    }

    @Override
    public void update(float dt)
    {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb)
    {
        clearScreen();

        sb.begin();
        sb.draw(gameTitle,
                titleCenterX, titleYCoord);
        sb.draw(playBtn,
                (MyGdxGame.centerXCoord) - (playBtnCenterX), playBtnYCoord);
        sb.draw(instructionsBtn,
                (MyGdxGame.centerXCoord) - (instructionsBtnCenterX), InstructionsYCoord);
        sb.draw(quitBtn,
                (MyGdxGame.centerXCoord) - (quitBtnCenterX), quitYCoord);
        sb.draw(facebookBtn,
                facebookXCoord, facebookYCoord);
        sb.end();
    }

    @Override
    public void dispose()
    {
        quitBtn.dispose();
        instructionsBtn.dispose();
        playBtn.dispose();
        facebookBtn.dispose();
        gameTitle.dispose();
    }
}
