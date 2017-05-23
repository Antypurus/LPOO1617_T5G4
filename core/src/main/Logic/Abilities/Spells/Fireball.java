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
    private main.Logic.ElementSystem.Element.DamageElement dmgElem = Element.DamageElement.FIRE;
    private Unit owner = null;
    private String name = "FireBall";

    public Fireball(Unit owner){
        this.owner = owner;
        this.scalingStat = owner.getINTELIGENCE();
    }

    public void AffectTarget(Unit target){
        if(this.canHitTarget(target)){
            this.owner.reduceMana(this.ManaCost);
            double dmg = this.getDamageToTarget(target);
            target.takeDamage(dmg);
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
        return this.Damage;
    }

    public double getRange(){
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
        dmg-=target.getFireRes();
        Element elem = new Element();
        if(target.getAfinity()!=null){
            dmg*=elem.ElementComparation(target.getAfinity(),this.dmgElem);
        }
        double dodge = target.generateDodgeVal();
        if(dodge>this.Chance){
            dmg = 0;
        }else if(dodge == 1){
            dmg*=2;
        }
        return dmg;
    }

}
