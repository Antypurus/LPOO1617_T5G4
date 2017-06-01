package main.Logic.Abilities.Basics;

import java.util.ArrayList;

import Logic.Abilities.BaseAbilityFunctions;
import main.Logic.Abilities.Ability;
import main.Logic.ElementSystem.Element;
import main.Logic.Map.Cell;
import main.Logic.Unit.Statistic;
import main.Logic.Unit.Unit;

public class Punch extends BaseAbilityFunctions implements Ability{

    private double PunchBaseDamage = 5;
    private int PucnhAOE = 0;
    private double PunchHitChance = 100;
    private Statistic PucnhScallingStat = null;
    private double PunchManaCost = 0;
    private int PunchRange = 1;
    private String PunchName = "Punch";
    private Element.type PunchType = Element.type.DAMAGE;
    private Element.DamageElement PunchDamageElement = null;
    private Element.DamageType PunchDamageType = Element.DamageType.Physical;
    private boolean PunchIsElemental = false;

    private Unit PunchOwner = null;

    public Punch(Unit PunchOwner){
        this.PunchOwner = PunchOwner;
        if(this.PunchOwner !=null){
            this.PucnhScallingStat = this.PunchOwner.getSTRENGHT();
            this.PunchOwner.addAbility(this);
        }
    }

    public void AffectTarget(Unit target){
        if(this.canHitTarget(target)){
            this.PunchOwner.reduceMana(this.PunchManaCost);
            double dmg = this.getDamageToTarget(target);
            target.takeDamage(dmg);
        }
    }

    public boolean canHitTarget(Unit target){
        return this.baseCanHitTarget(this,target);
    }

    public double getBaseDamage(){
        return this.PunchBaseDamage;
    }

    public int getRange(){
        return this.PunchRange;
    }

    public boolean isElemental(){
        return this.PunchIsElemental;
    }

    public main.Logic.ElementSystem.Element.type getType(){
        return this.PunchType;
    }

    public main.Logic.ElementSystem.Element.DamageElement getDamageElement(){
        return this.PunchDamageElement;
    }

    public main.Logic.ElementSystem.Element.DamageType getDamageType(){
        return this.PunchDamageType;
    }

    public String getName(){
        return this.PunchName;
    }

    public ArrayList<Element.type> getTraits(){
        return null;
    }

    public Unit getOwner(){
        return this.PunchOwner;
    }

    public Statistic getScalingStat(){
        return this.PucnhScallingStat;
    }

    public double getDamageToTarget(Unit target){
        double dmg = this.PunchBaseDamage;
        dmg*=this.PucnhScallingStat.EffectiveValue;
        double dodge = target.generateDodgeVal();
        if(dodge>this.PunchHitChance){
            dmg = 0;
        }else if(dodge == 1){
            dmg*=2;
        }
        dmg-=target.getArmor();
        if(dmg<0){
            dmg=0;
        }
        return dmg;
    }

    public double getHitChance(){
        return this.PunchHitChance;
    }

    public int getAOE(){
        return this.PucnhAOE;
    }

    public double getManaCost(){
        return this.PunchManaCost;
    }

    public boolean canHitCell(Cell cell){
        return this.baseCanHitCell(this.PunchOwner,cell,this.PunchRange);
    }

    @Override
    public ArrayList<Cell> getCellsThatCanHit() {
        return this.getOwner().getMap().validCells(this);
    }

    @Override
    public boolean canUse() {
        return this.baseCanUseAbility(this,this.getOwner());
    }
}
