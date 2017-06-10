package main.Logic.Abilities;

import java.util.ArrayList;

import main.Logic.Map.Cell;
import main.Logic.Unit.Statistic;
import main.Logic.Unit.Unit;

public interface Ability {
    /**
     *
     * This method has the ability affect the target and the owner wether it be healing or damage or movement
     * @param target target of the abbility
     */
    public abstract void AffectTarget(Unit target);

    /**
     * verifies if the target can be attack by the ability
     * @param target target if the ability
     * @return return if the target can be affected by the ability
     */
    public abstract boolean canHitTarget(Unit target);

    /**
     * Retyrb the base damage or healing value of the ability
     * @return returns the base damage or healing of the ability , if the value is negative the value
     * is a healing value otherwise its an offensive value
     */
    public abstract double getBaseDamage();

    /**
     *returns the range of the ability
     * @return the range or the ability
     */
    public abstract int getRange();

    /**
     * returns if the ability has an elemental affinity
     * @return wheter the ability is elemental or not
     */
    public abstract boolean isElemental();

    /**
     * returns the type of ability
     * @return the ability type
     */
    public abstract main.Logic.ElementSystem.Element.type getType();

    /**
     * returns the damage element of the ability or null if the ability ahs none
     * @return the ability damage element
     */
    public abstract main.Logic.ElementSystem.Element.DamageElement getDamageElement();

    /**
     * retuns the ability damage type (Physical , Elemental or true) or null of the
     * ability does no damage
     * @return the ability damage type
     */
    public abstract main.Logic.ElementSystem.Element.DamageType getDamageType();

    /**
     * returns the name of the ability
     * @return the name of the ability
     */
    public abstract String getName();

    /**
     * returns an array list of traits of the ability almost always null
     * due to not being needed / should have been removed
     * @return the traits of the ability
     */
    public abstract ArrayList<main.Logic.ElementSystem.Element.type> getTraits();

    /**
     * return the unit that owns this ability object
     * @return the owner of this ability
     */
    public abstract Unit getOwner();

    /**
     * returns the statistic from the owner that is responsible
     * for any value scaling in this ability
     * @return the scaling statistic of the ability
     */
    public abstract Statistic getScalingStat();

    /**
     * calculates the damage that should be done to the target taking
     * into account the possibility of dodging and any resistance to
     * the ability the target has.
     * @param target ability target
     * @return the damage that should be done to the target
     */
    public abstract double getDamageToTarget(Unit target);

    /**
     * returns the chance of this ability hitting the target
     * @return the hit chance of the ability
     */
    public abstract double getHitChance();

    /**
     * return the distance from the target from wich any unit in that
     * distance will be afflicted by the ability as well
     * @return the area of effect of the ability
     */
    public abstract int getAOE();

    /**
     * return the mana cost of this ability
     * @return the mana cost of the ability
     */
    public abstract double getManaCost();

    /**
     * checks if a given cell can be affected by the ability in case
     * it has a unit in it
     * @param cell cell whose elegibility is going to be checked
     * @return wheter the cell be affected or not
     */
    public abstract boolean canHitCell(Cell cell);

    /**
     * return all the cells that can be affected by the ability given
     * the current position of the owner
     * @return all cells that can currently be affected
     */
    public ArrayList<Cell> getCellsThatCanHit();

    /**
     * returns if the abbility can currently be used by its owner
     * @return if the ability can be used or not
     */
    public boolean canUse();
}
