package Logic.Abilities;

import java.util.ArrayList;

import ElementSystem.Element;
import Logic.Unit.Statistic;
import Logic.Unit.Unit;

public abstract class Ability {

    public String name = null;

    public Element.type AbilityType = null;
    public Element.DamageType type = null;
    public Element.DamageElement damageElement = null;

    public double HitChange ;

    public double value;
    public int effectRadius;
    public int targetRange;

    public ArrayList<Element.type> Traits = new ArrayList<Element.type>();

    public abstract void AffectTarget(Unit target);
    public abstract void setScalingStat(Statistic sta);
}
