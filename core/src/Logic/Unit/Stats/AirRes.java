package Logic.Unit.Stats;

import Logic.Unit.Statistic;


public class AirRes extends Statistic{

    public AirRes(Inteligence intel,Strenght str,Vitality vit){
        this.BaseValue = intel.BaseValue * str.BaseValue * vit.BaseValue;
        this.EffectiveValue = BaseValue;
        this.Name = "ARES";
    }

}
