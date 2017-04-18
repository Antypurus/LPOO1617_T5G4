package Logic.Unit;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Unit {
    //basic information
    public int xPos;
    public int yPos;
    private String name;



    public String getName(){
        return this.name;
    }

    //character stats
    public double HP;//Health points
    //maybe xp
    //maybe lvl
    public double MP;//Mana points
    public double inteligence;
    public double strenght;
    public double speed;

    //character resistances
    private double ArmorRating;
    private double MagicResistance;
    private double FireResistance;
    private double WaterResistance;
    private double AirResistance;
    private double EarthResistance;

    public abstract void receiveAttack();
    public abstract void attack();
}
