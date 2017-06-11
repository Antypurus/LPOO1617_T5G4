package game.States;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;


public class GameStateManager {

    private Stack<State> states;

    /**
     *
     * Constructor for the GameStateManager , contains the current state
     *
     */
    public GameStateManager()
    {
        states = new Stack<State>();
    }


    /**
     *
     * pushes a state to the state stack
     *
     * @param state state to be pushed to the state stack
     */
    public void push(State state){
        states.push(state);
    }

    /**
     *
     * pop's the state from the state stack
     *
     */
    public void pop()
    {
        states.pop();
    }

    /**
     *
     * sets the new state
     *
     * @param state state to be pushed to the state stack
     */
    public void set(State state)
    {
        states.pop();
        states.push(state);
    }

    /**
     *
     * calls the update method of the current state in the state stack
     *
     * @param dt time to update
     */
    public void update(float dt)
    {
        states.peek().update(dt);
    }

    /**
     *
     * calls the render method of the current state in the state stack
     *
     * @param sb spritebatch that the states will use
     */
    public void render(SpriteBatch sb)
    {
        states.peek().render(sb);
    }
}
