package main.Logic.Abilities.Physicals;

import java.util.ArrayList;

import Logic.Abilities.BaseAbilityFunctions;
import main.Logic.Abilities.Ability;
import main.Logic.ElementSystem.Element;
import main.Logic.Map.Cell;
import main.Logic.Unit.Statistic;
import main.Logic.Unit.Unit;

public class Charge extends BaseAbilityFunctions implements Ability {

    private  double ChargeBaseDamage = 15;
    private  double ChargeHitChance = 60;
    private  int ChargeRange = 15;
    private double ChargeManaCost = 0;
    private Statistic ChargeScalingStat = null;
    private Unit ChargeOwner = null;
    private String ChargeName = "Charge";
    private boolean ChargeIsElemental = false;
    private Element.type ChargeType = Element.type.DAMAGE;
    private Element.DamageType ChargeDamageType = Element.DamageType.Physical;
    private Element.DamageElement ChargeDamageElement = null;
    private int ChargeAOE = 0;

    public Charge(Unit ChargeOwner){
        this.ChargeOwner = ChargeOwner;
        if(this.ChargeOwner !=null){
            this.ChargeOwner.addAbility(this);
            this.ChargeScalingStat = this.ChargeOwner.getSTRENGHT();
        }
    }

    public void AffectTarget(Unit target){
        if(this.canHitTarget(target)&&this.ChargeOwner !=null){
            this.ChargeOwner.reduceMana(this.ChargeManaCost);
            double dmg = this.getDamageToTarget(target);
            int deltaX = target.getX()-this.ChargeOwner.getX();
            int deltaY = target.getY()-this.ChargeOwner.getY();
            if(deltaX<0){
                deltaX++;
            }else if(deltaX>0){
                deltaX--;
            }
            if(deltaY<0){
                deltaY++;
            }else if(deltaY>0){
                deltaY--;
            }
            this.ChargeOwner.unhinderedMove(deltaX,deltaY);
            target.takeDamage(dmg);
        }
    }

    public boolean canHitTarget(Unit target){
        if(!this.baseNonDistanceRelatedHitCheck(this,target)){
            return false;
        }
        if(!this.canHitCell(target.getPosition())){
            return false;
        }
        return true;
    }

    public double getBaseDamage(){
        return this.ChargeBaseDamage;
    }

    public int getRange(){
        return this.ChargeRange;
    }

    public boolean isElemental() {
        return this.ChargeIsElemental;
    }

    public main.Logic.ElementSystem.Element.type getType(){
        return this.ChargeType;
    }

    public main.Logic.ElementSystem.Element.DamageElement getDamageElement(){
        return this.ChargeDamageElement;
    }

    public main.Logic.ElementSystem.Element.DamageType getDamageType(){
        return this.ChargeDamageType;
    }

    public String getName(){
        return this.ChargeName;
    }

    public ArrayList<Element.type> getTraits(){
        return null;
    }

    public Unit getOwner(){
        return this.ChargeOwner;
    }

    public Statistic getScalingStat(){
        return this.ChargeScalingStat;
    }

    public double getDamageToTarget(Unit target){
        double dmg = this.ChargeBaseDamage;
        dmg*=this.ChargeScalingStat.EffectiveValue;
        double dodge = target.generateDodgeVal();
        dodge-=this.ChargeOwner.getSPD();
        if(dodge<=0){
            dodge = 1;
        }
        if(dodge>this.ChargeHitChance){
            dmg = 0;
            return dmg;
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
        return this.ChargeHitChance;
    }

    public int getAOE(){
        return this.ChargeAOE;
    }

    public double getManaCost(){
        return this.ChargeManaCost;
    }

    public boolean canHitCell(Cell cell){
        double dist = this.ChargeOwner.getPosition().distanceToCell(cell);
        if(dist > this.ChargeRange){
            return false;
        }
        if(dist == -1){
            return false;
        }
        if(this.ChargeOwner.getX()==cell.getxPos()&&this.ChargeOwner.getY()==cell.getyPos()){
            return false;
        }
        if(this.ChargeOwner.getY()!=cell.getyPos()&&this.ChargeOwner.getX()!=cell.getxPos()){
            return false;
        }
        return true;
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
