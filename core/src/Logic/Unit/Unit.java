package Logic.Unit;

import java.util.ArrayList;
import java.util.Random;

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

    public double generateDodgeVal(){
        double speed = this.Speed.EffectiveValue;
        Random generator = new Random();
        double dodge = generator.nextDouble()*100;
        dodge+=speed;
        if(dodge>100){
            dodge = 100;
        }
        return dodge;
    }

    public void update(){
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
        stat.instantiate(baseValue);
        int check = this.find_stat(stat.getName());
        if(check==-1){
            this.Stats.add(stat);
        }
        return;
    }

    private int findAbility(String AbilityName){
        for(int i = 0;i<Abilities.size();i++){
            if(this.Abilities.get(i).name.equals(AbilityName)){
                return i;
            }
        }
        return -1;
    }

    public void addAbility(Ability abl){
        int pos = findAbility(abl.name);
        if(pos==-1){
            this.Abilities.add(abl);
        }else{
            return;
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
        this.addStat(this.HP,this.Vitality.BaseValue * 10);
        this.addStat(this.MP,this.Inteligence.BaseValue * 5);
        this.addStat(this.FireResistance,this.Armor.BaseValue * this.Inteligence.BaseValue * this.Vitality.BaseValue);
        this.addStat(this.WaterResistence,this.Armor.BaseValue * this.Inteligence.BaseValue * this.Speed.BaseValue);
        this.addStat(this.EarthResistence,this.Armor.BaseValue * this.Inteligence.BaseValue * this.Strength.BaseValue);
        this.addStat(this.AirResistence,this.Inteligence.BaseValue * this.Strength.BaseValue * this.Vitality.BaseValue);
        this.update();
    }
}
