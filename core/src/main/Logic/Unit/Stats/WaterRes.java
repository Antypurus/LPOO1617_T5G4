package main.Logic.Unit.Stats;

public class WaterRes extends main.Logic.Unit.Statistic {

    private Armor armor = null;
    private Inteligence inteligence = null;
    private Speed speed = null;

    private double armorHash;
    private double intHash;
    private double speedHash;

    private int prevHash = this.Deltas.hashCode();
    private boolean needUpdate = false;

    public WaterRes(Armor armor,Inteligence intel,Speed speed){
        this.inteligence = intel;
        this.armor = armor;
        this.speed = speed;

        this.intHash = this.inteligence.BaseValue;
        this.speedHash = this.speed.BaseValue;
        this.armorHash = this.armor.BaseValue;

        this.BaseValue = this.inteligence.BaseValue + this.armor.BaseValue + this.speed.BaseValue;
        this.EffectiveValue = this.BaseValue;
        this.Name = "WRES";
    }

    public void baseValueUpdate(){
        if(armorHash!=this.armor.BaseValue||this.intHash!=this.inteligence.BaseValue
                ||this.speedHash!=this.speed.BaseValue){
            this.BaseValue = this.inteligence.BaseValue + this.armor.BaseValue + this.speed.BaseValue;
            this.EffectiveValue = this.BaseValue;
            this.needUpdate = true;
        }
    }

    public double update(){
        this.baseValueUpdate();
        if(this.prevHash!=this.Deltas.hashCode()||this.needUpdate){
            this.EffectiveValue = this.BaseValue;
            for(int i=0;i<this.Deltas.size();++i){
                this.EffectiveValue+=this.Deltas.get(i);
            }
            this.prevHash=this.Deltas.hashCode();
            this.needUpdate=false;
        }
        return this.EffectiveValue;
    }
}
