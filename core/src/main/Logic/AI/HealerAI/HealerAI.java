package Logic.AI.HealerAI;


import Logic.AI.BaseAIFeatures;
import Logic.AI.BaseAi;
import Logic.AI.TankAI.TankAI;
import Logic.Difficulty;
import Logic.GameController;
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
        
    }

    @Override
    public void OffensiveBehavior() {

    }

    @Override
    public void FullTurnBehavior() {

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
