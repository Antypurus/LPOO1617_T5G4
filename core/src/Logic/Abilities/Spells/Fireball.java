package Logic.Abilities.Spells;

import Logic.Abilities.Ability;
import Logic.Unit.Unit;

public class Fireball extends Ability{

    private double Damage = 100;
    private int AOE = 1;

    public Fireball(){
        this.value = Damage;
    }

    public void AffectTarget(Unit target){

    }

}
