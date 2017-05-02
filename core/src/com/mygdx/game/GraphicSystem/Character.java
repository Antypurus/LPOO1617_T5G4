package com.mygdx.game.GraphicSystem;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import Logic.Unit.Unit;

public class Character {
    private Unit unit=null;
    private Texture sprite=null;

    private Texture interm = null;
    private TextureRegion[][] texts = null;
    private TextureRegion[] textures = null;

    private Animation<TextureRegion> UpAnimation = null;
    private Animation<TextureRegion> DownAnimation = null;
    private Animation<TextureRegion> LeftAnimation = null;
    private Animation<TextureRegion> RightAnimation = null;

    public enum orientation{UP,DOWN,LEFT,RIGHT}

    private orientation ori = orientation.DOWN;

    public Character(){
        interm = new Texture("characters.png");
        texts = TextureRegion.split(interm,interm.getWidth()/12,interm.getHeight()/8);
        textures = new TextureRegion[3];
        System.arraycopy(texts[0],0,textures,0,3);
        sprite = textures[0].getTexture();
        {
            DownAnimation = new Animation<TextureRegion>(0.25f, textures);
            sprite = DownAnimation.getKeyFrame(0f).getTexture();
        }
        unit = new Unit("test",1,1,1,1,1);
    }

    public Texture getSprite(){
        return this.sprite;
    }

    public void update(){

    }
}
