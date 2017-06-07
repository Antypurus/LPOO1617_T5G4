
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
        testUnit.takeDamage(1);
        assertEquals(59,testUnit.getHP(),0.01);
        testUnit.takeDamage(1);
        assertEquals(58,testUnit.getHP(),0.01);
        testUnit.takeDamage(1);
        assertEquals(57,testUnit.getHP(),0.01);
        testUnit.takeDamage(1);
        assertEquals(56,testUnit.getHP(),0.01);
        testUnit.takeDamage(1);
        assertEquals(55,testUnit.getHP(),0.01);
        testUnit.takeDamage(1);
        assertEquals(54,testUnit.getHP(),0.01);
        testUnit.takeDamage(1);
        assertEquals(53,testUnit.getHP(),0.01);
        testUnit.takeDamage(1);
        assertEquals(52,testUnit.getHP(),0.01);
        testUnit.takeDamage(1);
        assertEquals(51,testUnit.getHP(),0.01);
        testUnit.takeDamage(1);
        assertEquals(50,testUnit.getHP(),0.01);
        testUnit.takeDamage(1);
        assertEquals(49,testUnit.getHP(),0.01);
        testUnit.takeDamage(1);
        assertEquals(48,testUnit.getHP(),0.01);
        testUnit.takeDamage(1);
        assertEquals(47,testUnit.getHP(),0.01);
        testUnit.takeDamage(1);
        assertEquals(46,testUnit.getHP(),0.01);
        testUnit.takeDamage(1);
        assertEquals(45,testUnit.getHP(),0.01);
        testUnit.takeDamage(1);
        assertEquals(44,testUnit.getHP(),0.01);
        testUnit.takeDamage(1);
        assertEquals(43,testUnit.getHP(),0.01);
        testUnit.takeDamage(1);
        assertEquals(42, testUnit.getHP(),0.01);
        testUnit.takeDamage(1);
        assertEquals(41,testUnit.getHP(),0.01);
        testUnit.takeDamage(1);
        assertEquals(40,testUnit.getHP(),0.01);
        testUnit.takeDamage(1);
        assertEquals(39,testUnit.getHP(),0.01);
        testUnit.takeDamage(1);
        assertEquals(38,testUnit.getHP(),0.01);
        testUnit.takeDamage(1);
        assertEquals(37,testUnit.getHP(),0.01);
        testUnit.takeDamage(1);
        assertEquals(36,testUnit.getHP(),0.01);
        testUnit.takeDamage(1);
        assertEquals(35,testUnit.getHP(),0.01);
        testUnit.takeDamage(1);
        assertEquals(34,testUnit.getHP(),0.01);
        testUnit.takeDamage(1);
        assertEquals(33,testUnit.getHP(),0.01);
        testUnit.takeDamage(1);
        assertEquals(32, testUnit.getHP(),0.01);
        testUnit.takeDamage(1);
        assertEquals(31,testUnit.getHP(),0.01);
        testUnit.takeDamage(1);
        assertEquals(30,testUnit.getHP(),0.01);
        testUnit.takeDamage(1);
        assertEquals(29,testUnit.getHP(),0.01);
        testUnit.takeDamage(1);
        assertEquals(28,testUnit.getHP(),0.01);
        testUnit.takeDamage(1);
        assertEquals(27,testUnit.getHP(),0.01);
        testUnit.takeDamage(1);
        assertEquals(26,testUnit.getHP(),0.01);
        testUnit.takeDamage(1);
        assertEquals(25,testUnit.getHP(),0.01);
        testUnit.takeDamage(1);
        assertEquals(24,testUnit.getHP(),0.01);
        testUnit.takeDamage(1);
        assertEquals(23,testUnit.getHP(),0.01);
        testUnit.takeDamage(1);
        assertEquals(22, testUnit.getHP(),0.01);
        testUnit.takeDamage(1);
        assertEquals(21,testUnit.getHP(),0.01);
        testUnit.takeDamage(1);
        assertEquals(20,testUnit.getHP(),0.01);
        testUnit.takeDamage(1);
        assertEquals(19,testUnit.getHP(),0.01);
        testUnit.takeDamage(1);
        assertEquals(18,testUnit.getHP(),0.01);
        testUnit.takeDamage(1);
        assertEquals(17,testUnit.getHP(),0.01);
        testUnit.takeDamage(1);
        assertEquals(16,testUnit.getHP(),0.01);
        testUnit.takeDamage(1);
        assertEquals(15,testUnit.getHP(),0.01);
        testUnit.takeDamage(1);
        assertEquals(14,testUnit.getHP(),0.01);
        testUnit.takeDamage(1);
        assertEquals(13,testUnit.getHP(),0.01);
        testUnit.takeDamage(1);
        assertEquals(12, testUnit.getHP(),0.01);
        testUnit.takeDamage(1);
        assertEquals(11,testUnit.getHP(),0.01);
        testUnit.takeDamage(1);
        assertEquals(10,testUnit.getHP(),0.01);
        testUnit.takeDamage(1);
        assertEquals(9,testUnit.getHP(),0.01);
        testUnit.takeDamage(1);
        assertEquals(8,testUnit.getHP(),0.01);
        testUnit.takeDamage(1);
        assertEquals(7,testUnit.getHP(),0.01);
        testUnit.takeDamage(1);
        assertEquals(6,testUnit.getHP(),0.01);
        testUnit.takeDamage(1);
        assertEquals(5,testUnit.getHP(),0.01);
        testUnit.takeDamage(1);
        assertEquals(4,testUnit.getHP(),0.01);
        testUnit.takeDamage(1);
        assertEquals(3,testUnit.getHP(),0.01);
        testUnit.takeDamage(1);
        assertEquals(2, testUnit.getHP(),0.01);
        testUnit.takeDamage(1);
        assertEquals(1,testUnit.getHP(),0.01);
        testUnit.takeDamage(1);
        assertEquals(0,testUnit.getHP(),0.01);

    }

    @Test
    public void HealTest(){
        Unit testUnit = new Unit("Test Unit",5,2,5,6,2);

        testUnit.takeDamage(59);
        assertEquals(1,testUnit.getHP(),0.01);
        testUnit.takeHeal(1);
        assertEquals(2,testUnit.getHP(),0.01);
        testUnit.takeHeal(1);
        assertEquals(3,testUnit.getHP(),0.01);
        testUnit.takeHeal(1);
        assertEquals(4,testUnit.getHP(),0.01);
        testUnit.takeHeal(1);
        assertEquals(5,testUnit.getHP(),0.01);
        testUnit.takeHeal(1);
        assertEquals(6,testUnit.getHP(),0.01);
        testUnit.takeHeal(1);
        assertEquals(7,testUnit.getHP(),0.01);
        testUnit.takeHeal(1);
        assertEquals(8,testUnit.getHP(),0.01);
        testUnit.takeHeal(1);
        assertEquals(9,testUnit.getHP(),0.01);
        testUnit.takeHeal(1);
        assertEquals(10,testUnit.getHP(),0.01);
        testUnit.takeHeal(1);
        assertEquals(11,testUnit.getHP(),0.01);
        testUnit.takeHeal(1);
        assertEquals(12,testUnit.getHP(),0.01);
        testUnit.takeHeal(1);
        assertEquals(13,testUnit.getHP(),0.01);
        testUnit.takeHeal(1);
        assertEquals(14,testUnit.getHP(),0.01);
        testUnit.takeHeal(1);
        assertEquals(15,testUnit.getHP(),0.01);
        testUnit.takeHeal(1);
        assertEquals(16,testUnit.getHP(),0.01);
        testUnit.takeHeal(1);
        assertEquals(17,testUnit.getHP(),0.01);
        testUnit.takeHeal(1);
        assertEquals(18, testUnit.getHP(),0.01);
        testUnit.takeHeal(1);
        assertEquals(19,testUnit.getHP(),0.01);
        testUnit.takeHeal(1);
        assertEquals(20,testUnit.getHP(),0.01);
        testUnit.takeHeal(1);
        assertEquals(21,testUnit.getHP(),0.01);
        testUnit.takeHeal(1);
        assertEquals(22,testUnit.getHP(),0.01);
        testUnit.takeHeal(1);
        assertEquals(23,testUnit.getHP(),0.01);
        testUnit.takeHeal(1);
        assertEquals(24,testUnit.getHP(),0.01);
        testUnit.takeHeal(1);
        assertEquals(25,testUnit.getHP(),0.01);
        testUnit.takeHeal(1);
        assertEquals(26,testUnit.getHP(),0.01);
        testUnit.takeHeal(1);
        assertEquals(27,testUnit.getHP(),0.01);
        testUnit.takeHeal(1);
        assertEquals(28, testUnit.getHP(),0.01);
        testUnit.takeHeal(1);
        assertEquals(29,testUnit.getHP(),0.01);
        testUnit.takeHeal(1);
        assertEquals(30,testUnit.getHP(),0.01);
        testUnit.takeHeal(1);
        assertEquals(31,testUnit.getHP(),0.01);
        testUnit.takeHeal(1);
        assertEquals(32,testUnit.getHP(),0.01);
        testUnit.takeHeal(1);
        assertEquals(33,testUnit.getHP(),0.01);
        testUnit.takeHeal(1);
        assertEquals(34,testUnit.getHP(),0.01);
        testUnit.takeHeal(1);
        assertEquals(35,testUnit.getHP(),0.01);
        testUnit.takeHeal(1);
        assertEquals(36,testUnit.getHP(),0.01);
        testUnit.takeHeal(1);
        assertEquals(37,testUnit.getHP(),0.01);
        testUnit.takeHeal(1);
        assertEquals(38, testUnit.getHP(),0.01);
        testUnit.takeHeal(1);
        assertEquals(39,testUnit.getHP(),0.01);
        testUnit.takeHeal(1);
        assertEquals(40,testUnit.getHP(),0.01);
        testUnit.takeHeal(1);
        assertEquals(41,testUnit.getHP(),0.01);
        testUnit.takeHeal(1);
        assertEquals(42,testUnit.getHP(),0.01);
        testUnit.takeHeal(1);
        assertEquals(43,testUnit.getHP(),0.01);
        testUnit.takeHeal(1);
        assertEquals(44,testUnit.getHP(),0.01);
        testUnit.takeHeal(1);
        assertEquals(45,testUnit.getHP(),0.01);
        testUnit.takeHeal(1);
        assertEquals(46,testUnit.getHP(),0.01);
        testUnit.takeHeal(1);
        assertEquals(47,testUnit.getHP(),0.01);
        testUnit.takeHeal(1);
        assertEquals(48, testUnit.getHP(),0.01);
        testUnit.takeHeal(1);
        assertEquals(49,testUnit.getHP(),0.01);
        testUnit.takeHeal(1);
        assertEquals(50,testUnit.getHP(),0.01);
        testUnit.takeHeal(1);
        assertEquals(51,testUnit.getHP(),0.01);
        testUnit.takeHeal(1);
        assertEquals(52,testUnit.getHP(),0.01);
        testUnit.takeHeal(1);
        assertEquals(53,testUnit.getHP(),0.01);
        testUnit.takeHeal(1);
        assertEquals(54,testUnit.getHP(),0.01);
        testUnit.takeHeal(1);
        assertEquals(55,testUnit.getHP(),0.01);
        testUnit.takeHeal(1);
        assertEquals(56,testUnit.getHP(),0.01);
        testUnit.takeHeal(1);
        assertEquals(57,testUnit.getHP(),0.01);
        testUnit.takeHeal(1);
        assertEquals(58, testUnit.getHP(),0.01);
        testUnit.takeHeal(1);
        assertEquals(59,testUnit.getHP(),0.01);
        testUnit.takeHeal(1);
        assertEquals(60,testUnit.getHP(),0.01);
    }

    @Test
    public void OverHealTest(){
        Unit testUnit = new Unit("Test Unit",5,2,5,6,2);

        assertEquals(60,testUnit.getHP(),0.01);
        testUnit.takeHeal(100);
        assertEquals(60,testUnit.getHP(),0.01);

        testUnit.takeHeal(1);
        assertEquals(60,testUnit.getHP(),0.01);
        testUnit.takeHeal(2);
        assertEquals(60,testUnit.getHP(),0.01);
        testUnit.takeHeal(3);
        assertEquals(60,testUnit.getHP(),0.01);
        testUnit.takeHeal(4);
        assertEquals(60,testUnit.getHP(),0.01);
        testUnit.takeHeal(5);
        assertEquals(60,testUnit.getHP(),0.01);
        testUnit.takeHeal(6);
        assertEquals(60,testUnit.getHP(),0.01);
        testUnit.takeHeal(7);
        assertEquals(60,testUnit.getHP(),0.01);
        testUnit.takeHeal(8);
        assertEquals(60,testUnit.getHP(),0.01);
        testUnit.takeHeal(9);
        assertEquals(60,testUnit.getHP(),0.01);
        testUnit.takeHeal(10);
        assertEquals(60,testUnit.getHP(),0.01);
        testUnit.takeHeal(11);
        assertEquals(60,testUnit.getHP(),0.01);
        testUnit.takeHeal(12);
        assertEquals(60,testUnit.getHP(),0.01);
        testUnit.takeHeal(13);
        assertEquals(60,testUnit.getHP(),0.01);
        testUnit.takeHeal(14);
        assertEquals(60,testUnit.getHP(),0.01);
        testUnit.takeHeal(15);
        assertEquals(60,testUnit.getHP(),0.01);
        testUnit.takeHeal(16);
        assertEquals(60,testUnit.getHP(),0.01);
        testUnit.takeHeal(17);
        assertEquals(60, testUnit.getHP(),0.01);
        testUnit.takeHeal(18);
        assertEquals(60,testUnit.getHP(),0.01);
        testUnit.takeHeal(19);
        assertEquals(60,testUnit.getHP(),0.01);
        testUnit.takeHeal(20);
        assertEquals(60,testUnit.getHP(),0.01);
        testUnit.takeHeal(21);
        assertEquals(60,testUnit.getHP(),0.01);
        testUnit.takeHeal(22);
        assertEquals(60,testUnit.getHP(),0.01);
        testUnit.takeHeal(23);
        assertEquals(60,testUnit.getHP(),0.01);
        testUnit.takeHeal(24);
        assertEquals(60,testUnit.getHP(),0.01);
        testUnit.takeHeal(25);
        assertEquals(60,testUnit.getHP(),0.01);
        testUnit.takeHeal(26);
        assertEquals(60,testUnit.getHP(),0.01);
        testUnit.takeHeal(27);
        assertEquals(60, testUnit.getHP(),0.01);
        testUnit.takeHeal(28);
        assertEquals(60,testUnit.getHP(),0.01);
        testUnit.takeHeal(29);
        assertEquals(60,testUnit.getHP(),0.01);
        testUnit.takeHeal(30);
        assertEquals(60,testUnit.getHP(),0.01);
        testUnit.takeHeal(31);
        assertEquals(60,testUnit.getHP(),0.01);
        testUnit.takeHeal(32);
        assertEquals(60,testUnit.getHP(),0.01);
        testUnit.takeHeal(33);
        assertEquals(60,testUnit.getHP(),0.01);
        testUnit.takeHeal(34);
        assertEquals(60,testUnit.getHP(),0.01);
        testUnit.takeHeal(35);
        assertEquals(60,testUnit.getHP(),0.01);
        testUnit.takeHeal(36);
        assertEquals(60,testUnit.getHP(),0.01);
        testUnit.takeHeal(37);
        assertEquals(60, testUnit.getHP(),0.01);
        testUnit.takeHeal(38);
        assertEquals(60,testUnit.getHP(),0.01);
        testUnit.takeHeal(39);
        assertEquals(60,testUnit.getHP(),0.01);
        testUnit.takeHeal(40);
        assertEquals(60,testUnit.getHP(),0.01);
        testUnit.takeHeal(41);
        assertEquals(60,testUnit.getHP(),0.01);
        testUnit.takeHeal(42);
        assertEquals(60,testUnit.getHP(),0.01);
        testUnit.takeHeal(43);
        assertEquals(60,testUnit.getHP(),0.01);
        testUnit.takeHeal(44);
        assertEquals(60,testUnit.getHP(),0.01);
        testUnit.takeHeal(45);
        assertEquals(60,testUnit.getHP(),0.01);
        testUnit.takeHeal(46);
        assertEquals(60,testUnit.getHP(),0.01);
        testUnit.takeHeal(47);
        assertEquals(60, testUnit.getHP(),0.01);
        testUnit.takeHeal(48);
        assertEquals(60,testUnit.getHP(),0.01);
        testUnit.takeHeal(49);
        assertEquals(60,testUnit.getHP(),0.01);
        testUnit.takeHeal(50);
        assertEquals(60,testUnit.getHP(),0.01);
        testUnit.takeHeal(51);
        assertEquals(60,testUnit.getHP(),0.01);
        testUnit.takeHeal(52);
        assertEquals(60,testUnit.getHP(),0.01);
        testUnit.takeHeal(53);
        assertEquals(60,testUnit.getHP(),0.01);
        testUnit.takeHeal(54);
        assertEquals(60,testUnit.getHP(),0.01);
        testUnit.takeHeal(55);
        assertEquals(60,testUnit.getHP(),0.01);
        testUnit.takeHeal(56);
        assertEquals(60,testUnit.getHP(),0.01);
        testUnit.takeHeal(57);
        assertEquals(60, testUnit.getHP(),0.01);
        testUnit.takeHeal(58);
        assertEquals(60,testUnit.getHP(),0.01);
        testUnit.takeHeal(59);
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

        testUnit.setPosition(testMap.getCell(0,2));
        assertEquals(0,testUnit.getX());
        assertEquals(2,testUnit.getY());

        testUnit.setPosition(testMap.getCell(0,3));
        assertEquals(0,testUnit.getX());
        assertEquals(3,testUnit.getY());

        testUnit.setPosition(testMap.getCell(0,4));
        assertEquals(0,testUnit.getX());
        assertEquals(4,testUnit.getY());

        testUnit.setPosition(testMap.getCell(0,5));
        assertEquals(0,testUnit.getX());
        assertEquals(5,testUnit.getY());

        testUnit.setPosition(testMap.getCell(0,6));
        assertEquals(0,testUnit.getX());
        assertEquals(6,testUnit.getY());

        testUnit.setPosition(testMap.getCell(0,7));
        assertEquals(0,testUnit.getX());
        assertEquals(7,testUnit.getY());

        testUnit.setPosition(testMap.getCell(0,8));
        assertEquals(0,testUnit.getX());
        assertEquals(8,testUnit.getY());

        testUnit.setPosition(testMap.getCell(0,9));
        assertEquals(0,testUnit.getX());
        assertEquals(9,testUnit.getY());

        testUnit.setPosition(testMap.getCell(1,0));
        assertEquals(1,testUnit.getX());
        assertEquals(0,testUnit.getY());

        testUnit.setPosition(testMap.getCell(1,1));
        assertEquals(1,testUnit.getX());
        assertEquals(1,testUnit.getY());

        testUnit.setPosition(testMap.getCell(1,2));
        assertEquals(1,testUnit.getX());
        assertEquals(2,testUnit.getY());

        testUnit.setPosition(testMap.getCell(1,3));
        assertEquals(1,testUnit.getX());
        assertEquals(3,testUnit.getY());

        testUnit.setPosition(testMap.getCell(1,4));
        assertEquals(1,testUnit.getX());
        assertEquals(4,testUnit.getY());

        testUnit.setPosition(testMap.getCell(1,5));
        assertEquals(1,testUnit.getX());
        assertEquals(5,testUnit.getY());

        testUnit.setPosition(testMap.getCell(1,6));
        assertEquals(1,testUnit.getX());
        assertEquals(6,testUnit.getY());

        testUnit.setPosition(testMap.getCell(1,7));
        assertEquals(1,testUnit.getX());
        assertEquals(7,testUnit.getY());

        testUnit.setPosition(testMap.getCell(1,8));
        assertEquals(1,testUnit.getX());
        assertEquals(8,testUnit.getY());

        testUnit.setPosition(testMap.getCell(1,9));
        assertEquals(1,testUnit.getX());
        assertEquals(9,testUnit.getY());

        testUnit.setPosition(testMap.getCell(2,0));
        assertEquals(2,testUnit.getX());
        assertEquals(0,testUnit.getY());

        testUnit.setPosition(testMap.getCell(2,1));
        assertEquals(2,testUnit.getX());
        assertEquals(1,testUnit.getY());

        testUnit.setPosition(testMap.getCell(2,2));
        assertEquals(2,testUnit.getX());
        assertEquals(2,testUnit.getY());

        testUnit.setPosition(testMap.getCell(2,3));
        assertEquals(2,testUnit.getX());
        assertEquals(3,testUnit.getY());

        testUnit.setPosition(testMap.getCell(2,4));
        assertEquals(2,testUnit.getX());
        assertEquals(4,testUnit.getY());


        testUnit.setPosition(testMap.getCell(2,5));
        assertEquals(2,testUnit.getX());
        assertEquals(5,testUnit.getY());

        testUnit.setPosition(testMap.getCell(2,6));
        assertEquals(2,testUnit.getX());
        assertEquals(6,testUnit.getY());

        testUnit.setPosition(testMap.getCell(2,7));
        assertEquals(2,testUnit.getX());
        assertEquals(7,testUnit.getY());

        testUnit.setPosition(testMap.getCell(2,8));
        assertEquals(2,testUnit.getX());
        assertEquals(8,testUnit.getY());

        testUnit.setPosition(testMap.getCell(2,9));
        assertEquals(2,testUnit.getX());
        assertEquals(9,testUnit.getY());

        testUnit.setPosition(testMap.getCell(3,0));
        assertEquals(3,testUnit.getX());
        assertEquals(0,testUnit.getY());

        testUnit.setPosition(testMap.getCell(3,1));
        assertEquals(3,testUnit.getX());
        assertEquals(1,testUnit.getY());

        testUnit.setPosition(testMap.getCell(3,2));
        assertEquals(3,testUnit.getX());
        assertEquals(2,testUnit.getY());

        testUnit.setPosition(testMap.getCell(3,3));
        assertEquals(3,testUnit.getX());
        assertEquals(3,testUnit.getY());

        testUnit.setPosition(testMap.getCell(3,4));
        assertEquals(3,testUnit.getX());
        assertEquals(4,testUnit.getY());

        testUnit.setPosition(testMap.getCell(3,5));
        assertEquals(3,testUnit.getX());
        assertEquals(5,testUnit.getY());

        testUnit.setPosition(testMap.getCell(3,6));
        assertEquals(3,testUnit.getX());
        assertEquals(6,testUnit.getY());

        testUnit.setPosition(testMap.getCell(3,7));
        assertEquals(3,testUnit.getX());
        assertEquals(7,testUnit.getY());

        testUnit.setPosition(testMap.getCell(3,8));
        assertEquals(3,testUnit.getX());
        assertEquals(8,testUnit.getY());

        testUnit.setPosition(testMap.getCell(3,9));
        assertEquals(3,testUnit.getX());
        assertEquals(9,testUnit.getY());

        testUnit.setPosition(testMap.getCell(4,0));
        assertEquals(4,testUnit.getX());
        assertEquals(0,testUnit.getY());

        testUnit.setPosition(testMap.getCell(4,1));
        assertEquals(4,testUnit.getX());
        assertEquals(1,testUnit.getY());

        testUnit.setPosition(testMap.getCell(4,2));
        assertEquals(4,testUnit.getX());
        assertEquals(2,testUnit.getY());

        testUnit.setPosition(testMap.getCell(4,3));
        assertEquals(4,testUnit.getX());
        assertEquals(3,testUnit.getY());

        testUnit.setPosition(testMap.getCell(4,4));
        assertEquals(4,testUnit.getX());
        assertEquals(4,testUnit.getY());

        testUnit.setPosition(testMap.getCell(4,5));
        assertEquals(4,testUnit.getX());
        assertEquals(5,testUnit.getY());

        testUnit.setPosition(testMap.getCell(4,6));
        assertEquals(4,testUnit.getX());
        assertEquals(6,testUnit.getY());

        testUnit.setPosition(testMap.getCell(4,7));
        assertEquals(4,testUnit.getX());
        assertEquals(7,testUnit.getY());

        testUnit.setPosition(testMap.getCell(4,8));
        assertEquals(4,testUnit.getX());
        assertEquals(8,testUnit.getY());

        testUnit.setPosition(testMap.getCell(4,9));
        assertEquals(4,testUnit.getX());
        assertEquals(9,testUnit.getY());

        testUnit.setPosition(testMap.getCell(5,0));
        assertEquals(5,testUnit.getX());
        assertEquals(0,testUnit.getY());

        testUnit.setPosition(testMap.getCell(5,1));
        assertEquals(5,testUnit.getX());
        assertEquals(1,testUnit.getY());

        testUnit.setPosition(testMap.getCell(5,2));
        assertEquals(5,testUnit.getX());
        assertEquals(2,testUnit.getY());

        testUnit.setPosition(testMap.getCell(5,3));
        assertEquals(5,testUnit.getX());
        assertEquals(3,testUnit.getY());

        testUnit.setPosition(testMap.getCell(5,4));
        assertEquals(5,testUnit.getX());
        assertEquals(4,testUnit.getY());

        testUnit.setPosition(testMap.getCell(5,5));
        assertEquals(5,testUnit.getX());
        assertEquals(5,testUnit.getY());

        testUnit.setPosition(testMap.getCell(5,6));
        assertEquals(5,testUnit.getX());
        assertEquals(6,testUnit.getY());

        testUnit.setPosition(testMap.getCell(5,7));
        assertEquals(5,testUnit.getX());
        assertEquals(7,testUnit.getY());

        testUnit.setPosition(testMap.getCell(5,8));
        assertEquals(5,testUnit.getX());
        assertEquals(8,testUnit.getY());

        testUnit.setPosition(testMap.getCell(5,9));
        assertEquals(5,testUnit.getX());
        assertEquals(9,testUnit.getY());

        testUnit.setPosition(testMap.getCell(6,0));
        assertEquals(6,testUnit.getX());
        assertEquals(0,testUnit.getY());

        testUnit.setPosition(testMap.getCell(6,1));
        assertEquals(6,testUnit.getX());
        assertEquals(1,testUnit.getY());

        testUnit.setPosition(testMap.getCell(6,2));
        assertEquals(6,testUnit.getX());
        assertEquals(2,testUnit.getY());

        testUnit.setPosition(testMap.getCell(6,3));
        assertEquals(6,testUnit.getX());
        assertEquals(3,testUnit.getY());

        testUnit.setPosition(testMap.getCell(6,4));
        assertEquals(6,testUnit.getX());
        assertEquals(4,testUnit.getY());

        testUnit.setPosition(testMap.getCell(6,5));
        assertEquals(6,testUnit.getX());
        assertEquals(5,testUnit.getY());

        testUnit.setPosition(testMap.getCell(6,6));
        assertEquals(6,testUnit.getX());
        assertEquals(6,testUnit.getY());

        testUnit.setPosition(testMap.getCell(6,7));
        assertEquals(6,testUnit.getX());
        assertEquals(7,testUnit.getY());

        testUnit.setPosition(testMap.getCell(6,8));
        assertEquals(6,testUnit.getX());
        assertEquals(8,testUnit.getY());

        testUnit.setPosition(testMap.getCell(6,9));
        assertEquals(6,testUnit.getX());
        assertEquals(9,testUnit.getY());

        testUnit.setPosition(testMap.getCell(7,0));
        assertEquals(7,testUnit.getX());
        assertEquals(0,testUnit.getY());

        testUnit.setPosition(testMap.getCell(7,1));
        assertEquals(7,testUnit.getX());
        assertEquals(1,testUnit.getY());

        testUnit.setPosition(testMap.getCell(7,2));
        assertEquals(7,testUnit.getX());
        assertEquals(2,testUnit.getY());

        testUnit.setPosition(testMap.getCell(7,3));
        assertEquals(7,testUnit.getX());
        assertEquals(3,testUnit.getY());

        testUnit.setPosition(testMap.getCell(7,4));
        assertEquals(7,testUnit.getX());
        assertEquals(4,testUnit.getY());

        testUnit.setPosition(testMap.getCell(7,5));
        assertEquals(7,testUnit.getX());
        assertEquals(5,testUnit.getY());

        testUnit.setPosition(testMap.getCell(7,6));
        assertEquals(7,testUnit.getX());
        assertEquals(6,testUnit.getY());

        testUnit.setPosition(testMap.getCell(7,7));
        assertEquals(7,testUnit.getX());
        assertEquals(7,testUnit.getY());

        testUnit.setPosition(testMap.getCell(7,8));
        assertEquals(7,testUnit.getX());
        assertEquals(8,testUnit.getY());

        testUnit.setPosition(testMap.getCell(7,9));
        assertEquals(7,testUnit.getX());
        assertEquals(9,testUnit.getY());

        testUnit.setPosition(testMap.getCell(8,0));
        assertEquals(8,testUnit.getX());
        assertEquals(0,testUnit.getY());

        testUnit.setPosition(testMap.getCell(8,1));
        assertEquals(8,testUnit.getX());
        assertEquals(1,testUnit.getY());

        testUnit.setPosition(testMap.getCell(8,2));
        assertEquals(8,testUnit.getX());
        assertEquals(2,testUnit.getY());

        testUnit.setPosition(testMap.getCell(8,3));
        assertEquals(8,testUnit.getX());
        assertEquals(3,testUnit.getY());

        testUnit.setPosition(testMap.getCell(8,4));
        assertEquals(8,testUnit.getX());
        assertEquals(4,testUnit.getY());

        testUnit.setPosition(testMap.getCell(8,5));
        assertEquals(8,testUnit.getX());
        assertEquals(5,testUnit.getY());

        testUnit.setPosition(testMap.getCell(8,6));
        assertEquals(8,testUnit.getX());
        assertEquals(6,testUnit.getY());

        testUnit.setPosition(testMap.getCell(8,7));
        assertEquals(8,testUnit.getX());
        assertEquals(7,testUnit.getY());

        testUnit.setPosition(testMap.getCell(8,8));
        assertEquals(8,testUnit.getX());
        assertEquals(8,testUnit.getY());

        testUnit.setPosition(testMap.getCell(8,9));
        assertEquals(8,testUnit.getX());
        assertEquals(9,testUnit.getY());

        testUnit.setPosition(testMap.getCell(9,0));
        assertEquals(9,testUnit.getX());
        assertEquals(0,testUnit.getY());

        testUnit.setPosition(testMap.getCell(9,1));
        assertEquals(9,testUnit.getX());
        assertEquals(1,testUnit.getY());

        testUnit.setPosition(testMap.getCell(9,2));
        assertEquals(9,testUnit.getX());
        assertEquals(2,testUnit.getY());

        testUnit.setPosition(testMap.getCell(9,3));
        assertEquals(9,testUnit.getX());
        assertEquals(3,testUnit.getY());

        testUnit.setPosition(testMap.getCell(9,4));
        assertEquals(9,testUnit.getX());
        assertEquals(4,testUnit.getY());

        testUnit.setPosition(testMap.getCell(9,5));
        assertEquals(9,testUnit.getX());
        assertEquals(5,testUnit.getY());

        testUnit.setPosition(testMap.getCell(9,6));
        assertEquals(9,testUnit.getX());
        assertEquals(6,testUnit.getY());

        testUnit.setPosition(testMap.getCell(9,7));
        assertEquals(9,testUnit.getX());
        assertEquals(7,testUnit.getY());

        testUnit.setPosition(testMap.getCell(9,8));
        assertEquals(9,testUnit.getX());
        assertEquals(8,testUnit.getY());

        testUnit.setPosition(testMap.getCell(9,9));
        assertEquals(9,testUnit.getX());
        assertEquals(9,testUnit.getY());
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
        testUnit.setPosition(testMap.getCell(9,9));

        assertEquals(9,testUnit.getX());
        assertEquals(9,testUnit.getY());

        testUnit.moveToCell(testMap.getCell(0,0));
        assertEquals(0,testUnit.getX());
        assertEquals(0,testUnit.getY());

        testUnit.moveToCell(testMap.getCell(0,1));
        assertEquals(0,testUnit.getX());
        assertEquals(1,testUnit.getY());

    }
}
