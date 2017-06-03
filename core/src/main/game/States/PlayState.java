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

import Logic.Difficulty;
import Logic.GameController;
import game.Buttons.HUD;
import game.GraphicsComponent.Character;
import main.Logic.Abilities.Ability;
import main.Logic.Abilities.Physicals.Charge;
import main.Logic.Abilities.Spells.Fireball;
import main.Logic.Map.Cell;
import main.Logic.Unit.Unit;
import main.game.InputHandler.GameHandler;

public class PlayState extends State
{
    private boolean attackMode = false;
    private boolean moveMode = false;
    Ability currAbl = null;

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

    Unit[] allies = new Unit[3];

    private ArrayList<Character> charArray = new ArrayList<Character>();
    private Character character=null;
    private Character char2 = null;
    private Character char3 = null;

    Unit[] enemies = new Unit[3];

    private ArrayList<Character> enemiesArray = new ArrayList<Character>();
    private Character enemy1 = null;
    private Character enemy2 = null;
    private Character enemy3 = null;

    GameController gameController = null;
    Unit currentChar = null;

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

        //this.character.setUnit(new Unit("Diogo - Caster",10,1,5,5,2));
        this.character.getUnit().setPosition(this.map.getCell(10,10));
        this.character.getUnit().addAbility(new Fireball(this.character.getUnit()));
        allies[0] = this.character.getUnit();
        character.update();
        charArray.add(this.character);

        this.char2 = new Character("Manuel",2);
        //char2.setUnit(new Unit("Manuel - Healer",10,1,4,8,2));
        allies[1] = this.char2.getUnit();

        this.char3 = new Character("Tiago",0);
        //char3.setUnit(new Unit("Tiago - Tank",1,10,5,15,10));
        allies[2] = this.char3.getUnit();


        this.char2.getUnit().setPosition(this.map.getCell(5,5));
        this.char2.getUnit().addAbility(new Fireball(this.char2.getUnit()));
        char2.update();
        charArray.add(this.char2);

        this.char3.getUnit().setPosition(this.map.getCell(15,15));
        this.char3.getUnit().addAbility(new Fireball(this.char3.getUnit()));
        char3.update();
        charArray.add(this.char3);

        this.enemy1 = new Character("Ogre",1);
        enemy1.getUnit().setIsAiControlled(true);
        enemies[0]=enemy1.getUnit();
        this.enemy2 = new Character("Maluco",2);
        enemy2.getUnit().setIsAiControlled(true);
        enemies[1]=enemy2.getUnit();
        this.enemy3 = new Character("Bebado",0);
        enemy3.getUnit().setIsAiControlled(true);
        enemies[2]=enemy3.getUnit();

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

        cam.update();

        gameController = new GameController(allies,enemies, Logic.Difficulty.DifficultyStage.EASY,map);
        currentChar = gameController.getCurrentChar();

        xPos = this.currentChar.getX() * Scale;
        yPos = this.currentChar.getY() * Scale;

        this.cam.position.set(this.currentChar.getX()*Scale,this.currentChar.getY()*Scale,0);
        cam.update();

        Gdx.input.setCursorCatched(false);

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
            this.currentChar.beginTurn();
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.R)){
            this.currentChar.setPosition(this.map.getCell(10,10));
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.A)){
            this.attackMode = true;
            this.moveMode = false;
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.M)){
            this.attackMode = false;
            this.moveMode = true;
            xPos = this.currentChar.getX() * Scale;
            yPos = this.currentChar.getY() * Scale;
            xCounter = 0;
            yCounter = 0;
            movements.clear();
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.R)){
            this.currentChar.setPosition(this.map.getCell(10,10));
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.E)){
            this.gameController.endTurn();
            currentChar = this.gameController.getCurrentChar();
            this.currAbl = null;

            xPos = this.currentChar.getX() * Scale;
            yPos = this.currentChar.getY() * Scale;
            this.movements.clear();

            this.attackMode = false;
            this.moveMode = false;
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.NUM_1)){
            if(this.currentChar.getAbilities().size()==0){
                currAbl = null;
                return;
            }
            currAbl = this.currentChar.getAbilities().get(0);
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.NUM_2)){
            if(this.currentChar.getAbilities().size()==1){
                currAbl = null;
                return;
            }
            currAbl = this.currentChar.getAbilities().get(1);
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.NUM_3)){
            if(this.currentChar.getAbilities().size()<=2){
                currAbl = null;
                return;
            }
            currAbl = this.currentChar.getAbilities().get(2);
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.UP)){
            //this.character.moveUp();
            movements.add("UP");

            if(yPos < this.map.height*Scale -Scale) {
                yCounter++;
                yPos+=Scale;
            }
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)){
            //this.character.moveDown();
            movements.add("DOWN");

            if(yPos > 0) {
                yCounter--;

                yPos -= Scale;
            }
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.LEFT)){
            //this.character.moveLeft();
            movements.add("LEFT");

            if(xPos > 0) {
                xCounter--;

                xPos -=Scale;
            }
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) {
            //this.character.moveRight();
            movements.add("RIGHT");

            if(xPos < this.map.width*Scale - Scale) {
                xCounter++;

                xPos += Scale;
            }
        }

        if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE))
        {
            Gdx.app.exit();
        }

        if(Gdx.input.isKeyPressed(Input.Keys.ENTER)) {
            if (moveMode) {
                Character currChar = null;

                for (int i = 0; i < this.charArray.size(); i++) {
                    if (charArray.get(i).getUnit().equals(this.currentChar)) {
                        currChar = charArray.get(i);
                        break;
                    }
                }

                if (currChar == null) {
                    return;
                }

                for (int i = 0; i < movements.size(); i++) {
                    if (movements.get(i) == "UP") {
                        currChar.moveUp();
                        batch.begin();
                        batch.draw(currChar.getSprite(), currChar.getUnit().getX() * Scale,
                                currChar.getUnit().getY() * Scale, Scale, Scale);
                        batch.end();
                        cam.update();
                    } else if (movements.get(i) == "DOWN") {
                        currChar.moveDown();
                        cam.update();
                    } else if (movements.get(i) == "LEFT") {
                        currChar.moveLeft();
                        cam.update();
                    } else if (movements.get(i) == "RIGHT") {
                        currChar.moveRight();
                        cam.update();
                    }
                    movements.remove(i);
                    i--;
                }
                xPos = this.currentChar.getX() * Scale;
                yPos = this.currentChar.getY() * Scale;
                yCounter = 0;
                xCounter = 0;
            }
            if(attackMode){
                Cell cell = this.map.getCell(xPos/Scale,yPos/Scale);
                if(currAbl!=null){
                    if(cell.getUnit()!=null) {
                        System.out.print("Attack \n");
                        this.currAbl.AffectTarget(cell.getUnit());
                    }
                }
            }
        }
        this.cam.position.set(currentChar.getX()*Scale+Scale/2,currentChar.getY()*Scale+Scale/2,0);
        cam.update();
        batch.setProjectionMatrix(cam.combined);
        return;
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

        sb.begin();

        sb.disableBlending();
        sb.draw(background,-1000,-400);
        sb.enableBlending();

        ArrayList<Cell> blocks = null;

        if(moveMode) {
            blocks = this.currentChar.getCellsThatCanMoveTo();
            for (int i = 0; i < blocks.size(); i++) {
                sb.draw(blueBlock, blocks.get(i).getxPos() * Scale, blocks.get(i).getyPos() * Scale, Scale, Scale);
            }
        }

        if(attackMode){
            if(currAbl!=null) {
                blocks = this.currAbl.getCellsThatCanHit();
                for (int i = 0; i < blocks.size(); i++) {
                    sb.draw(redBlock, blocks.get(i).getxPos() * Scale, blocks.get(i).getyPos() * Scale, Scale, Scale);
                }
            }
        }


        for(int i=0;i<this.map.height;++i){
            for(int j=0;j<this.map.width;++j){
                sb.draw(this.gridBlock,i*Scale,j*Scale,Scale,Scale);
            }
        }

        for(int i = 0; i < charArray.size() && i < enemiesArray.size(); i++)
        {
            if(!charArray.get(i).getUnit().isDead()) {
                sb.draw(charArray.get(i).getSprite(), charArray.get(i).getUnit().getX() * Scale,
                        charArray.get(i).getUnit().getY() * Scale, Scale, Scale);
                sb.draw(enemiesArray.get(i).getSprite(), enemiesArray.get(i).getUnit().getX() * Scale,
                        enemiesArray.get(i).getUnit().getY() * Scale, Scale, Scale);
            }
        }

        sb.draw(redBorder,xPos, yPos, Scale, Scale);

        font.setColor(Color.WHITE);
        for(int i = 0; i < charArray.size(); i++)
        {
            font.draw(sb, charArray.get(i).getUnit().getName(), (charArray.get(i).getUnit().getX())*Scale + 3,(charArray.get(i).getUnit().getY())*Scale + 60);
        }

        sb.end();
        //end of draw section
        Gdx.graphics.setTitle("RPGame FPS:"+fps+" Camara Zoom Value:"+cam.zoom+" Curr Char:"+this.currentChar.getName());

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