package Logic.AI.HealerAI;


import java.util.ArrayList;

import Logic.AI.BaseAIFeatures;
import Logic.AI.BaseAi;
import Logic.AI.TankAI.TankAI;
import Logic.Difficulty;
import Logic.GameController;
import main.Logic.Abilities.Ability;
import main.Logic.Map.Cell;
import main.Logic.Unit.Stats.Inteligence;
import main.Logic.Unit.Unit;

public class HealerAI extends BaseAIFeatures implements BaseAi{
    private Unit HealerAIUnit = null;
    private GameController CurrentGame = null;

    public HealerAI(Unit owner,GameController game){
        this.HealerAIUnit = owner;
        this.CurrentGame = game;
    }

    private int MINIMUM_HEALTH_PERCENT_TO_HEAL_IN_HARD = 75;

    @Override
    public void DefensiveBehavior() {
        if(this.CurrentGame.getCurrentDifficulty().equals(Difficulty.DifficultyStage.EASY)){
            return;
        }else{
            if(this.HealerAIUnit.getCurrentHPPercent()>=40){
                return ;
            }
        }
        if(this.HealerAIUnit.getRemainingMovement()==0){
            return;
        }
        String quad = this.determineSafestQuadrant(this.CurrentGame,this.HealerAIUnit);
        if(quad.equals("Center")){
            return;
        }else{
            ArrayList<Cell>cells = this.cellsInAQuadrantThatCanMoveTo(quad,this.HealerAIUnit);
            Cell toMove = this.cellAtBiggestDistance(cells,this.HealerAIUnit);
            this.HealerAIUnit.moveToCell(toMove);
        }
        Ability abl = this.getAbilityWithMostHealThatCanBeUsed(this.HealerAIUnit);
        abl.AffectTarget(this.HealerAIUnit);
    }

    private Unit unitWithLeastHp(ArrayList<Unit>allies){
        int HP = Integer.MAX_VALUE;
        Unit ret = null;

        for(int i=0;i<allies.size();++i){
            if(allies.get(i).getCurrentHPPercent()<HP){
                if(!allies.get(i).isDead()) {
                    HP = (int) allies.get(i).getCurrentHPPercent();
                    ret = allies.get(i);
                }
            }
        }

        return ret;
    }

    @Override
    public void OffensiveBehavior() {
        if(this.CurrentGame.getCurrentDifficulty().equals(Difficulty.DifficultyStage.HARD)){
            if(this.getAlliesWithOverPercentHealth(CurrentGame.getEnemies(),this.HealerAIUnit,
                    MINIMUM_HEALTH_PERCENT_TO_HEAL_IN_HARD,null)==0){
                return;
            }
        }
        ArrayList<Unit>allies = new ArrayList<Unit>();
        allies = this.CurrentGame.getEnemies();
        Unit target = this.unitWithLeastHp(allies);
        if(target == null){
            return;
        }
        Ability abl = this.getAbilityWithMostHealThatCanBeUsed(this.HealerAIUnit);
        if(abl == null){
            return;
        }
        ArrayList<Cell>cells = new ArrayList<Cell>();
        this.cellsFromWhereCanHitTargetWithAbility(abl,target,cells,this.HealerAIUnit);
        if(cells.size()==0){
            Cell cell = this.cellThatGetsClosestToTarget(this.HealerAIUnit,target);
            this.HealerAIUnit.moveToCell(cell);
            return;
        }else{
            Cell cell = this.cellAtSmalestDistance(cells,this.HealerAIUnit);
            this.HealerAIUnit.moveToCell(cell);
            abl.AffectTarget(target);
        }
        return;
    }

    @Override
    public void FullTurnBehavior() {
        this.OffensiveBehavior();
        this.DefensiveBehavior();
    }

    @Override
    public Unit getControledUnit() {
        return this.HealerAIUnit;
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
