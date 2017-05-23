package main.Logic.Abilities.Spells;

import java.util.ArrayList;

import main.Logic.Abilities.Ability;
import main.Logic.ElementSystem.Element;
import main.Logic.Unit.Statistic;
import main.Logic.Unit.Stats.Inteligence;
import main.Logic.Unit.Unit;

public class Fireball implements Ability{

    private double Damage = 10;
    private double ManaCost = 10;
    private Statistic scalingStat = null;
    private int AOE = 0;
    private double Chance = 100;
    private int range  = 10;
    private main.Logic.ElementSystem.Element.DamageElement dmgElem = Element.DamageElement.FIRE;
    private Unit owner = null;
    private String name = "FireBall";

    public Fireball(Unit owner){
        this.owner = owner;
        if(owner!=null) {
            this.owner.addAbility(this);
            this.scalingStat = owner.getINTELIGENCE();
        }
    }

    public void AffectTarget(Unit target){
        if(this.canHitTarget(target)){
            this.owner.reduceMana(this.ManaCost);
            double dmg = this.getDamageToTarget(target);
            target.takeDamage(dmg);
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
        double dist = this.owner.getPosition().distanceToCell(target.getPosition());
        if(dist > this.range){
            return false;
        }
        if(dist == -1){
            return false;
        }
        if(this.owner.getMP()-this.ManaCost<0){
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
        return this.Damage;
    }

    public int getRange(){
        return this.range;
    }

    public boolean isElemental(){
        return true;
    }

    public main.Logic.ElementSystem.Element.type getType(){
        return Element.type.DAMAGE;
    }

    public main.Logic.ElementSystem.Element.DamageElement getDamageElement(){
        return Element.DamageElement.FIRE;
    }

    public main.Logic.ElementSystem.Element.DamageType getDamageType(){
        return Element.DamageType.Magical;
    }

    public String getName(){
        return this.name;
    }

    public ArrayList<Element.type> getTraits(){
        ArrayList<Element.type>traits = new ArrayList<Element.type>();
        traits.add(Element.type.DAMAGE);
        return traits;
    }

    public Unit getOwner(){
        return this.owner;
    }

    public Statistic getScalingStat(){
        return this.scalingStat;
    }

    public double getDamageToTarget(Unit target){
        double dmg = this.Damage;
        dmg*=this.scalingStat.EffectiveValue;
        Element elem = new Element();
        if(target.getAfinity()!=null){
            dmg*=elem.ElementComparation(this.dmgElem,target.getAfinity());
        }
        double dodge = target.generateDodgeVal();
        if(dodge>this.Chance){
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
        return this.Chance;
    }

    public int getAOE(){
        return this.AOE;
    }

    public double getManaCost(){
        return this.ManaCost;
    }
}
