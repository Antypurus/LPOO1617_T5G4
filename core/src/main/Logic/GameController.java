package Logic;

import java.util.ArrayList;
import java.util.PriorityQueue;

import main.Logic.Map.Map;
import main.Logic.Unit.Unit;

public class GameController {
    private ArrayList<Unit>enemies = new ArrayList<Unit>();
    private ArrayList<Unit>allies = new ArrayList<Unit>();
    private PriorityQueue<Unit>units = new PriorityQueue<Unit>();
    private Difficulty.DifficultyStage currentDifficulty = null;
    private int numberOfChars = 0;
    private Unit currentChar = null;
    private Map gameMap = null;

    /**
     *
     * Constructor for the Game Controller , this class handles turns for the game and calls ai
     * when needed.
     *
     * @param allies an array with the player controller characters with positions already assigned
     * @param enemies an array with the npc's whi AI's pre-atributed with positions already assigned
     * @param difficultyStage the difficulty of the game
     * @param map the game map with unit positions already assigned
     */
    public GameController(Unit[] allies,Unit[] enemies,Difficulty.DifficultyStage difficultyStage,Map map){
        this.gameMap = map;
        this.currentDifficulty = difficultyStage;
        for(int i=0;i<allies.length;++i){
            allies[i].setIsAlly(true);
            this.allies.add(allies[i]);
            this.units.add(allies[i]);
            numberOfChars++;
        }
        for(int i=0;i<enemies.length;++i){
            enemies[i].setIsAlly(false);
            this.enemies.add(enemies[i]);
            this.units.add(enemies[i]);
            numberOfChars++;
        }
        this.currentChar = this.units.peek();
        this.startNextTurn();
    }

    /**
     *
     * returns the current character in the game crotolelr or the character whom the current
     * turn belongs to
     *
     * @return the current character
     */
    public Unit getCurrentChar(){
        return this.currentChar;
    }

    /**
     *
     * returns the map the game is being played in
     *
     * @return the current map
     */
    public Map getGameMap(){
        return this.gameMap;
    }

    /**
     *
     * returns the number of characters in the game
     *
     * @return the number of characters in the game
     */
    public int getNumberOfChars(){
        return this.numberOfChars;
    }

    /**
     *
     * returns the current difficulty of the game
     *
     * @return the current game difficulty
     */
    public Difficulty.DifficultyStage getCurrentDifficulty(){
        return this.currentDifficulty;
    }

    private boolean rebuildUnitQueue(){
        for(int i=0;i<this.allies.size();++i){
            if(!this.allies.get(i).isDead()){
                this.units.add(this.allies.get(i));
            }
        }
        for(int i=0;i<this.enemies.size();++i){
            if(!this.enemies.get(i).isDead()){
                this.units.add(this.enemies.get(i));
            }
        }
        if(this.units.size()==0||this.units.size()==1){
            return false;
        }
        return true;
    }

    /**
     *
     * returns the current number of alive player characters
     *
     * @return alive PC
     */
    public int aliveAllies(){
        int c=0;

        for(int i=0;i<this.allies.size();i++){
            if(!allies.get(i).isDead()){
                c++;
            }
        }

        return c;
    }

    /**
     *
     * retuns the current number of alive npc
     *
     * @return the current number of alive npc
     */
    public int aliveEnemies(){
        int c=0;

        for(int i=0;i<this.enemies.size();i++){
            if(!enemies.get(i).isDead()){
                c++;
            }
        }

        return c;
    }

    /**
     *
     * retuns false if players has not yet won and true if all enemies are dead.
     *
     * @return wether the player has won or not
     */
    public boolean hasWon(){
        if(this.aliveAllies()!=0){
            if(this.aliveEnemies()==0){
                return true;
            }
        }
        return false;
    }

    /**
     *
     * returns if the players has lost the game , returning true is all PC's are dead and false if the
     * player still has characters alive
     *
     * @return whether the player has lost or not
     */
    public boolean hasLost(){
        if(this.aliveAllies()==0){
            if(this.aliveEnemies()!=0){
                return true;
            }
        }
        return false;
    }

    private void startNextTurn(){
        this.currentChar = this.units.peek();
        if(this.currentChar!=null){
            if(!this.currentChar.isDead()) {
                this.currentChar.beginTurn();
            }
        }else{
            return ;
        }
        if(this.currentChar.isAIControlled()){
            if(this.currentChar.getAI()!=null) {
                if(!this.currentChar.isDead()) {
                    this.currentChar.getAI().FullTurnBehavior();
                }
            }
            this.endTurn();//TODO:do we want this ?
        }
    }

    /**
     * ends the turn for the current character , starting the turn of the next one and rebuild
     * the queue of characters if necessary
     */
    public void endTurn(){
        this.units.remove();
        if(this.units.size()==0){
            this.rebuildUnitQueue();
        }
        this.startNextTurn();
    }

    /**
     *
     * returns an arraylist with all the NPC characters
     *
     * @return the NPC characters
     */
    public ArrayList<Unit>getEnemies(){
        return this.enemies;
    }

    /**
     *
     * returns an arraylist with the player controlled characters
     *
     * @return the palyers characters
     */
    public ArrayList<Unit>getAllies(){
        return this.allies;
    }

    /**
     *
     * returns the priotity queue responsible for controlling turn orders
     *
     * @return the priority queue for the turns
     */
    public PriorityQueue<Unit> getUnits(){
        return this.units;
    }
}
