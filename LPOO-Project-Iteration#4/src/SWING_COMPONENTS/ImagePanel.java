package SWING_COMPONENTS;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagePanel extends JPanel implements MouseListener, MouseMotionListener, KeyListener{

    private Image ogre;
    private Image wall;
    private Image closeddoor;
    private Image openabledoor;
    private Image opendoor;
    private Image guard;
    private Image lever;
    private Image turnedlever;
    private Image hero;
    private static final int map_width = 10;
    private static final int map_height = 10;
    private static final int pixel_size = 30;
    public ImagePanel() {
          wall = new ImageIcon(this.getClass().getResource("/SWING_COMPONENTS/wall red.png")).getImage();
          closeddoor = new ImageIcon(this.getClass().getResource("/SWING_COMPONENTS/closed door.png")).getImage();
          openabledoor = new ImageIcon(this.getClass().getResource("/SWING_COMPONENTS/openableDoor.jpg")).getImage();
          opendoor = new ImageIcon(this.getClass().getResource("/SWING_COMPONENTS/openedDoor.png")).getImage();
          guard = new ImageIcon(this.getClass().getResource("/SWING_COMPONENTS/guard.png")).getImage();
          lever = new ImageIcon(this.getClass().getResource("/SWING_COMPONENTS/lever.png")).getImage();
          turnedlever = new ImageIcon(this.getClass().getResource("/SWING_COMPONENTS/leverturned.png")).getImage();
          hero = new ImageIcon(this.getClass().getResource("/SWING_COMPONENTS/hero.png")).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
     //   g.drawImage(ogre, 0, 0, this); // see javadoc for more info on the parameters          
       // g.drawImage(wall, 40,40,this);
        g.drawImage(hero, pixel_size,pixel_size,this);
    	g.drawImage(openabledoor, 0, pixel_size*5,this);
    	g.drawImage(openabledoor, 0, pixel_size*6,this);
    	g.drawImage(guard, pixel_size*8, pixel_size,this);
    	g.drawImage(lever, pixel_size*7, pixel_size*8,this);
        
        for(int i = 0; i < map_height; i++)
        {
        	if(i != 5 && i != 6)
        	g.drawImage(wall, 0, pixel_size*i,this);
        	g.drawImage(wall, (map_width-1)*pixel_size, pixel_size*i,this);
        	if(i!= 5 && i != 6)
        	g.drawImage(wall, 6*pixel_size, pixel_size*i,this);
        	if(i== 3 || i == 8)
        		g.drawImage(closeddoor, 2*pixel_size, pixel_size*i,this);
        	if(i== 1 || i == 3 || i == 8)
        		g.drawImage(closeddoor, 4*pixel_size, pixel_size*i,this);
            	
        }
        for(int i = 0; i < map_width; i++)
        {
        	g.drawImage(wall, pixel_size*i,0,this);
        	g.drawImage(wall, pixel_size*i, (map_height-1)*pixel_size,this);
        	if(i != 3 && i != 8 && i != 7)
        	g.drawImage(wall, pixel_size*i, 4*pixel_size,this);
        	if(i != 3 && i != 8)
        	g.drawImage(wall, pixel_size*i, 7*pixel_size,this);
        	if(i != 3 && i != 8 && i != 7)
        	g.drawImage(wall, pixel_size*i, 2*pixel_size,this);
        }
    }
    
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
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