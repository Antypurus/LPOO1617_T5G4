package game.Buttons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import game.GraphicsComponent.Character;
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

    private Integer worldTimer;
    private float timeCount;
    private Integer score;
    private Double health;

    Label player;

    public HUD(SpriteBatch sb, Character character)
    {
        music = MyGdxGame.manager.get("Audio/audio.mp3", Music.class);
        music.setLooping(true);
        music.play();

        worldTimer = 300;
        timeCount = 0;
        score = 0;
        this.character = character;
        health = this.character.getUnit().getHP();

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
        buttonAtlas2 = new TextureAtlas("Health/Health.pack");
        skin2.addRegions(buttonAtlas2);
        textButtonStyle2 = new TextButton.TextButtonStyle();
        textButtonStyle2.font = font2;
        textButtonStyle2.up = skin2.getDrawable("HP");
        //textButtonStyle2.checked = skin.getDrawable("SoundOff");
        button2 = new TextButton(health.toString(), textButtonStyle2);

        button.addListener(new InputListener()
        {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
               if(isPlaying)
               {
                   music.pause();
                   isPlaying = false;
               }
                else
               {
                   music.play();
                   isPlaying = true;
               }
                return true;
            }
        });

        Table table = new Table();
        table.top();
        table.setFillParent(true);

        //health  = new Label(String.format("%06d", score), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        player = new Label("MARIO", new Label.LabelStyle(new BitmapFont(), Color.WHITE));

        table.add(player).expandX().padTop(10);
        table.row();
        //table.add(health);

        button.setPosition(1100,580);
        button2.setPosition(0,500);

        stage.addActor(table);
        stage.addActor(button);
        stage.addActor(button2);
    }
}
