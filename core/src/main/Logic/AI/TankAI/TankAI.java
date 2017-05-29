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
