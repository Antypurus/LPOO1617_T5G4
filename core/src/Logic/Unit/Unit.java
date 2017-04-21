package Logic.Unit;

import com.badlogic.gdx.utils.Array;

import java.util.ArrayList;

import Logic.Abilities.Ability;
import Logic.Abilities.Statistic;

public class Unit {
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
    Statistic Inteligence = new Statistic("INT"); //Intelligence Stat
    Statistic Strength = new Statistic("STR"); //Strength Stat
    Statistic Vitality = new Statistic("VIT"); //Vitality Stat

    //Defensive Stats
    Statistic Armor = new Statistic("ARM"); //Physical Resistance Stat
    Statistic FireResistance = new Statistic("FRES"); //Magic Fire Resistance Stat
    Statistic WaterResistence = new Statistic("WRES"); //Magic Water Resistance Stat
    Statistic EarthResistence = new Statistic("ERES"); //Magic Earth Resistance Stat
    Statistic AirResistence = new Statistic("ARES"); //Magic Air Resistance Stat

    public void update(){
        this.HP.BaseValue = this.Vitality.BaseValue * 10;
        this.MP.BaseValue = this.Inteligence.BaseValue * 5;

        this.FireResistance.BaseValue = this.Armor.BaseValue * this.Inteligence.BaseValue * this.Vitality.BaseValue;
        this.WaterResistence.BaseValue = this.Armor.BaseValue * this.Inteligence.BaseValue * this.Speed.BaseValue;
        this.EarthResistence.BaseValue = this.Armor.BaseValue * this.Inteligence.BaseValue * this.Strength.BaseValue;
        this.AirResistence.BaseValue = this.Inteligence.BaseValue * this.Strength.BaseValue * this.Vitality.BaseValue;

        for(int i = 0;i<this.Stats.size();i++){
            this.Stats.get(i).update();
        }
        this.shouldUpdate = false;
        //reduce budd debuff duration.
    }

    public Unit(String name,double INT,double STR,double SPD,double VIT,double Armor){
        this.name = name;
        this.Inteligence.BaseValue = INT;
        this.Stats.add(this.Inteligence);
        this.Strength.BaseValue = STR;
        this.Stats.add(this.Strength);
        this.Vitality.BaseValue = VIT;
        this.Stats.add(this.Vitality);
        this.Speed.BaseValue = SPD;
        this.Stats.add(this.Speed);
        this.Armor.BaseValue = Armor;
        this.Stats.add(this.Armor);
        this.update();
    }
}
