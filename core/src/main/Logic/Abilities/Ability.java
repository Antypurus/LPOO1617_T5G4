package main.Logic.Abilities;

import java.util.ArrayList;

import main.Logic.Unit.Unit;

public interface Ability {

    public abstract void AffectTarget(Unit target);
    public abstract boolean canHitTarget(Unit target);
    public abstract double getBaseDamage();
    public abstract double getRange();
    public abstract boolean isElemental();
    public abstract main.Logic.ElementSystem.Element.type getType();
    public abstract main.Logic.ElementSystem.Element.DamageElement getDamageElement();
    public abstract main.Logic.ElementSystem.Element.DamageType getDamageType();
    public abstract String getName();
    public abstract ArrayList<main.Logic.ElementSystem.Element.type> getTraits();
    public abstract Unit getOwner();
}
