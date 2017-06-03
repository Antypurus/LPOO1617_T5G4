package game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

import game.Buttons.HUD;
import game.GraphicsComponent.Character;
import main.Logic.Abilities.Physicals.Charge;
import main.Logic.Abilities.Spells.Fireball;
import main.Logic.Map.Cell;
import main.game.InputHandler.GameHandler;

public class PlayState extends State
{
    private SpriteBatch batch = null;
    private Texture background = null;
    private Texture gridBlock = null;
    private Texture blueBlock = null;
    private Texture redBlock = null;
    private Texture redBorder = null;
    private ArrayList<String> movements = new ArrayList<String>();
    private main.game.InputHandler.MovementDelta response = null;
    private HUD hud;

    BitmapFont font;
    CharSequence str ;

    private int xPos = 0;
    private int yPos = 0;
    private int xCounter = 0;
    private int yCounter = 0;

    private ArrayList<Character> charArray = new ArrayList<Character>();
    private Character character=null;
    private Character char2 = null;
    private Character char3 = null;

    private ArrayList<Character> enemiesArray = new ArrayList<Character>();
    private Character enemy1 = null;
    private Character enemy2 = null;
    private Character enemy3 = null;



    private main.Logic.Map.Map map = new main.Logic.Map.Map("test",30,30);

    private OrthographicCamera cam;

    private int Scale = 0;

    public PlayState(GameStateManager gsm, int Difficulty)
    {
        super(gsm);
        this.Scale = Gdx.graphics.getWidth()/this.map.width;
        batch = new SpriteBatch();
        background = new Texture("background.jpg");
        gridBlock = new Texture("square.png");
        blueBlock = new Texture("blue3.png");
        redBlock = new Texture("red3.png");
        redBorder = new Texture("redborder.png");
        character = new Character("Diogo",1);


        font = new BitmapFont();
        str = this.character.getUnit().getName();

        this.cam = new OrthographicCamera(1280,720);
        cam.update();

        this.character.getUnit().setPosition(this.map.getCell(10,10));
        this.character.getUnit().addAbility(new Fireball(this.character.getUnit()));
        character.update();
        charArray.add(this.character);

        this.char2 = new Character("Manuel",2);
        this.char3 = new Character("Tiago",0);


        this.char2.getUnit().setPosition(this.map.getCell(5,5));
        this.char2.getUnit().addAbility(new Fireball(this.char2.getUnit()));
        char2.update();
        charArray.add(this.char2);

        this.char3.getUnit().setPosition(this.map.getCell(15,15));
        this.char3.getUnit().addAbility(new Fireball(this.char3.getUnit()));
        char3.update();
        charArray.add(this.char3);

        this.enemy1 = new Character("Ogre",1);
        this.enemy2 = new Character("Maluco",2);
        this.enemy3 = new Character("Bebado",0);

        this.enemy1.getUnit().setPosition(this.map.getCell(16,16));
        this.enemy1.getUnit().addAbility(new Fireball(this.enemy1.getUnit()));
        enemy1.update();
        enemiesArray.add(this.enemy1);

        this.enemy2.getUnit().setPosition(this.map.getCell(17,17));
        this.enemy2.getUnit().addAbility(new Fireball(this.enemy2.getUnit()));
        enemy2.update();
        enemiesArray.add(this.enemy2);

        this.enemy3.getUnit().setPosition(this.map.getCell(18,18));
        this.enemy3.getUnit().addAbility(new Fireball(this.enemy3.getUnit()));
        enemy3.update();
        enemiesArray.add(this.enemy3);


        //gameHandler = new GameHandler(this);

        xPos = this.character.getUnit().getX() * Scale;
        yPos = this.character.getUnit().getY() * Scale;

        this.cam.position.set(this.character.getUnit().getX()*Scale,this.character.getUnit().getY()*Scale,0);
        cam.update();

        Gdx.input.setCursorCatched(false);

        //char3.getUnit().takeDamage(2);
        hud = new HUD(this.batch, this.charArray, this.enemiesArray);
    }

    @Override
    protected void handleInput()
    {
        if(Gdx.input.isKeyPressed(Input.Keys.PAGE_UP)){
            this.cam.zoom-=0.02;
            if(cam.zoom<=0.15){
                cam.zoom=0.15f;
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.PAGE_DOWN)){
            this.cam.zoom+=0.02;
            if(cam.zoom>=1.7){
                cam.zoom=1.7f;
            }
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.Q)){
            this.character.getUnit().beginTurn();
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.R)){
            this.character.getUnit().setPosition(this.map.getCell(10,10));
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.UP)){
            //this.character.moveUp();
            movements.add("UP");

            if(yPos < this.map.height*Scale -Scale) {
                yCounter++;
                yPos = (this.character.getUnit().getY() + yCounter) * Scale;
            }
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)){
            //this.character.moveDown();
            movements.add("DOWN");

            if(yPos > 0) {
                yCounter--;

                yPos = (this.character.getUnit().getY() + yCounter) * Scale;
            }
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.LEFT)){
            //this.character.moveLeft();
            movements.add("LEFT");

            if(xPos > 0) {
                xCounter--;

                xPos = (this.character.getUnit().getX() + xCounter) * Scale;
            }
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) {
            //this.character.moveRight();
            movements.add("RIGHT");

            if(xPos < this.map.width*Scale - Scale) {
                xCounter++;

                xPos = (this.character.getUnit().getX() + xCounter) * Scale;
            }
        }

        if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE))
        {
            Gdx.app.exit();
        }

        if(Gdx.input.isKeyPressed(Input.Keys.ENTER))
        {

            for(int i = 0; i < movements.size(); i++)
            {
                if(movements.get(i) == "UP")
                {
                    character.moveUp();
                    batch.begin();
                    batch.draw(this.character.getSprite(),this.character.getUnit().getX()*Scale,
                            this.character.getUnit().getY()*Scale,Scale,Scale);
                    batch.end();
                    cam.update();
                }
                else if(movements.get(i) == "DOWN")
                {
                    character.moveDown();
                    cam.update();
                }

                else if(movements.get(i) == "LEFT")
                {
                    character.moveLeft();
                    cam.update();
                }

                else if(movements.get(i) == "RIGHT")
                {
                    character.moveRight();
                    cam.update();
                }
                movements.remove(i);
                i--;
            }
            xPos = this.character.getUnit().getX() * Scale;
            yPos = this.character.getUnit().getY() * Scale;
            yCounter = 0;
            xCounter = 0;
        }

       /* if(Gdx.input.justTouched())
        {
            if(Gdx.input.getX()*Scale >= (this.character.getUnit().getX() + 1)*Scale
                    && Gdx.input.getX()*Scale <= (this.character.getUnit().getX()+2)*Scale
                    && (screenHeight - Gdx.input.getY())*Scale >= (this.character.getUnit().getY())*Scale
                    && (screenHeight - Gdx.input.getY())*Scale <= (this.character.getUnit().getY() + 1)*Scale)
            {
                this.character.moveRight();
            }

        }
        */

        this.cam.position.set(this.character.getUnit().getX()*Scale+Scale/2,this.character.getUnit().getY()*Scale+Scale/2,0);
        cam.update();
        batch.setProjectionMatrix(cam.combined);
    }

    @Override
    public void update(float dt)
    {
        handleInput();
        hud.update(batch, charArray, enemiesArray);
    }

    @Override
    public void render(SpriteBatch sb)
    {
        sb = batch;
        sb.setProjectionMatrix(cam.combined);
        cam.update();
        fps = Gdx.graphics.getFramesPerSecond();
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //Start of Input Section

        //end of input section

        //this.response = this.handleInput();

      /* if(response!=null){
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
        } */

        //Start of Logic section

        //End Of Logic Section
        //start of draw section
        sb.begin();

        sb.disableBlending();
        sb.draw(background,-1000,-400);
        sb.enableBlending();

        ArrayList<Cell>blocks = this.character.getUnit().getCellsThatCanMoveTo();
        for(int i=0;i<blocks.size();i++){
            sb.draw(blueBlock,blocks.get(i).getxPos()*Scale,blocks.get(i).getyPos()*Scale,Scale,Scale);
        }

        for(int i=0;i<this.map.height;++i){
            for(int j=0;j<this.map.width;++j){
                sb.draw(this.gridBlock,i*Scale,j*Scale,Scale,Scale);
            }
        }

        for(int i = 0; i < charArray.size() && i < enemiesArray.size(); i++)
        {
            sb.draw(charArray.get(i).getSprite(),charArray.get(i).getUnit().getX()*Scale,
                    charArray.get(i).getUnit().getY()*Scale,Scale,Scale);
            sb.draw(enemiesArray.get(i).getSprite(),enemiesArray.get(i).getUnit().getX()*Scale,
                    enemiesArray.get(i).getUnit().getY()*Scale,Scale,Scale);
        }


     /*   sb.draw(blueBlock,(this.character.getUnit().getX()+1)*Scale,
                (this.character.getUnit().getY()+1)*Scale,Scale,Scale);
        sb.draw(blueBlock,(this.character.getUnit().getX()-1)*Scale,
                (this.character.getUnit().getY()+1)*Scale,Scale,Scale);
        sb.draw(blueBlock,(this.character.getUnit().getX()+1)*Scale,
                (this.character.getUnit().getY()-1)*Scale,Scale,Scale);
        sb.draw(blueBlock,(this.character.getUnit().getX()-1)*Scale,
                (this.character.getUnit().getY()-1)*Scale,Scale,Scale);
        sb.draw(blueBlock,(this.character.getUnit().getX())*Scale,
                (this.character.getUnit().getY()+1)*Scale,Scale,Scale);
        sb.draw(blueBlock,(this.character.getUnit().getX())*Scale,
                (this.character.getUnit().getY()-1)*Scale,Scale,Scale);
        sb.draw(blueBlock,(this.character.getUnit().getX()+1)*Scale,
                (this.character.getUnit().getY())*Scale,Scale,Scale);
        sb.draw(blueBlock,(this.character.getUnit().getX()-1)*Scale,
                (this.character.getUnit().getY())*Scale,Scale,Scale);
                */

        sb.draw(redBorder,xPos, yPos, Scale, Scale);

        font.setColor(Color.WHITE);
        for(int i = 0; i < charArray.size(); i++)
        {
            font.draw(sb, charArray.get(i).getUnit().getName(), (charArray.get(i).getUnit().getX())*Scale + 3,(charArray.get(i).getUnit().getY())*Scale + 60);
        }

        sb.end();
        //end of draw section
        Gdx.graphics.setTitle("RPGame FPS:"+fps+" Camara Zoom Value:"+cam.zoom);

        sb.setProjectionMatrix(hud.stage.getCamera().combined);
        hud.stage.draw();
    }

    double fps;

    @Override
    public void dispose ()
    {
        batch.dispose();
        background.dispose();
        gridBlock.dispose();
        blueBlock.dispose();
        redBlock.dispose();
        redBorder.dispose();

    }
}
///////////////////////////////////////