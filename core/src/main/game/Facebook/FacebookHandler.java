package game.Facebook;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.FacebookType;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import main.game.MyGdxGame;


public class FacebookHandler
{
    private boolean onFacebook = false;

    /**
     *
     * Constructor for the FacebookHandler , this class lets the user post to facebook
     *
     * @param message a String containing the message to be written alongside the facebook post
     */
    public FacebookHandler(String message)
    {
        String domain = "https://www.mediafire.com/folder/0zhuy220fbf6c/RPG-Game";
        String appId = "433157270402383";

        String authUrl = "https://graph.facebook.com/oauth/authorize?type=user_agent&client_id="
                +appId + "&redirect_uri="
                +domain+"&scope=user_about_me,"
                + "publish_actions";


        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get(authUrl);
        String accessToken;
        if(driver.getCurrentUrl().contains("facebook.com"))
            onFacebook = true;
        while(onFacebook)
        {
            if(!driver.getCurrentUrl().contains("facebook.com")) {
                String url = driver.getCurrentUrl();
                accessToken = url.replaceAll(".*#access_token=(.+)&.*", "$1");

                driver.close();

                FacebookClient fbClient = new DefaultFacebookClient(accessToken);

                FacebookType response = fbClient.publish("me/feed",
                        FacebookType.class, Parameter.with("message",
                                message),
                        Parameter.with("link", "https://www.mediafire.com/folder/0zhuy220fbf6c/RPG-Game"));

                onFacebook = false;

            }
        }
    }
}
