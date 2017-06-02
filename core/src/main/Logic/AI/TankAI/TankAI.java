package Logic.AI.TankAI;

import java.lang.annotation.Target;
import java.util.ArrayList;

import Logic.AI.BaseAIFeatures;
import Logic.AI.BaseAi;
import Logic.Difficulty;
import Logic.GameController;
import main.Logic.Abilities.Ability;
import main.Logic.Map.Cell;
import main.Logic.Unit.Stats.Inteligence;
import main.Logic.Unit.Unit;

public class TankAI extends BaseAIFeatures implements BaseAi{

    private Unit TankAIUnit = null;
    private GameController CurrentGame = null;

    public TankAI(Unit owner,GameController game){
        this.TankAIUnit = owner;
        this.CurrentGame = game;
    }

    private Unit determineClosestEnemy(){
        ArrayList<Unit>enemies = this.CurrentGame.getAllies();
        Unit ret = null;
        int ret_dist = Integer.MAX_VALUE;
        for(int i=0;i<enemies.size();i++){
            int dist = (int)this.TankAIUnit.getPosition().distanceToCell(enemies.get(i).getPosition());
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

    private Unit easyDeterminBestTarget(){
        Unit ret = null;
        ret = this.determineClosestEnemy();
        return ret;
    }

    private Ability abilityWithMostDamage(){
        ArrayList<Ability>abilities = this.TankAIUnit.getAbilities();
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

    private boolean isThereACellWhereAttackCanBeUsed(Ability ability,ArrayList<Cell>cellsToRet){
        ArrayList<Cell>retCells = new ArrayList<Cell>();
        boolean ret = false;
        ArrayList<Cell>cells = this.TankAIUnit.getCellsThatCanMoveTo();
        for(int i=0;i<cells.size();++i){
            if(ability.canHitCell(cells.get(i))){
                retCells.add(cells.get(i));
                ret = true;
            }
        }
        cellsToRet = retCells;
        return ret;
    }

    private boolean cellsFromWhereCanHitTargetWithAbility(Ability ability,Unit target,ArrayList<Cell>cellsToRet){
        boolean ret = false;
        ArrayList<Cell>retCells = new ArrayList<Cell>();
        ArrayList<Cell>cells = this.TankAIUnit.getCellsThatCanMoveTo();
        Cell originalPos = this.TankAIUnit.getPosition();

        for(int i=0;i<cells.size();++i){
            TankAIUnit.setPosition(cells.get(i));
            if(ability.canHitTarget(target)){
                ret = true;
                retCells.add(cells.get(i));
            }
        }
        TankAIUnit.setPosition(originalPos);
        cellsToRet = retCells;
        return ret;
    }

    private Cell cellAtSmalestDistance(ArrayList<Cell>cells){
        Cell ret = null;
        int retDist = Integer.MAX_VALUE;
        for(int i=0;i<cells.size();i++){
            int dist = (int)this.TankAIUnit.getPosition().distanceToCell(cells.get(i));
            if(dist<retDist){
                retDist=dist;
                ret = cells.get(i);
            }
        }
        return ret;
    }

    private ArrayList<Ability> abilitiesThatCanBeUsedOnTarget(Unit target){
        ArrayList<Ability>ret = new ArrayList<Ability>();
        ArrayList<Cell>cells = null;
        for(int i=0;i<this.TankAIUnit.getAbilities().size();++i){
            if(this.cellsFromWhereCanHitTargetWithAbility(this.TankAIUnit.getAbilities().get(i),target,null)){
                ret.add(this.TankAIUnit.getAbilities().get(i));
            }
        }
        return ret;
    }

    private Cell cellThatGetsClosestToTarget(Unit target){
        Cell ret = null;
        int dist = Integer.MAX_VALUE;
        ArrayList<Cell>cells = this.TankAIUnit.getCellsThatCanMoveTo();
        for(int i=0;i<cells.size();i++){
            int distance = (int)cells.get(i).distanceToCell(target.getPosition());
            if(dist>distance){
                dist = distance;
                ret = cells.get(i);
            }
        }
        return ret;
    }

    private void listEnemyQuadrants(int topLeft,int topRight,int botLeft,int botRight){
        topLeft=0;
        topRight=0;
        botLeft=0;
        botRight=0;
        ArrayList<Unit>enemies = this.CurrentGame.getAllies();
        for(int i=0;i<enemies.size();i++){
            if(enemies.get(i).getX()<=this.TankAIUnit.getX()){
                if(enemies.get(i).getY()>this.TankAIUnit.getX()){
                    topLeft++;
                }else{
                    botLeft++;
                }
            }else {
                if(enemies.get(i).getX()<=this.TankAIUnit.getX()) {
                    if (enemies.get(i).getY() > this.TankAIUnit.getX()) {
                        topRight++;
                    } else {
                        botRight++;
                    }
                }
            }
        }
    }

    private String determineSafestQuadrant(){
        String ret = "";
        int topLeft=0;
        int topRight=0;
        int botLeft=0;
        int botRight=0;
        this.listEnemyQuadrants(topLeft,topRight,botLeft,botRight);
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

    private void easyOffenseBehavior(){
        Unit toHit = this.easyDeterminBestTarget();
        Ability abl = this.abilityWithMostDamage();
        ArrayList<Cell>cells = null;
        if(!this.cellsFromWhereCanHitTargetWithAbility(abl,toHit,cells)){
            ArrayList<Ability>abls = this.abilitiesThatCanBeUsedOnTarget(toHit);
            if(abls.size()==0){
                Cell toGO = this.cellThatGetsClosestToTarget(toHit);
                if(toGO==null){
                    return;
                }
                this.TankAIUnit.moveToCell(toGO);
                return;
            }
            this.cellsFromWhereCanHitTargetWithAbility(abls.get(0),toHit,cells);
            Cell hit = this.cellAtSmalestDistance(cells);
            this.TankAIUnit.moveToCell(hit);
            abl.AffectTarget(toHit);
        }else{
            Cell hit = this.cellAtSmalestDistance(cells);
            this.TankAIUnit.moveToCell(hit);
            abl.AffectTarget(toHit);
        }
    }

    private Cell cellAtBiggestDistance(ArrayList<Cell>cells){
        Cell ret = null;
        int dist = 0;
        for(int i=0;i<cells.size();++i){
            int distance = (int)this.TankAIUnit.getPosition().distanceToCell(cells.get(i));
            if(dist<distance){
                dist = distance;
                ret = cells.get(i);
            }
        }
        return ret;
    }

    private ArrayList<Cell>cellsInAQuadrantThatCanMoveTo(String quad){
        ArrayList<Cell>cells = this.TankAIUnit.getCellsThatCanMoveTo();
        ArrayList<Cell>ret = new ArrayList<Cell>();
        for(int i=0;i<cells.size();++i){
            if(quad.equals("topLeft")){
                if(cells.get(i).getxPos()<=this.TankAIUnit.getX()){
                    if(cells.get(i).getyPos()>=this.TankAIUnit.getY()){
                        ret.add(cells.get(i));
                    }
                }
            }
            if(quad.equals("topRight")){
                if(cells.get(i).getxPos()>=this.TankAIUnit.getX()){
                    if(cells.get(i).getyPos()>=this.TankAIUnit.getY()){
                        ret.add(cells.get(i));
                    }
                }
            }
            if(quad.equals("botRight")){
                if(cells.get(i).getxPos()>=this.TankAIUnit.getX()){
                    if(cells.get(i).getyPos()<=this.TankAIUnit.getY()){
                        ret.add(cells.get(i));
                    }
                }
            }
            if(quad.equals("botLeft")){
                if(cells.get(i).getxPos()<=this.TankAIUnit.getX()){
                    if(cells.get(i).getyPos()>=this.TankAIUnit.getY()){
                        ret.add(cells.get(i));
                    }
                }
            }
        }
        return ret;
    }

    @Override
    public void DefensiveBehavior() {
        if(this.CurrentGame.getCurrentDifficulty().equals(Difficulty.DifficultyStage.EASY)){
            return;
        }else{
            if(this.TankAIUnit.getCurrentHPPercent()>=25){
                return ;
            }
        }
        if(this.TankAIUnit.getRemainingMovement()==0){
            return;
        }
        String quad = this.determineSafestQuadrant();
        if(quad.equals("Center")){
            return;
        }else{
            ArrayList<Cell>cells = this.cellsInAQuadrantThatCanMoveTo(quad);
            Cell toMove = this.cellAtBiggestDistance(cells);
            this.TankAIUnit.moveToCell(toMove);
        }
    }

    @Override
    public void OffensiveBehavior() {
        if(this.CurrentGame.getCurrentDifficulty().equals(Difficulty.DifficultyStage.HARD)){
            if(this.TankAIUnit.getCurrentHPPercent()<25){
                return ;
            }
        }
        if(this.numberOfOffensivAbilitiesAvailableToUse(this.TankAIUnit)==0){
            return;
        }
        this.easyOffenseBehavior();
    }

    @Override
    public void FullTurnBehavior() {
        this.OffensiveBehavior();
        this.DefensiveBehavior();
    }

    @Override
    public Unit getControledUnit() {
        return this.TankAIUnit;
    }

    @Override
    public GameController getCurrentGameController() {
        return this.CurrentGame;
    }

    @Override
    public Difficulty.DifficultyStage getDifficulty() {
        return this.CurrentGame.getCurrentDifficulty();
    }
}
