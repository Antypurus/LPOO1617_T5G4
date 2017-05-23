import org.junit.Test;

import main.Logic.Abilities.Ability;
import main.Logic.Abilities.Spells.Fireball;
import main.Logic.ElementSystem.Element;
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

        assertEquals(100,testFireBall.getBaseDamage(),0.01);
        assertEquals(100,testFireBall.getHitChance(),0.01);
        assertEquals(10,testFireBall.getManaCost(),0.01);
        assertEquals(10,testFireBall.getRange());
        assertEquals(0,testFireBall.getAOE());
        assertEquals(testUnit.StatFind("INT"),testFireBall.getScalingStat());
        assertEquals(Element.DamageElement.FIRE,testFireBall.getDamageElement());
        assertEquals(Element.DamageType.Magical,testFireBall.getDamageType());
        assertEquals(Element.type.DAMAGE,testFireBall.getType());
    }
}
