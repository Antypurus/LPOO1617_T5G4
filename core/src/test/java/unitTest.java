
import org.junit    .Test;

import java.util.regex.Pattern;

import Logic.Unit.Unit;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class unitTest {

    @Test
    public void stat_validation(){
        Unit unit = new Unit("Test",1,1,1,1,1);
        assertEquals(10,unit.getHP(),0.01);
    }

}
