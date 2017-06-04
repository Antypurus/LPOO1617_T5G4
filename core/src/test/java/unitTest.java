
import org.junit.Test;

import java.lang.reflect.Method;

import main.Logic.Map.Map;
import main.Logic.Unit.Statistic;
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
    public void DerivateStatTest(){
        Unit testUnit = new Unit("Test Unit",5,2,5,6,2);

        assertEquals(13,testUnit.getAirRes(),0.01);
        assertEquals(9,testUnit.getEarthRes(),0.01);
        assertEquals(13,testUnit.getFireRes(),0.01);
        assertEquals(12,testUnit.getWaterRes(),0.01);
    }

    @Test
    public void ChangeDerivatedIntTest(){
        Unit testUnit = new Unit("Test Unit",5,2,5,6,2);

        assertEquals(13,testUnit.getAirRes(),0.01);
        assertEquals(9,testUnit.getEarthRes(),0.01);
        assertEquals(13,testUnit.getFireRes(),0.01);
        assertEquals(12,testUnit.getWaterRes(),0.01);

        testUnit.StatFind("INT").modifyBase(1);
        testUnit.update();

        assertEquals(6,testUnit.getINT(),0.01);

        assertEquals(14,testUnit.getAirRes(),0.01);
        assertEquals(10,testUnit.getEarthRes(),0.01);
        assertEquals(14,testUnit.getFireRes(),0.01);
        assertEquals(13,testUnit.getWaterRes(),0.01);

        testUnit.StatFind("INT").modifyBase(-1);
        testUnit.update();

        assertEquals(5,testUnit.getINT(),0.01);

        assertEquals(13,testUnit.getAirRes(),0.01);
        assertEquals(9,testUnit.getEarthRes(),0.01);
        assertEquals(13,testUnit.getFireRes(),0.01);
        assertEquals(12,testUnit.getWaterRes(),0.01);
    }

    @Test
    public void ChangeDerivatedStrTest(){
        Unit testUnit = new Unit("Test Unit",5,2,5,6,2);

        assertEquals(13,testUnit.getAirRes(),0.01);
        assertEquals(9,testUnit.getEarthRes(),0.01);
        assertEquals(13,testUnit.getFireRes(),0.01);
        assertEquals(12,testUnit.getWaterRes(),0.01);

        testUnit.StatFind("STR").modifyBase(1);
        testUnit.update();

        assertEquals(3,testUnit.getSTR(),0.01);

        assertEquals(14,testUnit.getAirRes(),0.01);
        assertEquals(10,testUnit.getEarthRes(),0.01);
        assertEquals(13,testUnit.getFireRes(),0.01);
        assertEquals(12,testUnit.getWaterRes(),0.01);

        testUnit.StatFind("STR").modifyBase(-1);
        testUnit.update();

        assertEquals(2,testUnit.getSTR(),0.01);

        assertEquals(13,testUnit.getAirRes(),0.01);
        assertEquals(9,testUnit.getEarthRes(),0.01);
        assertEquals(13,testUnit.getFireRes(),0.01);
        assertEquals(12,testUnit.getWaterRes(),0.01);
    }

    @Test
    public void ChangeDerivatedSpdTest(){
        Unit testUnit = new Unit("Test Unit",5,2,5,6,2);

        assertEquals(13,testUnit.getAirRes(),0.01);
        assertEquals(9,testUnit.getEarthRes(),0.01);
        assertEquals(13,testUnit.getFireRes(),0.01);
        assertEquals(12,testUnit.getWaterRes(),0.01);

        testUnit.StatFind("SPD").modifyBase(1);
        testUnit.update();

        assertEquals(6,testUnit.getSPD(),0.01);

        assertEquals(13,testUnit.getAirRes(),0.01);
        assertEquals(9,testUnit.getEarthRes(),0.01);
        assertEquals(13,testUnit.getFireRes(),0.01);
        assertEquals(13,testUnit.getWaterRes(),0.01);

        testUnit.StatFind("SPD").modifyBase(-1);
        testUnit.update();

        assertEquals(5,testUnit.getSPD(),0.01);

        assertEquals(13,testUnit.getAirRes(),0.01);
        assertEquals(9,testUnit.getEarthRes(),0.01);
        assertEquals(13,testUnit.getFireRes(),0.01);
        assertEquals(12,testUnit.getWaterRes(),0.01);
    }

    @Test
    public void ChangeDerivatedArmorTest(){
        Unit testUnit = new Unit("Test Unit",5,2,5,6,2);

        assertEquals(13,testUnit.getAirRes(),0.01);
        assertEquals(9,testUnit.getEarthRes(),0.01);
        assertEquals(13,testUnit.getFireRes(),0.01);
        assertEquals(12,testUnit.getWaterRes(),0.01);

        testUnit.StatFind("ARMR").modifyBase(1);
        testUnit.update();

        assertEquals(3,testUnit.getArmor(),0.01);

        assertEquals(13,testUnit.getAirRes(),0.01);
        assertEquals(10,testUnit.getEarthRes(),0.01);
        assertEquals(14,testUnit.getFireRes(),0.01);
        assertEquals(13,testUnit.getWaterRes(),0.01);

        testUnit.StatFind("ARMR").modifyBase(-1);
        testUnit.update();

        assertEquals(2,testUnit.getArmor(),0.01);

        assertEquals(13,testUnit.getAirRes(),0.01);
        assertEquals(9,testUnit.getEarthRes(),0.01);
        assertEquals(13,testUnit.getFireRes(),0.01);
        assertEquals(12,testUnit.getWaterRes(),0.01);
    }

    @Test
    public void ChangeDerivatedVitTest(){
        Unit testUnit = new Unit("Test Unit",5,2,5,6,2);

        assertEquals(13,testUnit.getAirRes(),0.01);
        assertEquals(9,testUnit.getEarthRes(),0.01);
        assertEquals(13,testUnit.getFireRes(),0.01);
        assertEquals(12,testUnit.getWaterRes(),0.01);

        testUnit.StatFind("VIT").modifyBase(1);
        testUnit.update();

        assertEquals(7,testUnit.getVIT(),0.01);

        assertEquals(14,testUnit.getAirRes(),0.01);
        assertEquals(9,testUnit.getEarthRes(),0.01);
        assertEquals(14,testUnit.getFireRes(),0.01);
        assertEquals(12,testUnit.getWaterRes(),0.01);

        testUnit.StatFind("VIT").modifyBase(-1);
        testUnit.update();

        assertEquals(6,testUnit.getVIT(),0.01);

        assertEquals(13,testUnit.getAirRes(),0.01);
        assertEquals(9,testUnit.getEarthRes(),0.01);
        assertEquals(13,testUnit.getFireRes(),0.01);
        assertEquals(12,testUnit.getWaterRes(),0.01);
    }

    @Test
    public void StatFindTest(){
        Unit testUnit = new Unit("Test Unit",5,2,5,6,2);

        assertEquals(testUnit.StatFind("SPD").EffectiveValue,testUnit.getSPD(),0.01);
        assertEquals(testUnit.StatFind("VIT").EffectiveValue,testUnit.getVIT(),0.01);
        assertEquals(testUnit.StatFind("INT").EffectiveValue,testUnit.getINT(),0.01);
        assertEquals(testUnit.StatFind("STR").EffectiveValue,testUnit.getSTR(),0.01);
        assertEquals(testUnit.StatFind("ARMR").EffectiveValue,testUnit.getArmor(),0.01);
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
    public void ManaRegen(){
        Unit testUnit = new Unit("Test Unit",5,2,5,6,2);

        assertEquals( 50,testUnit.getMP(),0.01);
        testUnit.reduceMana(10);
        assertEquals( 40,testUnit.getMP(),0.01);
        testUnit.increaseMana(5);
        assertEquals( 45,testUnit.getMP(),0.01);
    }

    @Test
    public void ManaOverRegen(){
        Unit testUnit = new Unit("Test Unit",5,2,5,6,2);

        assertEquals( 50,testUnit.getMP(),0.01);
        testUnit.increaseMana(500);
        assertEquals( 50,testUnit.getMP(),0.01);
    }

    @Test
    public void ManaRegenWhileDead(){
        Unit testUnit = new Unit("Test Unit",5,2,5,6,2);

        assertEquals( 50,testUnit.getMP(),0.01);
        testUnit.reduceMana(500);
        assertEquals( 0,testUnit.getMP(),0.01);
        testUnit.takeDamage(1000);
        assertEquals(0,testUnit.getHP(),0.01);
        testUnit.increaseMana(1000);
        assertEquals( 0,testUnit.getMP(),0.01);
    }

    @Test
    public void SetPositionTest(){
        Unit testUnit = new Unit("Test Unit",5,2,5,6,2);
        Map testMap = new Map("Test Map",1280,720);

        testUnit.setPosition(testMap.getCell(10,11));
        assertEquals(10,testUnit.getX());
        assertEquals(11,testUnit.getY());
        testUnit.setPosition(testMap.getCell(5,5));
        assertEquals(5,testUnit.getX());
        assertEquals(5,testUnit.getY());
        testUnit.setPosition(testMap.getCell(15,15));
        assertEquals(15,testUnit.getX());
        assertEquals(15,testUnit.getY());
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

        testUnit.setPosition(testMap.getCell(10,11));
        testUnit.move(1,0);
        testUnit.move(0,1);
        assertEquals(11,testUnit.getX());
        assertEquals(12,testUnit.getY());

        testUnit.setPosition(testMap.getCell(10,11));
        testUnit.move(-1,0);
        testUnit.move(0,-1);
        assertEquals(9,testUnit.getX());
        assertEquals(10,testUnit.getY());

        testUnit.setPosition(testMap.getCell(10,11));
        testUnit.move(-1,0);
        testUnit.move(0,1);
        assertEquals(9,testUnit.getX());
        assertEquals(12,testUnit.getY());

        testUnit.setPosition(testMap.getCell(10,11));
        testUnit.move(1,0);
        testUnit.move(0,-1);
        assertEquals(11,testUnit.getX());
        assertEquals(10,testUnit.getY());
    }

    @Test
    public void cellWalkable(){
        Unit testUnit = new Unit("Test Unit",5,2,5,6,2);
        Map testMap = new Map("Test Map",1280,720);

        testUnit.setPosition(testMap.getCell(10,11));

        assertEquals(10,testUnit.getX());
        assertEquals(11,testUnit.getY());

        assertFalse(testMap.getCell(10,11).isWalkable());
        testUnit.move(1,0);
        assertFalse(testMap.getCell(11,11).isWalkable());
        assertTrue(testMap.getCell(10,11).isWalkable());
    }

    @Test
    public void BlockedMovementTest(){
        Unit testUnit = new Unit("Test Unit",5,2,5,6,2);
        Map testMap = new Map("Test Map",1280,720);

        testMap.getCell(11,11).setWalkable(false);
        testMap.getCell(9,11).setWalkable(false);
        testMap.getCell(10,12).setWalkable(false);
        testMap.getCell(10,10).setWalkable(false);

        testUnit.setPosition(testMap.getCell(10,11));
        assertEquals(10,testUnit.getX());
        assertEquals(11,testUnit.getY());

        testUnit.move(1,0);
        assertEquals(10,testUnit.getX());
        testUnit.move(-1,0);
        assertEquals(10,testUnit.getX());

        testUnit.move(0,1);
        assertEquals(11,testUnit.getY());
        testUnit.move(0,-1);
        assertEquals(11,testUnit.getY());
    }

    @Test
    public void MoveOutOfBoundsTest(){
        Unit testUnit = new Unit("Test Unit",5,2,5,6,2);
        Map testMap = new Map("Test Map",1280,720);

        testUnit.setPosition(testMap.getCell(0,0));
        assertEquals(0,testUnit.getX());
        assertEquals(0,testUnit.getY());

        testUnit.move(-1,0);
        assertEquals(0,testUnit.getX());
        testUnit.move(0,-1);
        assertEquals(0,testUnit.getY());

        testUnit.setPosition(testMap.getCell(1279,719));
        assertEquals(1279,testUnit.getX());
        assertEquals(719,testUnit.getY());

        testUnit.move(1,0);
        assertEquals(1279,testUnit.getX());
        testUnit.move(0,1);
        assertEquals(719,testUnit.getY());
    }

    @Test
    public void UnitInTheWayMovement(){
        Unit testUnit = new Unit("Test Unit",5,2,5,6,2);
        Unit testUnit2 = new Unit("Test Unit",5,2,5,6,2);
        Map testMap = new Map("Test Map",1280,720);

        testUnit.setPosition(testMap.getCell(10,10));
        testUnit2.setPosition(testMap.getCell(11,10));
        assertEquals(10,testUnit.getX());
        assertEquals(10,testUnit.getY());
        assertEquals(11,testUnit2.getX());
        assertEquals(10,testUnit2.getY());

        testUnit.move(1,0);
        assertEquals(10,testUnit.getX());
        assertEquals(10,testUnit.getY());
        testUnit2.setPosition(testMap.getCell(9,10));

        testUnit.move(-1,0);
        assertEquals(10,testUnit.getX());
        assertEquals(10,testUnit.getY());
        testUnit2.setPosition(testMap.getCell(10,11));

        testUnit.move(0,1);
        assertEquals(10,testUnit.getX());
        assertEquals(10,testUnit.getY());
        testUnit2.setPosition(testMap.getCell(10,9));

        testUnit.move(0,-1);
        assertEquals(10,testUnit.getX());
        assertEquals(10,testUnit.getY());
    }

    @Test
    public void PositionRedefinition(){
        Unit testUnit = new Unit("Test Unit",5,2,5,6,2);
        Map testMap = new Map("Test Map",1280,720);

        testUnit.setPosition(testMap.getCell(0,0));
        assertEquals(0,testUnit.getX());
        assertEquals(0,testUnit.getY());

        assertFalse(testMap.getCell(0,0).isWalkable());
        testUnit.setPosition(testMap.getCell(10,10));
        assertTrue(testMap.getCell(0,0).isWalkable());
    }

    @Test
    public void CellWalkacleAfterDeath(){
        Unit testUnit = new Unit("Test Unit",5,2,5,6,2);
        Unit testUnit2 = new Unit("Test Unit",5,2,5,6,2);
        Map testMap = new Map("Test Map",1280,720);

        testUnit.setPosition(testMap.getCell(0,0));
        testUnit2.setPosition(testMap.getCell(1,0));
        assertEquals(0,testUnit.getX());
        assertEquals(0,testUnit.getY());
        assertEquals(1,testUnit2.getX());
        assertEquals(0,testUnit2.getY());

        testUnit.takeDamage(1000);
        assertTrue(testUnit.isDead());
        assertTrue(testMap.getCell(0,0).isWalkable());

        testUnit2.move(-1,0);
        assertEquals(0,testUnit2.getX());
        assertEquals(0,testUnit2.getY());
    }

    @Test
    public void testDodgeValueGeneration(){
        Unit testUnit = new Unit("Test Unit",5,2,0,6,2);

        for(int i=0;i<1000000;++i){
            double val = testUnit.generateDodgeVal();
            assertTrue(val>0);
            assertTrue(val<=100);
        }
    }

    @Test
    public void testTestMode(){
        Unit testUnit = new Unit("Test Unit",5,2,0,6,2);

        assertFalse(testUnit.getTestMode());

        testUnit.setTestMode(true);
        assertTrue(testUnit.getTestMode());

        testUnit.setTestModeValue(0);
        assertEquals(0,testUnit.generateDodgeVal(),0.01);

        testUnit.setTestModeValue(100);
        assertEquals(100,testUnit.generateDodgeVal(),0.01);

        testUnit.setTestModeValue(1000);
        assertEquals(100,testUnit.generateDodgeVal(),0.01);
    }

    @Test
    public void testTestModeWithSpeedModifier(){
        Unit testUnit = new Unit("Test Unit",5,2,10,6,2);

        assertFalse(testUnit.getTestMode());

        testUnit.setTestMode(true);
        assertTrue(testUnit.getTestMode());

        testUnit.setTestModeValue(0);
        assertEquals(0,testUnit.generateDodgeVal(),0.01);

        testUnit.setTestModeValue(100);
        assertEquals(100,testUnit.generateDodgeVal(),0.01);

        testUnit.setTestModeValue(1000);
        assertEquals(100,testUnit.generateDodgeVal(),0.01);
    }

    @Test
    public void testModeValueCannotGoOver100(){
        Unit testUnit = new Unit("Test Unit",5,2,10,6,2);

        assertFalse(testUnit.getTestMode());

        testUnit.setTestMode(true);
        assertTrue(testUnit.getTestMode());

        testUnit.setTestModeValue(100000);
        assertEquals(100,testUnit.getTestModeValue(),0.01);

        assertEquals(100,testUnit.getTestModeValue(),0.01);
    }

    @Test
    public void cantSetPositionUnitAlreadyThere(){
        Unit testUnit =  new Unit("Test Unit",5,2,10,6,2);
        Unit testUnit2 =  new Unit("Test Unit",5,2,10,6,2);
        Map testMap = new Map("Test Map",10,10);

        testUnit.setPosition(testMap.getCell(0,0));
        assertEquals(0,testUnit.getX());
        assertEquals(0,testUnit.getY());

        testUnit2.setPosition(testMap.getCell(0,0));
        assertEquals(null,testUnit2.getPosition());

        testUnit2.setPosition(testMap.getCell(1,0));
        assertEquals(1,testUnit2.getX());
        assertEquals(0,testUnit2.getY());
    }

    @Test
    public void positionNotSetTest(){
        Unit testUnit =  new Unit("Test Unit",5,2,10,6,2);
        Map testMap = new Map("Test Map",10,10);

        assertEquals(-1,testUnit.getY());
        assertEquals(-1,testUnit.getX());

        testUnit.setPosition(testMap.getCell(0,0));
        assertEquals(0,testUnit.getX());
        assertEquals(0,testUnit.getY());
    }

    @Test
    public void movetoCellTest(){
        Unit testUnit =  new Unit("Test Unit",5,2,10,6,2);
        Map testMap = new Map("Test Map",10,10);
        testUnit.setPosition(testMap.getCell(10,10));

        assertEquals(10,testUnit.getX());
        assertEquals(10,testUnit.getY());

        testUnit.moveToCell(testMap.getCell(13,16));
        assertEquals(13,testUnit.getX());
        assertEquals(16,testUnit.getY());
    }
}
