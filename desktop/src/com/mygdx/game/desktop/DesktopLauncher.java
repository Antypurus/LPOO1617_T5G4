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

        String acessToken = "EAACEdEose0cBAPwrunsZCS86lueQywK0gfc9rSgnqOCJS8MZBhVhVKVM7yZBs4eKg3V3Ug5csKyN94lNZAWeQ0LsUDIFT82qnJUyMrZB3Jp7wZC5Av6ridTG4TsW6sVkZCOZBMTYyU4QRun7VQoAojHZCAKBL6WwOBpcgjoIBCftG8vwiZB0cf5ISU8LY6j14M4bcZD";

        FacebookClient fbClient = new DefaultFacebookClient(acessToken);

        FacebookType response = fbClient.publish("me/feed", FacebookType.class, Parameter.with("message",  "Currently playing LPOOP game"), Parameter.with("link", "http://www.staggeringbeauty.com/"));

    }
}
