package main.Logic.Unit.Stats;

public class EarthRes extends main.Logic.Unit.Statistic {

    private int prevHash = this.Deltas.hashCode();
    private boolean shouldUpdate = false;

    private double intHash;
    private double strHash;
    private double armHash;

    private Armor armor = null;
    private Inteligence inteligence = null;
    private Strenght strenght = null;

    public EarthRes(Armor armor,Inteligence intel,Strenght str){
        this.armor = armor;
        this.inteligence = intel;
        this.strenght = str;
        this.Name = "ERES";

        this.intHash = intel.BaseValue;
        this.strHash = str.BaseValue;
        this.armHash = armor.BaseValue;

        this.BaseValue = this.armor.BaseValue + this.inteligence.BaseValue + this.strenght.BaseValue;
        this.EffectiveValue = this.BaseValue;
    }

    private void baseValueUpdate(){
        if(this.intHash!=this.inteligence.BaseValue||this.armHash!=this.armor.BaseValue||
                this.strHash!=this.strenght.BaseValue){
            this.BaseValue = this.inteligence.BaseValue+this.strenght.BaseValue+this.armor.BaseValue;
            this.EffectiveValue = this.BaseValue;
            this.shouldUpdate = true;
        }
    }

    public double update(){
        this.baseValueUpdate();
        if(this.prevHash!=this.Deltas.hashCode()||this.shouldUpdate){
            this.EffectiveValue = this.BaseValue;
            for(int i=0;i<this.Deltas.size();++i){
                this.EffectiveValue+=this.Deltas.get(i);
            }
            this.prevHash = this.Deltas.hashCode();
            this.shouldUpdate = false;
            this.intHash = this.inteligence.BaseValue;
            this.strHash = this.strenght.BaseValue;
            this.armHash = this.armor.BaseValue;
        }
        return this.EffectiveValue;
    }
}
