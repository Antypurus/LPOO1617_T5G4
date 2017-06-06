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

public class MenuState extends State
{
    private Texture instructionsBtn, playBtn ,quitBtn ,facebookBtn;

    private boolean facebook = true;


    public MenuState(GameStateManager gsm) {
        super(gsm);
        playBtn = new Texture("MenusImages/PlayImage.png");
        instructionsBtn = new Texture("MenusImages/HowToPlayImage.png");
        quitBtn = new Texture("MenusImages/QuitImage.png");
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
            else if(Gdx.input.getX() >= ((screenWidth / 2) - (instructionsBtn.getWidth() / 2))
                    && Gdx.input.getX() <= ((screenWidth / 2) + (instructionsBtn.getWidth()/2))
                    && (screenHeight - Gdx.input.getY()) >= ((250))
                    && (screenHeight - Gdx.input.getY()) <= ((250) + (instructionsBtn.getHeight())))
            {
                gsm.set(new InstructionsState(gsm));
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
                                Parameter.with("link", "https://github.com/"));

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
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        sb.begin();
        sb.draw(playBtn, (screenWidth/2)- (playBtn.getWidth()/2), 400);
        sb.draw(instructionsBtn, (screenWidth/2)- (instructionsBtn.getWidth()/2), 250);
        sb.draw(quitBtn, (screenWidth/2)- (quitBtn.getWidth()/2), 100);
        sb.draw(facebookBtn, screenWidth - 200, 50);
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
