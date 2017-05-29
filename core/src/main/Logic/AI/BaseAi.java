package Logic.AI;

import Logic.Difficulty;
import Logic.GameController;
import main.Logic.Unit.Unit;

public interface BaseAi {
    public void DefensiveBehavior();
    public void OffensiveBehavior();
    public void FullTurnBehavior();
    public Unit getControledUnit();
    public GameController getCurrentGameController();
    public Difficulty.DifficultyStage getDifficulty();
}
