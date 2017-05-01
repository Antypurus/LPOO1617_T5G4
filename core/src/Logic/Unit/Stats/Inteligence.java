package Logic.Unit.Stats;

import Logic.Unit.Statistic;

public class Inteligence extends Statistic{

    private int prevHash = this.Deltas.hashCode();
    private boolean needUpdate = false;

    public Inteligence(double inteligence){
        this.BaseValue = inteligence;
        this.EffectiveValue = this.BaseValue;
        this.Name = "INT";
    }

    public void modifyInteligence(double delta){
        this.BaseValue+=delta;
        this.needUpdate = true;
        this.update();
    }

    public void setInteligence(double inteligence){
        this.BaseValue = inteligence;
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
