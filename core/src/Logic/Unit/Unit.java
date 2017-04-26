package Logic.Unit;

import java.util.ArrayList;
import java.util.Random;

import Logic.Abilities.Ability;
import Logic.Unit.Stats.AirRes;
import Logic.Unit.Stats.Armor;
import Logic.Unit.Stats.EarthRes;
import Logic.Unit.Stats.FireRes;
import Logic.Unit.Stats.HP;
import Logic.Unit.Stats.Inteligence;
import Logic.Unit.Stats.MP;
import Logic.Unit.Stats.Speed;
import Logic.Unit.Stats.Strenght;
import Logic.Unit.Stats.Vitality;
import Logic.Unit.Stats.WaterRes;

public class Unit {
    boolean shouldUpdate = false;

    String name=null;
    ArrayList<Statistic> Stats = new ArrayList<Statistic>();
    ArrayList<Ability> Abilities = new ArrayList<Ability>();

    //Position

    //primary resources
    HP Health;// health points
    MP Mana;// Mana points

    //primary scaling stats
    Speed Speed; //Speed Stat
    Inteligence Inteligence; //Intelligence Stat
    Strenght Strength; //Strength Stat
    Vitality Vitality; //Vitality Stat

    //Defensive Stats
    Armor Armor; //Physical Resistance Stat
    FireRes FireResistance; //Magic Fire Resistance Stat
    WaterRes WaterResistence; //Magic Water Resistance Stat
    EarthRes EarthResistence; //Magic Earth Resistance Stat
    AirRes AirResistence; //Magic Air Resistance Stat

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

    private void setStats(){
        this.Stats.add(this.Inteligence);
        this.Stats.add(this.Speed);
        this.Stats.add(this.Armor);
        this.Stats.add(this.Vitality);
        this.Stats.add(this.Strength);
        this.Stats.add(this.Health);
        this.Stats.add(this.Mana);
        this.Stats.add(this.AirResistence);
        this.Stats.add(this.EarthResistence);
        this.Stats.add(this.FireResistance);
        this.Stats.add(this.WaterResistence);
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
        this.Inteligence = new Inteligence();
        this.Strength = new Strenght(STR);
        this.Speed = new Speed(SPD);
        this.Vitality = new Vitality();
        this.Health = new HP(this.Vitality);
        this.Mana = new MP(this.Inteligence);
        this.Armor = new Armor(Armor);
        this.FireResistance = new FireRes(this.Armor,this.Inteligence,this.Vitality);
        this.WaterResistence = new WaterRes(this.Armor,this.Inteligence,this.Speed);
        this.EarthResistence = new EarthRes(this.Armor,this.Inteligence,this.Strength);
        this.AirResistence = new AirRes(this.Inteligence,this.Strength,this.Vitality);
        this.setStats();
        this.update();
    }
}
