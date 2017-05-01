package Logic.Unit.Stats;

import Logic.Unit.Statistic;

public class Speed extends Statistic {

    private int prevHash = this.Deltas.hashCode();
    private boolean needUpdate = false;

    public Speed(double speed){
        this.BaseValue = speed;
        this.Name = "SPD";
        this.EffectiveValue = this.BaseValue;
    }

    public void modifySpeed(double delta){
        this.BaseValue+=delta;
        this.needUpdate = true;
        this.update();
    }

    public void setSpeed(double speed){
        this.BaseValue = speed;
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
