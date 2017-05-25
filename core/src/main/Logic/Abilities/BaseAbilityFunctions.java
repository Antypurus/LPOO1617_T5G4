package Logic.Abilities;

import main.Logic.Abilities.Ability;
import main.Logic.Map.Cell;
import main.Logic.Unit.Unit;

public abstract class BaseAbilityFunctions {

    public boolean baseCanHitCell(Unit owner,Cell cell,double range){
        double dist = owner.getPosition().distanceToCell(cell);
        if(dist>range){
            return false;
        }
        if(dist==-1){
            return false;
        }
        return true;
    }

    public boolean baseCanHitTarget(Ability ability, Unit target){
        if (ability.getOwner() == null) {
            return false;
        }
        if(target==null){
            return false;
        }
        if(ability.getOwner().getPosition()==null){
            return false;
        }
        boolean ret = this.baseCanHitCell(ability.getOwner(),target.getPosition(),ability.getRange());
        if(!ret){
            return false;
        }
        if(ability.getOwner().getMP()-ability.getManaCost()<0){
            return false;
        }
        if(ability.getOwner().isDead()){
            return false;
        }
        if(target.isDead()){
            return false;
        }
        if(target==ability.getOwner()){
            return false;
        }
        return true;
    }

}
