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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Characters.Enemy;
import Characters.Guard;
import Characters.Hero;
import Characters.Oggre;
import Maps.Map;
import Objects.Door;
import Objects.Key;
import Objects.Lever;
import Weapons.Club;

public class ImagePanel extends JPanel implements MouseListener, MouseMotionListener, KeyListener{

	private int Direction;
	private boolean nextStage = false;
	private Hero H;
	private ArrayList<Enemy> E1 = new ArrayList<Enemy>();
	private ArrayList<Enemy> E2 = new ArrayList<Enemy>();
	private boolean openDoor = false;
	private boolean canProceed = false;
	private Map map;
	private Lever[] k;
	private int level;
	private Club Cl;
	private Key[] K;
    private Image ogre;
    private Image club;
    private Image wall;
    private Image door;
    private Image closeddoor;
    private Image openabledoor;
    private Image opendoor;
    private Image guard;
    private Image lever;
    private Image turnedlever;
    private Image hero;
    private Image ogreleft;
    private Image ogreright;
    private Image ogreup;
    private Image ogredown;
    private Image key;
    private final int map_width = 10;
    private final int map_height = 10;
    private final int pixel_size = 30;
//    public ImagePanel(Hero H, Guard G, Oggre O, Map map, Lever k, Key K, int level, Door mapDoors[], Club Cl) {
    public ImagePanel(Map map, Club Cl) {
    	addMouseListener(this);
    	addMouseMotionListener(this);
    	addKeyListener(this);
          wall = new ImageIcon(this.getClass().getResource("/SWING_COMPONENTS/wall red.png")).getImage();
          closeddoor = new ImageIcon(this.getClass().getResource("/SWING_COMPONENTS/closed door.png")).getImage();
          door = new ImageIcon(this.getClass().getResource("/SWING_COMPONENTS/openableDoor.jpg")).getImage();
          openabledoor = new ImageIcon(this.getClass().getResource("/SWING_COMPONENTS/openableDoor.jpg")).getImage();
          opendoor = new ImageIcon(this.getClass().getResource("/SWING_COMPONENTS/openedDoor.png")).getImage();
          lever = new ImageIcon(this.getClass().getResource("/SWING_COMPONENTS/lever.png")).getImage();
          turnedlever = new ImageIcon(this.getClass().getResource("/SWING_COMPONENTS/leverturned.png")).getImage();
          hero = new ImageIcon(this.getClass().getResource("/SWING_COMPONENTS/heroright.png")).getImage();
          ogre = new ImageIcon(this.getClass().getResource("/SWING_COMPONENTS/ogredown.png")).getImage();
          guard = new ImageIcon(this.getClass().getResource("/SWING_COMPONENTS/guardown.png")).getImage();
          key = new ImageIcon(this.getClass().getResource("/SWING_COMPONENTS/key.png")).getImage();
          club = new ImageIcon(this.getClass().getResource("/SWING_COMPONENTS/club.png")).getImage();
          this.map = map;
          this.Cl = Cl;
//          this.H = map.getHero();
//       for(int i = 0; i < map.getEnemies().size(); i++)
//       {
//    	   E1.add(map.getEnemies().get(i));
//       }
//       for(int i = 0; i < map.getNextMap().getEnemies().size(); i++)
//       {
//    	   E2.add(map.getNextMap().getEnemies().get(i));
//       }
//          this.k = map.getLevers();
//          this.K = map.getNextMap().getKeys();
//          this.Cl = Cl;
//          if(!this.nextStage)
//       for(int i = 0 ; i < map.getDoors().length; i++)
//       {
//    	   this.map1Doors[i] = map.getDoors()[i];
//       }
//          else
//          {
//              for(int i = 0 ; i < map.getNextMap().getDoors().length; i++)
//              {
//           	   this.map2Doors[i] = map.getNextMap().getDoors()[i];
//              }
//          }
    }

    public void playerDirection(int mov)
    {
    	this.Direction = mov;
    	playerMoved();
    }
    
    public void playerMoved()
    {
    if(Direction == 1)
    	hero = new ImageIcon(this.getClass().getResource("/SWING_COMPONENTS/heroup.png")).getImage();
    else if (Direction == 2)
    	hero = new ImageIcon(this.getClass().getResource("/SWING_COMPONENTS/herodown.png")).getImage();
    else if (Direction == 3)
    	hero = new ImageIcon(this.getClass().getResource("/SWING_COMPONENTS/heroleft.png")).getImage();
    else
    	hero = new ImageIcon(this.getClass().getResource("/SWING_COMPONENTS/heroright.png")).getImage();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
     //   g.drawImage(ogre, 0, 0, this); // see javadoc for more info on the parameters          
       // g.drawImage(wall, 40,40,this);
        if(!nextStage)
{
        	if(map.getLevers()[0].getState()){
        		g.drawImage(turnedlever, pixel_size*(map.getLevers()[0].getxPos()), pixel_size*(map.getLevers()[0].getyPos()),this);
        		g.drawImage(hero, map.getHero().getXPos()*pixel_size,map.getHero().getYPos()*pixel_size,this);
        	}
        	else
        	{
            	g.drawImage(lever, pixel_size*(map.getLevers()[0].getxPos()), pixel_size*(map.getLevers()[0].getyPos()),this);
                g.drawImage(hero, map.getHero().getXPos()*pixel_size,map.getHero().getYPos()*pixel_size,this);
        	}
   /*     g.drawImage(heroleft, 2*pixel_size,pixel_size,this);
        g.drawImage(herodown, 3*pixel_size,pixel_size,this);
        g.drawImage(heroup, 3*pixel_size,2*pixel_size,this);
        */
    	for(int i = 0; i < map.getDoors().length; i++)
    	{
    		if(map.getLevers()[0].getState())
    			g.drawImage(opendoor, (map.getDoors()[i].getxPos())*pixel_size,(map.getDoors()[i].getyPos())*pixel_size,this);
    		else
    			g.drawImage(openabledoor, (map.getDoors()[i].getxPos())*pixel_size,(map.getDoors()[i].getyPos())*pixel_size,this);
    	}
    	if(map.getEnemies().get(0).getSubType().equals("rookie")){
    		if(map.getEnemies().get(0).getXPos() == 8 && map.getEnemies().get(0).getYPos() == 1)
    			guard = new ImageIcon(this.getClass().getResource("/SWING_COMPONENTS/guardleft.png")).getImage();
    		else if(map.getEnemies().get(0).getXPos() == 7 && map.getEnemies().get(0).getYPos() == 1)
    			guard = new ImageIcon(this.getClass().getResource("/SWING_COMPONENTS/guardown.png")).getImage();
    		else if(map.getEnemies().get(0).getXPos() == 7 && map.getEnemies().get(0).getYPos() == 5)
    			guard = new ImageIcon(this.getClass().getResource("/SWING_COMPONENTS/guardleft.png")).getImage();
    		else if(map.getEnemies().get(0).getXPos() == 1 && map.getEnemies().get(0).getYPos() == 5)
    			guard = new ImageIcon(this.getClass().getResource("/SWING_COMPONENTS/guardown.png")).getImage();
    		else if(map.getEnemies().get(0).getXPos() == 1 && map.getEnemies().get(0).getYPos() == 6)
    			guard = new ImageIcon(this.getClass().getResource("/SWING_COMPONENTS/guardright.png")).getImage();
    		else if(map.getEnemies().get(0).getXPos() == 8 && map.getEnemies().get(0).getYPos() == 6)
    			guard = new ImageIcon(this.getClass().getResource("/SWING_COMPONENTS/guardup.png")).getImage();
    	}
    	g.drawImage(guard, map.getEnemies().get(0).getXPos()*pixel_size, map.getEnemies().get(0).getYPos()*pixel_size,this);
        
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
        else { 
        	repaint();
        	if(!map.getNextMap().getKeys()[0].isPicked())
        	{
            g.drawImage(key,pixel_size*map.getNextMap().getKeys()[0].getxPos(),pixel_size*map.getNextMap().getKeys()[0].getyPos(),this);
            g.drawImage(hero, map.getNextMap().getHero().getXPos()*pixel_size, map.getNextMap().getHero().getYPos()*pixel_size,this);
            g.drawImage(club,pixel_size*Cl.getxPos(),Cl.getyPos()*pixel_size,this);
        	}
            else
            {
                g.drawImage(hero,map.getNextMap().getHero().getXPos()*pixel_size, map.getNextMap().getHero().getYPos()*pixel_size,this);
                g.drawImage(club,pixel_size*Cl.getxPos(),Cl.getyPos()*pixel_size,this);
            }
        for(int i = 0; i < map_height; i++)
        {
        	if(i== 1)
        	g.drawImage(door, map.getNextMap().getDoors()[0].getxPos()*pixel_size, map.getNextMap().getDoors()[0].getyPos()*pixel_size,this);
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
        if(Cl.getxPos() < map.getNextMap().getEnemies().get(0).getXPos())
        	ogre = new ImageIcon(this.getClass().getResource("/SWING_COMPONENTS/ogreleft.png")).getImage();
        else if(Cl.getxPos() > map.getNextMap().getEnemies().get(0).getXPos())
        	ogre = new ImageIcon(this.getClass().getResource("/SWING_COMPONENTS/ogreright.png")).getImage();
        else if(Cl.getyPos() > map.getNextMap().getEnemies().get(0).getYPos())
        	ogre = new ImageIcon(this.getClass().getResource("/SWING_COMPONENTS/ogredown.png")).getImage();
        else if(Cl.getyPos() < map.getNextMap().getEnemies().get(0).getYPos())
        	ogre = new ImageIcon(this.getClass().getResource("/SWING_COMPONENTS/ogreup.png")).getImage();
        for(int i = 0; i < map.getNextMap().getEnemies().size();i++)
        g.drawImage(ogre,pixel_size*map.getNextMap().getEnemies().get(i).getXPos(),map.getNextMap().getEnemies().get(i).getYPos()*pixel_size,this);
        }
        this.requestFocusInWindow();
    }
    
    public boolean getnextStage()
    {
    	return nextStage;
    }
    
    public void setnextStage(boolean nextStage)
    {
    	this.nextStage = nextStage;
    }

    @Override
	public void keyPressed(KeyEvent e) {
		//int keycode = e.getKeyCode();

		if(e.getKeyCode() == KeyEvent.VK_UP)
		{
			if(!nextStage) {
			map.SwingmapLogic(1);
			this.playerDirection(1);
			if(map.hasLost()){
				repaint();
				JOptionPane.showMessageDialog(null, "You Lost!");
				System.exit(0);
			}
			
			if(map.hasWon()&&(!map.hasNextMap())){
				repaint();
				JOptionPane.showMessageDialog(null, "You Won!");
				System.exit(0);
			}
			}
			else  {
				map.getNextMap().SwingmapLogic(1);
				this.playerDirection(1);
				if(map.getNextMap().hasLost()){
					repaint();
					JOptionPane.showMessageDialog(null, "You Lost!");
					System.exit(0);
				}
				if(map.getNextMap().getKeys()[0].isPicked() && map.getNextMap().getHero().getXPos() == map.getNextMap().getDoors()[0].getxPos()+1){
					openDoor = true;
					if(canProceed)
						door = new ImageIcon(this.getClass().getResource("/SWING_COMPONENTS/openedDoor.png")).getImage();
					canProceed = true;
				}
				if(!openDoor)
					door = new ImageIcon(this.getClass().getResource("/SWING_COMPONENTS/openableDoor.jpg")).getImage();
				if(map.getNextMap().hasWon()){
					repaint();
					JOptionPane.showMessageDialog(null, "You Won!");
					System.exit(0);
				}
			}
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			if(!nextStage) {
			map.SwingmapLogic(2);
			this.playerDirection(2);
			if(map.hasLost()){
				repaint();
				JOptionPane.showMessageDialog(null, "You Lost!");
				System.exit(0);
			}
			
			if(map.hasWon()&&(!map.hasNextMap())){
				repaint();
				JOptionPane.showMessageDialog(null, "You Won!");
				System.exit(0);
			}
			}
			else  {
				map.getNextMap().SwingmapLogic(2);
				this.playerDirection(2);
				if(map.getNextMap().hasLost()){
					repaint();
					JOptionPane.showMessageDialog(null, "You Lost!");
					System.exit(0);
				}
				
				if(map.getNextMap().getKeys()[0].isPicked() && map.getNextMap().getHero().getXPos() == map.getNextMap().getDoors()[0].getxPos()+1){
					openDoor = true;
					if(canProceed)
						door = new ImageIcon(this.getClass().getResource("/SWING_COMPONENTS/openedDoor.png")).getImage();
					canProceed = true;
				}
				if(!openDoor)
					door = new ImageIcon(this.getClass().getResource("/SWING_COMPONENTS/openableDoor.jpg")).getImage();
				
				if(map.getNextMap().hasWon()){
					repaint();
					JOptionPane.showMessageDialog(null, "You Won!");
					System.exit(0);
				}
			}
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			if(!nextStage) {
			map.SwingmapLogic(3);
			this.playerDirection(3);
			if(map.hasLost()){
				repaint();
				JOptionPane.showMessageDialog(null, "You Lost!");
				System.exit(0);
			}
			
			if(map.hasWon()&&(!map.hasNextMap())){
				repaint();
				JOptionPane.showMessageDialog(null, "You Won!");
				System.exit(0);
			}
			if(map.hasWon()&&map.hasNextMap()){
				repaint();
				this.nextStage = true;
			}
			}
			else  {
				map.getNextMap().SwingmapLogic(3);
				this.playerDirection(3);
				if(map.getNextMap().hasLost()){
					repaint();
					JOptionPane.showMessageDialog(null, "You Lost!");
					System.exit(0);
				}
				door = new ImageIcon(this.getClass().getResource("/SWING_COMPONENTS/openableDoor.jpg")).getImage();
				
				if(canProceed)
					door = new ImageIcon(this.getClass().getResource("/SWING_COMPONENTS/openedDoor.png")).getImage();
					repaint();
				
				if(map.getNextMap().getKeys()[0].isPicked() && map.getNextMap().getHero().getXPos() == map.getNextMap().getDoors()[0].getxPos() +1){
					openDoor = true;
					canProceed = true;
				}
				
				if(map.getNextMap().hasWon()){
					repaint();
					JOptionPane.showMessageDialog(null, "You Won!");
					System.exit(0);
				}
			}
			repaint();
		}
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			if(!nextStage) {
			map.SwingmapLogic(4);
			this.playerDirection(4);
			if(map.hasLost()){
				repaint();
				JOptionPane.showMessageDialog(null, "You Lost!");
				System.exit(0);
			}
			
			if(map.hasWon()&&(!map.hasNextMap())){
				repaint();
				JOptionPane.showMessageDialog(null, "You Won!");
				System.exit(0);
			}
			}
			else  {
				map.getNextMap().SwingmapLogic(4);
				this.playerDirection(4);
				if(map.getNextMap().hasLost()){
					repaint();
					JOptionPane.showMessageDialog(null, "You Lost!");
					System.exit(0);
				}
				
				if(map.getNextMap().getKeys()[0].isPicked() && map.getNextMap().getHero().getXPos() == map.getNextMap().getDoors()[0].getxPos()+1){
					openDoor = true;
					if(canProceed)
						door = new ImageIcon(this.getClass().getResource("/SWING_COMPONENTS/openedDoor.png")).getImage();
					canProceed = true;
				}
				if(!openDoor)
					door = new ImageIcon(this.getClass().getResource("/SWING_COMPONENTS/openableDoor.jpg")).getImage();
				
				if(map.getNextMap().hasWon()){
					repaint();
					JOptionPane.showMessageDialog(null, "You Won!");
					System.exit(0);
				}
			}
		}
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
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