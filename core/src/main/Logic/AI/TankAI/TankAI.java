package Logic.AI.TankAI;

import java.util.ArrayList;

import Logic.AI.BaseAIFeatures;
import Logic.AI.BaseAi;
import Logic.Difficulty;
import Logic.GameController;
import main.Logic.Abilities.Ability;
import main.Logic.Unit.Stats.Inteligence;
import main.Logic.Unit.Unit;

public class TankAI extends BaseAIFeatures implements BaseAi{

    private Unit TankAIUnit = null;
    private GameController CurrentGame = null;

    public TankAI(Unit owner,GameController game){
        this.TankAIUnit = owner;
        this.CurrentGame = game;
    }

    private Unit determineClosestEnemy(){
        ArrayList<Unit>enemies = this.CurrentGame.getEnemies();
        Unit ret = null;
        int ret_dist = Integer.MAX_VALUE;
        for(int i=0;i<enemies.size();i++){
            int dist = (int)this.TankAIUnit.getPosition().distanceToCell(enemies.get(i).getPosition());
            if(ret == null){
                ret = enemies.get(i);
            }
            if(dist < ret_dist){
                ret_dist = dist;
                ret = enemies.get(i);
            }
        }
        return ret;
    }

    private Unit easyDeterminBestTarget(){
        Unit ret = null;
        ret = this.determineClosestEnemy();
        return ret;
    }

    private Ability abilityWithMostDamage(){
        return null;
    }

    private void easyOffenseBehavior(){

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
        if(this.TankAIUnit.getRemainingMovement()==0){
            return;
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
        if(this.numberOfOffensivAbilitiesAvailableToUse(this.TankAIUnit)==0){
            return;
        }
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
