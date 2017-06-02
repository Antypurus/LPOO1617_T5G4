package Logic.AI.HealerAI;


import java.util.ArrayList;

import Logic.AI.BaseAIFeatures;
import Logic.AI.BaseAi;
import Logic.AI.TankAI.TankAI;
import Logic.Difficulty;
import Logic.GameController;
import main.Logic.Abilities.Ability;
import main.Logic.Map.Cell;
import main.Logic.Unit.Unit;

public class HealerAI extends BaseAIFeatures implements BaseAi{
    private Unit HealerAIUnit = null;
    private GameController CurrentGame = null;

    public HealerAI(Unit owner,GameController game){
        this.HealerAIUnit = owner;
        this.CurrentGame = game;
    }

    @Override
    public void DefensiveBehavior() {
        if(this.CurrentGame.getCurrentDifficulty().equals(Difficulty.DifficultyStage.EASY)){
            return;
        }else{
            if(this.HealerAIUnit.getCurrentHPPercent()>=25){
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
    }

    @Override
    public void OffensiveBehavior() {

    }

    @Override
    public void FullTurnBehavior() {
        this.OffensiveBehavior();
        this.DefensiveBehavior();
    }

    @Override
    public Unit getControledUnit() {
        return null;
    }

    @Override
    public GameController getCurrentGameController() {
        return null;
    }

    @Override
    public Difficulty.DifficultyStage getDifficulty() {
        return null;
    }
}
