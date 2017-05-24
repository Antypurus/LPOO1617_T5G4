package main.Logic.Abilities.Heals;

import java.util.ArrayList;

import main.Logic.Abilities.Ability;
import main.Logic.ElementSystem.Element;
import main.Logic.Map.Cell;
import main.Logic.Unit.Statistic;
import main.Logic.Unit.Unit;

public class Mend implements Ability{

    private  double Heal = 100;
    private double manaCost = 10;
    private  int AOE = 0;
    private  double Chance = 100;
    private  int range  = 20;
    private Statistic scalingStaat = null;
    private Unit owner = null;
    private String name = "Mend";

    public Mend(Unit owner){
        this.owner = owner;
        if(this.owner!=null){
            this.scalingStaat = this.owner.getINTELIGENCE();
            this.owner.addAbility(this);
        }
    }

    public void AffectTarget(Unit target){
        if(this.canHitTarget(target)){
            this.owner.reduceMana(this.manaCost);
            double heal = this.getDamageToTarget(target);
            target.takeHeal(heal);
        }
    }

    public boolean canHitTarget(Unit target){
        if (this.owner == null) {
            return false;
        }
        if(target==null){
            return false;
        }
        if(this.owner.getPosition()==null){
            return false;
        }
        boolean ret = this.canHitCell(target.getPosition());
        if(!ret){
            return false;
        }
        if(this.owner.getMP()-this.manaCost<0){
            return false;
        }
        if(this.owner.isDead()){
            return false;
        }
        if(target.isDead()){
            return false;
        }
        if(target==this.owner){
            return false;
        }
        return true;
    }

    public double getBaseDamage(){
        return -this.Heal;
    }

    public int getRange(){
        return this.range;
    }

    public boolean isElemental(){
        return false;
    }

    public main.Logic.ElementSystem.Element.type getType(){
        return Element.type.HEAL;
    }

    public main.Logic.ElementSystem.Element.DamageElement getDamageElement(){
        return null;
    }

    public main.Logic.ElementSystem.Element.DamageType getDamageType(){
        return null;
    }

    public String getName(){
        return this.name;
    }

    public ArrayList<Element.type> getTraits(){
        return null;
    }

    public Unit getOwner(){
        return this.owner;
    }

    public Statistic getScalingStat(){
        return this.scalingStaat;
    }

    public double getDamageToTarget(Unit target){
        double heal = this.Heal;
        heal*=this.scalingStaat.EffectiveValue;
        heal+=target.getINT()*2;
        return heal;
    }

    public double getHitChance(){
        return 100;
    }

    public int getAOE(){
        return 0;
    }

    public double getManaCost(){
        return this.manaCost;
    }

    public boolean canHitCell(Cell cell){
        double dist = this.owner.getPosition().distanceToCell(cell);
        if(dist > this.range){
            return false;
        }
        if(dist == -1){
            return false;
        }
        return true;
    }

}
