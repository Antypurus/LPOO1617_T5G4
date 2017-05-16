
import org.junit.Test;

import main.Logic.Unit.Unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class unitTest {
    @Test
    public void StatTest() throws Exception {
        Unit testUnit = new Unit("Test Unit",5,2,5,6,2);

        assertEquals("Test Unit",testUnit.getName());
        assertEquals(60,testUnit.getHP(),0.01);
        assertEquals(50,testUnit.getMP(),0.01);
        assertEquals(5,testUnit.getINT(),0.01);
        assertEquals(2,testUnit.getSTR(),0.01);
        assertEquals(6,testUnit.getVIT(),0.01);
        assertEquals(5,testUnit.getSPD(),0.01);
        assertEquals(2,testUnit.getArmor(),0.01);
    }

    @Test
    public void DamageTest(){
        Unit testUnit = new Unit("Test Unit",5,2,5,6,2);

        assertEquals(60,testUnit.getHP(),0.01);
        testUnit.takeDamage(10);
        assertEquals(50,testUnit.getHP(),0.01);
    }

    @Test
    public void HealTest(){
        Unit testUnit = new Unit("Test Unit",5,2,5,6,2);

        assertEquals(60,testUnit.getHP(),0.01);
        testUnit.takeDamage(10);
        assertEquals(50,testUnit.getHP(),0.01);
        testUnit.takeHeal(5);
        assertEquals(55,testUnit.getHP(),0.01);
    }

    @Test
    public void OverHealTest(){
        Unit testUnit = new Unit("Test Unit",5,2,5,6,2);

        assertEquals(60,testUnit.getHP(),0.01);
        testUnit.takeHeal(100);
        assertEquals(60,testUnit.getHP(),0.01);
    }

    @Test
    public void DeadOrAliveTest(){
        Unit testUnit = new Unit("Test Unit",5,2,5,6,2);

        assertEquals(60,testUnit.getHP(),0.01);
        assertFalse(testUnit.isDead());
        testUnit.takeDamage(10);
        assertFalse(testUnit.isDead());
        testUnit.takeDamage(1000);
        assertTrue(testUnit.isDead());
    }

    @Test
    public void HealWhileDead(){
        Unit testUnit = new Unit("Test Unit",5,2,5,6,2);

        assertEquals(60,testUnit.getHP(),0.01);
        testUnit.takeDamage(10);
        assertEquals(50,testUnit.getHP(),0.01);
        testUnit.takeHeal(10);
        assertEquals(60,testUnit.getHP(),0.01);
        testUnit.takeDamage(1000);
        assertEquals(0,testUnit.getHP(),0.01);
        testUnit.takeHeal(1000);
        assertEquals(0,testUnit.getHP(),0.01);
    }
}