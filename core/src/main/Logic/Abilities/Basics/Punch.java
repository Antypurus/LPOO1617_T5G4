package main.Logic.Abilities.Basics;

import java.util.ArrayList;

import main.Logic.Abilities.Ability;
import main.Logic.ElementSystem.Element;
import main.Logic.Unit.Unit;

public class Punch implements Ability{

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
}
