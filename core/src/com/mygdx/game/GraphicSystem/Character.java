package com.mygdx.game.GraphicSystem;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import Logic.Unit.Unit;

public class Character {
    private Unit unit=null;
    private Sprite spr=null;

    private Texture interm = null;
    private TextureRegion[][] texts = null;
    private TextureRegion[] textures = null;

    private Animation<TextureRegion> UpAnimation = null;
    private Animation<TextureRegion> DownAnimation = null;
    private Animation<TextureRegion> LeftAnimation = null;
    private Animation<TextureRegion> RightAnimation = null;

    public enum orientation{UP,DOWN,LEFT,RIGHT}

    private orientation ori = orientation.DOWN;

    private float currKeyframe;

    public Character(){
        interm = new Texture("characters.png");
        texts = TextureRegion.split(interm,interm.getWidth()/12,interm.getHeight()/8);
        textures = new TextureRegion[3];
        System.arraycopy(texts[0],3,textures,0,3);
        spr = new Sprite(textures[2]);
        DownAnimation = new Animation<TextureRegion>(0.30f, textures);
        DownAnimation.setPlayMode(Animation.PlayMode.LOOP);
        currKeyframe = 0;
        unit = new Unit("test",1,1,1,1,1);
    }

    public Sprite getSprite(){
        spr.setRegion(DownAnimation.getKeyFrame(currKeyframe));
        currKeyframe+= Gdx.graphics.getDeltaTime();
        return this.spr;
    }

    public Unit getUnit(){
        return this.unit;
    }

    public void update(){

    }
}
