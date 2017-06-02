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

    private Unit easyDeterminBestTarget(){
        Unit ret = null;
        ret = this.determineClosestEnemy(this.CurrentGame,this.TankAIUnit);
        return ret;
    }

    private void easyOffenseBehavior(){
        Unit toHit = this.easyDeterminBestTarget();
        Ability abl = this.abilityWithMostDamage(this.TankAIUnit);
        ArrayList<Cell>cells = null;
        if(!this.cellsFromWhereCanHitTargetWithAbility(abl,toHit,cells,this.TankAIUnit)){
            ArrayList<Ability>abls = this.abilitiesThatCanBeUsedOnTarget(this.TankAIUnit,toHit);
            if(abls.size()==0){
                Cell toGO = this.cellThatGetsClosestToTarget(this.TankAIUnit,toHit);
                if(toGO==null){
                    return;
                }
                this.TankAIUnit.moveToCell(toGO);
                return;
            }
            this.cellsFromWhereCanHitTargetWithAbility(abls.get(0),toHit,cells,this.TankAIUnit);
            Cell hit = this.cellAtSmalestDistance(cells,this.TankAIUnit);
            this.TankAIUnit.moveToCell(hit);
            abl.AffectTarget(toHit);
        }else{
            Cell hit = this.cellAtSmalestDistance(cells,this.TankAIUnit);
            this.TankAIUnit.moveToCell(hit);
            abl.AffectTarget(toHit);
        }
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
        String quad = this.determineSafestQuadrant(this.CurrentGame,this.TankAIUnit);
        if(quad.equals("Center")){
            return;
        }else{
            ArrayList<Cell>cells = this.cellsInAQuadrantThatCanMoveTo(quad,this.TankAIUnit);
            Cell toMove = this.cellAtBiggestDistance(cells,this.TankAIUnit);
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
