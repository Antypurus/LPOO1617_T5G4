package Logic.Unit.Stats;

import Logic.Unit.Statistic;


public class AirRes extends Statistic{

    private boolean shoudlUpdate = false;

    private Inteligence inteligenc=null;
    private Strenght strenght = null;
    private Vitality vitality = null;

    private double intHash;
    private double strHash;
    private double vitHash;

    private int prevHash = this.Deltas.hashCode();


    public AirRes(Inteligence intel,Strenght str,Vitality vit){
        this.inteligenc = intel;
        this.strenght = str;
        this.vitality = vit;

        this.intHash = this.inteligenc.BaseValue;
        this.strHash = this.strenght.BaseValue;
        this.vitHash = this.vitality.BaseValue;

        this.BaseValue = intel.BaseValue + str.BaseValue + vit.BaseValue;
        this.EffectiveValue = BaseValue;
        this.Name = "ARES";
    }

    private void baseValueUpdate(){
        if(this.vitHash!=this.vitality.BaseValue||this.intHash!=this.inteligenc.BaseValue||
                this.strHash!=this.strenght.BaseValue){
            this.BaseValue = this.strenght.BaseValue + this.inteligenc.BaseValue +
                    this.vitality.BaseValue;
            this.EffectiveValue = this.BaseValue;
            this.shoudlUpdate = true;
        }
    }

    public double update(){
        this.baseValueUpdate();
        if(this.prevHash!=this.Deltas.hashCode()||this.shoudlUpdate) {
            this.EffectiveValue = this.BaseValue;
            for (int i = 0; i < this.Deltas.size(); ++i) {
                this.EffectiveValue += this.Deltas.get(i);
            }
            this.prevHash = this.Deltas.hashCode();
            this.shoudlUpdate = false;
        }

        return EffectiveValue;
    }



}
