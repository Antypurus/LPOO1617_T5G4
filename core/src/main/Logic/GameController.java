package Logic;

import java.util.ArrayList;
import java.util.PriorityQueue;

import main.Logic.Unit.Unit;

public class GameController {
    private ArrayList<Unit>enemies = new ArrayList<Unit>();
    private ArrayList<Unit>allies = new ArrayList<Unit>();
    private PriorityQueue<Unit>units = new PriorityQueue<Unit>();
    private Difficulty.DifficultyStage currentDifficulty = null;
    private int numberOfChars = 0;
    private int selectedChar = 0;
    private Unit currentChar = null;

    public GameController(Unit[] allies,Unit[] enemies,Difficulty.DifficultyStage difficultyStage){
        this.currentDifficulty = difficultyStage;
        for(int i=0;i<allies.length;++i){
            allies[i].setIsAlly(true);
            this.allies.add(allies[i]);
            this.units.add(allies[i]);
            numberOfChars++;
        }
        for(int i=0;i<enemies.length;++i){
            enemies[i].setIsAlly(false);
            this.enemies.add(enemies[i]);
            this.units.add(enemies[i]);
            numberOfChars++;
        }
        this.currentChar = this.units.peek();
    }
}
