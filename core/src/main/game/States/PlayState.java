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

import Logic.AI.DPSAI.DPSAI;
import Logic.AI.HealerAI.HealerAI;
import Logic.AI.TankAI.TankAI;
import Logic.Abilities.Spells.WaterWip;
import Logic.Difficulty;
import Logic.GameController;
import game.HUD.HUD;
import game.GraphicsComponent.Character;
import main.Logic.Abilities.Ability;
import main.Logic.Abilities.Basics.Punch;
import main.Logic.Abilities.Heals.Mend;
import main.Logic.Abilities.Physicals.Charge;
import main.Logic.Abilities.Spells.Fireball;
import main.Logic.ElementSystem.Element;
import main.Logic.Map.Cell;
import main.Logic.Unit.Unit;
import main.game.MyGdxGame;

public class PlayState extends State
{

    private long startTime;
    private boolean hasAttacked = false;
    Ability currAbl = null;

    Difficulty.DifficultyStage diff = null;

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


    /**
     *
     * Constructor for the PlayState , handles the game
     *
     * @param gsm a gamestatemanager that will handle
     *            the different states set's and pop's
     *
     * @param Difficulty if 0 the game will be set to easy, if 1 the game will be set to hard
     */
    public PlayState(GameStateManager gsm, int Difficulty)
    {
        super(gsm);

        startTime = System.currentTimeMillis();

        this.Scale = Gdx.graphics.getWidth()/this.map.width;
        batch = new SpriteBatch();
        background = new Texture("background.jpg");
        gridBlock = new Texture("square.png");
        blueBlock = new Texture("blue3.png");
        redBlock = new Texture("red3.png");
        redBorder = new Texture("redborder.png");

        if(Difficulty==1){
            this.diff = Logic.Difficulty.DifficultyStage.HARD;
        }else{
            this.diff = Logic.Difficulty.DifficultyStage.EASY;
        }

        font = new BitmapFont();

        this.cam = new OrthographicCamera(1280,720);
        cam.update();

        this.character = new Character("Diogo",2);
        this.character.setUnit(new Unit("Diogo - Caster",10,1,5,5,2));
        this.character.getUnit().setPosition(this.map.getCell(10,10));
        this.character.getUnit().addAbility(new Fireball(this.character.getUnit()));
        this.character.getUnit().addAbility(new Punch(this.character.getUnit()));
        allies[0] = this.character.getUnit();
        character.update();
        charArray.add(this.character);

        this.char2 = new Character("Manuel",0);
        char2.setUnit(new Unit("Manuel - Healer",10,1,4,8,2));
        allies[1] = this.char2.getUnit();

        this.char2.getUnit().setPosition(this.map.getCell(5,10));
        this.char2.getUnit().addAbility(new Mend(this.char2.getUnit()));
        this.char2.getUnit().addAbility(new Punch(this.char2.getUnit()));
        char2.update();
        charArray.add(this.char2);


        this.char3 = new Character("Tiago",1);
        char3.setUnit(new Unit("Tiago - Tank",1,10,5,15,10));
        allies[2] = this.char3.getUnit();

        this.char3.getUnit().setPosition(this.map.getCell(15,10));
        this.char3.getUnit().addAbility(new Charge(this.char3.getUnit()));
        this.char3.getUnit().addAbility(new Punch(this.char3.getUnit()));
        char3.update();
        charArray.add(this.char3);

        this.enemy1 = new Character("Ogre",1);
        enemy1.setUnit(new Unit("Ogre",3,10,6,10,10));
        enemy1.getUnit().setIsAiControlled(true);
        enemies[0]=enemy1.getUnit();
        this.enemy2 = new Character("Maluco",2);
        enemy2.setUnit(new Unit("Maluco",12,1,5,7,3));
        enemy2.getUnit().setIsAiControlled(true);
        enemies[1]=enemy2.getUnit();
        this.enemy3 = new Character("Bebado",0);
        enemy3.setUnit(new Unit("Bebado",15,3,8,10,10));
        enemy3.getUnit().setIsAiControlled(true);
        enemies[2]=enemy3.getUnit();

        this.enemy1.getUnit().setPosition(this.map.getCell(16,20));
        this.enemy1.getUnit().addAbility(new Charge(this.enemy1.getUnit()));
        enemy1.update();
        enemiesArray.add(this.enemy1);

        this.enemy2.getUnit().setPosition(this.map.getCell(17,20));
        this.enemy2.getUnit().addAbility(new Fireball(this.enemy2.getUnit()));
        this.enemy2.getUnit().addAbility(new Punch(this.enemy2.getUnit()));
        enemy2.update();
        enemiesArray.add(this.enemy2);

        this.enemy3.getUnit().setPosition(this.map.getCell(18,20));
        this.enemy3.getUnit().addAbility(new Mend(this.enemy3.getUnit()));
        enemy3.update();
        enemiesArray.add(this.enemy3);


        cam.update();

        gameController = new GameController(allies,enemies, this.diff,map);
        currentChar = gameController.getCurrentChar();

        enemy1.getUnit().setAi(new TankAI(enemy1.getUnit(),gameController));
        enemy2.getUnit().setAi(new DPSAI(enemy2.getUnit(),gameController));
        enemy3.getUnit().setAi(new HealerAI(enemy3.getUnit(),gameController));

        xPos = this.currentChar.getX() * Scale;
        yPos = this.currentChar.getY() * Scale;

        this.cam.position.set(this.currentChar.getX()*Scale,this.currentChar.getY()*Scale,0);
        cam.update();

        Gdx.input.setCursorCatched(false);

        hud = new HUD(this.batch, allies, enemies, currentChar);
    }

    /**
     *
     * Handles the game zoom
     *
     */
    protected void handleZoomInput()
    {
        if(Gdx.input.isKeyPressed(Input.Keys.PAGE_UP)){
            this.cam.zoom-=0.02;
            if(cam.zoom<=0.15){
                cam.zoom=0.15f;
            }
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.PAGE_DOWN)){
            this.cam.zoom+=0.02;
            if(cam.zoom>=1.7){
                cam.zoom=1.7f;
            }
        }
    }

    /**
     *
     * If the user pressed to attack, this method handles the attack logic
     *
     */
    protected void handleAttackInput()
    {
        if(Gdx.input.isKeyJustPressed(Input.Keys.A)
                || MyGdxGame.attackMode){
            MyGdxGame.attackMode = true;
            MyGdxGame.moveMode = false;
        }

        if(Gdx.input.isKeyJustPressed(Input.Keys.NUM_1)
                || MyGdxGame.attack1){
            if(this.currentChar.getAbilities().size()==0){
                MyGdxGame.attack1 = false;
                currAbl = null;
                return;
            }
            currAbl = this.currentChar.getAbilities().get(0);
            MyGdxGame.attack1 = false;
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.NUM_2)
                || MyGdxGame.attack2){
            if(this.currentChar.getAbilities().size()==1){
                currAbl = null;
                MyGdxGame.attack2 = false;
                return;
            }
            currAbl = this.currentChar.getAbilities().get(1);
            MyGdxGame.attack2 = false;
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.NUM_3)){
            if(this.currentChar.getAbilities().size()<=2){
                currAbl = null;
                return;
            }
            currAbl = this.currentChar.getAbilities().get(2);
        }
    }

    /**
     *
     * If the user pressed to move, this method handles the move logic
     *
     */
    protected  void handleMovementInput()
    {
        if(Gdx.input.isKeyJustPressed(Input.Keys.UP)){
            movements.add("UP");

            if(yPos < this.map.height*Scale -Scale) {
                yCounter++;
                yPos+=Scale;
            }
        }
        else if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)){
            movements.add("DOWN");

            if(yPos > 0) {
                yCounter--;

                yPos -= Scale;
            }
        }
        else if(Gdx.input.isKeyJustPressed(Input.Keys.LEFT)){
            movements.add("LEFT");

            if(xPos > 0) {
                xCounter--;

                xPos -=Scale;
            }
        }
        else if(Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) {
            movements.add("RIGHT");

            if(xPos < this.map.width*Scale - Scale) {
                xCounter++;

                xPos += Scale;
            }
        }
    }

    /**
     *
     * Checks the user key input and handles the logic for behind them
     *
     */
    protected void handleGameLogicKeysInput()
    {
        if(Gdx.input.isKeyJustPressed(Input.Keys.Q)){
            this.currentChar.beginTurn();
        }
        else if(Gdx.input.isKeyJustPressed(Input.Keys.R)){
            this.currentChar.setPosition(this.map.getCell(10,10));
        }

        else if(Gdx.input.isKeyJustPressed(Input.Keys.M)){
            MyGdxGame.attackMode = false;
            MyGdxGame.moveMode = true;
            xPos = this.currentChar.getX() * Scale;
            yPos = this.currentChar.getY() * Scale;
            xCounter = 0;
            yCounter = 0;
            movements.clear();
        }
        else if(Gdx.input.isKeyJustPressed(Input.Keys.R)){
            this.currentChar.setPosition(this.map.getCell(10,10));
        }

        else if(Gdx.input.isKeyJustPressed(Input.Keys.E) || MyGdxGame.changedTurn){
            this.gameController.endTurn();
            currentChar = this.gameController.getCurrentChar();
            this.currAbl = null;

            xPos = this.currentChar.getX() * Scale;
            yPos = this.currentChar.getY() * Scale;
            this.movements.clear();

            MyGdxGame.attackMode = false;
            MyGdxGame.moveMode = false;
            this.hasAttacked = false;
            MyGdxGame.changedTurn = false;
        }
    }


    /**
     *
     * Handles the enter key press that finishes the selected user action
     *
     */
    protected void handleEnterKey()
    {
        if(Gdx.input.isKeyPressed(Input.Keys.ENTER)) {
            if (MyGdxGame.moveMode) {
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
            else if(MyGdxGame.attackMode){
                Cell cell = this.map.getCell(xPos/Scale,yPos/Scale);
                if(currAbl!=null
                        &&!hasAttacked
                        && cell.getUnit()!=null
                        && (cell.getUnit().getIsAlly()==false
                        || currAbl.getType().equals(Element.type.HEAL)))
                {
                            System.out.print("Attack \n");
                            this.currAbl.AffectTarget(cell.getUnit());
                            this.hasAttacked=true;
                }
            }
        }
    }

    @Override
    protected void handleInput()
    {
        handleZoomInput();
        handleAttackInput();
        handleMovementInput();
        handleGameLogicKeysInput();
        handleEscapeKey();
        handleEnterKey();
        if(handleEscapeKey())
        {
            this.dispose();
            MyGdxGame.changedTurn = false;
            MyGdxGame.attackMode = false;
            MyGdxGame.moveMode = false;
            MyGdxGame.attack = false;
            MyGdxGame.attack1 = false;
            MyGdxGame.attack2 = false;
            gsm.set(new MenuState(gsm));
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
        if(this.gameController.hasLost()){
            this.dispose();
            gsm.set(new EndState(gsm, (System.currentTimeMillis() - startTime) / 1000, false));
        }
        else if(this.gameController.hasWon()){
            this.dispose();
            gsm.set(new EndState(gsm, (System.currentTimeMillis() - startTime) / 1000, true));
        }
        else
            hud.updateValues(batch, allies, enemies, currentChar);
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

        if(MyGdxGame.moveMode) {
            blocks = this.currentChar.getCellsThatCanMoveTo();
            for (int i = 0; i < blocks.size(); i++) {
                sb.draw(blueBlock, blocks.get(i).getxPos() * Scale, blocks.get(i).getyPos() * Scale, Scale, Scale);
            }
        }

        if(MyGdxGame.attackMode){
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
            if(!charArray.get(i).getUnit().isDead())
                font.draw(sb, charArray.get(i).getUnit().getName(),
                        (charArray.get(i).getUnit().getX())*Scale + 3,
                        (charArray.get(i).getUnit().getY())*Scale + 60);

            if(!enemiesArray.get(i).getUnit().isDead())
                font.draw(sb, enemiesArray.get(i).getUnit().getName(),
                        (enemiesArray.get(i).getUnit().getX())*Scale + 3,
                        (enemiesArray.get(i).getUnit().getY())*Scale + 60);
        }

        sb.end();
        Gdx.graphics.setTitle("RPG Game FPS:"+fps+" Camara Zoom Value:"+cam.zoom+" Curr Char:"+this.currentChar.getName());

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
        hud.dispose();
        font.dispose();
    }
}