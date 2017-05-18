package Logic.Unit.GraphicsComponent;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import main.game.MyGdxGame;

import main.Logic.Unit.Unit;

public class Character {

    private Unit unit=null;
    private Sprite spr=null;

    private Texture interm = null;
    private TextureRegion[][] texts = null;
    private TextureRegion[] texturesLeft = null;
    private TextureRegion[] texturesRight = null;
    private TextureRegion[] texturesUp = null;
    private TextureRegion[] textures = null;

    private Animation<TextureRegion> UpAnimation = null;
    private Animation<TextureRegion> DownAnimation = null;
    private Animation<TextureRegion> LeftAnimation = null;
    private Animation<TextureRegion> RightAnimation = null;

    public enum orientation{UP,DOWN,LEFT,RIGHT}

    private orientation ori = orientation.DOWN;

    private float currKeyframe;

    private SpriteBatch batch = null;
    private MyGdxGame game = null;

    public Character(SpriteBatch batch, MyGdxGame game){
        interm = new Texture("characters.png");
        texts = TextureRegion.split(interm,interm.getWidth()/12,interm.getHeight()/8);
        textures = new TextureRegion[3];
        System.arraycopy(texts[0],3,textures,0,3);
        spr = new Sprite(textures[0]);
        DownAnimation = new Animation<TextureRegion>(0.30f, textures);
        DownAnimation.setPlayMode(Animation.PlayMode.LOOP);

        texturesLeft = new TextureRegion[3];
        System.arraycopy(texts[1],3,texturesLeft,0,3);
        LeftAnimation = new Animation<TextureRegion>(0.3f,texturesLeft);
        LeftAnimation.setPlayMode(Animation.PlayMode.LOOP);

        texturesRight = new TextureRegion[3];
        System.arraycopy(texts[2],3,texturesRight,0,3);
        RightAnimation = new Animation<TextureRegion>(0.3f,texturesRight);
        RightAnimation.setPlayMode(Animation.PlayMode.LOOP);

        texturesUp = new TextureRegion[3];
        System.arraycopy(texts[3],3,texturesUp,0,3);
        UpAnimation = new Animation<TextureRegion>(0.3f,texturesUp);
        UpAnimation.setPlayMode(Animation.PlayMode.LOOP);

        currKeyframe = 0;

        unit = new Unit("test",1,1,1,1,1);
    }

    public Sprite getSprite(){
        currKeyframe+= Gdx.graphics.getDeltaTime();
        if(this.ori.equals(orientation.DOWN)) {
            spr.setRegion(DownAnimation.getKeyFrame(currKeyframe));
        }else if(this.ori.equals(orientation.UP)){
            spr.setRegion(UpAnimation.getKeyFrame(currKeyframe));
        }else if(this.ori.equals(orientation.LEFT)){
            spr.setRegion(LeftAnimation.getKeyFrame(currKeyframe));
        }else if(this.ori.equals(orientation.RIGHT)){
            spr.setRegion(RightAnimation.getKeyFrame(currKeyframe));
        }
        return this.spr;
    }

    public Unit getUnit(){
        return this.unit;
    }

    public void moveUp(){
        this.unit.move(0,1);
        this.ori = orientation.UP;
    }

    public void moveDown(){
        this.unit.move(0,-1);
        this.ori = orientation.DOWN;
    }

    public void moveLeft(){
        this.unit.move(-1,0);
        this.ori = orientation.LEFT;
    }

    public void moveRight(){
        this.unit.move(1,0);
        this.ori = orientation.RIGHT;
    }

    public void update(){

    }
}
