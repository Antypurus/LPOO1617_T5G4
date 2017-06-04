package game.Buttons;

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

/**
 * Created by Diogo on 01/06/2017.
 */

public class HUD
{
    public Stage stage;
    private Viewport viewport;
    private Music music;
    private boolean isPlaying = true;
    private Character character = null;
    private ArrayList<Character> allies = new ArrayList<Character>();
    private ArrayList<Character> enemies = new ArrayList<Character>();

    private Texture xText;
    private TextureRegion xTextureRegion;
    private TextureRegionDrawable xRegionDrawable;
    private ImageButton stopRound;

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

    TextButton button2;
    TextButton.TextButtonStyle textButtonStyle2;
    BitmapFont font2;
    Skin skin2;
    TextureAtlas buttonAtlas2;

    TextButton button3;
    TextButton.TextButtonStyle textButtonStyle3;
    BitmapFont font3;
    Skin skin3;
    TextureAtlas buttonAtlas3;

    TextButton red;
    TextButton.TextButtonStyle redstyle, bluestyle;
    BitmapFont redfont;
    Skin redskin;
    TextureAtlas redatlas;

    TextButton button4, button5, button6,button7, red2,red3, blue, blue2, blue3;

    TextButton name1,name2,name3;

    TextButton name1char, name2char, name3char;

    TextButton healthNumbers1, healthNumbers2, healthNumbers3;
    TextButton manaNumbers1, manaNumbers2, manaNumbers3;
    TextButton.TextButtonStyle healthstyle;
    BitmapFont healthfont;
    Skin healthskin;


    private Integer worldTimer;
    private float timeCount;
    private Integer score;

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

    private TextButton enemyButton, enemyButton2, enemyButton3, enemyButton4, enemyButton5, enemyButton6;
    private TextButton enemyHealthBtn, enemyHealthBtn2, enemyHealthBtn3;
    private TextButton enemyManaBtn, enemyManaBtn2, enemyManaBtn3;
    private TextButton enemyHealthRed, enemyHealthRed2, enemyHealthRed3;
    private TextButton enemyManaBlue, enemyManaBlue2, enemyManaBlue3;
    private TextButton enemyName1, enemyName2, enemyName3;


    Label player;

    public HUD(SpriteBatch sb, ArrayList<Character> allies, ArrayList<Character> enemies, Unit current)
    {
        xText = new Texture("RoundsImages/x_orange.png");
        xTextureRegion = new TextureRegion(xText);
        xRegionDrawable = new TextureRegionDrawable(xTextureRegion);
        stopRound = new ImageButton(xRegionDrawable);

        attackText = new Texture("RoundsImages/attack.png");
        attackTextureRegion = new TextureRegion(attackText);
        attackRegionDrawable = new TextureRegionDrawable(attackTextureRegion);
        attack = new ImageButton(attackRegionDrawable);

        music = MyGdxGame.manager.get("Audio/audio.mp3", Music.class);
        music.setLooping(true);
        if(this.isPlaying) {
            music.play();
            isPlaying = true;
        }else{
            music.pause();
            isPlaying = false;
        }

        this.allies = allies;
        this.enemies = enemies;

        //TODO: repeated code
        health = allies.get(0).getUnit().getHP();
        healthMax = allies.get(0).getUnit().getHP();
        mana = allies.get(0).getUnit().getMANA().EffectiveValue;
        manaMax = allies.get(0).getUnit().getMANA().EffectiveValue;

        health2 = allies.get(1).getUnit().getHP();
        healthMax2 = allies.get(1).getUnit().getHP();
        mana2 = allies.get(1).getUnit().getMANA().EffectiveValue;
        manaMax2 = allies.get(1).getUnit().getMANA().EffectiveValue;

        health3 = allies.get(2).getUnit().getHP();
        healthMax3 = allies.get(2).getUnit().getHP();
        mana3 = allies.get(2).getUnit().getMANA().EffectiveValue;
        manaMax3 = allies.get(2).getUnit().getMANA().EffectiveValue;

        enemyHealth = enemies.get(0).getUnit().getHP();
        enemyHealthMax = enemies.get(0).getUnit().getHP();
        enemyMana = enemies.get(0).getUnit().getMANA().EffectiveValue;
        enemyManaMax = enemies.get(0).getUnit().getMANA().EffectiveValue;

        enemyHealth2 = enemies.get(1).getUnit().getHP();
        enemyHealthMax2 = enemies.get(1).getUnit().getHP();
        enemyMana2 = enemies.get(1).getUnit().getMANA().EffectiveValue;
        enemyManaMax2 = enemies.get(1).getUnit().getMANA().EffectiveValue;

        enemyHealth3 = enemies.get(2).getUnit().getHP();
        enemyHealthMax3 = enemies.get(2).getUnit().getHP();
        enemyMana3 = enemies.get(2).getUnit().getMANA().EffectiveValue;
        enemyManaMax3 = enemies.get(2).getUnit().getMANA().EffectiveValue;

        viewport = new FitViewport(MyGdxGame.WIDTH, MyGdxGame.HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport,sb);
        Gdx.input.setInputProcessor(stage);

        font = new BitmapFont();
        skin = new Skin();
        buttonAtlas = new TextureAtlas("MenuImages/MenuImages.pack");
        skin.addRegions(buttonAtlas);
        textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = font;
        textButtonStyle.up = skin.getDrawable("SoundOn");
        textButtonStyle.checked = skin.getDrawable("SoundOff");
        button = new TextButton("", textButtonStyle);

        font2 = new BitmapFont();
        skin2 = new Skin();
        buttonAtlas2 = new TextureAtlas("Bars/Bars.pack");
        skin2.addRegions(buttonAtlas2);
        textButtonStyle2 = new TextButton.TextButtonStyle();
        //font2.getData().setScale(1.4f, 1.5f);
        textButtonStyle2.font = font2;
        textButtonStyle2.up = skin2.getDrawable("EmptyBar");
        button2 = new TextButton("", textButtonStyle2);
        button3 = new TextButton("", textButtonStyle2);
        button4 = new TextButton("", textButtonStyle2);
        button5 = new TextButton("", textButtonStyle2);
        button6 = new TextButton("", textButtonStyle2);
        button7 = new TextButton("", textButtonStyle2);

        name1 = new TextButton(allies.get(0).getUnit().getName(), textButtonStyle2);
        name2 = new TextButton(allies.get(1).getUnit().getName(), textButtonStyle2);
        name3 = new TextButton(allies.get(2).getUnit().getName(), textButtonStyle2);

        enemyName1 = new TextButton(enemies.get(0).getUnit().getName(), textButtonStyle2);
        enemyName2 = new TextButton(enemies.get(1).getUnit().getName(), textButtonStyle2);
        enemyName3  = new TextButton(enemies.get(2).getUnit().getName(), textButtonStyle2);

        enemyButton = new TextButton("", textButtonStyle2);
        enemyButton2 = new TextButton("", textButtonStyle2);
        enemyButton3 = new TextButton("", textButtonStyle2);
        enemyButton4 = new TextButton("", textButtonStyle2);
        enemyButton5 = new TextButton("", textButtonStyle2);
        enemyButton6 = new TextButton("", textButtonStyle2);


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
        enemyHealthRed = new TextButton("", redstyle);
        enemyHealthRed2 = new TextButton("", redstyle);
        enemyHealthRed3 = new TextButton("", redstyle);

        bluestyle = new TextButton.TextButtonStyle();
        bluestyle.font = redfont;
        bluestyle.up = redskin.getDrawable("BlueColor");
        blue = new TextButton("", bluestyle);
        blue2 = new TextButton("", bluestyle);
        blue3 = new TextButton("", bluestyle);
        enemyManaBlue = new TextButton("", bluestyle);
        enemyManaBlue2 = new TextButton("", bluestyle);
        enemyManaBlue3 = new TextButton("", bluestyle);


        healthfont = new BitmapFont();
        healthskin = new Skin();
        healthstyle = new TextButton.TextButtonStyle();
        healthstyle.font = healthfont;
        healthNumbers1 = new TextButton(health.toString() + "/ "  + healthMax , healthstyle);
        healthNumbers2 = new TextButton(health2.toString() + "/ "  + healthMax2, healthstyle);
        healthNumbers3 = new TextButton(health3.toString() + "/ " + healthMax3, healthstyle);

        enemyHealthBtn = new TextButton(enemyHealth.toString() + "/ " + enemyHealthMax, healthstyle);
        enemyHealthBtn2 = new TextButton(enemyHealth2.toString() + "/ " + enemyHealthMax2, healthstyle);
        enemyHealthBtn3 = new TextButton(enemyHealth3.toString() + "/ " + enemyHealthMax3, healthstyle);

        manaNumbers1 = new TextButton(mana.toString() + " / " + manaMax, healthstyle);
        manaNumbers2 = new TextButton(mana2.toString()+ " / " + manaMax2, healthstyle);
        manaNumbers3 = new TextButton(mana3.toString() + " / " + manaMax3, healthstyle);

        enemyManaBtn = new TextButton(enemyMana.toString() + " / " + enemyManaMax, healthstyle);
        enemyManaBtn2 = new TextButton(enemyMana2.toString() + " / " + enemyManaMax2, healthstyle);
        enemyManaBtn3 = new TextButton(enemyMana3.toString()+ " / " + enemyManaMax3, healthstyle);

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

        attack.addListener(new InputListener()
        {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int buttonx) {
                MyGdxGame.attackMode = true;
                return true;
            }
        });

        Table table = new Table();
        table.top();
        table.setFillParent(true);

        //health  = new Label(String.format("%06d", score), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        //player = new Label("MARIO", new Label.LabelStyle(new BitmapFont(), Color.WHITE));

        //table.add(player).expandX().padTop(10);
        //table.row();
        //table.add(health);

        //TODO: too much code
        //button.setPosition(1100,580);

        name1.setPosition(0,600);
        button2.setPosition(0,570);
        button5.setPosition(0,540);

        name2.setPosition(0,450);
        button3.setPosition(0,420);
        button6.setPosition(0,390);

        name3.setPosition(0,300);
        button4.setPosition(0,270);
        button7.setPosition(0,240);

        enemyName1.setPosition(950,600);
        enemyButton.setPosition(950,570);
        enemyButton4.setPosition(950,540);

        enemyName2.setPosition(950,450);
        enemyButton2.setPosition(950,420);
        enemyButton5.setPosition(950,390);

        enemyName3.setPosition(950,300);
        enemyButton3.setPosition(950,270);
        enemyButton6.setPosition(950,240);

        red.setPosition(10,573);
        red2.setPosition(10,423);
        red3.setPosition(10,273);

        enemyHealthRed.setPosition(950, 573);
        enemyHealthRed2.setPosition(950, 423);
        enemyHealthRed3.setPosition(950, 273);

        red.setTransform(true);
        red.setScaleX(health.floatValue()*0.1f);
        red2.setTransform(true);
        red2.setScaleX(health2.floatValue()*0.1f);
        red3.setTransform(true);
        red3.setScaleX(health3.floatValue()*0.1f);

        enemyHealthRed.setTransform(true);
        enemyHealthRed.setScaleX(enemyHealth.floatValue()*0.1f);
        enemyHealthRed2.setTransform(true);
        enemyHealthRed2.setScaleX(enemyHealth2.floatValue()*0.1f);
        enemyHealthRed3.setTransform(true);
        enemyHealthRed3.setScaleX(enemyHealth3.floatValue()*0.1f);

        blue.setPosition(10,543);
        blue2.setPosition(10,393);
        blue3.setPosition(10,243);

        enemyManaBlue.setPosition(950, 543);
        enemyManaBlue2.setPosition(950,393);
        enemyManaBlue3.setPosition(950,243);

        healthNumbers1.setPosition(105,573);
        healthNumbers2.setPosition(105,423);
        healthNumbers3.setPosition(105,273);
        manaNumbers1.setPosition(105,543);
        manaNumbers2.setPosition(105,393);
        manaNumbers3.setPosition(105,243);

        enemyHealthBtn.setPosition(105 + 950,573);
        enemyHealthBtn2.setPosition(105 + 950,423);
        enemyHealthBtn3.setPosition(105 + 950,273);
        enemyManaBtn.setPosition(105 + 950,543);
        enemyManaBtn2.setPosition(105 + 950,393);
        enemyManaBtn3.setPosition(105 + 950,243);

        stage.addActor(table);
        stage.addActor(button);
        stage.addActor(button2);
        stage.addActor(button3);
        stage.addActor(button4);
        stage.addActor(button5);
        stage.addActor(button6);
        stage.addActor(button7);
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

        stage.addActor(enemyButton);
        stage.addActor(enemyButton2);
        stage.addActor(enemyButton3);
        stage.addActor(enemyButton4);
        stage.addActor(enemyButton5);
        stage.addActor(enemyButton6);
        stage.addActor(enemyHealthRed);
        stage.addActor(enemyHealthRed2);
        stage.addActor(enemyHealthRed3);
        stage.addActor(enemyManaBlue);
        stage.addActor(enemyManaBlue2);
        stage.addActor(enemyManaBlue3);
        stage.addActor(enemyHealthBtn);
        stage.addActor(enemyHealthBtn2);
        stage.addActor(enemyHealthBtn3);
        stage.addActor(enemyManaBtn);
        stage.addActor(enemyManaBtn2);
        stage.addActor(enemyManaBtn3);

        stage.addActor(name1);
        stage.addActor(name2);
        stage.addActor(name3);
    }

    public void update(SpriteBatch sb, ArrayList<Character> allies, ArrayList<Character> enemies, Unit current)
    {
        this.allies = allies;
        this.enemies = enemies;

        health = this.allies.get(0).getUnit().getHP();
        mana = this.allies.get(0).getUnit().getMANA().EffectiveValue;

        health2 = this.allies.get(1).getUnit().getHP();
        mana2 = this.allies.get(1).getUnit().getMANA().EffectiveValue;

        health3 = this.allies.get(2).getUnit().getHP();
        mana3 = this.allies.get(2).getUnit().getMANA().EffectiveValue;

        enemyHealth = this.enemies.get(0).getUnit().getHP();
        enemyMana = this.enemies.get(0).getUnit().getMANA().EffectiveValue;

        enemyHealth2 = this.enemies.get(1).getUnit().getHP();
        enemyMana2 = this.enemies.get(1).getUnit().getMANA().EffectiveValue;

        enemyHealth3 = this.enemies.get(2).getUnit().getHP();
        enemyMana3 = this.enemies.get(2).getUnit().getMANA().EffectiveValue;

        viewport = new FitViewport(MyGdxGame.WIDTH, MyGdxGame.HEIGHT, new OrthographicCamera());

        healthNumbers1 = new TextButton(health.toString() + "/ "  + healthMax , healthstyle);
        healthNumbers2 = new TextButton(health2.toString() + "/ "  + healthMax2, healthstyle);
        healthNumbers3 = new TextButton(health3.toString() + "/ "  + healthMax3, healthstyle);

        enemyHealthBtn = new TextButton(enemyHealth.toString() + "/ " + enemyHealthMax, healthstyle);
        enemyHealthBtn2 = new TextButton(enemyHealth2.toString() + "/ "  + enemyHealthMax2, healthstyle);
        enemyHealthBtn3 = new TextButton(enemyHealth3.toString() + "/ "  + enemyHealthMax3, healthstyle);

        manaNumbers1 = new TextButton(mana.toString() + " / " + manaMax, healthstyle);
        manaNumbers2 = new TextButton(mana2.toString() + " / " + manaMax2, healthstyle);
        manaNumbers3 = new TextButton(mana3.toString() + " / " + manaMax3, healthstyle);

        enemyManaBtn = new TextButton(enemyMana.toString() + " / " + enemyManaMax, healthstyle);
        enemyManaBtn2 = new TextButton(enemyMana2.toString() + " / " + enemyManaMax2, healthstyle);
        enemyManaBtn3 = new TextButton(enemyMana3.toString() + " / " + enemyManaMax3, healthstyle);


        name1.setPosition(0,600);
        button2.setPosition(0,570);
        button5.setPosition(0,540);

        name2.setPosition(0,450);
        button3.setPosition(0,420);
        button6.setPosition(0,390);

        name3.setPosition(0,300);
        button4.setPosition(0,270);
        button7.setPosition(0,240);

        enemyName1.setPosition(1025,600);
        enemyButton.setPosition(1025,570);
        enemyButton4.setPosition(1025,540);

        enemyName2.setPosition(1025,450);
        enemyButton2.setPosition(1025,420);
        enemyButton5.setPosition(1025,390);

        enemyName3.setPosition(1025,300);
        enemyButton3.setPosition(1025,270);
        enemyButton6.setPosition(1025,240);

        red.setPosition(10,573);
        red2.setPosition(10,423);
        red3.setPosition(10,273);

        enemyHealthRed.setPosition(1025 + 10, 573);
        enemyHealthRed2.setPosition(1025 + 10, 423);
        enemyHealthRed3.setPosition(1025 + 10, 273);


        red.setTransform(true);
        red.setScaleX(health.floatValue()/healthMax.floatValue());
        red2.setTransform(true);
        red2.setScaleX(health2.floatValue()/healthMax2.floatValue());
        red3.setTransform(true);
        red3.setScaleX(health3.floatValue()/healthMax3.floatValue());

        enemyHealthRed.setTransform(true);
        enemyHealthRed.setScaleX(enemyHealth.floatValue()/enemyHealthMax.floatValue());
        enemyHealthRed2.setTransform(true);
        enemyHealthRed2.setScaleX(enemyHealth2.floatValue()/enemyHealthMax2.floatValue());
        enemyHealthRed3.setTransform(true);
        enemyHealthRed3.setScaleX(enemyHealth3.floatValue()/enemyHealthMax3.floatValue());

        blue.setTransform(true);
        blue.setScaleX(mana.floatValue()/manaMax.floatValue());
        blue2.setTransform(true);
        blue2.setScaleX(mana2.floatValue()/manaMax2.floatValue());
        blue3.setTransform(true);
        blue3.setScaleX(mana3.floatValue()/manaMax3.floatValue());

        enemyManaBlue.setTransform(true);
        enemyManaBlue.setScaleX(enemyMana.floatValue()/enemyManaMax.floatValue());
        enemyManaBlue2.setTransform(true);
        enemyManaBlue2.setScaleX(enemyMana2.floatValue()/enemyManaMax.floatValue());
        enemyManaBlue3.setTransform(true);
        enemyManaBlue3.setScaleX(enemyMana3.floatValue()/enemyManaMax.floatValue());

        blue.setPosition(10,543);
        blue2.setPosition(10,393);
        blue3.setPosition(10,243);

        enemyManaBlue.setPosition(1025 + 10, 543);
        enemyManaBlue2.setPosition(1025 + 10,393);
        enemyManaBlue3.setPosition(1025 + 10,243);

        healthNumbers1.setPosition(105,573);
        healthNumbers2.setPosition(105,423);
        healthNumbers3.setPosition(105,273);
        manaNumbers1.setPosition(105,543);
        manaNumbers2.setPosition(105,393);
        manaNumbers3.setPosition(105,243);

        enemyHealthBtn.setPosition(105 + 1025,573);
        enemyHealthBtn2.setPosition(105 + 1025,423);
        enemyHealthBtn3.setPosition(105 + 1025,273);
        enemyManaBtn.setPosition(105 + 1025,543);
        enemyManaBtn2.setPosition(105 + 1025,393);
        enemyManaBtn3.setPosition(105 + 1025,243);

        stage.clear();
        stage.addActor(button);
        stage.addActor(button2);
        stage.addActor(button3);
        stage.addActor(button4);
        stage.addActor(button5);
        stage.addActor(button6);
        stage.addActor(button7);
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

        stage.addActor(enemyButton);
        stage.addActor(enemyButton2);
        stage.addActor(enemyButton3);
        stage.addActor(enemyButton4);
        stage.addActor(enemyButton5);
        stage.addActor(enemyButton6);
        stage.addActor(enemyHealthRed);
        stage.addActor(enemyHealthRed2);
        stage.addActor(enemyHealthRed3);
        stage.addActor(enemyManaBlue);
        stage.addActor(enemyManaBlue2);
        stage.addActor(enemyManaBlue3);
        stage.addActor(enemyHealthBtn);
        stage.addActor(enemyHealthBtn2);
        stage.addActor(enemyHealthBtn3);
        stage.addActor(enemyManaBtn);
        stage.addActor(enemyManaBtn2);
        stage.addActor(enemyManaBtn3);
        stage.addActor(enemyName1);
        stage.addActor(enemyName2);
        stage.addActor(enemyName3);

        stopRound.setPosition(0, 150);
        stage.addActor(stopRound);
        attack.setPosition(40, 150);
        stage.addActor(attack);
        if(MyGdxGame.attackMode) {

                attack1Text = new Texture("RoundsImages/" + current.getAbilities().get(0).getName() +".png");

                attack1TextureRegion = new TextureRegion(attack1Text);
                attack1RegionDrawable = new TextureRegionDrawable(attack1TextureRegion);
                attack1 = new ImageButton(attack1RegionDrawable);

                attack1.setPosition(80, 150);
                stage.addActor(attack1);

                attack1.addListener(new InputListener()
                {
                    @Override
                    public boolean touchDown(InputEvent event, float x, float y, int pointer, int buttonx) {
                        MyGdxGame.attack1 = true;
                        return true;
                    }
                });

          /*  attack2Text = new Texture("RoundsImages/attack.png");
            attack2TextureRegion = new TextureRegion(attack2Text);
            attack2RegionDrawable = new TextureRegionDrawable(attack2TextureRegion);
            attack2 = new ImageButton(attack2RegionDrawable);
            attack2.setPosition(120, 150);
            stage.addActor(attack2);

            attack2.addListener(new InputListener()
            {
                @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int buttonx) {
                    MyGdxGame.attack2 = true;
                    return true;
                }
            });
            */
        }



    }
}
