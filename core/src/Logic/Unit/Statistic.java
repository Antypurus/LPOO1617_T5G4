package Logic.Unit;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

import Logic.Abilities.Ability;

public abstract class Statistic {

    protected String Name="";
    public double BaseValue=0;
    public double maxValue =0;
    public double EffectiveValue=0;//current stat value to work with
    public ArrayList<Double> Deltas = new ArrayList<Double>();//buff related deltas
    public Queue<Double> modifiers ;

    public void instantiate(double baseValue){
        this.BaseValue = baseValue;
        this.EffectiveValue = baseValue;
    }

    public void addDelta(double delta){
        Deltas.add(delta);
    }

    public int findDelta(double delta){
        for(int i=0;i<this.Deltas.size();i++){
            if(this.Deltas.get(i)==delta){
                return i;//value found
            }
        }
        return -1;//value not found
    }

    public boolean removeDelta(double delta){
        int deltaPos = this.findDelta(delta);
        if(deltaPos==-1){
            System.out.println("Delta Value Not Found");
            return false;//value not found
        }else{
            this.Deltas.remove(deltaPos);
        }
        return false;
    }

    public void queueModifier(double modifier){
        this.modifiers.add(modifier);
    }

    public double update(){
        this.maxValue = 0;
        this.maxValue+=this.BaseValue;
        for(int i=0;i<this.Deltas.size();i++){
            this.maxValue+=this.Deltas.get(i);
        }
        while(this.modifiers.size()!=0){
            this.EffectiveValue+=this.modifiers.poll();
        }
        if(this.EffectiveValue>=this.maxValue){
            this.EffectiveValue = this.maxValue;
        }
        return this.EffectiveValue;
    }

    public String getName(){
        return this.Name;
    }

}
