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
    private Image heroleft;
    private Image heroright;
    private Image heroup;
    private Image herodown;
    private Image ogreleft;
    private Image ogreright;
    private Image ogreup;
    private Image ogredown;
    private Image guardleft;
    private Image guardright;
    private Image guardup;
    private Image guarddown;
    private Image key;
    private static final int map_width = 10;
    private static final int map_height = 10;
    private static final int pixel_size = 30;
    public ImagePanel() {
          wall = new ImageIcon(this.getClass().getResource("/SWING_COMPONENTS/wall red.png")).getImage();
          closeddoor = new ImageIcon(this.getClass().getResource("/SWING_COMPONENTS/closed door.png")).getImage();
          openabledoor = new ImageIcon(this.getClass().getResource("/SWING_COMPONENTS/openableDoor.jpg")).getImage();
          opendoor = new ImageIcon(this.getClass().getResource("/SWING_COMPONENTS/openedDoor.png")).getImage();
          lever = new ImageIcon(this.getClass().getResource("/SWING_COMPONENTS/lever.png")).getImage();
          turnedlever = new ImageIcon(this.getClass().getResource("/SWING_COMPONENTS/leverturned.png")).getImage();
          heroleft = new ImageIcon(this.getClass().getResource("/SWING_COMPONENTS/heroleft.png")).getImage();
          heroright = new ImageIcon(this.getClass().getResource("/SWING_COMPONENTS/heroright.png")).getImage();
          heroup = new ImageIcon(this.getClass().getResource("/SWING_COMPONENTS/heroup.png")).getImage();
          herodown = new ImageIcon(this.getClass().getResource("/SWING_COMPONENTS/herodown.png")).getImage();
          ogreleft = new ImageIcon(this.getClass().getResource("/SWING_COMPONENTS/ogreleft.png")).getImage();
          ogreright = new ImageIcon(this.getClass().getResource("/SWING_COMPONENTS/ogreright.png")).getImage();
          ogreup = new ImageIcon(this.getClass().getResource("/SWING_COMPONENTS/ogreup.png")).getImage();
          ogredown = new ImageIcon(this.getClass().getResource("/SWING_COMPONENTS/ogredown.png")).getImage();
          guardleft = new ImageIcon(this.getClass().getResource("/SWING_COMPONENTS/guardleft.png")).getImage();
          guardright = new ImageIcon(this.getClass().getResource("/SWING_COMPONENTS/guardright.png")).getImage();
          guardup = new ImageIcon(this.getClass().getResource("/SWING_COMPONENTS/guardup.png")).getImage();
          guarddown = new ImageIcon(this.getClass().getResource("/SWING_COMPONENTS/guardown.png")).getImage();
          key = new ImageIcon(this.getClass().getResource("/SWING_COMPONENTS/key.png")).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
     //   g.drawImage(ogre, 0, 0, this); // see javadoc for more info on the parameters          
       // g.drawImage(wall, 40,40,this);
        g.drawImage(heroright, pixel_size,pixel_size,this);
        g.drawImage(heroleft, 2*pixel_size,pixel_size,this);
        g.drawImage(herodown, 3*pixel_size,pixel_size,this);
        g.drawImage(heroup, 3*pixel_size,2*pixel_size,this);
    	g.drawImage(openabledoor, 0, pixel_size*5,this);
    	g.drawImage(openabledoor, 0, pixel_size*6,this);
    	g.drawImage(guarddown, pixel_size*8, pixel_size,this);
    	g.drawImage(guardup, pixel_size*8, 2*pixel_size,this);
    	g.drawImage(guardright, pixel_size*8, 3*pixel_size,this);
    	g.drawImage(guardleft, pixel_size*8, 4*pixel_size,this);
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
    /*   
        for(int i = 0; i < map_height; i++)
        {
        	if(i== 1)
        	g.drawImage(openabledoor, 0, pixel_size*i,this);
        	else
        	g.drawImage(wall, 0, pixel_size*i,this);
        	g.drawImage(wall, (map_width-1)*pixel_size, pixel_size*i,this);
        }
        
        for(int i = 0; i < map_height; i++)
        {
        	g.drawImage(wall,pixel_size*i,0,this);
        	g.drawImage(wall,pixel_size*i,(map_height-1)*pixel_size,this);
        }
        g.drawImage(heroright, pixel_size*2, pixel_size*(map_height-2),this);
        g.drawImage(key,pixel_size*(map_width-2),pixel_size,this);
        g.drawImage(ogreup,pixel_size*5,2*pixel_size,this);
        g.drawImage(ogredown,pixel_size*5,3*pixel_size,this);
        g.drawImage(ogreleft,pixel_size*5,4*pixel_size,this);
        g.drawImage(ogreright,pixel_size*5,5*pixel_size,this);
        */
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