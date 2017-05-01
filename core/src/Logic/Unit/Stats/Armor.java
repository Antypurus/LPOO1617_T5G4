package Logic.Unit.Stats;

import Logic.Unit.Statistic;

public class Armor  extends Statistic{

    private int prevHash;
    private boolean needUpdate = false;

    public Armor(double val){
        this.BaseValue = val;
        this.EffectiveValue = this.BaseValue;
        this.Name = "ARMR";
        this.prevHash = this.Deltas.hashCode();
    }

    public void modifyArmor(double delta){
        this.BaseValue += delta;
        this.needUpdate = true;
        this.update();
    }

    public void setArmor(double armor){
        this.BaseValue = armor;
        this.needUpdate = true;
        this.update();
    }

    public double update(){
        if(this.prevHash!=this.Deltas.hashCode()||this.needUpdate){
            this.EffectiveValue = this.BaseValue;
            for(int i = 0;i<this.Deltas.size();++i){
                this.EffectiveValue+=this.Deltas.get(i);
            }
            this.prevHash = this.Deltas.hashCode();
            this.needUpdate = false;
        }
        return this.EffectiveValue;
    }
}