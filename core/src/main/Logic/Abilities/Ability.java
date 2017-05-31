package main.Logic.Abilities;

import java.util.ArrayList;

import main.Logic.Map.Cell;
import main.Logic.Unit.Statistic;
import main.Logic.Unit.Unit;

public interface Ability {
    public abstract void AffectTarget(Unit target);
    public abstract boolean canHitTarget(Unit target);
    public abstract double getBaseDamage();
    public abstract int getRange();
    public abstract boolean isElemental();
    public abstract main.Logic.ElementSystem.Element.type getType();
    public abstract main.Logic.ElementSystem.Element.DamageElement getDamageElement();
    public abstract main.Logic.ElementSystem.Element.DamageType getDamageType();
    public abstract String getName();
    public abstract ArrayList<main.Logic.ElementSystem.Element.type> getTraits();
    public abstract Unit getOwner();
    public abstract Statistic getScalingStat();
    public abstract double getDamageToTarget(Unit target);
    public abstract double getHitChance();
    public abstract int getAOE();
    public abstract double getManaCost();
    public abstract boolean canHitCell(Cell cell);
    public boolean canUse();
}
