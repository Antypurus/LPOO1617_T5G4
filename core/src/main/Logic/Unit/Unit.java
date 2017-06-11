package main.Logic.Unit;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

import Logic.AI.BaseAi;
import main.Logic.Map.Cell;
import main.Logic.Map.Map;

public class Unit implements Comparable<Unit> {

    private BaseAi AI = null;

    private static int Identifier = 0;
    private int ID = -1;

    private boolean shouldUpdate = false;
    private boolean testMode = false;
    private double testModeValue = 0;
    private boolean isAIControlled = false;

    private boolean isAlly = false;

    private boolean dead = false;

    private int movementsPerTurn = 0;
    private int remainingMovement = 0;

    private main.Logic.Map.Map map = null;

    private main.Logic.ElementSystem.Element.DamageElement Afinity = null;

    private main.Logic.Map.Cell position = null;

    private String name=null;
    private ArrayList<Statistic> Stats = new ArrayList<Statistic>();
    private ArrayList<main.Logic.Abilities.Ability> Abilities = new ArrayList<main.Logic.Abilities.Ability>();

    //TODO:primary resources
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

    //Afinity

    /**
     * Sets the Elemental affinity of this character, this will be used with abilities to increase
     * or reduce damage values
     * @param Afinity Affinity to set this character
     */
    public void setAfinity(main.Logic.ElementSystem.Element.DamageElement Afinity){
        this.Afinity = Afinity;
    }

    /**
     * returns the current elemental afinity of this character
     * @return the elemental affinity of this character bject
     */
    public main.Logic.ElementSystem.Element.DamageElement getAfinity(){
        return this.Afinity;
    }

    /**
     * returns an arraylist with all the abilities the character currently knows
     * @return the abilities of this character
     */
    public ArrayList<main.Logic.Abilities.Ability> getAbilities(){
        return this.Abilities;
    }

    /**
     *
     * returns if this unit is an ally of the player or not
     *
     * @return wheter or not this object is an ally
     */
    public boolean getIsAlly(){
        return this.isAlly;
    }

    /**
     * sets whether or not this object is an ally of the player
     * @param value value to set to
     */
    public void setIsAlly(boolean value){
        this.isAlly = value;
    }

    /**
     * generates a dodge value to be used agains abilities and their hit chance
     * this value is between 1 and 100 and can be upgraded with the units speed
     * @return the dodge value that was generated
     */
    public double generateDodgeVal(){
        double speed = this.Speed.EffectiveValue;
        Random generator = new Random();
        double dodge = 0;
        if(!testMode) {
             dodge = generator.nextDouble() * 100 + 1;
        }else{
             dodge = this.testModeValue;
            return dodge;
        }
        dodge+=speed;
        if(dodge>100){
            dodge = 100;
        }
        return dodge;
    }

    /**
     *  sets whether this unit is in test mode or not
     * @param value wheter in test mode or not
     */
    public void setTestMode(boolean value){
        this.testMode = value;
    }

    /**
     * returns if this unit is in test mode or not
     * @return the tesmo mode enabled value
     */
    public boolean getTestMode(){
        return this.testMode;
    }

    /**
     * sets the value that the test mode is set to modify generated dodge values to
     * @param value test mode dodge value
     */
    public void setTestModeValue(double value){
        if(value>100){
            value = 100;
        }
        this.testModeValue = value;
    }

    /**
     * returns the test mode dodge value that was set
     * @return test mode dodge value
     */
    public double getTestModeValue(){
        return this.testModeValue;
    }

    /**
     * updates this units stats
     */
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

    /**
     * finds a statistic of this unit by its name
     * @param StatName name of the statistic
     * @return the statistic queried for or null if not found
     */
    public Statistic StatFind(String StatName){
        int i = find_stat(StatName);
        if(i!=-1) {
            return this.Stats.get(i);
        }
        return null;
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
            if(this.Abilities.get(i).getName().equals(AbilityName)){
                return i;
            }
        }
        return -1;
    }

    /**
     * adds an ability to the array list of abilities know by this unit
     * @param abl ability to be added to the know abilities list
     */
    public void addAbility(main.Logic.Abilities.Ability abl){
        int pos = findAbility(abl.getName());
        if(abl==null){
            return;
        }
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
    public double getFireRes(){
        return this.FireResistance.EffectiveValue;
    }
    public double getWaterRes(){
        return this.WaterResistence.EffectiveValue;
    }
    public double getEarthRes(){
        return this.EarthResistence.EffectiveValue;
    }
    public double getAirRes(){
        return this.AirResistence.EffectiveValue;
    }

    /**
     * this method is used to have the unit take damage no resistance are taken in account here
     * also updates the state of whether or not this unit is alive
     * @param value damage that unit will take
     */
    public void takeDamage(double value){
        if(!dead){
        this.Health.queueModifier(-value);
        this.Health.update();
        if(this.isDead()){
            this.dead = true;
            if(this.position!=null) {
                this.position.setWalkable(true);
                this.position.setUnit(null);
                this.position = null;
            }
        }}
    }

    /**
     *  reduces the mana currently available to this unit
     * @param value value to reduve mana by
     */
    public void reduceMana(double value){
        if(!dead){
        this.Mana.queueModifier(-value);
        this.Mana.update();}
    }

    /**
     *  heals the unit by a given value , cannot go over maximum health value
     * @param value value to heal unit by
     */
    public void takeHeal(double value){
        if(!dead){
        this.Health.queueModifier(value);
        this.Health.update();}
    }

    /**
     * increases the currently avalilable mana by a given value , cannot not go over the maximum
     * current ammount of mana
     * @param value ammount to increase mana by
     */
    public void increaseMana(double value){
        if(!dead){
        this.Mana.queueModifier(value);
        this.Mana.update();}
    }

    public String getName(){
        return this.name;
    }

    /**
     *  Unit constructor creates all the related stats and identifiers updating them and adding all
     *  stats to the global arraylist of stat for this character
     * @param name name of the unit
     * @param INT inteligence of the unit
     * @param STR strenght of the unit
     * @param SPD speed of the unit
     * @param VIT vitality of the unit
     * @param Armor armor of the unit
     */
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
        this.movementsPerTurn = (int)this.Speed.EffectiveValue*2;
        this.remainingMovement = this.movementsPerTurn;
        this.ID = this.Identifier++;
    }

    /**
     * sets the current characts position to a cell in a map
     * @param position cell that unit will be in
     */
    public void setPosition(main.Logic.Map.Cell position){
        if(position==null){
            return;
        }
        if(position.getUnit()==null) {
            if (this.position != null) {
                this.position.setWalkable(true);
                this.position.setUnit(null);
            }
            this.map = position.getMap();
            this.position = position;
            position.setWalkable(false);
            position.setUnit(this);
        }
        if(position==null){
            this.position.setWalkable(true);
            this.position.setUnit(null);
        }
    }

    /**
     *
     * @return returns the units unique identifier
     */
    public int getID(){
        return this.ID;
    }

    /**
     *
     * @return returns the cell in wich the unit is in
     */
    public main.Logic.Map.Cell getPosition(){
        return this.position;
    }

    /**
     *
     * @return returns the x componend of the coordinates the unit is in
     */
    public int getX(){
        if(this.position!=null){
            return this.position.getxPos();
        }else{
            return -1;
        }
    }

    /**
     *
     * @return returns the y componend of the coordinated the unit is in
     */
    public int getY(){
        if(this.position!=null){
            return this.position.getyPos();
        }else{
            return -1;
        }
    }

    private void unlinkAndLink(int x,int y){
        if(map!=null){
            this.position.setUnit(null);
            this.position.setWalkable(true);
            this.position = map.getCell(x,y);
            this.position.setUnit(this);
        }
    }

    /**
     * moves a character no taking into account how much it can move this turn and not decrementing
     * the remaining ammount of movements left this turn
     * @param deltaX x value to move by
     * @param deltaY y value to move by
     * @return return if the movement was concluded sucessfully
     */
    public boolean unhinderedMove(int deltaX,int deltaY){
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
        if(!map.getCell(xPos+deltaX,yPos+deltaY).isWalkable()){
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

    /**
     * moves the characts taking into account the remaining ammount of movements left this turn
     * and decrementing the number of movements left
     * @param deltaX x value to move by
     * @param deltaY y value to move by
     * @return return if the movement was concluded sucessfully
     */
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
        int dist = (int)this.position.distanceToCell(map.getCell(xPos+deltaX,yPos+deltaY));
        if(this.remainingMovement-dist<0){
            return false;
        }
        if(!map.getCell(xPos+deltaX,yPos+deltaY).isWalkable()){
            return false;
        }
        if(yPos+deltaY>=map.height||yPos+deltaY<0||xPos+deltaX>=map.width||xPos+deltaX<0){
            return false;
        }else{
            this.unlinkAndLink(xPos+deltaX,yPos+deltaY);
            this.remainingMovement-=dist;
            map.update();
            return true;
        }
    }

    /**
     *
     * @return returns if this unit is dead or not
     */
    public boolean isDead(){
        if(this.Health.EffectiveValue ==0){
            return true;
        }
        return false;
    }

    /**
     * begins the turn for this unit ,regenerating some mana and resetting the ammount of movements
     * left this turn
     */
    public void beginTurn(){
        this.remainingMovement = this.movementsPerTurn;
        this.increaseMana(this.Inteligence.EffectiveValue);
    }

    /**
     *
     * @return the maximum ammount of movement per turn
     */
    public int getMovementsPerTurn(){
        return this.movementsPerTurn;
    }

    /**
     *
     * @return the remaining movements for this turn
     */
    public int getRemainingMovement(){
        return this.remainingMovement;
    }

    /**
     *
     * @return the cells in the map the unit can move to
     */
    public ArrayList<Cell> getCellsThatCanMoveTo(){
        return this.map.validCells(this);
    }

    public main.Logic.Unit.Stats.HP getHEALTH(){
        return this.Health;
    }
    public main.Logic.Unit.Stats.MP getMANA(){
        return this.Mana;
    }
    public main.Logic.Unit.Stats.Inteligence getINTELIGENCE(){
        return this.Inteligence;
    }
    public main.Logic.Unit.Stats.Strenght getSTRENGHT(){
        return this.Strength;
    }
    public main.Logic.Unit.Stats.Vitality getVITALITY(){
        return this.Vitality;
    }
    public main.Logic.Unit.Stats.Armor getARMOR(){
        return this.Armor;
    }
    public main.Logic.Unit.Stats.Speed getSPEED(){
        return this.Speed;
    }
    public main.Logic.Unit.Stats.AirRes getAIRRES(){
        return this.AirResistence;
    }
    public main.Logic.Unit.Stats.FireRes getFIRERES(){
        return this.FireResistance;
    }
    public main.Logic.Unit.Stats.WaterRes getWATERRES(){
        return this.WaterResistence;
    }
    public main.Logic.Unit.Stats.EarthRes getEARTHRES(){
        return this.EarthResistence;
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof Unit){
            if(this.ID==((Unit) o).getID()){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    @Override
    public int compareTo(Unit o) {
        if(this.Speed.BaseValue==o.getSPD()){
            return this.getName().compareTo(o.getName());
        }
        if(this.Speed.BaseValue<o.getSPD()){
            return 1;
        }else{
            return -1;
        }
    }

    /**
     *
     * @return if the unit is AI controlelr or not
     */
    public boolean isAIControlled(){
        return this.isAIControlled;
    }

    /**
     *
     * @return the current percentage of HP left in this unit
     */
    public double getCurrentHPPercent(){
        double curr = this.Health.EffectiveValue;
        double max = this.Health.maxValue;
        double val = (double)curr/max;
        return val*100;
    }

    /**
     * used to attack another unit with an ability from this one
     * @param abilityID the identifier of the ability to be used
     * @param target the target
     * @return the damage dealt
     */
    public double attack(int abilityID,Unit target){
        if(abilityID<0||abilityID>this.Abilities.size()){
            return 0;
        }
        if(this.Abilities.get(abilityID)==null){
            return 0;
        }
        double delta = 0;
        double init = target.getHP();
        this.Abilities.get(abilityID).AffectTarget(target);
        double end = target.getHP();
        delta = end-init;
        return delta;
    }

    /**
     * sets if this unit is AI controlled or not
     * @param value value for ai controlled boolean variable
     */
    public void setIsAiControlled(boolean value){
        this.isAIControlled = value;
    }

    /**
     * moves the unit to a specific cell instead of giving delta y and delta x movement value
     * @param cell cell to move to
     */
    public void moveToCell(Cell cell){
        if(cell == null){
            return;
        }
        int deltaX = cell.getxPos()-this.getX();
        int deltaY = cell.getyPos()-this.getY();
        this.move(deltaX,deltaY);
    }

    /**
     *
     * @return the map the unit is in
     */
    public Map getMap(){
        return this.map;
    }

    /**
     *
     * @return the AI controlling this unit if it has one , returns null otherwise
     */
    public BaseAi getAI(){
        return this.AI;
    }

    /**
     * sets the ai that controlls this unit
     * @param AI the AI that will control this unit
     */
    public void setAi(BaseAi AI){
        this.AI = AI;
    }
}