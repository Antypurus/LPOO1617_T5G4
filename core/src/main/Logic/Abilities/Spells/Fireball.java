package main.Logic.Abilities.Spells;

import java.util.ArrayList;

import Logic.Abilities.BaseAbilityFunctions;
import main.Logic.Abilities.Ability;
import main.Logic.ElementSystem.Element;
import main.Logic.Map.Cell;
import main.Logic.Unit.Statistic;
import main.Logic.Unit.Unit;

public class Fireball extends BaseAbilityFunctions implements Ability{

    private double FireBallBaseDamage = 6;
    private double FireBallManaCost = 10;
    private Statistic FireBallScallingStat = null;
    private int FireballAOE = 0;
    private double FireBallHitChance = 100;
    private int FireBallRange = 10;
    private Element.DamageElement FireBallDamageElement = Element.DamageElement.FIRE;
    private Element.type FireBallType = Element.type.DAMAGE;
    private Element.DamageType FireBallDamageType = Element.DamageType.Magical;
    private boolean FireBallIsElemental = true;
    private Unit FireBallOwner = null;
    private String FireBallName = "FireBall";
    private Element elem = new Element();

    public Fireball(Unit FireBallOwner){
        this.FireBallOwner = FireBallOwner;
        if(FireBallOwner !=null) {
            this.FireBallOwner.addAbility(this);
            this.FireBallScallingStat = FireBallOwner.getINTELIGENCE();
        }
    }

    public void AffectTarget(Unit target){
        if(this.canHitTarget(target)){
            this.FireBallOwner.reduceMana(this.FireBallManaCost);
            double dmg = this.getDamageToTarget(target);
            target.takeDamage(dmg);
        }
    }

    public boolean canHitTarget(Unit target){
        return this.baseCanHitTarget(this,target);
    }

    public double getBaseDamage(){
        return this.FireBallBaseDamage;
    }

    public int getRange(){
        return this.FireBallRange;
    }

    public boolean isElemental(){
        return this.FireBallIsElemental;
    }

    public main.Logic.ElementSystem.Element.type getType(){
        return this.FireBallType;
    }

    public main.Logic.ElementSystem.Element.DamageElement getDamageElement(){
        return this.FireBallDamageElement;
    }

    public main.Logic.ElementSystem.Element.DamageType getDamageType(){
        return this.FireBallDamageType;
    }

    public String getName(){
        return this.FireBallName;
    }

    public ArrayList<Element.type> getTraits(){
        ArrayList<Element.type>traits = new ArrayList<Element.type>();
        traits.add(Element.type.DAMAGE);
        return traits;
    }

    public Unit getOwner(){
        return this.FireBallOwner;
    }

    public Statistic getScalingStat(){
        return this.FireBallScallingStat;
    }

    public double getDamageToTarget(Unit target){
        double dmg = this.FireBallBaseDamage;
        dmg*=this.FireBallScallingStat.EffectiveValue;
        if(target.getAfinity()!=null){
            dmg*=this.elem.ElementComparation(this.FireBallDamageElement,target.getAfinity());
        }
        double dodge = target.generateDodgeVal();
        if(dodge>this.FireBallHitChance){
            dmg = 0;
        }else if(dodge == 1){
            dmg*=2;
        }
        dmg-=target.getFireRes();
        if(dmg<0){
            dmg=0;
        }
        return dmg;
    }

    public double getHitChance(){
        return this.FireBallHitChance;
    }

    public int getAOE(){
        return this.FireballAOE;
    }

    public double getManaCost(){
        return this.FireBallManaCost;
    }

    public boolean canHitCell(Cell cell){
        return this.baseCanHitCell(this.FireBallOwner,cell,this.FireBallRange);
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
