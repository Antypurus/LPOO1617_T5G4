import com.badlogic.gdx.Game;

import org.junit.Test;

import Logic.Difficulty;
import Logic.GameController;
import main.Logic.Map.Map;
import main.Logic.Unit.Unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

public class GameControllerTest {

    @Test
    public void creationTest(){
        Unit[] allies = new Unit[3];
        Unit[] enemies = new Unit[3];
        Map map = new Map("Test Map",30,30);

        Unit allyTestUnit1 = new Unit("Ally Unit 1",5,2,6,5,4);
        Unit allyTestUnit2 = new Unit("Ally Unit 2",5,2,8,5,4);
        Unit allyTestUnit3 = new Unit("Ally Unit 3",5,2,2,5,4);

        Unit enemyTestUnit1 = new Unit("Enemy Unit 1",5,2,4,5,4);
        Unit enemyTestUnit2 = new Unit("Enemy Unit 2",5,2,7,5,4);
        Unit enemyTestUnit3 = new Unit("Enemy Unit 3",5,2,3,5,4);

        allies[0] = allyTestUnit1;
        allies[1] = allyTestUnit2;
        allies[2] = allyTestUnit3;

        enemies[0] = enemyTestUnit1;
        enemies[1] = enemyTestUnit2;
        enemies[2] = enemyTestUnit3;

        allyTestUnit1.setPosition(map.getCell(10,10));
        allyTestUnit2.setPosition(map.getCell(11,10));
        allyTestUnit3.setPosition(map.getCell(12,10));

        enemyTestUnit1.setPosition(map.getCell(10,20));
        enemyTestUnit2.setPosition(map.getCell(11,20));
        enemyTestUnit3.setPosition(map.getCell(12,20));

        GameController currentGame = new GameController(allies,enemies, Difficulty.DifficultyStage.EASY,map);

        assertEquals(Difficulty.DifficultyStage.EASY,currentGame.getCurrentDifficulty());
        assertFalse(currentGame.hasLost());
        assertFalse(currentGame.hasWon());
        assertEquals(6,currentGame.getNumberOfChars());
        assertEquals(map,currentGame.getGameMap());
    }

    @Test
    public void turnOrderTest(){
        Unit[] allies = new Unit[3];
        Unit[] enemies = new Unit[3];
        Map map = new Map("Test Map",30,30);

        Unit allyTestUnit1 = new Unit("Ally Unit 1",5,2,6,5,4);
        Unit allyTestUnit2 = new Unit("Ally Unit 2",5,2,8,5,4);
        Unit allyTestUnit3 = new Unit("Ally Unit 3",5,2,2,5,4);

        Unit enemyTestUnit1 = new Unit("Enemy Unit 1",5,2,4,5,4);
        Unit enemyTestUnit2 = new Unit("Enemy Unit 2",5,2,7,5,4);
        Unit enemyTestUnit3 = new Unit("Enemy Unit 3",5,2,3,5,4);

        allies[0] = allyTestUnit1;
        allies[1] = allyTestUnit2;
        allies[2] = allyTestUnit3;

        enemies[0] = enemyTestUnit1;
        enemies[1] = enemyTestUnit2;
        enemies[2] = enemyTestUnit3;

        allyTestUnit1.setPosition(map.getCell(10,10));
        allyTestUnit2.setPosition(map.getCell(11,10));
        allyTestUnit3.setPosition(map.getCell(12,10));

        enemyTestUnit1.setPosition(map.getCell(10,20));
        enemyTestUnit2.setPosition(map.getCell(11,20));
        enemyTestUnit3.setPosition(map.getCell(12,20));

        GameController currentGame = new GameController(allies,enemies, Difficulty.DifficultyStage.EASY,map);

        assertNotEquals(allyTestUnit1,currentGame.getUnits().peek());

        assertEquals(allyTestUnit2,currentGame.getUnits().poll());
        assertEquals(enemyTestUnit2,currentGame.getUnits().poll());
        assertEquals(allyTestUnit1,currentGame.getUnits().poll());
        assertEquals(enemyTestUnit1,currentGame.getUnits().poll());
        assertEquals(enemyTestUnit3,currentGame.getUnits().poll());
        assertEquals(allyTestUnit3,currentGame.getUnits().poll());
    }

}
