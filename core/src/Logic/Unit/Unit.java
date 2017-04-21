package Logic.Unit;

import com.badlogic.gdx.utils.Array;

import java.util.ArrayList;

import Logic.Abilities.Ability;
import Logic.Abilities.Statistic;

public abstract class Unit {
    boolean shouldUpdate = false;

    String name=null;
    ArrayList<Statistic> Stats = new ArrayList<Statistic>();
    ArrayList<Ability> Abilities = new ArrayList<Ability>();

    //Position

    //primary resources
    Statistic HP = new Statistic("HP");// health points
    Statistic MP = new Statistic("MP");// Mana points

    //primary scaling stats
    Statistic Speed = new Statistic("SPD"); //Speed Stat
    Statistic Inteligent = new Statistic("INT"); //Intelligence Stat
    Statistic Strength = new Statistic("STR"); //Strength Stat
    Statistic Vitality = new Statistic("VIT"); //Vitality Stat

    //Defensive Stats
    Statistic Armor = new Statistic("ARM"); //Physical Resistance Stat
    Statistic FireResistance = new Statistic("FRES"); //Magic Fire Resistance Stat
    Statistic WaterResistence = new Statistic("WRES"); //Magic Water Resistance Stat
    Statistic EarthResistence = new Statistic("ERES"); //Magic Earth Resistance Stat
    Statistic AirResistence = new Statistic("ARES"); //Magic Air Resistance Stat

    public void update(){
        for(int i = 0;i<this.Stats.size();i++){
            this.Stats.get(i).update();
        }
        this.shouldUpdate = false;
        //reduce budd debuff duration.
    }

}
