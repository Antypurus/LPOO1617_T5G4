import org.junit.Test;

import java.util.ArrayList;

import main.Logic.Abilities.Ability;
import main.Logic.Abilities.Spells.Fireball;
import main.Logic.ElementSystem.Element;
import main.Logic.Map.Map;
import main.Logic.Unit.Unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class fireballTest {

    @Test
    public void testCreation(){
        Unit testUnit = new Unit("Test Unit",5,2,5,6,2);
        Ability testFireBall = new Fireball(testUnit);

        assertEquals(1,testUnit.getAbilities().size());
        assertEquals(testUnit,testFireBall.getOwner());
        assertEquals("FireBall",testFireBall.getName());
        assertTrue(testUnit.getAbilities().get(0).equals(testFireBall));
        assertEquals(testUnit.StatFind("INT"),testFireBall.getScalingStat());
    }

    @Test
    public void testFireBallStat(){
        Unit testUnit = new Unit("Test Unit",5,2,5,6,2);
        Ability testFireBall = new Fireball(testUnit);

        assertEquals(6,testFireBall.getBaseDamage(),0.01);
        assertEquals(100,testFireBall.getHitChance(),0.01);
        assertEquals(10,testFireBall.getManaCost(),0.01);
        assertEquals(10,testFireBall.getRange());
        assertEquals(0,testFireBall.getAOE());
        assertEquals(testUnit.StatFind("INT"),testFireBall.getScalingStat());
        assertEquals(Element.DamageElement.FIRE,testFireBall.getDamageElement());
        assertEquals(Element.DamageType.Magical,testFireBall.getDamageType());
        assertEquals(Element.type.DAMAGE,testFireBall.getType());
        ArrayList<Element.type> traits  = new ArrayList<Element.type>();
        traits.add(Element.type.DAMAGE);
        assertEquals(traits,testFireBall.getTraits());
        assertTrue(testFireBall.isElemental());
    }

    @Test
    public void canHitInRange(){
        Unit testUnit = new Unit("Test Unit",5,2,5,6,2);
        Unit testUnit2 = new Unit("Test Unit",5,2,5,6,2);
        Map testMap = new Map("Test Map",30,30);
        Ability testFireBall = new Fireball(testUnit);

        testUnit.setPosition(testMap.getCell(10,10));
        testUnit2.setPosition(testMap.getCell(11,10));

        assertTrue(testFireBall.canHitTarget(testUnit2));

        testUnit2.setPosition(testMap.getCell(20,10));
        assertTrue(testFireBall.canHitTarget(testUnit2));
    }

    @Test
    public void cantHitInRangeNoMana(){
        Unit testUnit = new Unit("Test Unit",5,2,5,6,2);
        Unit testUnit2 = new Unit("Test Unit",5,2,5,6,2);
        Map testMap = new Map("Test Map",30,30);
        Ability testFireBall = new Fireball(testUnit);

        testUnit.setPosition(testMap.getCell(10,10));
        testUnit2.setPosition(testMap.getCell(11,10));

        assertTrue(testFireBall.canHitTarget(testUnit2));

        testUnit.reduceMana(45);
        assertFalse(testFireBall.canHitTarget(testUnit2));
    }

    @Test
    public void cantHitOutOfRange(){
        Unit testUnit = new Unit("Test Unit",5,2,5,6,2);
        Unit testUnit2 = new Unit("Test Unit",5,2,5,6,2);
        Map testMap = new Map("Test Map",30,30);
        Ability testFireBall = new Fireball(testUnit);

        testUnit.setPosition(testMap.getCell(0,0));
        testUnit2.setPosition(testMap.getCell(8,0));

        assertTrue(testFireBall.canHitTarget(testUnit2));

        testUnit2.setPosition(testMap.getCell(29,29));
        assertFalse(testFireBall.canHitTarget(testUnit2));

        testUnit2.setPosition(testMap.getCell(11,0));
        assertFalse(testFireBall.canHitTarget(testUnit2));
    }

    @Test
    public void cantHitSelf(){
        Unit testUnit = new Unit("Test Unit",5,2,5,6,2);
        Map testMap = new Map("Test Map",30,30);
        Ability testFireBall = new Fireball(testUnit);
        testUnit.setPosition(testMap.getCell(0,0));

        assertFalse(testFireBall.canHitTarget(testUnit));
    }

    @Test
    public void cantHitPositionNotSet(){
        Unit testUnit = new Unit("Test Unit",5,2,5,6,2);
        Unit testUnit2 = new Unit("Test Unit",5,2,5,6,2);
        Map testMap = new Map("Test Map",30,30);
        Ability testFireBall = new Fireball(testUnit);

        assertFalse(testFireBall.canHitTarget(testUnit));
        testUnit.setPosition(testMap.getCell(0,0));

        assertFalse(testFireBall.canHitTarget(testUnit2));
        testUnit2.setPosition(testMap.getCell(1,0));

        assertTrue(testFireBall.canHitTarget(testUnit2));
    }

    @Test
    public void cantHitOwnerDead(){
        Unit testUnit = new Unit("Test Unit",5,2,5,6,2);
        Unit testUnit2 = new Unit("Test Unit",5,2,5,6,2);
        Map testMap = new Map("Test Map",30,30);
        Ability testFireBall = new Fireball(testUnit);

        testUnit.setPosition(testMap.getCell(10,10));
        testUnit2.setPosition(testMap.getCell(11,11));

        assertTrue(testFireBall.canHitTarget(testUnit2));

        testUnit.takeDamage(1000);
        assertEquals(0,testUnit.getHP(),0.01);
        assertFalse(testFireBall.canHitTarget(testUnit2));
    }

    @Test
    public void cantHitTargetIsDead(){
        Unit testUnit = new Unit("Test Unit",5,2,5,6,2);
        Unit testUnit2 = new Unit("Test Unit",5,2,5,6,2);
        Map testMap = new Map("Test Map",30,30);
        Ability testFireBall = new Fireball(testUnit);

        testUnit.setPosition(testMap.getCell(10,10));
        testUnit2.setPosition(testMap.getCell(11,11));

        assertTrue(testFireBall.canHitTarget(testUnit2));

        testUnit2.takeDamage(1000);
        assertEquals(0,testUnit2.getHP(),0.01);
        assertFalse(testFireBall.canHitTarget(testUnit2));
    }

    @Test
    public void cantHitNoOwner(){
        Unit testUnit2 = new Unit("Test Unit",5,2,5,6,2);
        Map testMap = new Map("Test Map",30,30);
        Ability testFireBall = new Fireball(null);

        testUnit2.setPosition(testMap.getCell(11,11));
        assertFalse(testFireBall.canHitTarget(testUnit2));
    }

    @Test
    public void cantHitNoTarget(){
        Unit testUnit = new Unit("Test Unit",5,2,5,6,2);
        Map testMap = new Map("Test Map",30,30);
        Ability testFireBall = new Fireball(testUnit);

        testUnit.setPosition(testMap.getCell(10,10));
        assertFalse(testFireBall.canHitTarget(null));
    }

    @Test
    public void testAffectingTargetNoAffinity(){
        Unit testUnit = new Unit("Test Unit",5,2,5,6,2);
        Unit testUnit2 = new Unit("Test Unit",5,2,0,6,2);
        Map testMap = new Map("Test Map",30,30);
        Ability testFireBall = new Fireball(testUnit);

        testUnit.setPosition(testMap.getCell(10,10));
        testUnit2.setPosition(testMap.getCell(11,11));

        testUnit2.setTestMode(true);
        assertTrue(testUnit2.getTestMode());
        testUnit2.setTestModeValue(10);
        assertEquals(10,testUnit2.getTestModeValue(),0.01);

        testFireBall.AffectTarget(testUnit2);
        assertEquals(43,testUnit2.getHP(),0.01);
        assertEquals(40,testUnit.getMP(),0.01);
    }

    @Test
    public void testAffectingTargetWithAffinity(){
        Unit testUnit = new Unit("Test Unit",10,2,5,6,2);
        Unit testUnit2 = new Unit("Test Unit",5,2,0,60,2);
        Map testMap = new Map("Test Map",30,30);
        Ability testFireBall = new Fireball(testUnit);

        testUnit.setPosition(testMap.getCell(10,10));
        testUnit2.setPosition(testMap.getCell(11,11));
        testUnit2.setAfinity(Element.DamageElement.FIRE);

        testUnit2.setTestMode(true);
        assertTrue(testUnit2.getTestMode());
        testUnit2.setTestModeValue(10);
        assertEquals(10,testUnit2.getTestModeValue(),0.01);

        testFireBall.AffectTarget(testUnit2);
        assertEquals(600,testUnit2.getHP(),0.01);

        testUnit2.setAfinity(Element.DamageElement.EARTH);
        assertTrue(testFireBall.canHitTarget(testUnit2));
        testFireBall.AffectTarget(testUnit2);
        assertEquals(547,testUnit2.getHP(),0.01);

        testUnit2.setAfinity(Element.DamageElement.WATER);
        assertTrue(testFireBall.canHitTarget(testUnit2));
        testFireBall.AffectTarget(testUnit2);
        assertEquals(547,testUnit2.getHP(),0.01);
    }

    @Test
    public void testAffectingTargetCriticalFail(){
        Unit testUnit = new Unit("Test Unit",10,2,5,6,2);
        Unit testUnit2 = new Unit("Test Unit",5,2,0,60,2);
        Map testMap = new Map("Test Map",30,30);
        Ability testFireBall = new Fireball(testUnit);

        testUnit.setPosition(testMap.getCell(10,10));
        testUnit2.setPosition(testMap.getCell(11,11));

        testUnit2.setTestMode(true);
        assertTrue(testUnit2.getTestMode());
        testUnit2.setTestModeValue(1);
        assertEquals(1,testUnit2.getTestModeValue(),0.01);

        testFireBall.AffectTarget(testUnit2);
        assertEquals(547,testUnit2.getHP(),0.01);
    }
}
