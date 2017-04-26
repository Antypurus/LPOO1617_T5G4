package Logic.Unit.Stats;

import Logic.Unit.Statistic;

public class Speed extends Statistic {

    public Speed(double speed){
        this.BaseValue = speed;
        this.Name = "SPD";
        this.EffectiveValue = this.BaseValue;
    }

    public void modifySpeed(double delta){
        this.BaseValue+=delta;
    }

    public void setSpeed(double speed){
        this.BaseValue = speed;
    }

    public double update(){
        this.EffectiveValue = this.BaseValue;
        for(int i=0;i<this.Deltas.size();++i){
            this.EffectiveValue+=this.Deltas.get(i);
        }
        return this.EffectiveValue;
    }

}
