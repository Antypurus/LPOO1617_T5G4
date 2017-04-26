package Logic.Abilities.Spells;

import Logic.Abilities.Ability;
import Logic.Unit.Statistic;
import Logic.Unit.Unit;

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

    public void setScalingStat(Statistic stat){
        if(stat.getName().equals("INT")){
            
        }
    }

}
