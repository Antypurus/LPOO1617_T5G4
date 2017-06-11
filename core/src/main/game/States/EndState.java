package game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.FacebookType;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import game.Facebook.FacebookHandler;
import main.game.MyGdxGame;


public class EndState extends State {

    private final int quitYCoord = 140;
    private final int facebookYCoord = 50;
    private final int facebookXCoord = MyGdxGame.WIDTH - 200;

    private Texture facebookBtn;
    private Texture quitBtn;
    private Texture template;

    private int quitBtnCenterX;
    private int templateCenterX;
    private int templateCenterY;

    private boolean gameWon;

    private Integer elapsedTime;

    private BitmapFont timeFont;

    private FacebookHandler facebookHandler;

    private String message;


    protected EndState(GameStateManager gsm, Long elapsedTime, Boolean gameWon)
    {
        super(gsm);

        facebookBtn = new Texture("FacebookImages/Facebook.png");
        quitBtn = new Texture("MenusImages/QuitImage.png");
        template = new Texture("MenusImages/Template.png");

        this.quitBtnCenterX  = quitBtn.getWidth()  / 2;
        this.templateCenterX = template.getWidth() / 2;
        this.templateCenterY = template.getHeight()/ 2;

        this.elapsedTime = elapsedTime.intValue();
        this.gameWon = gameWon;

        this.timeFont = new BitmapFont();

        if(this.gameWon)
            this.message = "Won the game in " + this.elapsedTime.toString() + " seconds. Try to beat my time.";
        else
            this.message = "Lost the game in " + this.elapsedTime.toString() + " seconds. Better luck next time.";
    }

    protected EndState(GameStateManager gsm) {
        super(gsm);

    }


    protected void handleMouseInput()
    {
        if (handleFacebookBtn(facebookXCoord, facebookYCoord, facebookBtn.getWidth(), facebookBtn.getHeight()))
        {
            facebookHandler = new FacebookHandler(message);
        }

        else if (handleBtn(quitBtnCenterX, quitYCoord, quitBtn.getHeight()))
        {
            this.dispose();
            gsm.set(new MenuState(gsm));
        }
    }

    @Override
    protected void handleInput()
    {
        if(handleEscapeKey())
        {
        this.dispose();
        gsm.set(new MenuState(gsm));
        }
        else if(Gdx.input.justTouched())
            handleMouseInput();
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {

        clearScreen();

        sb.begin();

        sb.draw(facebookBtn,
                facebookXCoord, facebookYCoord);
        sb.draw(quitBtn,
                (MyGdxGame.centerXCoord) - (quitBtnCenterX), quitYCoord);
        sb.draw(template,
                MyGdxGame.centerXCoord - (templateCenterX), MyGdxGame.centerYCoord);

        timeFont.setColor(Color.BLACK);
        timeFont.draw(sb, message, MyGdxGame.centerXCoord, MyGdxGame.centerYCoord + templateCenterY);

        sb.end();
    }

    @Override
    public void dispose() {
        facebookBtn.dispose();
        quitBtn.dispose();
        template.dispose();
    }
}
