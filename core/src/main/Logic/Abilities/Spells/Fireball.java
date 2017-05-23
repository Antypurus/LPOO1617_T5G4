package main.Logic.Abilities.Spells;

import java.util.ArrayList;

import main.Logic.Abilities.Ability;
import main.Logic.ElementSystem.Element;
import main.Logic.Unit.Statistic;
import main.Logic.Unit.Stats.Inteligence;
import main.Logic.Unit.Unit;

public class Fireball implements Ability{

    private double Damage = 100;
    private double ManaCost = 10;
    private Statistic scalingStat = null;
    private int AOE = 0;
    private double Chance = 100;
    private int range  = 10;

    private Unit owner = null;

    public Fireball(Unit owner){
        this.owner = owner;
        this.scalingStat = owner.getINTELIGENCE();
    }

    public void AffectTarget(Unit target){
        if(this.canHitTarget(target)){
            this.owner.reduceMana(this.ManaCost);
        }
    }

    public boolean canHitTarget(Unit target){
        double dist = this.owner.getPosition().distanceToCell(target.getPosition());
        if(dist > this.range){
            return false;
        }
        if(this.owner.getMP()-this.ManaCost<0){
            return false;
        }
        return true;
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
