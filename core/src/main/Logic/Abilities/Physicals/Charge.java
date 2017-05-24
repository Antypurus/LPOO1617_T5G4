package main.Logic.Abilities.Physicals;

import java.util.ArrayList;

import main.Logic.Abilities.Ability;
import main.Logic.ElementSystem.Element;
import main.Logic.Map.Cell;
import main.Logic.Unit.Statistic;
import main.Logic.Unit.Unit;

public class Charge implements Ability {

    private  double Damage = 20;
    private  double Chance = 60;
    private  int range  = 15;
    private double manaCost = 0;
    private Statistic scalingStat = null;
    private Unit owner = null;
    private String name = "Charge";

    public Charge(Unit owner){
        this.owner = owner;
        if(this.owner!=null){
            this.owner.addAbility(this);
            this.scalingStat = this.owner.getSTRENGHT();
        }
    }

    public void AffectTarget(Unit target){
        if(this.canHitTarget(target)&&this.owner!=null){
            this.owner.reduceMana(this.manaCost);
            double dmg = this.getDamageToTarget(target);
            target.takeDamage(dmg);
            int deltaX = target.getX()-this.owner.getX();
            int deltaY = target.getY()-this.owner.getY();
            this.owner.move(deltaX,deltaY);
        }
    }

    public boolean canHitTarget(Unit target){
        if(target==null){
            return false;
        }
        if(this.owner==null){
            return false;
        }
        if(this.owner==target){
            return false;
        }
        if(this.owner.getPosition()==null){
            return false;
        }
        if(target.getPosition()==null){
            return false;
        }
        if(this.owner.getMP()-this.manaCost<0){
            return false;
        }
        if(owner.isDead()){
            return false;
        }
        if(target.isDead()){
            return false;
        }
        boolean ret = this.canHitCell(target.getPosition());
        if(!ret){
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

    public boolean isElemental() {
        return false;
    }

    public main.Logic.ElementSystem.Element.type getType(){
        return Element.type.DAMAGE;
    }

    public main.Logic.ElementSystem.Element.DamageElement getDamageElement(){
        return null;
    }

    public main.Logic.ElementSystem.Element.DamageType getDamageType(){
        return Element.DamageType.Physical;
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
        return this.scalingStat;
    }

    public double getDamageToTarget(Unit target){
        return 0;
    }

    public double getHitChance(){
        return this.Chance;
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
        if(this.owner.getX()==cell.getxPos()&&this.owner.getY()==cell.getyPos()){
            return false;
        }
        if(this.owner.getY()!=cell.getyPos()&&this.owner.getX()!=cell.getxPos()){
            return false;
        }
        return true;
    }
}
