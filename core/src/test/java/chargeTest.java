import org.junit.Test;

import main.Logic.Abilities.Ability;
import main.Logic.Abilities.Physicals.Charge;
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
        
    }
}
