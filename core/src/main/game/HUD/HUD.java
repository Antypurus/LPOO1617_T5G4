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

    TextButton.TextButtonStyle textButtonStyle3;
    BitmapFont font3;
    Skin skin3;
    TextureAtlas buttonAtlas3;

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

    public HUD(SpriteBatch sb, Unit[] allies, Unit[] enemies, Unit current)
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

        mText = new Texture("RoundsImages/Movement.png");
        mTextureRegion = new TextureRegion(mText);
        mRegionDrawable = new TextureRegionDrawable(mTextureRegion);
        moveStart = new ImageButton(mRegionDrawable);

        MText = new Texture("RoundsImages/M.png");
        MTextureRegion = new TextureRegion(MText);
        MRegionDrawable = new TextureRegionDrawable(MTextureRegion);
        LetterM = new ImageButton(MRegionDrawable);

        EText = new Texture("RoundsImages/E.png");
        ETextureRegion = new TextureRegion(EText);
        ERegionDrawable = new TextureRegionDrawable(ETextureRegion);
        LetterE = new ImageButton(ERegionDrawable);

        AText = new Texture("RoundsImages/A.png");
        ATextureRegion = new TextureRegion(AText);
        ARegionDrawable = new TextureRegionDrawable(ATextureRegion);
        LetterA = new ImageButton(ARegionDrawable);

        xText = new Texture("RoundsImages/x_orange.png");
        xTextureRegion = new TextureRegion(xText);
        xRegionDrawable = new TextureRegionDrawable(xTextureRegion);
        stopRound = new ImageButton(xRegionDrawable);

        attackText = new Texture("RoundsImages/Attack.png");
        attackTextureRegion = new TextureRegion(attackText);
        attackRegionDrawable = new TextureRegionDrawable(attackTextureRegion);
        attack = new ImageButton(attackRegionDrawable);

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

        font2 = new BitmapFont();
        skin2 = new Skin();
        buttonAtlas2 = new TextureAtlas("Bars/Bars.pack");
        skin2.addRegions(buttonAtlas2);
        textButtonStyle2 = new TextButton.TextButtonStyle();
        textButtonStyle2.font = font2;
        textButtonStyle2.up = skin2.getDrawable("EmptyBar");

        name1 = new TextButton(allies[0].getName(), textButtonStyle2);
        name2 = new TextButton(allies[1].getName(), textButtonStyle2);
        name3 = new TextButton(allies[2].getName(), textButtonStyle2);

        enemyName1 = new TextButton(enemies[0].getName(), textButtonStyle2);
        enemyName2 = new TextButton(enemies[1].getName(), textButtonStyle2);
        enemyName3  = new TextButton(enemies[2].getName(), textButtonStyle2);

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

        viewport = new FitViewport(MyGdxGame.WIDTH, MyGdxGame.HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport,sb);
        Gdx.input.setInputProcessor(stage);

        font = new BitmapFont();
        skin = new Skin();
        buttonAtlas = new TextureAtlas("Audio/Audio.pack");
        skin.addRegions(buttonAtlas);
        textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = font;
        textButtonStyle.up = skin.getDrawable("SoundOn");
        textButtonStyle.checked = skin.getDrawable("SoundOff");
        button = new TextButton("", textButtonStyle);


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

        bluestyle = new TextButton.TextButtonStyle();
        bluestyle.font = redfont;
        bluestyle.up = redskin.getDrawable("BlueColor");
        blue = new TextButton("", bluestyle);
        blue2 = new TextButton("", bluestyle);
        blue3 = new TextButton("", bluestyle);
        enemyBlue = new TextButton("", bluestyle);
        enemyBlue2 = new TextButton("", bluestyle);
        enemyBlue3 = new TextButton("", bluestyle);

        healthfont = new BitmapFont();
        healthskin = new Skin();
        healthstyle = new TextButton.TextButtonStyle();
        healthstyle.font = healthfont;

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

    public void update(SpriteBatch sb, Unit[] allies, Unit[] enemies, Unit current)
    {

        health = allies[0].getHP();
        mana = allies[0].getMANA().EffectiveValue;

        health2 = allies[1].getHP();
        mana2 = allies[1].getMANA().EffectiveValue;

        health3 = allies[2].getHP();
        mana3 = allies[2].getMANA().EffectiveValue;

        enemyHealth = enemies[0].getHP();
        enemyMana = enemies[0].getMANA().EffectiveValue;

        enemyHealth2 = enemies[1].getHP();
        enemyMana2 = enemies[1].getMANA().EffectiveValue;

        enemyHealth3 = enemies[2].getHP();
        enemyMana3 = enemies[2].getMANA().EffectiveValue;

        viewport = new FitViewport(MyGdxGame.WIDTH, MyGdxGame.HEIGHT, new OrthographicCamera());

        healthNumbers1 = new TextButton(health.toString() + "/ "  + healthMax , healthstyle);
        healthNumbers2 = new TextButton(health2.toString() + "/ "  + healthMax2, healthstyle);
        healthNumbers3 = new TextButton(health3.toString() + "/ "  + healthMax3, healthstyle);

        enemyHealthNumbers = new TextButton(enemyHealth.toString() + "/ " + enemyHealthMax, healthstyle);
        enemyHealthNumbers2 = new TextButton(enemyHealth2.toString() + "/ " + enemyHealthMax2, healthstyle);
        enemyHealthNumbers3 = new TextButton(enemyHealth3.toString() + "/ " + enemyHealthMax3, healthstyle);

        manaNumbers1 = new TextButton(mana.toString() + " / " + manaMax, healthstyle);
        manaNumbers2 = new TextButton(mana2.toString()+ " / " + manaMax2, healthstyle);
        manaNumbers3 = new TextButton(mana3.toString() + " / " + manaMax3, healthstyle);

        enemyManaNumbers = new TextButton(enemyMana.toString() + " / " + enemyManaMax, healthstyle);
        enemyManaNumbers2 = new TextButton(enemyMana2.toString() + " / " + enemyManaMax2, healthstyle);
        enemyManaNumbers3 = new TextButton(enemyMana3.toString()+ " / " + enemyManaMax3, healthstyle);


        name1.setPosition(0,600);
        templateBar.setPosition(0,570);
        templateBar2.setPosition(0,540);

        name2.setPosition(0,450);
        templateBar3.setPosition(0,420);
        templateBar4.setPosition(0,390);

        name3.setPosition(0,300);
        templateBar5.setPosition(0,270);
        templateBar6.setPosition(0,240);

        enemyName1.setPosition(1025,600);
        enemytemplateBar.setPosition(1025,570);
        enemytemplateBar2.setPosition(1025,540);

        enemyName2.setPosition(1025,450);
        enemytemplateBar3.setPosition(1025,420);
        enemytemplateBar4.setPosition(1025,390);

        enemyName3.setPosition(1025,300);
        enemytemplateBar5.setPosition(1025,270);
        enemytemplateBar6.setPosition(1025,240);

        red.setPosition(10,573);
        red2.setPosition(10,423);
        red3.setPosition(10,273);

        red.setTransform(true);
        red.setScaleX(health.floatValue()/healthMax.floatValue());
        red2.setTransform(true);
        red2.setScaleX(health2.floatValue()/healthMax2.floatValue());
        red3.setTransform(true);
        red3.setScaleX(health3.floatValue()/healthMax3.floatValue());

        enemyRed.setPosition(1035, 573);
        enemyRed2.setPosition(1035, 423);
        enemyRed3.setPosition(1035, 273);

        enemyRed.setTransform(true);
        enemyRed.setScaleX(enemyHealth.floatValue()/enemyHealthMax.floatValue());
        enemyRed2.setTransform(true);
        enemyRed2.setScaleX(enemyHealth2.floatValue()/enemyHealthMax2.floatValue());
        enemyRed3.setTransform(true);
        enemyRed3.setScaleX(enemyHealth3.floatValue()/enemyHealthMax3.floatValue());

        blue.setPosition(10,543);
        blue2.setPosition(10,393);
        blue3.setPosition(10,243);

        blue.setTransform(true);
        blue.setScaleX(mana.floatValue()/manaMax.floatValue());
        blue2.setTransform(true);
        blue2.setScaleX(mana2.floatValue()/manaMax2.floatValue());
        blue3.setTransform(true);
        blue3.setScaleX(mana3.floatValue()/manaMax3.floatValue());

        enemyBlue.setPosition(1035, 543);
        enemyBlue2.setPosition(1035,393);
        enemyBlue3.setPosition(1035,243);

        enemyBlue.setTransform(true);
        enemyBlue.setScaleX(enemyMana.floatValue()/enemyManaMax.floatValue());
        enemyBlue2.setTransform(true);
        enemyBlue2.setScaleX(enemyMana2.floatValue()/enemyManaMax2.floatValue());
        enemyBlue3.setTransform(true);
        enemyBlue3.setScaleX(enemyMana3.floatValue()/enemyManaMax3.floatValue());//

        healthNumbers1.setPosition(105,573);
        healthNumbers2.setPosition(105,423);
        healthNumbers3.setPosition(105,273);
        manaNumbers1.setPosition(105,543);
        manaNumbers2.setPosition(105,393);
        manaNumbers3.setPosition(105,243);

        enemyHealthNumbers.setPosition(105 + 1025,573);
        enemyHealthNumbers2.setPosition(105 + 1025,423);
        enemyHealthNumbers3.setPosition(105 + 1025,273);
        enemyManaNumbers.setPosition(105 + 1025,543);
        enemyManaNumbers2.setPosition(105 + 1025,393);
        enemyManaNumbers3.setPosition(105 + 1025,243);


        stage.clear();
        stage.addActor(button);
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

        stopRound.setPosition(0, 150);
        stage.addActor(stopRound);
        moveStart.setPosition(40, 150);
        stage.addActor(moveStart);
        attack.setPosition(80, 150);
        stage.addActor(attack);
        if(MyGdxGame.attackMode) {

            attack1Text = new Texture("RoundsImages/" + current.getAbilities().get(0).getName() +".png");

            attack1TextureRegion = new TextureRegion(attack1Text);
            attack1RegionDrawable = new TextureRegionDrawable(attack1TextureRegion);
            attack1 = new ImageButton(attack1RegionDrawable);

            attack1.setPosition(120, 150);
            stage.addActor(attack1);

            attack1.addListener(new InputListener()
            {
                @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int buttonx) {
                    MyGdxGame.attack1 = true;
                    return true;
                }
            });

            Number1Text = new Texture("RoundsImages/1.png");
            Number1TextureRegion = new TextureRegion(Number1Text);
            Number1RegionDrawable = new TextureRegionDrawable(Number1TextureRegion);
            Number1 = new ImageButton(Number1RegionDrawable);

            Number1.setPosition(attack1.getX()+8, attack1.getY()-15);
            stage.addActor(Number1);


            attack2Text = new Texture("RoundsImages/" + current.getAbilities().get(1).getName() + ".png");
            attack2TextureRegion = new TextureRegion(attack2Text);
            attack2RegionDrawable = new TextureRegionDrawable(attack2TextureRegion);
            attack2 = new ImageButton(attack2RegionDrawable);
            attack2.setPosition(160, 150);
            stage.addActor(attack2);

            attack2.addListener(new InputListener()
            {
                @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int buttonx) {
                    MyGdxGame.attack2 = true;
                    return true;
                }
            });

            Number2Text = new Texture("RoundsImages/2.png");
            Number2TextureRegion = new TextureRegion(Number2Text);
            Number2RegionDrawable = new TextureRegionDrawable(Number2TextureRegion);
            Number2 = new ImageButton(Number2RegionDrawable);

            Number2.setPosition(attack2.getX()+8, attack2.getY()-15);
            stage.addActor(Number2);

        }

        LetterM.setPosition(moveStart.getX() + 8, moveStart.getY() - 15);
        stage.addActor(LetterM);

        LetterA.setPosition(attack.getX() + 8, attack.getY() - 15);
        stage.addActor(LetterA);

        LetterE.setPosition(stopRound.getX() + 8, stopRound.getY() - 15);
        stage.addActor(LetterE);

    }


    public void dispose()
    {
        music.dispose();
        stage.dispose();
        if(xText != null)
            xText.dispose();
        if(Number1Text != null)
            Number1Text.dispose();
        if(Number2Text != null)
            Number2Text.dispose();
        if(AText != null)
            AText.dispose();
        if(MText != null)
            MText.dispose();
        if(EText != null)
            EText.dispose();
        if(mText != null)
            mText.dispose();
        if(attackText != null)
            attackText.dispose();
        if(attack1Text != null)
            attack1Text.dispose();
        if(attack2Text != null)
            attack2Text.dispose();
        if(font != null)
            font.dispose();
        if(skin != null)
            skin.dispose();
        if(buttonAtlas != null)
            buttonAtlas.dispose();
        if(font2 != null)
            font2.dispose();
        if(skin2 != null)
            skin2.dispose();
        if(buttonAtlas2 != null)
            buttonAtlas2.dispose();
        if(font3 != null)
            font3.dispose();
        if(skin3 != null)
            skin3.dispose();
        if(redfont != null)
            redfont.dispose();
        if(redskin != null)
            redskin.dispose();
        if(redatlas != null)
            redatlas.dispose();
        if(healthfont != null)
            healthfont.dispose();
        if(healthskin != null)
            healthskin.dispose();
    }
}
