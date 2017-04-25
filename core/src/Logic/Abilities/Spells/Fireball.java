package Logic.Abilities.Spells;

import Logic.Abilities.Ability;
import Logic.Unit.Unit;

public class Fireball extends Ability{

    private double Damage = 100;
    private int AOE = 0;
    private double Chance = 100;

    public Fireball(){
        this.value = Damage;
        this.effectRadius = AOE;
        this.name = "FireBall";
    }

    public void AffectTarget(Unit target){

    }

}
