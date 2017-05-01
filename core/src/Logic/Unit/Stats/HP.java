package Logic.Unit.Stats;

import Logic.Unit.Statistic;

public class HP extends Statistic{

    private Vitality vit;
    private double scale = 10;

    public HP(Vitality vit){
        this.Name = "HP";
        this.vit = vit;

        this.BaseValue = this.scale*this.vit.BaseValue;
        this.EffectiveValue = this.BaseValue;
        this.maxValue = this.BaseValue;
    }

    public double update(){
        return 0;
    }
}
