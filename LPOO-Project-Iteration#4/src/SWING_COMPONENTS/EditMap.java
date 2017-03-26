package SWING_COMPONENTS;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Characters.Oggre;
import Maps.Map;


public class EditMap extends JPanel implements MouseListener, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Oggre O;
	private Image sprite;
	private Image Ogre;
	private Image Wall;
	private Image Hero;
	private Image Door;
	private Map map;
	private boolean isHeroChosen = false;
	private boolean isReadyToPlay = false;
	private ArrayList<Image> Images = new ArrayList<Image>();
	private ArrayList<Integer> X = new ArrayList<Integer>();
	private ArrayList<Integer> Y = new ArrayList<Integer>();
	private String type;
	private static final int pixel_size = 30;
	private static final int map_height = 10;
	private static final int map_width = 10;
	
    /**
	 * Load the images that will be drawn on screen
     *
     */
	public EditMap()
	{
		addMouseListener(this);
		this.Ogre = new ImageIcon(this.getClass().getResource("/SWING_COMPONENTS/ogredown.png")).getImage();
		this.Door = new ImageIcon(this.getClass().getResource("/SWING_COMPONENTS/openableDoor.jpg")).getImage();
		this.Wall = new ImageIcon(this.getClass().getResource("/SWING_COMPONENTS/wall red.png")).getImage();
		this.Hero = new ImageIcon(this.getClass().getResource("/SWING_COMPONENTS/heroright.png")).getImage();
	}
	
    /**
	 * Checks if the image that will be drawn is currently null
	 * Check if the user pressed the exit button
     *
     * @param type the member type will be equal to this param
     */
	public void setType(String type)
	{
		this.type = type;
		 if(type != null) {
		 if(type.equals("Exit"))
			System.exit(0);
		 }
	}
	
    /**
	 * When the game is ready to be played this function is called
     *
     * @param b the member isreadytoplay will be equal to this param
     */
	public void setisReadyToPlay(boolean b)
	{
		this.isReadyToPlay = b;
	}
    /**
	 * Checks if the game is ready to be played
     *
     * @return value of isreadytoplay
     */
	public boolean isReadyToPlay()
	{
		return this.isReadyToPlay;
	}
    /**
	 * Checks which button was pressed with which image
	 * Adds the images to the arrayList images
	 * Draws all the images added to the image arrayList
     *
     * @param g draws the screen
     */
	@Override
	protected void paintComponent(Graphics g)
	{
		 super.paintComponent(g);
		 
		 if(type != null) {
		 if(type.equals("Ogre")){
			Images.add(Ogre);
			O = new Oggre(X.get(X.size()-1), Y.get(Y.size() -1));
		 }
		 if(type.equals("Hero") && !this.isHeroChosen){
			this.isHeroChosen = true;
			Images.add(Hero);
		 }
		 if(type.equals("Door"))
			Images.add(Door);
		 if(type.equals("Wall"))
			Images.add(Wall);
		 }
		 
		 for(int i = 0; i < Images.size(); i++)
		 {
			 g.drawImage(Images.get(i), X.get(i), Y.get(i), this);
		 }
		 
//		 if(sprite != null)
//		 g.drawImage(sprite,x, y,this);
	}

    /**
     * when the mouse is clicked in the panel
     * the coordinates of the click will be verified
     * and the final coordinates will be 
     * the top left corner of a 30x30 square
     *
     * @param arg0 handles the mouse events
     */
	@Override
	public void mouseClicked(MouseEvent arg0) {
		for(int i = 1; i <= map_width; i++)
		{
			if(arg0.getX() < pixel_size * i)
			for(int j = 1; j <= map_height; j++){
				if(arg0.getY() < pixel_size * j){
				this.X.add(pixel_size*i-pixel_size);
				this.Y.add(pixel_size*j-pixel_size);
				this.repaint();
				return;
			}
			}
		}
		this.repaint();
		
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
