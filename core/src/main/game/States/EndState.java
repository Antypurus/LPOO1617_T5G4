package game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.FacebookType;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class EndState extends State {

    private Texture facebookBtn;
    private Texture quitBtn;
    private boolean facebook = true;
    private boolean gameWon = false;
    private int elapsedTime;


    protected EndState(GameStateManager gsm, Long elapsedTime, Boolean gameWon)
    {
        super(gsm);
        facebookBtn = new Texture("FacebookImages/Facebook.png");
        quitBtn = new Texture("MenusImages/QuitImage.png");
        this.elapsedTime = elapsedTime.intValue();
        this.gameWon = gameWon;
    }

    protected EndState(GameStateManager gsm) {
        super(gsm);

    }

    @Override
    protected void handleInput()
    {
        if(Gdx.input.justTouched())
        {
            if (Gdx.input.getX() >= (screenWidth - 200)
                    && Gdx.input.getX() <= (screenWidth - 200 + (facebookBtn.getWidth()))
                    && (screenHeight - Gdx.input.getY()) >= ((50))
                    && (screenHeight - Gdx.input.getY()) <= ((50) + (facebookBtn.getHeight())))
            {
                String domain = "https://github.com/";
                String appId = "433157270402383";

                String authUrl = "https://graph.facebook.com/oauth/authorize?type=user_agent&client_id="+appId + "&redirect_uri="+domain+"&scope=user_about_me,"
                        + "publish_actions";

                System.setProperty("webdriver.chrome.driver", "chromedriver.exe");


                WebDriver driver = new ChromeDriver();
                driver.get(authUrl);
                String accessToken;
                while(facebook)
                {
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
                }
            }

            else if (Gdx.input.getX() >= ((this.screenWidth / 2) - (quitBtn.getWidth() / 2))
                    && Gdx.input.getX() <= ((screenWidth / 2) + (quitBtn.getWidth() / 2))
                    && (screenHeight - Gdx.input.getY()) >= ((100))
                    && (screenHeight - Gdx.input.getY()) <= ((100) + (quitBtn.getHeight())))
            {
                gsm.set(new MenuState(gsm));
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
        sb.draw(facebookBtn, screenWidth - 200, 50);
        sb.draw(quitBtn, (screenWidth/2)- (quitBtn.getWidth()/2), 100);
        sb.end();
    }

    @Override
    public void dispose() {
        facebookBtn.dispose();
        quitBtn.dispose();
    }
}
