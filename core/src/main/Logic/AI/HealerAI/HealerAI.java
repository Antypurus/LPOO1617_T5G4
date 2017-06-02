package Logic.AI.HealerAI;


import Logic.AI.TankAI.TankAI;
import Logic.GameController;
import main.Logic.Unit.Unit;

public class HealerAI{
    private Unit HealerAIUnit = null;
    private GameController CurrentGame = null;

    public HealerAI(Unit owner,GameController game){
        this.HealerAIUnit = owner;
        this.CurrentGame = game;
    }
}
