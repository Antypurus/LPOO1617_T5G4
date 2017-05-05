package main.Logic.Abilities.Spells;

import main.Logic.Abilities.Ability;
import main.Logic.Unit.Stats.Inteligence;
import main.Logic.Unit.Unit;

public class Fireball extends Ability{

    private final double Damage = 100;
    private final int AOE = 0;
    private final double Chance = 100;
    private final int range  = 10;

    public Fireball(){
        this.value = Damage;
        this.effectRadius = AOE;
        this.name = "FireBall";
        this.targetRange = range;
    }

    public void AffectTarget(Unit target){

    }

    public void setScalingStat(Inteligence stat){

    }

}
