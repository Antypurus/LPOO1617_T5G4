package main.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import game.States.GameStateManager;
import game.States.MenuState;

public class MyGdxGame extends ApplicationAdapter {
	public static final int WIDTH  = 1280;
	public static final int HEIGHT = 720;
	private GameStateManager gsm;

	private SpriteBatch batch;

	Texture img;

	@Override
	public void create()
	{
		batch = new SpriteBatch();
		gsm = new GameStateManager();
		img = new Texture("red.png");
		gsm.push(new MenuState(gsm));
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
		img.dispose();
	}
/*
	private SpriteBatch batch = null;
	private Texture background = null;
	private Texture gridBlock = null;

	private GameHandler gameHandler = null;
	private main.game.InputHandler.MovementDelta response = null;

	private Character character=null;
	private main.Logic.Map.Map map = new main.Logic.Map.Map("test",30,30);

	private OrthographicCamera cam;

	private int Scale = 0;

	@Override
	public void create () {
		this.Scale = Gdx.graphics.getWidth()/this.map.width;

		batch = new SpriteBatch();
		background = new Texture("background.jpg");
		gridBlock = new Texture("square.png");
		character = new Character(this.batch,this);

		this.cam = new OrthographicCamera(1280,720);
		cam.update();

		this.character.getUnit().setPosition(this.map.getCell(10,10));
		character.update();
		gameHandler = new GameHandler(this);

		this.cam.position.set(this.character.getUnit().getX()*Scale,this.character.getUnit().getY()*Scale,0);
		cam.update();

		Gdx.input.setCursorCatched(true);
	}
	double fps;

	@Override
	public void render () {
		batch.setProjectionMatrix(cam.combined);
		cam.update();
		fps = Gdx.graphics.getFramesPerSecond();
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		//Start of Input Section

		//end of input section
		if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
			Gdx.app.exit();
		}
		this.response = this.gameHandler.update();
		if(response!=null){
            if(response.deltaY==1){
                this.character.moveUp();
            }

            if(response.deltaY==-1){
				this.character.moveDown();
            }

            if(response.deltaX==-1){
				this.character.moveLeft();
            }

            if(response.deltaX==1){
				this.character.moveRight();
            }

            this.cam.position.set(this.character.getUnit().getX()*Scale,this.character.getUnit().getY()*Scale,0);
            cam.update();
            batch.setProjectionMatrix(cam.combined);
		}

		//Start of Logic section

		//End Of Logic Section
		//start of draw section
		batch.begin();

		batch.disableBlending();
		batch.draw(background,-1000,-400);
		batch.enableBlending();

		for(int i=0;i<this.map.height;++i){
			for(int j=0;j<this.map.width;++j){
				batch.draw(this.gridBlock,i*Scale,j*Scale,Scale,Scale);
			}
		}

		batch.draw(this.character.getSprite(),this.character.getUnit().getX()*Scale,
				this.character.getUnit().getY()*Scale,Scale,Scale);

		batch.end();
		//end of draw section
		Gdx.graphics.setTitle("RPGame FPS:"+fps);
	}

	@Override
	public void dispose () {
		batch.dispose();
		background.dispose();
	}
	*/
}
