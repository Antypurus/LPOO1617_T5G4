package main.Logic.Unit.Stats;

public class HP extends main.Logic.Unit.Statistic {

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
            if(this.maxValue<=0){
                this.maxValue = 1;
            }
        }
        while(this.modifiers.size()!=0){
            this.EffectiveValue+=this.modifiers.poll();
        }
        if(this.EffectiveValue>this.maxValue){
            this.EffectiveValue = this.maxValue;
        }
        if(this.EffectiveValue<0){
            this.EffectiveValue = 0;
        }

        return this.EffectiveValue;
    }
}