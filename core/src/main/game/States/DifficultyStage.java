package game.States;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Diogo on 24/05/2017.
 */

public class DifficultyStage extends State
{
    private Texture easyBtn;
    private Texture hardBtn;

    public DifficultyStage(GameStateManager gsm) {
        super(gsm);
        easyBtn = new Texture("easy.png");
        hardBtn = new Texture("hard.png");
    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render(SpriteBatch sb) {

    }

    @Override
    public void dispose() {

    }
}
