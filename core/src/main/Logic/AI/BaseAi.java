package Logic.AI;

import Logic.Difficulty;
import Logic.GameController;
import main.Logic.Unit.Unit;

public interface BaseAi {
    /**
     * this methods will act on the defensive behavior scripted for the AI Type
     */
    public void DefensiveBehavior();

    /**
     *this methods will act on the offensive behavior scripted for the AI Type
     */
    public void OffensiveBehavior();

    /**
     * ecetutes the full behavior of the AI type , firs the offensive behavior then the defensive
     */
    public void FullTurnBehavior();

    /**
     *
     * @return the unit that is being controlled by the AI
     */
    public Unit getControledUnit();

    /**
     *
     * @return the game Controller of the game the unit is in
     */
    public GameController getCurrentGameController();

    /**
     *
     * @return the difficulty of the game
     */
    public Difficulty.DifficultyStage getDifficulty();
}
