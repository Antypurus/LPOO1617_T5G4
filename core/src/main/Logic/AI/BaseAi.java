package Logic.AI;

import Logic.GameController;
import main.Logic.Unit.Unit;

public interface BaseAi {
    public void DefensiveBehavior();
    public void OffensiveBehavior();
    public Unit getControledUnit();
    public GameController getCurrentGameController();
}
