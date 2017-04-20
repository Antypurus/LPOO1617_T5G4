package Logic.Unit;

import java.util.ArrayList;

import Logic.Abilities.Ability;

public abstract class Unit {
    //basic information
    public int xPos;
    public int yPos;
    private String name;



    public String getName(){
        return this.name;
    }

    //character stats
    private double HP;//Health points
    private double currentHP=HP;
    //maybe xp
    //maybe lvl
    private double MP;//Mana points
    private double currentMP = MP;

    private double inteligence;//magic based abilities deal more damage or heal more, increases mana points
    private double strenght;//physical based abilities deal more damage , increases defenses
    private double vitality;//increases maximum HP
    private double speed;//determines the units speed and therefore their order in the turn flow.

    ArrayList<Ability> abilities;

    //character resistances
    private double ArmorRating;
    private double MagicResistance;
    private double FireResistance;
    private double WaterResistance;
    private double AirResistance;
    private double EarthResistance;

    public abstract void receiveAttack();
    public abstract void receiveHealth();
    public abstract void attack(Ability select);
    public abstract void move();
}
