package main.Logic.Unit.Stats;

import main.Logic.Unit.Statistic;

public class FireRes extends Statistic{

    private int prevHash = this.Deltas.hashCode();
    private boolean shouldUpdate = false;

    private double intHash;
    private double armorHash;
    private double vitHash;

    private Armor armor = null;
    private main.Logic.Unit.Stats.Inteligence inteligence = null;
    private main.Logic.Unit.Stats.Vitality vitality = null;

    public FireRes(Armor armor, main.Logic.Unit.Stats.Inteligence intel, main.Logic.Unit.Stats.Vitality vit){
        this.inteligence = intel;
        this.armor = armor;
        this.vitality = vit;
        this.Name = "FRES";

        this.intHash = this.inteligence.BaseValue;
        this.armorHash = this.armor.BaseValue;
        this.vitHash = this.vitality.BaseValue;

        this.BaseValue = this.inteligence.BaseValue + this.armor.BaseValue + this.vitality.BaseValue;
        this.EffectiveValue = this.BaseValue;
    }

    private void baseValueUpdate(){
        if(this.intHash!=this.inteligence.BaseValue||this.vitHash!=this.vitality.BaseValue
                ||this.armorHash!=this.armor.BaseValue){
            this.BaseValue = this.inteligence.BaseValue+this.armor.BaseValue+this.vitality.BaseValue;
            this.EffectiveValue=this.BaseValue;
            this.shouldUpdate = true;
        }
    }

    public double update(){
        this.baseValueUpdate();
        if(this.prevHash!=this.Deltas.hashCode()||shouldUpdate){
            this.EffectiveValue = this.BaseValue;
            for(int i=0;i<this.Deltas.size();++i){
                this.EffectiveValue+=this.Deltas.get(i);
            }
            this.prevHash = this.Deltas.hashCode();
            this.shouldUpdate = false;
            this.intHash = this.inteligence.BaseValue;
            this.armorHash = this.armor.BaseValue;
            this.vitHash = this.vitality.BaseValue;
        }
        return 0;
    }
}
