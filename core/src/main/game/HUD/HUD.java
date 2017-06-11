package game.HUD;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.ArrayList;

import game.GraphicsComponent.Character;
import main.Logic.Unit.Unit;
import main.game.MyGdxGame;


public class HUD
{
    public Stage stage;
    private Viewport viewport;
    private Music music;
    private boolean isPlaying = true;
    private Character character = null;

    private Texture xText;
    private TextureRegion xTextureRegion;
    private TextureRegionDrawable xRegionDrawable;
    private ImageButton stopRound;

    private Texture Number1Text;
    private TextureRegion Number1TextureRegion;
    private TextureRegionDrawable Number1RegionDrawable;
    private ImageButton Number1;

    private Texture Number2Text;
    private TextureRegion Number2TextureRegion;
    private TextureRegionDrawable Number2RegionDrawable;
    private ImageButton Number2;

    private Texture AText;
    private TextureRegion ATextureRegion;
    private TextureRegionDrawable ARegionDrawable;
    private ImageButton LetterA;

    private Texture MText;
    private TextureRegion MTextureRegion;
    private TextureRegionDrawable MRegionDrawable;
    private ImageButton LetterM;

    private Texture EText;
    private TextureRegion ETextureRegion;
    private TextureRegionDrawable ERegionDrawable;
    private ImageButton LetterE;

    private Texture mText;
    private TextureRegion mTextureRegion;
    private TextureRegionDrawable mRegionDrawable;
    private ImageButton moveStart;

    private Texture attackText;
    private TextureRegion attackTextureRegion;
    private TextureRegionDrawable attackRegionDrawable;
    private ImageButton attack;

    private Texture attack1Text;
    private TextureRegion attack1TextureRegion;
    private TextureRegionDrawable attack1RegionDrawable;
    private ImageButton attack1;

    private Texture attack2Text;
    private TextureRegion attack2TextureRegion;
    private TextureRegionDrawable attack2RegionDrawable;
    private ImageButton attack2;

    TextButton button;
    TextButton.TextButtonStyle textButtonStyle;
    BitmapFont font;
    Skin skin;
    TextureAtlas buttonAtlas;

    private Texture emptyBar;
    private TextureRegion emptyBarTextureRegion;
    private TextureRegionDrawable emptyBarRegionDrawable;
    private ImageButton templateBar, templateBar2, templateBar3, templateBar4,
            templateBar5, templateBar6;
    private ImageButton enemytemplateBar, enemytemplateBar2, enemytemplateBar3,
            enemytemplateBar4, enemytemplateBar5, enemytemplateBar6;

    TextButton.TextButtonStyle textButtonStyle2;
    BitmapFont font2;
    Skin skin2;
    TextureAtlas buttonAtlas2;

    TextButton red, red2,red3, blue, blue2, blue3;
    TextButton enemyRed, enemyRed2, enemyRed3, enemyBlue, enemyBlue2, enemyBlue3;
    TextButton.TextButtonStyle redstyle, bluestyle;
    BitmapFont redfont;
    Skin redskin;
    TextureAtlas redatlas;


    TextButton name1,name2,name3;
    TextButton enemyName1, enemyName2, enemyName3;


    TextButton healthNumbers1, healthNumbers2, healthNumbers3;
    TextButton manaNumbers1, manaNumbers2, manaNumbers3;
    TextButton.TextButtonStyle healthstyle;
    BitmapFont healthfont;
    Skin healthskin;

    private Double health;
    private Double healthMax;
    private Double mana;
    private Double manaMax;

    private Double health2;
    private Double healthMax2;
    private Double mana2;
    private Double manaMax2;

    private Double health3;
    private Double healthMax3;
    private Double mana3;
    private Double manaMax3;

    private Double enemyHealth;
    private Double enemyHealthMax;
    private Double enemyMana;
    private Double enemyManaMax;

    private Double enemyHealth2;
    private Double enemyHealthMax2;
    private Double enemyMana2;
    private Double enemyManaMax2;

    private Double enemyHealth3;
    private Double enemyHealthMax3;
    private Double enemyMana3;
    private Double enemyManaMax3;

    private TextButton enemyHealthNumbers, enemyHealthNumbers2, enemyHealthNumbers3;
    private TextButton enemyManaNumbers, enemyManaNumbers2, enemyManaNumbers3;


    /**
     *
     * Constructor for the HUD , handles the user Hud
     *
     * @param sb spritebatch containing the sprites to be drawn
     * @param allies array containing the allies units
     * @param enemies array containing the enemies units
     * @param current current char controlled by the player
     */
    public HUD(SpriteBatch sb, Unit[] allies, Unit[] enemies, Unit current)
    {
        MusicGetter();
        StartMovementUI();
        StartAttackUI();
        FinishRoundUI();
        SettingTemplateBars();
        getNames(allies, enemies);
        getMaxHealthMana(allies, enemies);
        RedHealthBars();
        BlueManaBars();
        SoundImages();
        viewport = new FitViewport(MyGdxGame.WIDTH, MyGdxGame.HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport,sb);
        Gdx.input.setInputProcessor(stage);
        healthButtonStyle();
        MusicButtonListener();
        RoundsButtonsListeners();

    }

    /**
     *
     * Gets the music to be played in the game
     *
     */
    public void MusicGetter()
    {
        music = MyGdxGame.manager.get("Audio/audio.mp3", Music.class);
        music.setLooping(true);
        if(this.isPlaying) {
            music.play();
            isPlaying = true;
        }else{
            music.pause();
            isPlaying = false;
        }
    }


    /**
     *
     * Images related to the player movement
     *
     */
    public void StartMovementUI()
    {
        mText = new Texture("RoundsImages/Movement.png");
        mTextureRegion = new TextureRegion(mText);
        mRegionDrawable = new TextureRegionDrawable(mTextureRegion);
        moveStart = new ImageButton(mRegionDrawable);

        MText = new Texture("RoundsImages/M.png");
        MTextureRegion = new TextureRegion(MText);
        MRegionDrawable = new TextureRegionDrawable(MTextureRegion);
        LetterM = new ImageButton(MRegionDrawable);
    }

    /**
     *
     * Images related to the player attack
     *
     */
    public void AttackAbilitiesUI()
    {
        Number1Text = new Texture("RoundsImages/1.png");
        Number1TextureRegion = new TextureRegion(Number1Text);
        Number1RegionDrawable = new TextureRegionDrawable(Number1TextureRegion);
        Number1 = new ImageButton(Number1RegionDrawable);

        Number2Text = new Texture("RoundsImages/2.png");
        Number2TextureRegion = new TextureRegion(Number2Text);
        Number2RegionDrawable = new TextureRegionDrawable(Number2TextureRegion);
        Number2 = new ImageButton(Number2RegionDrawable);
    }

    /**
     *
     * Images related to the player attack habilities
     *
     */
    public void StartAttackUI()
    {
        AText = new Texture("RoundsImages/A.png");
        ATextureRegion = new TextureRegion(AText);
        ARegionDrawable = new TextureRegionDrawable(ATextureRegion);
        LetterA = new ImageButton(ARegionDrawable);

        attackText = new Texture("RoundsImages/Attack.png");
        attackTextureRegion = new TextureRegion(attackText);
        attackRegionDrawable = new TextureRegionDrawable(attackTextureRegion);
        attack = new ImageButton(attackRegionDrawable);
        AttackAbilitiesUI();
    }

    /**
     *
     * Images related to finishing the round
     *
     */
    public void FinishRoundUI()
    {
        xText = new Texture("RoundsImages/x_orange.png");
        xTextureRegion = new TextureRegion(xText);
        xRegionDrawable = new TextureRegionDrawable(xTextureRegion);
        stopRound = new ImageButton(xRegionDrawable);

        EText = new Texture("RoundsImages/E.png");
        ETextureRegion = new TextureRegion(EText);
        ERegionDrawable = new TextureRegionDrawable(ETextureRegion);
        LetterE = new ImageButton(ERegionDrawable);
    }

    /**
     *
     * Sets the bars that will be drawn below every game's information
     *
     */
    public void SettingTemplateBars()
    {
        emptyBar = new Texture("Bars/EmptyBar.png");
        emptyBarTextureRegion = new TextureRegion(emptyBar);
        emptyBarRegionDrawable = new TextureRegionDrawable(emptyBarTextureRegion);
        templateBar = new ImageButton(emptyBarRegionDrawable);
        templateBar2 = new ImageButton(emptyBarRegionDrawable);
        templateBar3 = new ImageButton(emptyBarRegionDrawable);
        templateBar4 = new ImageButton(emptyBarRegionDrawable);
        templateBar5 = new ImageButton(emptyBarRegionDrawable);
        templateBar6 = new ImageButton(emptyBarRegionDrawable);
        enemytemplateBar = new ImageButton(emptyBarRegionDrawable);
        enemytemplateBar2 = new ImageButton(emptyBarRegionDrawable);
        enemytemplateBar3 = new ImageButton(emptyBarRegionDrawable);
        enemytemplateBar4 = new ImageButton(emptyBarRegionDrawable);
        enemytemplateBar5 = new ImageButton(emptyBarRegionDrawable);
        enemytemplateBar6 = new ImageButton(emptyBarRegionDrawable);
    }

    /**
     *
     * Buttons that will contain the characters names
     *
     */
    public void getNamesButtonStyle()
    {
        font2 = new BitmapFont();
        skin2 = new Skin();
        buttonAtlas2 = new TextureAtlas("Bars/Bars.pack");
        skin2.addRegions(buttonAtlas2);
        textButtonStyle2 = new TextButton.TextButtonStyle();
        textButtonStyle2.font = font2;
        textButtonStyle2.up = skin2.getDrawable("EmptyBar");
    }

    /**
     *
     * Get's the chars names
     *
     */
    public void getNames(Unit[] allies, Unit[] enemies)
    {
        getNamesButtonStyle();
        name1 = new TextButton(allies[0].getName(), textButtonStyle2);
        name2 = new TextButton(allies[1].getName(), textButtonStyle2);
        name3 = new TextButton(allies[2].getName(), textButtonStyle2);

        enemyName1 = new TextButton(enemies[0].getName(), textButtonStyle2);
        enemyName2 = new TextButton(enemies[1].getName(), textButtonStyle2);
        enemyName3  = new TextButton(enemies[2].getName(), textButtonStyle2);
    }

    /**
     *
     * Get's the chars max health and Mana
     *
     */
    public void getMaxHealthMana(Unit[] allies, Unit[] enemies)
    {
        healthMax = allies[0].getHP();
        manaMax = allies[0].getMANA().EffectiveValue;

        healthMax2 = allies[1].getHP();
        manaMax2 = allies[1].getMANA().EffectiveValue;

        healthMax3 = allies[2].getHP();
        manaMax3 = allies[2].getMANA().EffectiveValue;

        enemyHealthMax = enemies[0].getHP();
        enemyManaMax = enemies[0].getMANA().EffectiveValue;

        enemyHealthMax2 = enemies[1].getHP();
        enemyManaMax2 = enemies[1].getMANA().EffectiveValue;

        enemyHealthMax3 = enemies[2].getHP();
        enemyManaMax3 = enemies[2].getMANA().EffectiveValue;
    }

    /**
     *
     * Get's the chars red bars representing health
     *
     */
    public void RedHealthBars()
    {
        redfont = new BitmapFont();
        redskin = new Skin();
        redatlas = new TextureAtlas("Bars/Bars.pack");
        redskin.addRegions(redatlas);
        redstyle = new TextButton.TextButtonStyle();
        redstyle.font = redfont;
        redstyle.up = redskin.getDrawable("RedColor");
        red = new TextButton("", redstyle);
        red2 = new TextButton("", redstyle);
        red3 = new TextButton("", redstyle);
        enemyRed = new TextButton("", redstyle);
        enemyRed2 = new TextButton("", redstyle);
        enemyRed3 = new TextButton("", redstyle);
    }

    /**
     *
     * Get's the chars blue bars representing mana
     *
     */
    public void BlueManaBars()
    {
        bluestyle = new TextButton.TextButtonStyle();
        bluestyle.font = redfont;
        bluestyle.up = redskin.getDrawable("BlueColor");
        blue = new TextButton("", bluestyle);
        blue2 = new TextButton("", bluestyle);
        blue3 = new TextButton("", bluestyle);
        enemyBlue = new TextButton("", bluestyle);
        enemyBlue2 = new TextButton("", bluestyle);
        enemyBlue3 = new TextButton("", bluestyle);
    }

    /**
     *
     * Sets the sound off and on images, and checks if the user pressed them to change image
     *
     */
    public void SoundImages()
    {
        font = new BitmapFont();
        skin = new Skin();
        buttonAtlas = new TextureAtlas("Audio/Audio.pack");
        skin.addRegions(buttonAtlas);
        textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = font;
        textButtonStyle.up = skin.getDrawable("SoundOn");
        textButtonStyle.checked = skin.getDrawable("SoundOff");
        button = new TextButton("", textButtonStyle);
    }

    /**
     *
     * If the user pressed the sound image the game will start the music, or stop
     *
     */
    public void MusicButtonListener()
    {
        button.addListener(new InputListener()
        {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int buttonx) {
                if(isPlaying)
                {
                    music.pause();
                    button.getStyle().up = skin.getDrawable("SoundOff");
                    isPlaying = false;
                }
                else
                {
                    music.play();
                    button.getStyle().up = skin.getDrawable("SoundOn");
                    isPlaying = true;
                }
                return true;
            }
        });
    }

    /**
     *
     * Font Button that will contain the chars health points and mana points
     *
     */
    public void healthButtonStyle()
    {
        healthfont = new BitmapFont();
        healthskin = new Skin();
        healthstyle = new TextButton.TextButtonStyle();
        healthstyle.font = healthfont;
    }

    /**
     *
     * checks which ui button the user pressed and changes the game logic accordingly
     *
     */
    public void RoundsButtonsListeners()
    {
        stopRound.addListener(new InputListener()
        {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int buttonx) {
                MyGdxGame.changedTurn = true;
                return true;
            }
        });

        moveStart.addListener(new InputListener()
        {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int buttonx) {
                MyGdxGame.attackMode = false;
                MyGdxGame.moveMode = true;
                return true;
            }
        });

        attack.addListener(new InputListener()
        {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int buttonx) {
                MyGdxGame.moveMode = false;
                MyGdxGame.attackMode = true;
                return true;
            }
        });
    }

    /**
     *
     * Calls the methods above to update all the ui elements
     *
     * @param sb spritebatch containing the sprites to be drawn
     * @param allies array containing the allies units
     * @param enemies array containing the enemies units
     * @param current current char controlled by the player
     */
    public void updateValues(SpriteBatch sb, Unit[] allies, Unit[] enemies, Unit current)
    {
        updateHealth(allies,enemies);
        updateMana(allies, enemies);
        setManaValuePositions();
        setEnemiesManaImage();
        viewport = new FitViewport(MyGdxGame.WIDTH, MyGdxGame.HEIGHT, new OrthographicCamera());

        stage.clear();
        stage.addActor(button);
        addAlliesToStage();
        addEnemiesToStage();
        addVisibleUIelements();
        addVisibleUIelementsControlls();
        addAttackUIelements(current);

    }

    /**
     *
     * Update's the chars health points
     *
     * @param allies array containing the allies units
     * @param enemies array containing the enemies units
     */
    public void updateHealth(Unit[] allies, Unit[] enemies)
    {
        health = allies[0].getHP();
        health2 = allies[1].getHP();
        health3 = allies[2].getHP();
        enemyHealth = enemies[0].getHP();
        enemyHealth2 = enemies[1].getHP();
        enemyHealth3 = enemies[2].getHP();
    }

    /**
     *
     * Update's the buttons containing the chars health points
     *
     */
    public void updateHealthNumbers()
    {
        healthNumbers1 = new TextButton(health.toString() + "/ "  + healthMax , healthstyle);
        healthNumbers2 = new TextButton(health2.toString() + "/ "  + healthMax2, healthstyle);
        healthNumbers3 = new TextButton(health3.toString() + "/ "  + healthMax3, healthstyle);
        enemyHealthNumbers = new TextButton(enemyHealth.toString() + "/ " + enemyHealthMax, healthstyle);
        enemyHealthNumbers2 = new TextButton(enemyHealth2.toString() + "/ " + enemyHealthMax2, healthstyle);
        enemyHealthNumbers3 = new TextButton(enemyHealth3.toString() + "/ " + enemyHealthMax3, healthstyle);
    }

    /**
     *
     * Update's the chars mana points
     *
     * @param allies array containing the allies units
     * @param enemies array containing the enemies units
     */
    public void updateMana(Unit[] allies, Unit[] enemies)
    {
        mana = allies[0].getMANA().EffectiveValue;
        mana2 = allies[1].getMANA().EffectiveValue;
        mana3 = allies[2].getMANA().EffectiveValue;
        enemyMana = enemies[0].getMANA().EffectiveValue;
        enemyMana2 = enemies[1].getMANA().EffectiveValue;
        enemyMana3 = enemies[2].getMANA().EffectiveValue;
    }

    /**
     *
     * Update's the buttons containing the chars mana points
     *
     */
    public void updateManaNumbers()
    {
        updateHealthNumbers();
        manaNumbers1 = new TextButton(mana.toString() + " / " + manaMax, healthstyle);
        manaNumbers2 = new TextButton(mana2.toString()+ " / " + manaMax2, healthstyle);
        manaNumbers3 = new TextButton(mana3.toString() + " / " + manaMax3, healthstyle);
        enemyManaNumbers = new TextButton(enemyMana.toString() + " / " + enemyManaMax, healthstyle);
        enemyManaNumbers2 = new TextButton(enemyMana2.toString() + " / " + enemyManaMax2, healthstyle);
        enemyManaNumbers3 = new TextButton(enemyMana3.toString()+ " / " + enemyManaMax3, healthstyle);
    }

    /**
     *
     * Set's on screen the allies information
     *
     */
    public void setAlliesUiPosition()
    {
        updateManaNumbers();
        name1.setPosition(0,600);
        templateBar.setPosition(0,570);
        templateBar2.setPosition(0,540);
        name2.setPosition(0,450);
        templateBar3.setPosition(0,420);
        templateBar4.setPosition(0,390);
        name3.setPosition(0,300);
        templateBar5.setPosition(0,270);
        templateBar6.setPosition(0,240);
    }

    /**
     *
     * Set's on screen the allies health bars
     *
     */
    public void setAlliesHealthImage()
    {
        setAlliesUiPosition();
        red.setPosition(10,573);
        red2.setPosition(10,423);
        red3.setPosition(10,273);

        red.setTransform(true);
        red.setScaleX(health.floatValue()/healthMax.floatValue());
        red2.setTransform(true);
        red2.setScaleX(health2.floatValue()/healthMax2.floatValue());
        red3.setTransform(true);
        red3.setScaleX(health3.floatValue()/healthMax3.floatValue());
    }

    /**
     *
     * Set's on screen the allies mana bars
     *
     */
    public void setAlliesManaImage()
    {
        setAlliesHealthImage();
        blue.setPosition(10,543);
        blue2.setPosition(10,393);
        blue3.setPosition(10,243);

        blue.setTransform(true);
        blue.setScaleX(mana.floatValue()/manaMax.floatValue());
        blue2.setTransform(true);
        blue2.setScaleX(mana2.floatValue()/manaMax2.floatValue());
        blue3.setTransform(true);
        blue3.setScaleX(mana3.floatValue()/manaMax3.floatValue());
    }

    /**
     *
     * Set's on screen the chars health values
     *
     */
    public void setHealthValuePositions()
    {
        setAlliesManaImage();
        healthNumbers1.setPosition(105,573);
        healthNumbers2.setPosition(105,423);
        healthNumbers3.setPosition(105,273);
        enemyHealthNumbers.setPosition(105 + 1025,573);
        enemyHealthNumbers2.setPosition(105 + 1025,423);
        enemyHealthNumbers3.setPosition(105 + 1025,273);
    }

    /**
     *
     * Set's on screen the chars mana values
     *
     */
    public void setManaValuePositions()
    {
        setHealthValuePositions();
        manaNumbers1.setPosition(105,543);
        manaNumbers2.setPosition(105,393);
        manaNumbers3.setPosition(105,243);

        enemyManaNumbers.setPosition(105 + 1025,543);
        enemyManaNumbers2.setPosition(105 + 1025,393);
        enemyManaNumbers3.setPosition(105 + 1025,243);
    }

    /**
     *
     * Set's on screen the enemies informations
     *
     */
    public void setEnemiesUiPosition()
    {
        enemyName1.setPosition(1025,600);
        enemytemplateBar.setPosition(1025,570);
        enemytemplateBar2.setPosition(1025,540);

        enemyName2.setPosition(1025,450);
        enemytemplateBar3.setPosition(1025,420);
        enemytemplateBar4.setPosition(1025,390);

        enemyName3.setPosition(1025,300);
        enemytemplateBar5.setPosition(1025,270);
        enemytemplateBar6.setPosition(1025,240);
    }

    /**
     *
     * Set's on screen the enemies health values
     *
     */
    public void setEnemiesHealthImage()
    {
        setEnemiesUiPosition();
        enemyRed.setPosition(1035, 573);
        enemyRed2.setPosition(1035, 423);
        enemyRed3.setPosition(1035, 273);

        enemyRed.setTransform(true);
        enemyRed.setScaleX(enemyHealth.floatValue() / enemyHealthMax.floatValue());
        enemyRed2.setTransform(true);
        enemyRed2.setScaleX(enemyHealth2.floatValue() / enemyHealthMax2.floatValue());
        enemyRed3.setTransform(true);
        enemyRed3.setScaleX(enemyHealth3.floatValue() / enemyHealthMax3.floatValue());
    }

    /**
     *
     * Set's on screen the enemies mana values
     *
     */
    public void setEnemiesManaImage()
    {
        setEnemiesHealthImage();
        enemyBlue.setPosition(1035, 543);
        enemyBlue2.setPosition(1035,393);
        enemyBlue3.setPosition(1035,243);

        enemyBlue.setTransform(true);
        enemyBlue.setScaleX(enemyMana.floatValue()/enemyManaMax.floatValue());
        enemyBlue2.setTransform(true);
        enemyBlue2.setScaleX(enemyMana2.floatValue()/enemyManaMax2.floatValue());
        enemyBlue3.setTransform(true);
        enemyBlue3.setScaleX(enemyMana3.floatValue()/enemyManaMax3.floatValue());
    }

    /**
     *
     * Add's the allies to the stage
     *
     */
    public void addAlliesToStage()
    {
        stage.addActor(templateBar);
        stage.addActor(templateBar2);
        stage.addActor(templateBar3);
        stage.addActor(templateBar4);
        stage.addActor(templateBar5);
        stage.addActor(templateBar6);
        stage.addActor(red);
        stage.addActor(red2);
        stage.addActor(red3);
        stage.addActor(blue);
        stage.addActor(blue2);
        stage.addActor(blue3);
        stage.addActor(healthNumbers1);
        stage.addActor(healthNumbers2);
        stage.addActor(healthNumbers3);
        stage.addActor(manaNumbers1);
        stage.addActor(manaNumbers2);
        stage.addActor(manaNumbers3);
        stage.addActor(name1);
        stage.addActor(name2);
        stage.addActor(name3);
    }

    /**
     *
     * Add's the enemies to the stage
     *
     */
    public void addEnemiesToStage()
    {
        stage.addActor(enemytemplateBar);
        stage.addActor(enemytemplateBar2);
        stage.addActor(enemytemplateBar3);
        stage.addActor(enemytemplateBar4);
        stage.addActor(enemytemplateBar5);
        stage.addActor(enemytemplateBar6);
        stage.addActor(enemyRed);
        stage.addActor(enemyRed2);
        stage.addActor(enemyRed3);
        stage.addActor(enemyBlue);
        stage.addActor(enemyBlue2);
        stage.addActor(enemyBlue3);
        stage.addActor(enemyHealthNumbers);
        stage.addActor(enemyHealthNumbers2);
        stage.addActor(enemyHealthNumbers3);
        stage.addActor(enemyManaNumbers);
        stage.addActor(enemyManaNumbers2);
        stage.addActor(enemyManaNumbers3);
        stage.addActor(enemyName1);
        stage.addActor(enemyName2);
        stage.addActor(enemyName3);
    }

    /**
     *
     * Add's the always visible ui elements to the stage
     *
     */
    public void addVisibleUIelements()
    {
        stopRound.setPosition(0, 150);
        stage.addActor(stopRound);
        moveStart.setPosition(40, 150);
        stage.addActor(moveStart);
        attack.setPosition(80, 150);
        stage.addActor(attack);
    }

    /**
     *
     * Add's the always visible ui elements keys to the stage
     *
     */
    public void addVisibleUIelementsControlls()
    {
        addVisibleUIelements();
        LetterM.setPosition(moveStart.getX() + 8, moveStart.getY() - 15);
        stage.addActor(LetterM);

        LetterA.setPosition(attack.getX() + 8, attack.getY() - 15);
        stage.addActor(LetterA);

        LetterE.setPosition(stopRound.getX() + 8, stopRound.getY() - 15);
        stage.addActor(LetterE);
    }

    /**
     *
     * Sets the first hability image to the char's first hability
     *
     */
    public void attack1GetImage(Unit current)
    {
        attack1Text = new Texture("RoundsImages/" + current.getAbilities().get(0).getName() +".png");
        attack1TextureRegion = new TextureRegion(attack1Text);
        attack1RegionDrawable = new TextureRegionDrawable(attack1TextureRegion);
        attack1 = new ImageButton(attack1RegionDrawable);
    }

    /**
     *
     * Sets the second hability image to the char's second hability
     *
     */
    public void attack2GetImage(Unit current)
    {
        attack2Text = new Texture("RoundsImages/" + current.getAbilities().get(1).getName() + ".png");
        attack2TextureRegion = new TextureRegion(attack2Text);
        attack2RegionDrawable = new TextureRegionDrawable(attack2TextureRegion);
        attack2 = new ImageButton(attack2RegionDrawable);
    }

    /**
     *
     * Add's the habilities keys to the stage
     *
     */
    public void addAttackUIelements(Unit current)
    {
        if(MyGdxGame.attackMode) {
            attack1GetImage(current);
            attack1.setPosition(120, 150);
            stage.addActor(attack1);
            Number1.setPosition(attack1.getX()+8, attack1.getY()-15);
            stage.addActor(Number1);

            attack2GetImage(current);
            attack2.setPosition(160, 150);
            stage.addActor(attack2);
            Number2.setPosition(attack2.getX()+8, attack2.getY()-15);
            stage.addActor(Number2);
            attackListeners();
        }
    }

    /**
     *
     * Checks which hability the user chose for the attack
     *
     */
    public void attackListeners()
    {
        attack1.addListener(new InputListener()
        {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int buttonx) {
                MyGdxGame.attack1 = true;
                return true;
            }
        });

        attack2.addListener(new InputListener()
        {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int buttonx) {
                MyGdxGame.attack2 = true;
                return true;
            }
        });

    }

    /**
     *
     * Deletes all textures from memory
     *
     */
    public void disposeTextures()
    {
        if(xText!=null)
        xText.dispose();
        if(AText!=null)
        AText.dispose();
        if(MText!=null)
        MText.dispose();
        if(EText!=null)
        EText.dispose();
        if(mText!=null)
        mText.dispose();
        if(attackText!=null)
        attackText.dispose();
        if(attack1Text!=null)
        attack1Text.dispose();
        if(attack2Text!=null)
        attack2Text.dispose();
    }

    /**
     *
     * Deletes all text buttons from memory
     *
     */
    public void disposeTextButtonsResources()
    {
        if(font!=null)
        font.dispose();
        if(skin!=null)
        skin.dispose();
        if(buttonAtlas!=null)
        buttonAtlas.dispose();
        if(font2!=null)
        font2.dispose();
        if(skin2!=null)
        skin2.dispose();
        if(buttonAtlas2!=null)
        buttonAtlas2.dispose();
        if(redfont!=null)
        redfont.dispose();
        if(redskin!=null)
        redskin.dispose();
        if(redatlas!=null)
        redatlas.dispose();
        if(healthfont!=null)
        healthfont.dispose();
        if(healthskin!=null)
        healthskin.dispose();
    }

    /**
     *
     * calls the methods to dispose the elements and also dispose's the stage and music
     *
     */
    public void dispose()
    {
        music.dispose();
        stage.dispose();
        disposeTextures();
        disposeTextButtonsResources();
    }
}
