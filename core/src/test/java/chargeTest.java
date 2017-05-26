import org.junit.Test;

import main.Logic.Abilities.Ability;
import main.Logic.Abilities.Physicals.Charge;
import main.Logic.ElementSystem.Element;
import main.Logic.Map.Map;
import main.Logic.Unit.Unit;

import static org.junit.Assert.assertEquals;
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

        assertEquals(20,testCharge.getBaseDamage(),0.01);
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
}
