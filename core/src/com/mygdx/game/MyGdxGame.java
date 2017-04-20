package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sun.corba.se.impl.oa.poa.ActiveObjectMap;

import static com.badlogic.gdx.Gdx.input;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture background = null;


	@Override
	public void create () {
		batch = new SpriteBatch();
		background = new Texture("Screenshot1.jpg");
	}
	double fps;

	@Override
	public void render () {
		fps = Gdx.graphics.getFramesPerSecond();
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		//Start of Logic section

		if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
			Gdx.app.exit();
		}

		//End Of Logic Section
		batch.begin();
		batch.disableBlending();
		batch.draw(background,0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		batch.enableBlending();
		batch.end();
		Gdx.graphics.setTitle("RPGame FPS:"+fps);
	}

	@Override
	public void dispose () {
		batch.dispose();
		background.dispose();
	}
}
