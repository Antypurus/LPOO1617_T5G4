import org.junit.Test;

import main.Logic.Abilities.Ability;
import main.Logic.Abilities.Physicals.Charge;
import main.Logic.ElementSystem.Element;
import main.Logic.Map.Map;
import main.Logic.Unit.Unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class chargeTest {
    @Test
    public void cretionTest(){
        Unit testUnit = new Unit("Test Unit",5,2,5,6,2);
        Ability testCharge = new Charge(testUnit);

        assertEquals(1,testUnit.getAbilities().size());
        assertEquals(testUnit,testCharge.getOwner());
        assertEquals("Charge",testCharge.getName());
        assertTrue(testUnit.getAbilities().get(0).equals(testCharge));
        assertEquals(testUnit.StatFind("STR"),testCharge.getScalingStat());
    }

    @Test
    public void testChargeStat(){
        Unit testUnit = new Unit("Test Unit",5,2,5,6,2);
        Ability testCharge = new Charge(testUnit);

        assertEquals(15,testCharge.getBaseDamage(),0.01);
        assertEquals(60,testCharge.getHitChance(),0.01);
        assertEquals(15,testCharge.getRange());
        assertEquals(0,testCharge.getAOE());
        assertEquals(0,testCharge.getManaCost(),0.01);
        assertEquals(null,testCharge.getTraits());
    }

    @Test
    public void testChargeEnums(){
        Unit testUnit = new Unit("Test Unit",5,2,5,6,2);
        Ability testCharge = new Charge(testUnit);

        assertEquals(Element.type.DAMAGE,testCharge.getType());
        assertEquals(Element.DamageType.Physical,testCharge.getDamageType());
        assertEquals(null,testCharge.getDamageElement());
    }

    @Test
    public void canHitInRange(){
        Unit testUnit = new Unit("Test Unit",5,2,5,6,2);
        Unit testUnit2 = new Unit("Test Unit",5,2,5,6,2);
        Map testMap = new Map("Test Map",30,30);
        Ability testCharge = new Charge(testUnit);

        testUnit.setPosition(testMap.getCell(10,10));
        testUnit2.setPosition(testMap.getCell(11,10));

        assertTrue(testCharge.canHitTarget(testUnit2));

        testUnit2.setPosition(testMap.getCell(20,10));
        testUnit.setPosition(testMap.getCell(5,10));
        assertTrue(testCharge.canHitTarget(testUnit2));

        testUnit2.setPosition(testMap.getCell(5,11));
        testUnit.setPosition(testMap.getCell(5,10));
        assertTrue(testCharge.canHitTarget(testUnit2));

        testUnit2.setPosition(testMap.getCell(5,25));
        testUnit.setPosition(testMap.getCell(5,10));
        assertTrue(testCharge.canHitTarget(testUnit2));

        testUnit.setPosition(testMap.getCell(20,10));
        testUnit2.setPosition(testMap.getCell(5,10));
        assertTrue(testCharge.canHitTarget(testUnit2));

        testUnit2.setPosition(testMap.getCell(19,10));
        testUnit.setPosition(testMap.getCell(20,10));
        assertTrue(testCharge.canHitTarget(testUnit2));

        testUnit2.setPosition(testMap.getCell(25,28));
        testUnit.setPosition(testMap.getCell(25,29));
        assertTrue(testCharge.canHitTarget(testUnit2));

        testUnit2.setPosition(testMap.getCell(20,14));
        testUnit.setPosition(testMap.getCell(20,29));
        assertTrue(testCharge.canHitTarget(testUnit2));
    }

    @Test
    public void cantHitInDiagonal(){
        Unit testUnit = new Unit("Test Unit",5,2,5,6,2);
        Unit testUnit2 = new Unit("Test Unit",5,2,5,6,2);
        Map testMap = new Map("Test Map",30,30);
        Ability testCharge = new Charge(testUnit);

        testUnit.setPosition(testMap.getCell(10,10));
        testUnit2.setPosition(testMap.getCell(11,11));
        assertFalse(testCharge.canHitTarget(testUnit2));

        testUnit2.setPosition(testMap.getCell(9,9));
        assertFalse(testCharge.canHitTarget(testUnit2));

        testUnit2.setPosition(testMap.getCell(11,9));
        assertFalse(testCharge.canHitTarget(testUnit2));

        testUnit2.setPosition(testMap.getCell(9,11));
        assertFalse(testCharge.canHitTarget(testUnit2));

        testUnit2.setPosition(testMap.getCell(6,11));
        assertFalse(testCharge.canHitTarget(testUnit2));

        testUnit2.setPosition(testMap.getCell(9,14));
        assertFalse(testCharge.canHitTarget(testUnit2));

        testUnit2.setPosition(testMap.getCell(15,16));
        assertFalse(testCharge.canHitTarget(testUnit2));

        testUnit2.setPosition(testMap.getCell(17,0));
        assertFalse(testCharge.canHitTarget(testUnit2));
    }

    @Test
    public void catnHitOutOfRange(){
        Unit testUnit = new Unit("Test Unit",5,2,5,6,2);
        Unit testUnit2 = new Unit("Test Unit",5,2,5,6,2);
        Map testMap = new Map("Test Map",30,30);
        Ability testCharge = new Charge(testUnit);

        testUnit.setPosition(testMap.getCell(10,10));
        testUnit2.setPosition(testMap.getCell(29,10));
        assertFalse(testCharge.canHitTarget(testUnit2));

        testUnit2.setPosition(testMap.getCell(10,29));
        assertFalse(testCharge.canHitTarget(testUnit2));
    }

    @Test
    public void cantHitSelf(){
        Unit testUnit = new Unit("Test Unit",5,2,5,6,2);
        Map testMap = new Map("Test Map",30,30);
        Ability testCharge = new Charge(testUnit);
        testUnit.setPosition(testMap.getCell(10,10));
        assertFalse(testCharge.canHitTarget(testUnit));
    }

    @Test
    public void cantHitOwnerPositionNotSet(){
        Unit testUnit = new Unit("Test Unit",5,2,5,6,2);
        Unit testUnit2 = new Unit("Test Unit",5,2,5,6,2);
        Map testMap = new Map("Test Map",30,30);
        Ability testCharge = new Charge(testUnit);
        testUnit2.setPosition(testMap.getCell(10,10));
        assertFalse(testCharge.canHitTarget(testUnit2));
    }

    @Test
    public void cantHitTargetPositionNotSet(){
        Unit testUnit = new Unit("Test Unit",5,2,5,6,2);
        Unit testUnit2 = new Unit("Test Unit",5,2,5,6,2);
        Map testMap = new Map("Test Map",30,30);
        Ability testCharge = new Charge(testUnit);
        testUnit.setPosition(testMap.getCell(10,10));
        assertFalse(testCharge.canHitTarget(testUnit2));
    }

    @Test
    public void cantHitOwnerDead(){
        Unit testUnit = new Unit("Test Unit",5,2,5,6,2);
        Unit testUnit2 = new Unit("Test Unit",5,2,5,6,2);
        Map testMap = new Map("Test Map",30,30);
        Ability testCharge = new Charge(testUnit);

        testUnit.setPosition(testMap.getCell(10,10));
        testUnit2.setPosition(testMap.getCell(11,10));

        testUnit.takeDamage(1000);
        assertFalse(testCharge.canHitTarget(testUnit2));
    }

    @Test
    public void cantHitTargetDead(){
        Unit testUnit = new Unit("Test Unit",5,2,5,6,2);
        Unit testUnit2 = new Unit("Test Unit",5,2,5,6,2);
        Map testMap = new Map("Test Map",30,30);
        Ability testCharge = new Charge(testUnit);

        testUnit.setPosition(testMap.getCell(10,10));
        testUnit2.setPosition(testMap.getCell(11,10));

        testUnit2.takeDamage(1000);
        assertFalse(testCharge.canHitTarget(testUnit2));
    }

    @Test
    public void cantHitNoOwner(){
        Unit testUnit = new Unit("Test Unit",5,2,5,6,2);
        Unit testUnit2 = new Unit("Test Unit",5,2,5,6,2);
        Map testMap = new Map("Test Map",30,30);
        Ability testCharge = new Charge(null);

        testUnit.setPosition(testMap.getCell(10,10));
        testUnit2.setPosition(testMap.getCell(11,10));

        assertFalse(testCharge.canHitTarget(testUnit2));
    }

    @Test
    public void cantHitNoTarget(){
        Unit testUnit = new Unit("Test Unit",5,2,5,6,2);
        Unit testUnit2 = new Unit("Test Unit",5,2,5,6,2);
        Map testMap = new Map("Test Map",30,30);
        Ability testCharge = new Charge(testUnit);

        testUnit.setPosition(testMap.getCell(10,10));
        testUnit2.setPosition(testMap.getCell(11,10));

        assertFalse(testCharge.canHitTarget(null));
    }

    @Test
    public void affectTargetTest(){
        Unit testUnit = new Unit("Test Unit",10,2,5,6,2);
        Unit testUnit2 = new Unit("Test Unit",5,2,5,60,2);
        Map testMap = new Map("Test Map",30,30);
        Ability testCharge = new Charge(testUnit);

        testUnit.setPosition(testMap.getCell(10,10));
        testUnit2.setPosition(testMap.getCell(10,11));
        assertTrue(testCharge.canHitTarget(testUnit2));

        testUnit2.setTestMode(true);
        assertTrue(testUnit2.getTestMode());
        testUnit2.setTestModeValue(10);
        assertEquals(10,testUnit2.generateDodgeVal(),0.01);

        testCharge.AffectTarget(testUnit2);
        assertEquals(572,testUnit2.getHP(),0.01);
    }

    @Test
    public void affectTargetCriticalHitTest(){
        Unit testUnit = new Unit("Test Unit",10,2,5,6,2);
        Unit testUnit2 = new Unit("Test Unit",5,2,5,60,2);
        Map testMap = new Map("Test Map",30,30);
        Ability testCharge = new Charge(testUnit);

        testUnit.setPosition(testMap.getCell(10,10));
        testUnit2.setPosition(testMap.getCell(10,11));
        assertTrue(testCharge.canHitTarget(testUnit2));

        testUnit2.setTestMode(true);
        assertTrue(testUnit2.getTestMode());
        testUnit2.setTestModeValue(6);
        assertEquals(6,testUnit2.generateDodgeVal(),0.01);

        testCharge.AffectTarget(testUnit2);
        assertEquals(542,testUnit2.getHP(),0.01);
    }

    @Test
    public void affectTargetCriticalFailTest(){
        Unit testUnit = new Unit("Test Unit",10,2,5,6,2);
        Unit testUnit2 = new Unit("Test Unit",5,2,5,60,2);
        Map testMap = new Map("Test Map",30,30);
        Ability testCharge = new Charge(testUnit);

        testUnit.setPosition(testMap.getCell(10,10));
        testUnit2.setPosition(testMap.getCell(10,11));
        assertTrue(testCharge.canHitTarget(testUnit2));

        testUnit2.setTestMode(true);
        assertTrue(testUnit2.getTestMode());
        testUnit2.setTestModeValue(1);
        assertEquals(1,testUnit2.generateDodgeVal(),0.01);

        testCharge.AffectTarget(testUnit2);
        assertEquals(542,testUnit2.getHP(),0.01);
    }

    @Test
    public void affectTargetMoveOwnerTest(){
        Unit testUnit = new Unit("Test Unit",10,2,5,6,2);
        Unit testUnit2 = new Unit("Test Unit",5,2,5,60,2);
        Map testMap = new Map("Test Map",30,30);
        Ability testCharge = new Charge(testUnit);

        testUnit.setPosition(testMap.getCell(10,10));
        testUnit2.setPosition(testMap.getCell(10,20));
        assertEquals(10,testUnit.getX());
        assertEquals(10,testUnit.getY());
        assertEquals(10,testUnit2.getX());
        assertEquals(20,testUnit2.getY());

        assertTrue(testCharge.canHitTarget(testUnit2));

        testUnit2.setTestMode(true);
        assertTrue(testUnit2.getTestMode());
        testUnit2.setTestModeValue(10);
        assertEquals(10,testUnit2.generateDodgeVal(),0.01);

        testCharge.AffectTarget(testUnit2);
        assertEquals(572,testUnit2.getHP(),0.01);

        assertEquals(10,testUnit.getX());
        assertEquals(19,testUnit.getY());

        testUnit.setPosition(testMap.getCell(10,10));
        testUnit2.setPosition(testMap.getCell(20,10));
        assertEquals(10,testUnit.getX());
        assertEquals(10,testUnit.getY());
        assertEquals(20,testUnit2.getX());
        assertEquals(10,testUnit2.getY());
        assertTrue(testCharge.canHitTarget(testUnit2));

        testCharge.AffectTarget(testUnit2);

        assertEquals(19,testUnit.getX());
        assertEquals(10,testUnit.getY());

        testUnit.setPosition(testMap.getCell(10,10));
        testUnit2.setPosition(testMap.getCell(0,10));
        assertEquals(10,testUnit.getX());
        assertEquals(10,testUnit.getY());
        assertEquals(0,testUnit2.getX());
        assertEquals(10,testUnit2.getY());
        assertTrue(testCharge.canHitTarget(testUnit2));

        testCharge.AffectTarget(testUnit2);

        assertEquals(1,testUnit.getX());
        assertEquals(10,testUnit.getY());

        testUnit.setPosition(testMap.getCell(10,10));
        testUnit2.setPosition(testMap.getCell(10,0));
        assertEquals(10,testUnit.getX());
        assertEquals(10,testUnit.getY());
        assertEquals(10,testUnit2.getX());
        assertEquals(0,testUnit2.getY());
        assertTrue(testCharge.canHitTarget(testUnit2));

        testCharge.AffectTarget(testUnit2);

        assertEquals(10,testUnit.getX());
        assertEquals(1,testUnit.getY());
    }
}
