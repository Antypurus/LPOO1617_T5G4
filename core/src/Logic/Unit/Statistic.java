package Logic.Unit;

import java.util.ArrayList;

import Logic.Abilities.Ability;

public class Statistic {

    private String Name="";
    public double BaseValue=0;
    public double EffectiveValue=0;
    public ArrayList<Double> Deltas = new ArrayList<Double>();

    public Statistic(String name){
        this.Name = name;
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

    public double update(){
        this.EffectiveValue = 0;
        this.EffectiveValue+=this.BaseValue;
        for(int i=0;i<this.Deltas.size();i++){
            this.EffectiveValue+=this.Deltas.get(i);
        }
        return this.EffectiveValue;
    }

    public String getName(){
        return this.Name;
    }

}
