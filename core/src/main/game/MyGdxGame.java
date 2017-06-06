package main.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import game.States.GameStateManager;
import game.States.MenuState;

public class MyGdxGame extends ApplicationAdapter {
	public static final int WIDTH  = 1280;
	public static final int HEIGHT = 720;
	public static boolean changedTurn = false;
	public static boolean attackMode = false;
	public static boolean moveMode = false;
	public static boolean attack = false;
	public static boolean attack1 = false;
	public static boolean attack2 = false;

	private GameStateManager gsm;
	private SpriteBatch batch;
	public static AssetManager manager;


	@Override
	public void create()
	{
		batch = new SpriteBatch();
		gsm = new GameStateManager();
		gsm.push(new MenuState(gsm));
		manager = new AssetManager();
		manager.load("Audio/audio.mp3", Music.class);
		manager.finishLoading();
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1,0,0,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(batch);
	}

	@Override
	public void dispose()
	{
		batch.dispose();
	}
}