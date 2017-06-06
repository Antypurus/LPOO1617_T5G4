package game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.FacebookType;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import main.game.MyGdxGame;

public class MenuState extends State
{
    private final int playBtnYCoord = 400;
    private final int InstructionsYCoord = 250;
    private final int quitYCoord = 100;
    private final int facebookYCoord = 50;
    private final int facebookXCoord = MyGdxGame.WIDTH - 200;

    private int playBtnCenterX;
    private int instructionsBtnCenterX;
    private int quitBtnCenterX;

    private Texture instructionsBtn;
    private Texture playBtn;
    private Texture quitBtn;
    private Texture facebookBtn;

    private long startTime;
    private long elapsedTime;

    private boolean facebook = true;


    public MenuState(GameStateManager gsm) {
        super(gsm);

        playBtn = new Texture("MenusImages/PlayImage.png");
        instructionsBtn = new Texture("MenusImages/HowToPlayImage.png");
        quitBtn = new Texture("MenusImages/QuitImage.png");
        facebookBtn = new Texture("FacebookImages/Facebook.png");

        this.playBtnCenterX = playBtn.getWidth() / 2;
        this.instructionsBtnCenterX = instructionsBtn.getWidth()/2;
        this.quitBtnCenterX = quitBtn.getWidth() / 2;
    }

    @Override
    protected void handleInput()
    {
        if(Gdx.input.justTouched())
        {
            if (Gdx.input.getX() >= ((MyGdxGame.centerXCoord) - (playBtnCenterX))
                    && Gdx.input.getX() <= ((MyGdxGame.centerXCoord) + (playBtnCenterX))
                    && (MyGdxGame.HEIGHT - Gdx.input.getY()) >= ((playBtnYCoord))
                    && (MyGdxGame.HEIGHT - Gdx.input.getY()) <= ((playBtnYCoord) + (playBtn.getHeight())))
            {
                this.dispose();
                gsm.set(new DifficultyStage(gsm));
            }
            else if(Gdx.input.getX() >= ((MyGdxGame.centerXCoord) - (instructionsBtnCenterX))
                    && Gdx.input.getX() <= ((MyGdxGame.centerXCoord) + (instructionsBtnCenterX))
                    && (MyGdxGame.HEIGHT - Gdx.input.getY()) >= ((InstructionsYCoord))
                    && (MyGdxGame.HEIGHT - Gdx.input.getY()) <= ((InstructionsYCoord) + (instructionsBtn.getHeight())))
            {
                this.dispose();
                gsm.set(new InstructionsState(gsm));
            }

            else if (Gdx.input.getX() >= ((MyGdxGame.centerXCoord) - (quitBtnCenterX))
                    && Gdx.input.getX() <= ((MyGdxGame.centerXCoord) + (quitBtnCenterX))
                    && (MyGdxGame.HEIGHT  - Gdx.input.getY()) >= ((quitYCoord))
                    && (MyGdxGame.HEIGHT  - Gdx.input.getY()) <= ((quitYCoord) + (quitBtn.getHeight())))
            {
                this.dispose();
                Gdx.app.exit();
            }

            else if (Gdx.input.getX() >= (facebookXCoord)
                    && Gdx.input.getX() <= (facebookXCoord + (facebookBtn.getWidth()))
                    && (MyGdxGame.HEIGHT  - Gdx.input.getY()) >= ((facebookYCoord))
                    && (MyGdxGame.HEIGHT  - Gdx.input.getY()) <= ((facebookYCoord) + (facebookBtn.getHeight())))
            {

                //TODO: mudar este link para um site onde seja possivel fazer download do jogo
                String domain = "https://github.com/";
                String appId = "433157270402383";

                String authUrl = "https://graph.facebook.com/oauth/authorize?type=user_agent&client_id="+appId + "&redirect_uri="+domain+"&scope=user_about_me,"
                        + "publish_actions";

                System.setProperty("webdriver.chrome.driver", "chromedriver.exe");


                WebDriver driver = new ChromeDriver();
                driver.get(authUrl);
                startTime = System.currentTimeMillis();
                String accessToken;
                while(facebook)
                {
                    elapsedTime = (System.currentTimeMillis() - startTime) / 1000;

                    if(!driver.getCurrentUrl().contains("facebook.com")) {
                        String url = driver.getCurrentUrl();
                        accessToken = url.replaceAll(".*#access_token=(.+)&.*", "$1");

                        driver.close();

                        FacebookClient fbClient = new DefaultFacebookClient(accessToken);

                        FacebookType response = fbClient.publish("me/feed",
                                FacebookType.class, Parameter.with("message",
                                        "Currently playing LPOO game"),
                                Parameter.with("link", "https://github.com/"));

                        facebook = false;

                    }
                    else if(elapsedTime >= 60) {
                        driver.close();
                        facebook = false;
                    }
                }
            }
        }

        if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)){
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
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        sb.begin();
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
    }
}
