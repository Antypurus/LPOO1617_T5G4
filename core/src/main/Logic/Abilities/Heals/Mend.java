package main.Logic.Abilities.Heals;

import java.util.ArrayList;

import Logic.Abilities.BaseAbilityFunctions;
import main.Logic.Abilities.Ability;
import main.Logic.ElementSystem.Element;
import main.Logic.Map.Cell;
import main.Logic.Unit.Statistic;
import main.Logic.Unit.Unit;

public class Mend extends BaseAbilityFunctions implements Ability{

    private  double MendBaseHeal = 10;
    private double MendManaCost = 10;
    private  int MendAOE = 0;
    private  double MendHitChance = 100;
    private  int MendRange = 20;
    private Statistic MendScallingStat = null;
    private Unit MendOwner = null;
    private String MendName = "Mend";
    private boolean MendIsElemental = false;
    private Element.type MendType = Element.type.HEAL;
    private Element.DamageElement MendDamageElement = null;
    private Element.DamageType MendDamageType = null;

    public Mend(Unit MendOwner){
        this.MendOwner = MendOwner;
        if(this.MendOwner !=null){
            this.MendScallingStat = this.MendOwner.getINTELIGENCE();
            this.MendOwner.addAbility(this);
        }
    }

    public void AffectTarget(Unit target){
        if(this.canHitTarget(target)){
            this.MendOwner.reduceMana(this.MendManaCost);
            double heal = this.getDamageToTarget(target);
            target.takeHeal(heal);
        }
    }

    public boolean canHitTarget(Unit target){
        return this.targetIsOwnerAbilityCheck(this,target);
    }

    public double getBaseDamage(){
        return -this.MendBaseHeal;
    }

    public int getRange(){
        return this.MendRange;
    }

    public boolean isElemental(){
        return this.MendIsElemental;
    }

    public main.Logic.ElementSystem.Element.type getType(){
        return this.MendType;
    }

    public main.Logic.ElementSystem.Element.DamageElement getDamageElement(){
        return this.MendDamageElement;
    }

    public main.Logic.ElementSystem.Element.DamageType getDamageType(){
        return this.MendDamageType;
    }

    public String getName(){
        return this.MendName;
    }

    public ArrayList<Element.type> getTraits(){
        return null;
    }

    public Unit getOwner(){
        return this.MendOwner;
    }

    public Statistic getScalingStat(){
        return this.MendScallingStat;
    }

    public double getDamageToTarget(Unit target){
        double heal = this.MendBaseHeal;
        heal*=this.MendScallingStat.EffectiveValue;
        heal+=target.getINT()*2;
        return heal;
    }

    public double getHitChance(){
        return this.MendHitChance;
    }

    public int getAOE(){
        return this.MendAOE;
    }

    public double getManaCost(){
        return this.MendManaCost;
    }

    public boolean canHitCell(Cell cell){
        return this.baseCanHitCell(this.MendOwner,cell,this.MendRange);
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
