package Logic.AI;

import com.badlogic.gdx.Game;

import java.util.ArrayList;

import Logic.GameController;
import main.Logic.Abilities.Ability;
import main.Logic.ElementSystem.Element;
import main.Logic.Map.Cell;
import main.Logic.Unit.Unit;

public abstract class BaseAIFeatures {

    public int numberOfOffensivAbilitiesAvailableToUse(Unit owner){
        int ret = 0;
        for(int i=0;i<owner.getAbilities().size();++i){
            if(owner.getAbilities().get(i).getType().equals(Element.type.DAMAGE)){
                if(owner.getAbilities().get(i).canUse()){
                    ret++;
                }
            }
        }
        return ret;
    }

    public int numberOfHealingAbilitiesAvailableToUse(Unit owner){
        int ret = 0;
        for(int i=0;i<owner.getAbilities().size();++i){
            if(owner.getAbilities().get(i).getType().equals(Element.type.HEAL)){
                if(owner.getAbilities().get(i).canUse()){
                    ret++;
                }
            }
        }
        return ret;
    }

    protected Unit determineClosestEnemy(GameController CurrentGame,Unit unit){
        ArrayList<Unit> enemies = CurrentGame.getAllies();
        Unit ret = null;
        int ret_dist = Integer.MAX_VALUE;
        for(int i=0;i<enemies.size();i++){
            int dist = (int)unit.getPosition().distanceToCell(enemies.get(i).getPosition());
            if(ret == null){
                ret = enemies.get(i);
            }
            if(dist < ret_dist){
                ret_dist = dist;
                ret = enemies.get(i);
            }
        }
        return ret;
    }

    protected Ability abilityWithMostDamage(Unit unit){
        ArrayList<Ability>abilities = unit.getAbilities();
        Ability ret = null;
        double ret_dmg = 0;
        for(int i=0;i<abilities.size();++i){
            if(abilities.get(i).getBaseDamage()>ret_dmg){
                ret_dmg = abilities.get(i).getBaseDamage();
                ret = abilities.get(i);
            }
        }
        return ret;
    }

    protected boolean isThereACellWhereAttackCanBeUsed(Ability ability,ArrayList<Cell>cellsToRet,Unit unit){
        ArrayList<Cell>retCells = new ArrayList<Cell>();
        boolean ret = false;
        ArrayList<Cell>cells = unit.getCellsThatCanMoveTo();
        for(int i=0;i<cells.size();++i){
            if(ability.canHitCell(cells.get(i))){
                retCells.add(cells.get(i));
                ret = true;
            }
        }
        cellsToRet = retCells;
        return ret;
    }

    protected boolean cellsFromWhereCanHitTargetWithAbility(Ability ability,Unit target,ArrayList<Cell>cellsToRet,Unit unit){
        boolean ret = false;
        ArrayList<Cell>retCells = new ArrayList<Cell>();
        ArrayList<Cell>cells = unit.getCellsThatCanMoveTo();
        Cell originalPos = unit.getPosition();

        for(int i=0;i<cells.size();++i){
            unit.setPosition(cells.get(i));
            if(ability.canHitTarget(target)){
                ret = true;
                retCells.add(cells.get(i));
            }
        }
        unit.setPosition(originalPos);
        cellsToRet = retCells;
        return ret;
    }

    protected Cell cellAtSmalestDistance(ArrayList<Cell>cells,Unit owner){
        Cell ret = null;
        int retDist = Integer.MAX_VALUE;
        for(int i=0;i<cells.size();i++){
            int dist = (int)owner.getPosition().distanceToCell(cells.get(i));
            if(dist<retDist){
                retDist=dist;
                ret = cells.get(i);
            }
        }
        return ret;
    }

    protected ArrayList<Ability> abilitiesThatCanBeUsedOnTarget(Unit owner,Unit target){
        ArrayList<Ability>ret = new ArrayList<Ability>();
        ArrayList<Cell>cells = null;
        for(int i=0;i<owner.getAbilities().size();++i){
            if(this.cellsFromWhereCanHitTargetWithAbility(owner.getAbilities().get(i),target,null,owner)){
                ret.add(owner.getAbilities().get(i));
            }
        }
        return ret;
    }

    protected Cell cellThatGetsClosestToTarget(Unit owner,Unit target){
        Cell ret = null;
        int dist = Integer.MAX_VALUE;
        ArrayList<Cell>cells = owner.getCellsThatCanMoveTo();
        for(int i=0;i<cells.size();i++){
            int distance = (int)cells.get(i).distanceToCell(target.getPosition());
            if(dist>distance){
                dist = distance;
                ret = cells.get(i);
            }
        }
        return ret;
    }

    protected void listEnemyQuadrants(int topLeft,int topRight,int botLeft,int botRight,Unit owner,GameController CurrentGame){
        topLeft=0;
        topRight=0;
        botLeft=0;
        botRight=0;
        ArrayList<Unit>enemies = CurrentGame.getAllies();
        for(int i=0;i<enemies.size();i++){
            if(enemies.get(i).getX()<=owner.getX()){
                if(enemies.get(i).getY()>owner.getX()){
                    topLeft++;
                }else{
                    botLeft++;
                }
            }else {
                if(enemies.get(i).getX()<=owner.getX()) {
                    if (enemies.get(i).getY() > owner.getX()) {
                        topRight++;
                    } else {
                        botRight++;
                    }
                }
            }
        }
    }

    protected String determineSafestQuadrant(GameController CurrentGame,Unit owner){
        String ret = "";
        int topLeft=0;
        int topRight=0;
        int botLeft=0;
        int botRight=0;
        this.listEnemyQuadrants(topLeft,topRight,botLeft,botRight,owner,CurrentGame);
        if(topLeft<=topRight&&topLeft<=botRight&&topLeft<=botLeft){
            return "topLeft";
        }
        if(topRight<=topLeft&&topRight<=botRight&&topRight<=botLeft){
            return "topRight";
        }
        if(botRight<=topLeft&&botRight<=topRight&&botRight<=botLeft){
            return "botRight";
        }
        if(botLeft<=topLeft&&botLeft<=botRight&&botLeft<=topRight){
            return "botLeft";
        }
        if(botLeft==botRight&&botLeft==topLeft&&botLeft==topRight){
            return "Center";
        }
        return ret;
    }

    protected Cell cellAtBiggestDistance(ArrayList<Cell>cells,Unit owner){
        Cell ret = null;
        int dist = 0;
        for(int i=0;i<cells.size();++i){
            int distance = (int)owner.getPosition().distanceToCell(cells.get(i));
            if(dist<distance){
                dist = distance;
                ret = cells.get(i);
            }
        }
        return ret;
    }

    protected ArrayList<Cell>cellsInAQuadrantThatCanMoveTo(String quad,Unit owner){
        ArrayList<Cell>cells = owner.getCellsThatCanMoveTo();
        ArrayList<Cell>ret = new ArrayList<Cell>();
        for(int i=0;i<cells.size();++i){
            if(quad.equals("topLeft")){
                if(cells.get(i).getxPos()<=owner.getX()){
                    if(cells.get(i).getyPos()>=owner.getY()){
                        ret.add(cells.get(i));
                    }
                }
            }
            if(quad.equals("topRight")){
                if(cells.get(i).getxPos()>=owner.getX()){
                    if(cells.get(i).getyPos()>=owner.getY()){
                        ret.add(cells.get(i));
                    }
                }
            }
            if(quad.equals("botRight")){
                if(cells.get(i).getxPos()>=owner.getX()){
                    if(cells.get(i).getyPos()<=owner.getY()){
                        ret.add(cells.get(i));
                    }
                }
            }
            if(quad.equals("botLeft")){
                if(cells.get(i).getxPos()<=owner.getX()){
                    if(cells.get(i).getyPos()>=owner.getY()){
                        ret.add(cells.get(i));
                    }
                }
            }
        }
        return ret;
    }
}
