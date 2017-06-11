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

    /**
     * add a delta modifiers to the stat , delta modifiers act as buffs and debuffs reducing or
     * increasing the maximum value of a given stat
     * @param delta delta value
     */
    public void addDelta(double delta){
        Deltas.add(delta);
    }

    /**
     * finds a delta in the arraylist of deltas and returns its index or -1 if it doesnt exist
     * @param delta delta value to look for
     * @return the index of the delta or -1
     */
    public int findDelta(double delta){
        for(int i=0;i<this.Deltas.size();i++){
            if(this.Deltas.get(i)==delta){
                return i;//value found
            }
        }
        return -1;//value not found
    }

    /**
     * removes a delta from the delta list
     * @param delta delta to remove
     * @return whether the delta was found or not and properly removed
     */
    public boolean removeDelta(double delta){
        int deltaPos = this.findDelta(delta);
        if(deltaPos==-1){
            System.out.println("Delta Value Not Found");
            return false;//value not found
        }else{
            this.Deltas.remove(deltaPos);
            return true;
        }
    }

    /**
     * queues a modifier into the stat , modifiers directly affect the current value of some stats
     * in this case only HP and MP
     * @param modifier
     */
    public void queueModifier(double modifier){
        this.modifiers.add(modifier);
    }

    /**
     * updates the values for the stat
     * @return the current effective value of the stat
     */
    public abstract double update();

    /**
     * modifies the base value by a given ammount , to be used if leveling up was implemented
     * @param delta value to modify by
     */
    public void modifyBase(double delta){
        this.BaseValue+=delta;
        this.update();
    }

    /**
     *
     * @return the name of the stat
     */
    public String getName(){
        return this.Name;
    }

}
