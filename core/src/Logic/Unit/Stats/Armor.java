package Logic.Unit.Stats;

import Logic.Unit.Statistic;

public class Armor  extends Statistic{

    int prevHash;

    public Armor(double val){
        this.BaseValue = val;
        this.EffectiveValue = this.BaseValue;
        this.Name = "ARMR";
        this.prevHash = this.Deltas.hashCode();
    }

    public double update(){
        if(this.prevHash!=this.Deltas.hashCode()){
            this.EffectiveValue = this.BaseValue;
            for(int i = 0;i<this.Deltas.size();++i){
                this.EffectiveValue+=this.Deltas.get(i);
            }
            this.prevHash = this.Deltas.hashCode();
        }
        return this.EffectiveValue;
    }
}
