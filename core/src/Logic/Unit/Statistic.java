package Logic.Unit;

import java.util.ArrayList;

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
