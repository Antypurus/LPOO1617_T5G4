package Logic.Abilities;

import java.util.ArrayList;

import Logic.ElementSystem.Element;
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
}
