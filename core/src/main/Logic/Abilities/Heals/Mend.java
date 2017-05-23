package main.Logic.Abilities.Heals;

import java.util.ArrayList;

import main.Logic.Abilities.Ability;
import main.Logic.ElementSystem.Element;
import main.Logic.Unit.Statistic;
import main.Logic.Unit.Unit;

public class Mend implements Ability{

    private  double Damage = 100;
    private  int AOE = 0;
    private  double Chance = 100;
    private  int range  = 10;

    private Unit owner = null;

    public void AffectTarget(Unit target){

    }

    public boolean canHitTarget(Unit target){
        return false;
    }

    public double getBaseDamage(){
        return 0;
    }

    public double getRange(){
        return 0;
    }

    public boolean isElemental(){
        return false;
    }

    public main.Logic.ElementSystem.Element.type getType(){
        return null;
    }

    public main.Logic.ElementSystem.Element.DamageElement getDamageElement(){
        return null;
    }

    public main.Logic.ElementSystem.Element.DamageType getDamageType(){
        return null;
    }

    public String getName(){
        return null;
    }

    public ArrayList<Element.type> getTraits(){
        return null;
    }

    public Unit getOwner(){
        return null;
    }

    public Statistic getScalingStat(){
        return null;
    }

    public double getDamageToTarget(Unit target){
        return 0;
    }

}
