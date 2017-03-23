package SWING_COMPONENTS;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Characters.Guard;
import Characters.Hero;
import Characters.Oggre;
import Maps.Map;
import Objects.Door;
import Objects.Key;
import Objects.Lever;

public class ImagePanel extends JPanel implements MouseListener, MouseMotionListener, KeyListener{

	private Hero H;
	private Guard G;
	private Oggre O;
	private Map map;
	private Lever k;
	private int level;
	private Key K;
	private Door[] map1Doors = new Door[2];
	private Door[] map2Doors = new Door[1];
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
    private final int map_width = 10;
    private final int map_height = 10;
    private final int pixel_size = 30;
    public ImagePanel(Hero H, Guard G, Oggre O, Map map, Lever k, Key K, int level, Door mapDoors[]) {
    	addMouseListener(this);
    	addMouseMotionListener(this);
    	addKeyListener(this);
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
          this.H = H;
          this.G = G;
          this.O = O;
          this.map = map;
          this.level = level;
          this.k = k;
          this.K = K;
          if(level == 1)
       for(int i = 0 ; i < mapDoors.length; i++)
       {
    	   this.map1Doors[i] = mapDoors[i];
       }
          else
          {
              for(int i = 0 ; i < mapDoors.length; i++)
              {
           	   this.map2Doors[i] = mapDoors[i];
              }
          }
    }

    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
     //   g.drawImage(ogre, 0, 0, this); // see javadoc for more info on the parameters          
       // g.drawImage(wall, 40,40,this);
        if(level == 1)
{
    	g.drawImage(lever, pixel_size*(k.getxPos()), pixel_size*(k.getyPos()),this);
        g.drawImage(heroright, H.getXPos()*pixel_size,H.getYPos()*pixel_size,this);
   /*     g.drawImage(heroleft, 2*pixel_size,pixel_size,this);
        g.drawImage(herodown, 3*pixel_size,pixel_size,this);
        g.drawImage(heroup, 3*pixel_size,2*pixel_size,this);
        */
    	for(int i = 0; i < map1Doors.length; i++)
    	{
    		 g.drawImage(openabledoor, (map1Doors[i].getxPos())*pixel_size,(map1Doors[i].getyPos())*pixel_size,this);
    	}
    	g.drawImage(guarddown, G.getXPos()*pixel_size, G.getYPos()*pixel_size,this);
//    	g.drawImage(guardup, pixel_size*8, 2*pixel_size,this);
//    	g.drawImage(guardright, pixel_size*8, 3*pixel_size,this);
//    	g.drawImage(guardleft, pixel_size*8, 4*pixel_size,this);
        
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
        else if(level == 2){ 
        	repaint();
            g.drawImage(heroright, H.getXPos()*pixel_size, H.getYPos()*pixel_size,this);
            g.drawImage(key,pixel_size*K.getxPos(),pixel_size*K.getyPos(),this);
            g.drawImage(ogreup,pixel_size*O.getXPos(),O.getYPos()*pixel_size,this);
        for(int i = 0; i < map_height; i++)
        {
        	if(i== 1)
        	g.drawImage(openabledoor, map2Doors[0].getxPos()*pixel_size, map2Doors[0].getyPos()*pixel_size,this);
        	else
        	g.drawImage(wall, 0, pixel_size*i,this);
        	g.drawImage(wall, (map_width-1)*pixel_size, pixel_size*i,this);
        }
        
        for(int i = 0; i < map_height; i++)
        {
        	g.drawImage(wall,pixel_size*i,0,this);
        	g.drawImage(wall,pixel_size*i,(map_height-1)*pixel_size,this);
        }
//        g.drawImage(ogredown,pixel_size*5,3*pixel_size,this);
//        g.drawImage(ogreleft,pixel_size*5,4*pixel_size,this);
//        g.drawImage(ogreright,pixel_size*5,5*pixel_size,this);
        
        }
        this.requestFocusInWindow();
    }
    
    @Override
	public void keyPressed(KeyEvent e) {
		//int keycode = e.getKeyCode();

		if(e.getKeyCode() == KeyEvent.VK_UP)
		{
			map.SwingmapLogic(1);
			if(map.hasLost()){
				repaint();
				JOptionPane.showMessageDialog(null, "You Lost!");
				System.exit(0);
			}
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			map.SwingmapLogic(2);
			if(map.hasLost()){
				repaint();
				JOptionPane.showMessageDialog(null, "You Lost!");
				System.exit(0);
			}
			
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			map.SwingmapLogic(3);
			if(map.hasLost()){
				repaint();
				JOptionPane.showMessageDialog(null, "You Lost!");
				System.exit(0);
			}
			
		}
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			map.SwingmapLogic(4);
			if(map.hasLost()){
				repaint();
				JOptionPane.showMessageDialog(null, "You Lost!");
				System.exit(0);
			}
			
		}
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
//		int keycode = e.getKeyCode();
//
//		if(keycode == KeyEvent.VK_UP)
//		{
//			map.SwingmapLogic(4);
//			repaint();
//		}
////		if(keycode == KeyEvent.VK_DOWN)
////		{
////			a = J.move(2);
////		}
////		if(keycode == KeyEvent.VK_LEFT)
////		{
////			a = J.move(3);
////		}
//		if(keycode == KeyEvent.VK_RIGHT)
//		{
//			map.SwingmapLogic(4);
//			repaint();
//		}
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