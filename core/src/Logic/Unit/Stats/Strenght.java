package Logic.Unit.Stats;

import Logic.Unit.Statistic;

public class Strenght extends Statistic{

    int prevHash = this.Deltas.hashCode();

    public Strenght(double strenght){
        this.BaseValue = strenght;
        this.EffectiveValue = this.BaseValue;
        this.Name = "STR";
    }

    public void modifyStrength(double delta){
        this.BaseValue+=delta;
    }

    public void setStrength(double strength){
        this.BaseValue = strength;
    }

    public double update(){
        if(this.prevHash!=this.Deltas.hashCode()){
            this.EffectiveValue = this.BaseValue;
            for(int i=0;i<this.Deltas.size();++i){
                this.EffectiveValue+=this.Deltas.get(i);
            }
            this.prevHash = this.Deltas.hashCode();
        }
        return 0;
    }

}
