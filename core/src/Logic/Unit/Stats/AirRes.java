package Logic.Unit.Stats;

import Logic.Unit.Statistic;


public class AirRes extends Statistic{

    private boolean shoudlUpdate = false;

    private Inteligence inteligenc=null;
    private Strenght strenght = null;
    private Vitality vitality = null;

    private int intHash;
    private int strHash;
    private int vitHash;

    private int prevHash = this.Deltas.hashCode();


    public AirRes(Inteligence intel,Strenght str,Vitality vit){
        this.inteligenc = intel;
        this.strenght = str;
        this.vitality = vit;

        this.intHash = this.inteligenc.hashCode();
        this.strHash = this.strenght.hashCode();
        this.vitHash = this.vitality.hashCode();

        this.BaseValue = intel.BaseValue + str.BaseValue + vit.BaseValue;
        this.EffectiveValue = BaseValue;
        this.Name = "ARES";
    }

    private void baseValueUpdate(){
        if(this.vitHash!=this.vitality.hashCode()||this.intHash!=this.inteligenc.hashCode()||
                this.strHash!=this.strenght.hashCode()){
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
