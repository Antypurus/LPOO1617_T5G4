package Logic.Unit.Stats;

import Logic.Unit.Statistic;

public class Strenght extends Statistic{

    private int prevHash = this.Deltas.hashCode();
    private boolean needUpdate = false;

    public Strenght(double strenght){
        this.BaseValue = strenght;
        this.EffectiveValue = this.BaseValue;
        this.Name = "STR";
    }

    public void modifyStrength(double delta){
        this.BaseValue+=delta;
        this.needUpdate = true;
        this.update();
    }

    public void setStrength(double strength){
        this.BaseValue = strength;
        this.needUpdate = true;
        this.update();
    }

    public double update(){
        if(this.prevHash!=this.Deltas.hashCode()||this.needUpdate){
            this.EffectiveValue = this.BaseValue;
            for(int i=0;i<this.Deltas.size();++i){
                this.EffectiveValue+=this.Deltas.get(i);
            }
            this.prevHash = this.Deltas.hashCode();
            this.needUpdate = false;
        }
        return this.EffectiveValue;
    }

}
