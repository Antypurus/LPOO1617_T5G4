package game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

import main.game.MyGdxGame;


public class InstructionsState extends State
{
    private final int quitYCoord = 50;
    private final int instructionsXPos = 300;
    private final int instructionsYPos = 550;
    private final int titleYPos = instructionsYPos + 70;

    private int quitBtnCenterX;

    private Texture InstructionsImage;
    private Texture quitBtn;
    private Texture AttackImage;
    private Texture ChargeImage;
    private Texture FireBallImage;
    private Texture HealingImage;
    private Texture MovementImage;
    private Texture PunchImage;
    private Texture StopImage;
    private Texture WaterWhip;

    private ArrayList<Texture> Images = new ArrayList<Texture>();

    /**
     *
     * Constructor for the InstructionsState , shows the game's instructions
     *
     * @param gsm a gamestatemanager that will handle
     *            the different states set's and pop's
     */
    public InstructionsState(GameStateManager gsm) {
        super(gsm);

        quitBtn = new Texture("MenusImages/QuitImage.png");
        InstructionsImage = new Texture("InstructionsImages/InstructionsImage.png");
        Images.add(AttackImage = new Texture("InstructionsImages/AttackImage.png"));
        Images.add(ChargeImage = new Texture("InstructionsImages/ChargeImage.png"));
        Images.add(FireBallImage = new Texture("InstructionsImages/FireballImage.png"));
        Images.add(HealingImage = new Texture("InstructionsImages/HealingImage.png"));
        Images.add(WaterWhip = new Texture("InstructionsImages/WaterWhip.png"));
        Images.add(PunchImage = new Texture("InstructionsImages/PunchImage.png"));
        Images.add(MovementImage = new Texture("InstructionsImages/MovementImage.png"));
        Images.add(StopImage = new Texture("InstructionsImages/StopImage.png"));

        this.quitBtnCenterX = quitBtn.getWidth() / 2;
    }


    /**
     *
     * Checks which button the user pressed
     *
     */
    protected void handleInstructionsMouseInput()
    {
        if (handleBtn(quitBtnCenterX, quitYCoord, quitBtn.getHeight()))
        {
            this.dispose();
            gsm.set(new MenuState(gsm));
        }
    }


    @Override
    protected void handleInput()
    {
        if(Gdx.input.justTouched())
            handleInstructionsMouseInput();
        else if(handleEscapeKey())
        {
            this.dispose();
            gsm.set(new MenuState(gsm));
        }
    }

    @Override
    public void update(float dt)
    {
        handleInput();
        clearScreen();
    }

    @Override
    public void render(SpriteBatch sb)
    {
        sb.begin();
        sb.draw(InstructionsImage, instructionsXPos, titleYPos);
        for(int i = 0; i < Images.size(); i++)
        sb.draw(Images.get(i),
                instructionsXPos, instructionsYPos - i*50);
        sb.draw(quitBtn,
                (MyGdxGame.centerXCoord) - (quitBtnCenterX), quitYCoord);
        sb.end();
    }

    @Override
    public void dispose()
    {
        quitBtn.dispose();
        InstructionsImage.dispose();
        quitBtn.dispose();
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
