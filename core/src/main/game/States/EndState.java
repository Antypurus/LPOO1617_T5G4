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

import main.game.MyGdxGame;


public class EndState extends State {

    private final int quitYCoord = 100;
    private final int facebookYCoord = 50;
    private final int facebookXCoord = MyGdxGame.WIDTH - 200;

    private Texture facebookBtn;
    private Texture quitBtn;
    private Texture template;

    private int quitBtnCenterX;
    private int templateCenterX;
    private int templateCenterY;

    private boolean facebook = true;
    private boolean gameWon = false;

    private Integer elapsedTime;

    private long facebookStartTime;
    private long facebookElapsedTime;

    private BitmapFont timeFont;


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
    }

    protected EndState(GameStateManager gsm) {
        super(gsm);

    }

    @Override
    protected void handleInput()
    {
        if(Gdx.input.justTouched())
        {
            if (Gdx.input.getX() >= (facebookXCoord)
                && Gdx.input.getX() <= (facebookXCoord + (facebookBtn.getWidth()))
                && (MyGdxGame.HEIGHT  - Gdx.input.getY()) >= ((facebookYCoord))
                && (MyGdxGame.HEIGHT  - Gdx.input.getY()) <= ((facebookYCoord) + (facebookBtn.getHeight())))
            {
                String domain = "https://github.com/";
                String appId = "433157270402383";

                String authUrl = "https://graph.facebook.com/oauth/authorize?type=user_agent&client_id="+appId + "&redirect_uri="+domain+"&scope=user_about_me,"
                        + "publish_actions";

                System.setProperty("webdriver.chrome.driver", "chromedriver.exe");


                WebDriver driver = new ChromeDriver();
                driver.get(authUrl);
                facebookStartTime = System.currentTimeMillis();
                String accessToken;

                while(facebook)
                {
                    facebookElapsedTime = (System.currentTimeMillis() - facebookStartTime) / 1000;

                    if(!driver.getCurrentUrl().contains("facebook.com")) {
                        String url = driver.getCurrentUrl();
                        accessToken = url.replaceAll(".*#access_token=(.+)&.*", "$1");


                        FacebookClient fbClient = new DefaultFacebookClient(accessToken);

                        if(gameWon) {
                            FacebookType response = fbClient.publish("me/feed",
                                    FacebookType.class, Parameter.with("message",
                                            "Won my game in " + elapsedTime + " seconds"),
                                    Parameter.with("link", "https://github.com/"));
                        }
                        else
                        {
                            FacebookType response = fbClient.publish("me/feed",
                                    FacebookType.class, Parameter.with("message",
                                            "Lost my game in " + elapsedTime + " seconds"),
                                    Parameter.with("link", "https://github.com/"));
                        }

                        facebook = false;

                    }

                    else if(facebookElapsedTime >= 60) {
                        driver.close();
                        facebook = false;
                    }
                }
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

        sb.draw(facebookBtn,
                facebookXCoord, facebookYCoord);
        sb.draw(quitBtn,
                (MyGdxGame.centerXCoord) - (quitBtnCenterX), quitYCoord);
        sb.draw(template,
                MyGdxGame.centerXCoord - (templateCenterX), MyGdxGame.centerYCoord);

        timeFont.setColor(Color.BLACK);
        timeFont.draw(sb, elapsedTime.toString(), MyGdxGame.centerXCoord, MyGdxGame.centerYCoord + templateCenterY);

        sb.end();
    }

    @Override
    public void dispose() {
        facebookBtn.dispose();
        quitBtn.dispose();
        template.dispose();
    }
}
