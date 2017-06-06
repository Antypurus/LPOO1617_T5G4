package game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;


public class InstructionsState extends State
{
    private Texture InstructionsImage, QuitBtn, AttackImage, ChargeImage, FireBallImage,
            HealingImage, MovementImage, PunchImage, StopImage, WaterWhip;

    private ArrayList<Texture> Images = new ArrayList<Texture>();

    public InstructionsState(GameStateManager gsm) {
        super(gsm);
        QuitBtn = new Texture("MenusImages/QuitImage.png");
        InstructionsImage = new Texture("InstructionsImages/InstructionsImage.png");
        Images.add(AttackImage = new Texture("InstructionsImages/AttackImage.png"));
        Images.add(ChargeImage = new Texture("InstructionsImages/ChargeImage.png"));
        Images.add(FireBallImage = new Texture("InstructionsImages/FireBallImage.png"));
        Images.add(HealingImage = new Texture("InstructionsImages/HealingImage.png"));
        Images.add(MovementImage = new Texture("InstructionsImages/MovementImage.png"));
        Images.add(PunchImage = new Texture("InstructionsImages/PunchImage.png"));
        Images.add(StopImage = new Texture("InstructionsImages/StopImage.png"));
        Images.add(WaterWhip = new Texture("InstructionsImages/WaterWhip.png"));
    }

    @Override
    protected void handleInput()
    {
        if(Gdx.input.justTouched())
        {
            if (Gdx.input.getX() >= ((this.screenWidth / 2) - (QuitBtn.getWidth() / 2))
                    && Gdx.input.getX() <= ((screenWidth / 2) + (QuitBtn.getWidth() / 2))
                    && (screenHeight - Gdx.input.getY()) >= (60)
                    && (screenHeight - Gdx.input.getY()) <= ((60) + (QuitBtn.getHeight())))////
            {
                gsm.set(new MenuState(gsm));
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
            Gdx.app.exit();
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
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        sb.begin();
        sb.draw(InstructionsImage, 300, 600);
        for(int i = 0; i < Images.size(); i++)
        sb.draw(Images.get(i), 300, 550 - i*50);
        sb.draw(QuitBtn, screenWidth / 2 - QuitBtn.getWidth()/2, 60);
        sb.end();
    }

    @Override
    public void dispose()
    {
        QuitBtn.dispose();
        InstructionsImage.dispose();
        QuitBtn.dispose();
        AttackImage.dispose();
        ChargeImage.dispose();
        FireBallImage.dispose();
        HealingImage.dispose();
        MovementImage.dispose();
        PunchImage.dispose();
        StopImage.dispose();
        WaterWhip.dispose();;
    }
}
