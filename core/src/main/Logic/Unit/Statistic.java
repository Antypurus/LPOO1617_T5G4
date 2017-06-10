package main.Logic.Unit;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public abstract class Statistic {

    protected String Name="";
    public double BaseValue=0;
    public double maxValue =0;
    public double EffectiveValue=0;//TODO:current stat value to work with
    public ArrayList<Double> Deltas = new ArrayList<Double>();//buff related deltas
    public Queue<Double> modifiers = new LinkedList<Double>();//queues generic modificcation to effective value

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

    public abstract double update();

    public void modifyBase(double delta){
        this.BaseValue+=delta;
        this.update();
    }

    public String getName(){
        return this.Name;
    }

}
