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

import static com.badlogic.gdx.Gdx.input;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Texture background;
	Texture cursor;

	private Sprite spr;

	int x = 0;
	int y = 0;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		background = new Texture("Screenshot1.jpg");
		cursor = new Texture("CR_Cursor.png");
		spr = new Sprite(img);
		spr.setScale(0.15f);
		//Gdx.input.setCursorCatched(true);
		x = Gdx.graphics.getWidth()/2;
		y = Gdx.graphics.getHeight()/2;
		spr.setOrigin(0,0);
		spr.setX(x);
		spr.setY(y);
	}
	double fps;

	@Override
	public void render () {
		Color cor = new Color(1,0,0,1);
		fps = Gdx.graphics.getFramesPerSecond();
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.disableBlending();
		batch.draw(background,0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		batch.enableBlending();
		spr.draw(batch);
		x = (int)spr.getX();
		y = (int)spr.getY();
		batch.draw(cursor,Gdx.input.getX(),Gdx.graphics.getHeight()-(Gdx.input.getY()+30),30,30);
		if(Gdx.input.isKeyPressed(Input.Keys.UP)){
			y++;
			spr.setY(y);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
			y--;
			spr.setY(y);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
			x++;
			spr.setX(x);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
			x--;
			spr.setX(x);
		}

		if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
			Gdx.app.exit();
		}
		int cX = Gdx.input.getX();
		int cY = Gdx.graphics.getHeight()-Gdx.input.getY();
		float wd = spr.getScaleX()*spr.getWidth();
		float hg = spr.getHeight()*spr.getScaleY();

		if(cX>=x&&cX<=(x+wd)){
			if(cY>=y&&cY<=(y+hg)){
				spr.setColor(cor);
			}
		}
		batch.end();
		int b = batch.renderCalls;
		Gdx.graphics.setTitle("RPGame FPS:"+fps+" Draw Calls This Frame:"+b+" Cursor Position("+cX+","+cY+") Target Height:" + wd + " Target Width:"+hg + " Target Position("+x+","+y+") X Region ["+x+","+(x+wd)+"]"
		+ "Y Region ["+y+","+(y+hg)+"]");
	}

	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
