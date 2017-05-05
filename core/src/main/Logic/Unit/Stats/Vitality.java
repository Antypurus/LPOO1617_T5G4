package main.Logic.Unit.Stats;

public class Vitality extends main.Logic.Unit.Statistic {

    private boolean needUpdate = false;
    private int prevHash = this.Deltas.hashCode();

    public Vitality(double vitality){
        this.BaseValue = vitality;
        this.EffectiveValue = this.BaseValue;
        this.Name = "VIT";
    }

    public void modifyVitality(double delta){
        this.BaseValue += delta;
        this.needUpdate = true;
        this.update();
    }

    public void setVitality(double vitality){
        this.BaseValue = vitality;
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
