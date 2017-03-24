package SWING_COMPONENTS;

import java.awt.Graphics;
import java.awt.Image;


import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Characters.Oggre;

public class EditMap extends JPanel{
	
	private Oggre O;
	private Image ogre;
	
	public EditMap()
	{
		 this.ogre = new ImageIcon(this.getClass().getResource("/SWING_COMPONENTS/ogredown.png")).getImage();
	}
	
	@Override
	protected void paintComponent(Graphics g)
	{
		 super.paintComponent(g);
		 g.drawImage(ogre,0, 0,this);
	}
}
