package Logic.AI.DPSAI;

import Logic.AI.BaseAIFeatures;
import Logic.AI.BaseAi;
import Logic.Difficulty;
import Logic.GameController;
import main.Logic.Unit.Unit;

public class DPSAI extends BaseAIFeatures implements BaseAi{

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
