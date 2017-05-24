package main.Logic.Abilities.Physicals;

import java.util.ArrayList;

import main.Logic.Abilities.Ability;
import main.Logic.ElementSystem.Element;
import main.Logic.Map.Cell;
import main.Logic.Unit.Statistic;
import main.Logic.Unit.Unit;

public class Charge implements Ability {

    private  double Damage = 100;
    private  int AOE = 0;
    private  double Chance = 100;
    private  int range  = 10;
    private double manaCost = 0;

    private Unit owner = null;

    public void AffectTarget(Unit target){
        if(this.canHitTarget(target)&&this.owner!=null){

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
        double dist = this.owner.getPosition().distanceToCell(target.getPosition());
        if(dist > this.range){
            return false;
        }
        if(dist == -1){
            return false;
        }
        if(this.owner.getX()==target.getX()&&this.owner.getY()==target.getY()){
            return false;
        }
        if(this.owner.getY()!=target.getY()&&this.owner.getX()!=target.getX()){
            return false;
        }
        return true;
    }

    public double getBaseDamage(){
        return 0;
    }

    public int getRange(){
        return 0;
    }

    public boolean isElemental() {
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

    public double getHitChance(){
        return 0;
    }

    public int getAOE(){
        return 0;
    }

    public double getManaCost(){
        return 0;
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
