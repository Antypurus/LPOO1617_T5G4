package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.FacebookType;

import main.game.MyGdxGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		System.setProperty("user.name","Player");
		config.width=1280;
		config.height=720;
		config.fullscreen = false;
		config.samples = 0;
		config.vSyncEnabled = false;
		config.foregroundFPS = 0;
		config.backgroundFPS = 0;
		new LwjglApplication(new MyGdxGame(), config);

        String acessToken = "EAACEdEose0cBAC2nOV1MM8NVljMMurGZC1rhQvjLoaZCDULqPz3ZCJw3j0Ni2h8KjEqSMlHZCCAWDRWnq1ZBhO2bhuJOEdkNkcvqCwdFyembLyNiEhNbMkpUQ755ELYFAqWZCZC2YsY4uDfvACfI6c8bDsNdr6PQMrpO8Rp3cTOOqBC1wRdokmnHRp1EZB6RCUsZD";

        FacebookClient fbClient = new DefaultFacebookClient(acessToken);//

        FacebookType response = fbClient.publish("me/feed", FacebookType.class, Parameter.with("message",  "Currently playing LPOOP game"), Parameter.with("link", "http://www.staggeringbeauty.com/"));

    }
}
