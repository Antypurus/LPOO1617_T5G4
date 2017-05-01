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
        this.BaseValue = this.scale * this.vit.BaseValue;
        this.maxValue = this.BaseValue;

        for(int i=0;i<this.Deltas.size();++i){
            this.maxValue+=this.Deltas.get(i);
        }

        while(this.modifiers.size()!=0){
            this.EffectiveValue+=this.modifiers.poll();
        }
        if(this.EffectiveValue>this.maxValue){
            this.EffectiveValue = this.maxValue;
        }

        return this.EffectiveValue;
    }
}
