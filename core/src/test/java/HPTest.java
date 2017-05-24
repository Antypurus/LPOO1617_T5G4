import org.junit.Test;

import main.Logic.Unit.Stats.HP;
import main.Logic.Unit.Stats.Vitality;

import static org.junit.Assert.assertEquals;

public class HPTest {

    @Test
    public void testCreation(){
        Vitality testVitality = new Vitality(10);
        HP testHp = new HP(testVitality);

        assertEquals(100,testHp.BaseValue,0.01);
        assertEquals(100,testHp.EffectiveValue,0.01);
        assertEquals(100,testHp.maxValue,0.01);
    }

    @Test
    public void queueModifiersTest(){
        Vitality testVitality = new Vitality(10);
        HP testHp = new HP(testVitality);

        testHp.queueModifier(-10);
        assertEquals(100,testHp.EffectiveValue,0.01);
        testHp.update();
        assertEquals(90,testHp.EffectiveValue,0.01);

        testHp.queueModifier(100);
        assertEquals(90,testHp.EffectiveValue,0.01);
        testHp.update();
        assertEquals(100,testHp.EffectiveValue,0.01);
    }

    @Test
    public void applyDeltasTest(){
        Vitality testVitality = new Vitality(10);
        HP testHp = new HP(testVitality);

        assertEquals(100,testHp.EffectiveValue,0.01);
        testHp.addDelta(-5);
        assertEquals(100,testHp.EffectiveValue,0.01);
        testHp.update();
        assertEquals(95,testHp.EffectiveValue,0.01);

        testHp.addDelta(+5);
        assertEquals(95,testHp.EffectiveValue,0.01);
        testHp.update();
        assertEquals(95,testHp.EffectiveValue,0.01);

        testHp.addDelta(-50000000);
        assertEquals(95,testHp.EffectiveValue,0.01);
        testHp.update();
        assertEquals(1,testHp.EffectiveValue,0.01);
    }

    @Test
    public void removeDeltaTest(){
        Vitality testVitality = new Vitality(10);
        HP testHp = new HP(testVitality);

        assertEquals(100,testHp.EffectiveValue,0.01);
        testHp.addDelta(-5);
        assertEquals(100,testHp.EffectiveValue,0.01);
        testHp.queueModifier(5);
        testHp.update();
        assertEquals(95,testHp.EffectiveValue,0.01);

        testHp.removeDelta(-5);
        assertEquals(95,testHp.EffectiveValue,0.01);
        testHp.queueModifier(5);
        testHp.update();
        assertEquals(100,testHp.EffectiveValue,0.01);

        testHp.addDelta(-5);
        testHp.addDelta(-5);
        assertEquals(100,testHp.EffectiveValue,0.01);
        testHp.update();
        assertEquals(90,testHp.EffectiveValue,0.01);
        testHp.removeDelta(-5);
        testHp.queueModifier(10);
        testHp.update();
        assertEquals(95,testHp.EffectiveValue,0.01);
    }

    @Test
    public void changeScalingAbility(){
        Vitality testVitality = new Vitality(10);
        HP testHp = new HP(testVitality);

        assertEquals(100,testHp.EffectiveValue,0.01);
        testVitality.modifyVitality(+5);

        testHp.update();
        assertEquals(100,testHp.EffectiveValue,0.01);
        assertEquals(150,testHp.maxValue,0.01);

        testVitality.modifyVitality(-10);
        testHp.update();
        assertEquals(50,testHp.EffectiveValue,0.01);
        assertEquals(50,testHp.maxValue,0.01);
    }

}
