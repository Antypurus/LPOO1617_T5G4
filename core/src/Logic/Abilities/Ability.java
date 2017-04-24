package Logic.Abilities;

import java.util.ArrayList;

import Logic.Unit.Unit;

public abstract class Ability {

    String name = null;

    public enum type{DAMAGE,HEAL,BUFF}
    public double value;
    public int effectRadius;

    public ArrayList<type> Traits = new ArrayList<type>();

    public abstract void AffectTarget(Unit target);
}
