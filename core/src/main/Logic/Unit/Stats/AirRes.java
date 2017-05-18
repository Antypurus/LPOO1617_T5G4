package main.Logic.Unit.Stats;


public class AirRes extends main.Logic.Unit.Statistic {

    private boolean shoudlUpdate = false;

    private Inteligence inteligenc=null;
    private main.Logic.Unit.Stats.Strenght strenght = null;
    private main.Logic.Unit.Stats.Vitality vitality = null;

    private double intHash;
    private double strHash;
    private double vitHash;

    private int prevHash = this.Deltas.hashCode();


    public AirRes(Inteligence intel, main.Logic.Unit.Stats.Strenght str, main.Logic.Unit.Stats.Vitality vit){
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
            this.vitHash = this.vitality.BaseValue;
            this.intHash = this.inteligenc.BaseValue;
            this.strHash = this.strenght.BaseValue;
        }

        return EffectiveValue;
    }



}
