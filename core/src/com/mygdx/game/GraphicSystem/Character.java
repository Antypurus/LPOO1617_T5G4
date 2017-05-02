package com.mygdx.game.GraphicSystem;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;

import Logic.Unit.Unit;

public class Character {
    private Unit unit=null;
    private Sprite sprite=null;

    Animation<Texture> UpAnimation = null;
    Animation<Texture> DownAnimation = null;
    Animation<Texture> LeftAnimation = null;
    Animation<Texture> RightAnimation = null;
}
