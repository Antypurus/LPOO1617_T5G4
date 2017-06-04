package Logic.AI.DPSAI;

import java.util.ArrayList;

import Logic.AI.BaseAIFeatures;
import Logic.AI.BaseAi;
import Logic.Difficulty;
import Logic.GameController;
import main.Logic.Abilities.Ability;
import main.Logic.ElementSystem.Element;
import main.Logic.Map.Cell;
import main.Logic.Unit.Unit;

public class DPSAI extends BaseAIFeatures implements BaseAi{
    private Unit DPSAIUnit = null;
    private GameController CurrentGame = null;

    public DPSAI(Unit owner,GameController game){
        this.DPSAIUnit = owner;
        this.CurrentGame = game;
    }

    private void easyOffensiveBehavior(){
        Unit target = this.determineClosestEnemy(this.CurrentGame,this.DPSAIUnit);
        if(this.DPSAIUnit.getMP()>0){
            Ability abl = this.abilityWithMostDamage(this.DPSAIUnit);
            if(this.getDifficulty().equals(Difficulty.DifficultyStage.HARD)){//looking for an ability that will utilize the affinity power
                if(target.getAfinity()!=null){
                    Element el = new Element();
                    for(int i=0;i<this.DPSAIUnit.getAbilities().size();++i){
                        if(el.ElementComparation(this.DPSAIUnit.getAbilities().get(i).getDamageElement(),target.getAfinity())==2){
                            abl = this.DPSAIUnit.getAbilities().get(i);
                        }
                    }
                }
            }
            ArrayList<Cell> cells = new ArrayList<Cell>();
            this.cellsFromWhereCanHitTargetWithAbility(abl,target,cells,this.DPSAIUnit);
            if(cells.size()==0){//cant thit
                if(this.DPSAIUnit.getMP()-abl.getManaCost()<0){//cant hit because of lack of mana
                    for(int i=0;i<this.DPSAIUnit.getAbilities().size();++i){
                        abl = this.DPSAIUnit.getAbilities().get(i);
                        cells.clear();
                        this.cellsFromWhereCanHitTargetWithAbility(abl,target,cells,this.DPSAIUnit);
                        if(cells.size()!=0){
                            Cell cell = this.cellAtSmalestDistance(cells,this.DPSAIUnit);
                            this.DPSAIUnit.moveToCell(cell);
                            abl.AffectTarget(target);
                            return;
                        }
                    }
                }else{//cant hit because of distance
                    Cell cell = this.cellThatGetsClosestToTarget(this.DPSAIUnit,target);
                    this.DPSAIUnit.moveToCell(cell);
                }
            }else{//can hit
                Cell cell = this.cellAtSmalestDistance(cells,this.DPSAIUnit);
                this.DPSAIUnit.moveToCell(cell);
                abl.AffectTarget(target);
            }
        }else{
            return;//doesnt have mana
        }
        return;//doesnt have a single ability with mana for.
    }

    @Override
    public void DefensiveBehavior() {
        if(this.CurrentGame.getCurrentDifficulty().equals(Difficulty.DifficultyStage.EASY)){
            return;
        }else{
            if(this.DPSAIUnit.getCurrentHPPercent()>=35){
                return ;
            }
        }
        if(this.DPSAIUnit.getRemainingMovement()==0){
            return;
        }
        String quad = this.determineSafestQuadrant(this.CurrentGame,this.DPSAIUnit);
        if(quad.equals("Center")){
            return;
        }else{
            ArrayList<Cell>cells = this.cellsInAQuadrantThatCanMoveTo(quad,this.DPSAIUnit);
            Cell toMove = this.cellAtBiggestDistance(cells,this.DPSAIUnit);
            this.DPSAIUnit.moveToCell(toMove);
        }
    }

    @Override
    public void OffensiveBehavior() {
        this.easyOffensiveBehavior();
    }

    @Override
    public void FullTurnBehavior() {
        this.OffensiveBehavior();
        this.DefensiveBehavior();
    }

    @Override
    public Unit getControledUnit() {
        return this.DPSAIUnit;
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
