package main.Logic.Abilities;

import java.util.ArrayList;

import main.Logic.Unit.Unit;

public abstract class Ability {

    public String name = null;

    public main.Logic.ElementSystem.Element.type AbilityType = null;
    public main.Logic.ElementSystem.Element.DamageType type = null;
    public main.Logic.ElementSystem.Element.DamageElement damageElement = null;

    public double HitChange ;

    public double value;
    public int effectRadius;
    public int targetRange;

    public ArrayList<main.Logic.ElementSystem.Element.type> Traits = new ArrayList<main.Logic.ElementSystem.Element.type>();

    public abstract void AffectTarget(Unit target);
}
