package game.States;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.FacebookType;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import main.game.MyGdxGame;

public class MenuState extends State
{
    private Texture background;
    private Texture optionsBtn;
    private Texture playBtn;
    private Texture quitBtn;
    private Texture facebookBtn;
    private boolean facebook = true;


    public MenuState(GameStateManager gsm) {
        super(gsm);
        background = new Texture("black.png");
        playBtn = new Texture("SinglePlayer.png");
        optionsBtn = new Texture("Options.png");
        quitBtn = new Texture("quit.png");
        facebookBtn = new Texture("FacebookImages/Facebook.png");
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

            else if (Gdx.input.getX() >= (screenWidth - 200)
                    && Gdx.input.getX() <= (screenWidth - 200 + (facebookBtn.getWidth()))
                    && (screenHeight - Gdx.input.getY()) >= ((50))
                    && (screenHeight - Gdx.input.getY()) <= ((50) + (facebookBtn.getHeight())))
            {
               /* String acessToken = "EAACEdEose0cBALVlZAORGSWIacZCUuXbwNN0M8GoKXcaKnNZA1i1lbO5TO4JIeNYalz9iSdRwHMHGN6flfvejtl1ZBQrIdUT4VlAvXXWlVQVltSHjBkr1lEaASCGgtKylA6JZCSfZCGxmHpnpZChKD4yOvOzIZA7kD76xwRgh60eyPTeCml97JMZCvt3TlxlMFcgZD";

                FacebookClient fbClient = new DefaultFacebookClient(acessToken);//

                FacebookType response = fbClient.publish("me/feed", FacebookType.class, Parameter.with("message",  "Currently playing LPOOP game"), Parameter.with("link", "http://www.staggeringbeauty.com/"));
*/

                //TODO: mudar este link para um site onde seja possivel fazer download do jogo
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

                        FacebookType response = fbClient.publish("me/feed",
                                FacebookType.class, Parameter.with("message",
                                        "Currently playing LPOO game"),
                                Parameter.with("link", "http://www.staggeringbeauty.com/"));

                        facebook = false;

                    }
                }
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
        sb.draw(facebookBtn, screenWidth - 200, 50);
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
