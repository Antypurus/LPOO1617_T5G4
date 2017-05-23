package game.States;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import main.game.MyGdxGame;

public class MenuState extends State
{
    private Texture background;
    private Texture playBtn;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        background = new Texture("black.png");
        playBtn = new Texture("SinglePlayer.png");
    }

    @Override
    protected void handleInput()
    {
        if(Gdx.input.justTouched())
        {
            gsm.set(new PlayState(gsm));
        }
    }

    @Override
    public void update(float dt)
    {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb)
    {
        sb.begin();
        sb.draw(background, 0,0, MyGdxGame.WIDTH, MyGdxGame.HEIGHT);
        sb.draw(playBtn, (MyGdxGame.WIDTH/2)- (playBtn.getWidth()/2), MyGdxGame.HEIGHT/2);
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        playBtn.dispose();
    }
}
