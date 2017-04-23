package Logic.Unit;

import java.util.ArrayList;

import Logic.Abilities.Ability;

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

    private int find_stat(String StatName){
        for(int i=0;i<this.Stats.size();i++){
            if(this.Stats.get(i).getName().equals(StatName)){
                return i;
            }
        }
        return -1;
    }

    private void addStat(Statistic stat,double baseValue){
        if(baseValue<=0){
            baseValue = 1;
        }
        stat.BaseValue = baseValue;
        int check = this.find_stat(stat.getName());
        if(check==-1){
            this.Stats.add(stat);
        }
        return;
    }

    public Unit(String name,double INT,double STR,double SPD,double VIT,double Armor){
        this.name = name;
        this.addStat(this.Inteligence,INT);
        this.addStat(this.Strength,STR);
        this.addStat(this.Speed,SPD);
        this.addStat(this.Vitality,VIT);
        this.addStat(this.Armor,Armor);
        System.out.println(this.Stats.get(this.find_stat("INT")).BaseValue);
        this.update();
    }
}
