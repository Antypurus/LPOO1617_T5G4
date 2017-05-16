package main.Logic.Unit;

import java.util.ArrayList;
import java.util.Random;

public class Unit {
    boolean shouldUpdate = false;

    private main.Logic.Map.Cell position = null;

    private String name=null;
    private ArrayList<Statistic> Stats = new ArrayList<Statistic>();
    private ArrayList<main.Logic.Abilities.Ability> Abilities = new ArrayList<main.Logic.Abilities.Ability>();

    //Position

    //primary resources
    private main.Logic.Unit.Stats.HP Health;// health points
    private main.Logic.Unit.Stats.MP Mana;// Mana points

    //primary scaling stats
    private main.Logic.Unit.Stats.Speed Speed; //Speed Stat
    private main.Logic.Unit.Stats.Inteligence Inteligence; //Intelligence Stat
    private main.Logic.Unit.Stats.Strenght Strength; //Strength Stat
    private main.Logic.Unit.Stats.Vitality Vitality; //Vitality Stat

    //Defensive Stats
    private main.Logic.Unit.Stats.Armor Armor; //Physical Resistance Stat
    private main.Logic.Unit.Stats.FireRes FireResistance; //Magic Fire Resistance Stat
    private main.Logic.Unit.Stats.WaterRes WaterResistence; //Magic Water Resistance Stat
    private main.Logic.Unit.Stats.EarthRes EarthResistence; //Magic Earth Resistance Stat
    private main.Logic.Unit.Stats.AirRes AirResistence; //Magic Air Resistance Stat

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

    public void addAbility(main.Logic.Abilities.Ability abl){
        int pos = findAbility(abl.name);
        if(pos==-1){
            this.Abilities.add(abl);
        }else{
            return;
        }
        return;
    }

    public double getHP(){
        return this.Health.EffectiveValue;
    }
    public double getMP(){
        return this.Mana.EffectiveValue;
    }
    public double getSTR(){
        return this.Strength.EffectiveValue;
    }
    public double getINT(){
        return this.Inteligence.EffectiveValue;
    }
    public double getVIT(){
        return this.Vitality.EffectiveValue;
    }
    public double getArmor(){
        return this.Armor.EffectiveValue;
    }
    public double getSPD(){
        return this.Speed.EffectiveValue;
    }

    public void takeDamage(double value){
        this.Health.queueModifier(-value);
        this.Health.update();
    }

    public String getName(){
        return this.name;
    }

    public Unit(String name,double INT,double STR,double SPD,double VIT,double Armor){
        this.name = name;
        this.Inteligence = new main.Logic.Unit.Stats.Inteligence(INT);
        this.Strength = new main.Logic.Unit.Stats.Strenght(STR);
        this.Speed = new main.Logic.Unit.Stats.Speed(SPD);
        this.Vitality = new main.Logic.Unit.Stats.Vitality(VIT);
        this.Health = new main.Logic.Unit.Stats.HP(this.Vitality);
        this.Mana = new main.Logic.Unit.Stats.MP(this.Inteligence);
        this.Armor = new main.Logic.Unit.Stats.Armor(Armor);
        this.FireResistance = new main.Logic.Unit.Stats.FireRes(this.Armor,this.Inteligence,this.Vitality);
        this.WaterResistence = new main.Logic.Unit.Stats.WaterRes(this.Armor,this.Inteligence,this.Speed);
        this.EarthResistence = new main.Logic.Unit.Stats.EarthRes(this.Armor,this.Inteligence,this.Strength);
        this.AirResistence = new main.Logic.Unit.Stats.AirRes(this.Inteligence,this.Strength,this.Vitality);
        this.setStats();
        this.update();
    }

    public void setPosition(main.Logic.Map.Cell position){
        this.position = position;
    }

    public main.Logic.Map.Cell getPosition(){
        return this.position;
    }

    public int getX(){
        if(this.position!=null){
            return this.position.getxPos();
        }else{
            return 0;
        }
    }

    public int getY(){
        if(this.position!=null){
            return this.position.getyPos();
        }else{
            return 0;
        }
    }

    private main.Logic.Map.Map map = null;

    private void unlinkAndLink(int x,int y){
        if(map!=null){
            this.position.setUnit(null);
            this.position = map.getCell(x,y);
            this.position.setUnit(this);
        }
    }

    public boolean move(int deltaX,int deltaY){
        if(this.position==null){
            return false;
        }
        int xPos=0;
        int yPos=0;
        xPos = this.getX();
        yPos = this.getY();
        this.map = this.position.getMap();
        if(map.getCell(xPos+deltaX,yPos+deltaY)==null){
            return false;
        }
        if(yPos+deltaY>=map.height||yPos+deltaY<0||xPos+deltaX>=map.width||xPos+deltaX<0){
            return false;
        }else{
            this.unlinkAndLink(xPos+deltaX,yPos+deltaY);
            map.update();
            return true;
        }
    }
}
