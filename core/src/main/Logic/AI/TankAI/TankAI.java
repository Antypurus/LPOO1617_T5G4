package Logic.AI.TankAI;

import Logic.AI.BaseAi;
import Logic.Difficulty;
import Logic.GameController;
import main.Logic.Unit.Unit;

public class TankAI implements BaseAi{

    private Unit TankAIUnit = null;
    private GameController CurrentGame = null;

    public TankAI(Unit owner,GameController game){
        this.TankAIUnit = owner;
        this.CurrentGame = game;
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
        //Do The Modeled AI Behavior
    }

    @Override
    public void OffensiveBehavior() {
        if(this.CurrentGame.getCurrentDifficulty().equals(Difficulty.DifficultyStage.HARD)){
            if(this.TankAIUnit.getCurrentHPPercent()<25){
                return ;
            }
        }
        //Do The AI Behavior Modeled
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
