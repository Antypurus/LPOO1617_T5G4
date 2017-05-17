
import org.junit.Test;

import main.Logic.Map.Map;
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

    @Test
    public void ManaUsage(){
        Unit testUnit = new Unit("Test Unit",5,2,5,6,2);

        assertEquals( 50,testUnit.getMP(),0.01);
        testUnit.reduceMana(10);
        assertEquals( 40,testUnit.getMP(),0.01);
        testUnit.reduceMana(1000);
        assertEquals(0,testUnit.getMP(),0.01);
    }

    @Test
    public void SetPositionTest(){
        Unit testUnit = new Unit("Test Unit",5,2,5,6,2);
        Map testMap = new Map("Test Map",1280,720);

        testUnit.setPosition(testMap.getCell(10,11));
        assertEquals(10,testUnit.getX());
        assertEquals(11,testUnit.getY());
    }

    @Test
    public void MovementTest(){
        Unit testUnit = new Unit("Test Unit",5,2,5,6,2);
        Map testMap = new Map("Test Map",1280,720);

        testUnit.setPosition(testMap.getCell(10,11));
        assertEquals(10,testUnit.getX());
        assertEquals(11,testUnit.getY());

        testUnit.move(1,0);
        assertEquals(11,testUnit.getX());
        testUnit.move(-1,0);
        assertEquals(10,testUnit.getX());

        testUnit.move(0,1);
        assertEquals(12,testUnit.getY());
        testUnit.move(0,-1);
        assertEquals(11,testUnit.getY());
    }

    @Test
    public void BlockedMovementTest(){
        Unit testUnit = new Unit("Test Unit",5,2,5,6,2);
        Map testMap = new Map("Test Map",1280,720);

        testUnit.setPosition(testMap.getCell(10,11));
        assertEquals(10,testUnit.getX());
        assertEquals(11,testUnit.getY());
    }
}
