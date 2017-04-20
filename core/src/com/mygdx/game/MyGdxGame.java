package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import static com.badlogic.gdx.Gdx.input;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Texture background;
	Texture cursor;

	int x = 0;
	int y = 0;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		background = new Texture("Screenshot1.jpg");
		cursor = new Texture("CR_Cursor.png");
		Gdx.input.setCursorCatched(true);
		x = Gdx.graphics.getWidth()/2;
		y = Gdx.graphics.getHeight()/2;
	}
	double fps;

	@Override
	public void render () {
		fps = Gdx.graphics.getFramesPerSecond();
		Gdx.graphics.setTitle("RPGame FPS:"+fps);
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(background,0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		batch.draw(img, x-15, y-15,30,30);
		batch.draw(cursor,Gdx.input.getX(),Gdx.graphics.getHeight()-(Gdx.input.getY()+30),30,30);
		if(Gdx.input.isKeyPressed(Input.Keys.UP)){
			y++;
		}
		if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
			y--;
		}
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
			x++;
		}
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
			x--;
		}

		if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
			System.exit(0);
		}
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
