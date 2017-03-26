package SWING_COMPONENTS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;

import Characters.Enemy;
import Characters.Guard;
import Characters.Hero;
import Characters.Oggre;
import Maps.Map;
import Maps.MapDimension;
import Objects.Door;
import Objects.Key;
import Objects.Lever;
import Weapons.Club;
import Weapons.Weapon;

import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.awt.Font;
import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;

public class Main_Window{

	/**
	 * 
	 */
	private JFrame frmDungeonKeep;
	private JTextField OggreCounter;
	private ImagePanel panel;
	private boolean goodFormat = true;
	private boolean nextLevel= false;
	private Map Map1;
	private Map Map2;
	private Guard map1Guard;
	private Hero ma1Hero;
	private Hero map2Hero;
	private Oggre map2Oggre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_Window window = new Main_Window();
					window.frmDungeonKeep.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main_Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * Loads the maps
	 */
	private void initialize() {

		 String[][] map1=new String[][]{
	        {"X","X","X","X","X","X","X","X","X","X"},
	        {"X"," "," "," ","I"," ","X"," "," ","X"},
	        {"X","X","X"," ","X","X","X"," "," ","X"},
	        {"X"," ","I"," ","I"," ","X"," "," ","X"},
	        {"X","X","X"," ","X","X","X"," "," ","X"},
	        {" "," "," "," "," "," "," "," "," ","X"},
	        {" "," "," "," "," "," "," "," "," ","X"},
	        {"X","X","X"," ","X","X","X","X"," ","X"},
	        {"X"," ","I"," ","I"," ","X"," "," ","X"},
	        {"X","X","X","X","X","X","X","X","X","X"}
	    };
	     String[][] referenceMap1=new String[][]{
	            {"X","X","X","X","X","X","X","X","X","X"},
	            {"X"," "," "," ","I"," ","X"," "," ","X"},
	            {"X","X","X"," ","X","X","X"," "," ","X"},
	            {"X"," ","I"," ","I"," ","X"," "," ","X"},
	            {"X","X","X"," ","X","X","X"," "," ","X"},
	            {" "," "," "," "," "," "," "," "," ","X"},
	            {" "," "," "," "," "," "," "," "," ","X"},
	            {"X","X","X"," ","X","X","X","X"," ","X"},
	            {"X"," ","I"," ","I"," ","X"," "," ","X"},
	            {"X","X","X","X","X","X","X","X","X","X"}
	    };
	     MapDimension map1Dimension=new MapDimension(10,10);


	     String[][] map2=new String[][]{
	            {"X","X","X","X","X","X","X","X","X","X"},
	            {" "," "," "," "," "," "," "," "," ","X"},
	            {"X"," "," "," "," "," "," "," "," ","X"},
	            {"X"," "," "," "," "," "," "," "," ","X"},
	            {"X"," "," "," "," "," "," "," "," ","X"},
	            {"X"," "," "," "," "," "," "," "," ","X"},
	            {"X"," "," "," "," "," "," "," "," ","X"},
	            {"X"," "," "," "," "," "," "," "," ","X"},
	            {"X"," "," "," "," "," "," "," "," ","X"},
	            {"X","X","X","X","X","X","X","X","X","X"}
	    };

	     String[][] referenceMap2=new String[][]{
	            {"X","X","X","X","X","X","X","X","X","X"},
	            {" "," "," "," "," "," "," "," "," ","X"},
	            {"X"," "," "," "," "," "," "," "," ","X"},
	            {"X"," "," "," "," "," "," "," "," ","X"},
	            {"X"," "," "," "," "," "," "," "," ","X"},
	            {"X"," "," "," "," "," "," "," "," ","X"},
	            {"X"," "," "," "," "," "," "," "," ","X"},
	            {"X"," "," "," "," "," "," "," "," ","X"},
	            {"X"," "," "," "," "," "," "," "," ","X"},
	            {"X","X","X","X","X","X","X","X","X","X"}
	    };
	    
	     MapDimension map2Dimension=new MapDimension(10,10);

	     ma1Hero= new Hero(map1,1,1);
	     map2Hero=new Hero(map2,1,8);

	     map2Oggre = new Oggre(map2);

	     Lever map1Lever = new Lever(7,8);
	     Key map2Key = new Key(8,1);

	     Enemy[] map1Enemies=new Enemy[1];
	   

	     Lever[] map1Levers=new Lever[1];

	     Key[] map2Keys = new Key [1];

	     Door[] map1Doors = new Door[2];
	     Door[] map2Doors = new Door[1];

	     Club map2Club = new Club(map2Oggre);

	     Weapon[] oggreMap2Weapons = new Weapon[1];
	     

		frmDungeonKeep = new JFrame();
		frmDungeonKeep.setResizable(false);
		frmDungeonKeep.setTitle("Dungeon Keep");
		frmDungeonKeep.setBounds(100, 100, 532, 460);
		frmDungeonKeep.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDungeonKeep.getContentPane().setLayout(null);

		JLabel OggreCounterLabel = new JLabel("Number Of Ogres");
		OggreCounterLabel.setBounds(10, 11, 120, 14);
		frmDungeonKeep.getContentPane().add(OggreCounterLabel);

		OggreCounter = new JTextField();
		OggreCounter.setBounds(134, 8, 86, 20);
		frmDungeonKeep.getContentPane().add(OggreCounter);
		OggreCounter.setColumns(10);

		JLabel GuardPersonalityLabel = new JLabel("Guard Personality");
		GuardPersonalityLabel.setBounds(10, 36, 120, 14);
		frmDungeonKeep.getContentPane().add(GuardPersonalityLabel);

		JComboBox GuardPersonalitySelector = new JComboBox();
		GuardPersonalitySelector.setModel(new DefaultComboBoxModel(new String[] { "rookie", "drunken", "suspicious" }));
		GuardPersonalitySelector.setBounds(134, 33, 86, 20);
		frmDungeonKeep.getContentPane().add(GuardPersonalitySelector);

	
		JLabel GameStatusMessage = new JLabel("");
		JButton MovementButtonLeft = new JButton("Left");
		JButton MovementButtonUp = new JButton("Up");
		JButton MovementButtonRight = new JButton("Right");
		JButton MovementButtonDown = new JButton("Down");
		
		JButton btnMapEditor = new JButton("Map Editor");
		btnMapEditor.addMouseListener(new MouseAdapter() {
			int ct = 0;
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ct++;
				
				if(ct >= 2)
				{	
					
					frmDungeonKeep.getContentPane().removeAll();
					frmDungeonKeep.getContentPane().repaint();
					
					EditMap editPanel = new EditMap();
					editPanel.setBackground(Color.WHITE);
					editPanel.setBounds(10, 95, 300, 300);
					frmDungeonKeep.getContentPane().add(editPanel);
					
					
					JButton btnOgre = new JButton("Ogre");
					btnOgre.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							editPanel.setType("Ogre");
						}
					});
					btnOgre.setBounds(389, 168, 89, 23);
					frmDungeonKeep.getContentPane().add(btnOgre);
					
					JButton btnHero = new JButton("Hero");
					btnHero.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							editPanel.setType("Hero");
							btnHero.setEnabled(false);
						}
					});
					btnHero.setBounds(389, 202, 89, 23);
					frmDungeonKeep.getContentPane().add(btnHero);
					
					JButton btnWall = new JButton("Wall");
					btnWall.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							editPanel.setType("Wall");
						}
					});
					btnWall.setBounds(389, 236, 89, 23);
					frmDungeonKeep.getContentPane().add(btnWall);
					
					JButton btnDoor = new JButton("Door");
					btnDoor.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {
							editPanel.setType("Door");
						}
					});
					btnDoor.setBounds(389, 270, 89, 23);
					frmDungeonKeep.getContentPane().add(btnDoor);
					
					JButton btnExit = new JButton("Exit");
					btnExit.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {
							editPanel.setType("Exit");
						}
					});
					btnExit.setBounds(389, 309, 89, 23);
					frmDungeonKeep.getContentPane().add(btnExit);
					
					JButton btnPlay = new JButton("Play");
					btnPlay.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {
							editPanel.setType("Play");
						}
					});
					btnPlay.setBounds(389, 348, 89, 23);
					frmDungeonKeep.getContentPane().add(btnPlay);

					ct = 0;
				}
			}
		});
		btnMapEditor.setBounds(389, 121, 89, 23);
		frmDungeonKeep.getContentPane().add(btnMapEditor);
		
		JButton btnLoad = new JButton("Load");
		btnLoad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
//				Map1.writeExternal(Map1);
				try {
					
					FileInputStream fi = new FileInputStream("test.ser");
					ObjectInputStream oi = new ObjectInputStream(fi);

					// Read objects
					try {
						String personality;
						personality = GuardPersonalitySelector.getSelectedItem().toString();
						map1Guard = (Guard) oi.readObject();
						ma1Hero = (Hero) oi.readObject();
						map2Hero = (Hero) oi.readObject();
						map2Oggre = (Oggre) oi.readObject();
						Enemy[] map2Enemies = new  Enemy[1];
						map1Enemies[0]=map1Guard;
				        map1Levers[0]=map1Lever;
				        map1Doors[0]=new Door(0,5,map1Lever);
				        map1Doors[1]=new Door(0,6,map1Lever);
				        oggreMap2Weapons[0]=map2Club;
				        map2Oggre.setWeapons(oggreMap2Weapons);
				        for(int i = 0; i < 1; i++)
				        map2Enemies[i]= map2Oggre;
				        map2Keys[0]=map2Key;
				        map2Doors[0]=new Door(0,1,map2Key);

					Map1 = new Map(map1, referenceMap1, map1Dimension, ma1Hero, map1Enemies, map1Levers, true);
					Map1.setDoor(map1Doors);
					Map2 = new Map(map2, referenceMap2, map2Dimension, map2Hero, map2Enemies, map2Keys, true);
					Map2.setDoor(map2Doors);
					Map1.setNextMap(Map2);
					if(!nextLevel){
					panel = new ImagePanel(Map1, map2Club);
					panel.setBackground(Color.WHITE);
					panel.setBounds(10, 95, 300, 300);
					frmDungeonKeep.getContentPane().add(panel);
					panel.repaint();
					}
					else
					{
						panel = new ImagePanel(Map1, map2Club);
						panel.setBackground(Color.WHITE);
						panel.setBounds(10, 95, 300, 300);
						frmDungeonKeep.getContentPane().add(panel);
						panel.setnextStage(true);
						panel.repaint();
					}
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					oi.close();
					fi.close();
//					// read object from file
//					FileInputStream fis = new FileInputStream("mybean.ser");
//					ObjectInputStream ois = new ObjectInputStream(fis);
//					MyBean result = (MyBean) ois.readObject();
//					ois.close();

				} catch (FileNotFoundException e) {
					System.out.println("File not found");
				} catch (IOException e) {
					System.out.println("Error initializing stream");
				}
				MovementButtonUp.setEnabled(true);
				MovementButtonDown.setEnabled(true);
				MovementButtonRight.setEnabled(true);
				MovementButtonLeft.setEnabled(true);
			}
		});
		btnLoad.setBounds(389, 50, 89, 23);
		frmDungeonKeep.getContentPane().add(btnLoad);

		JButton NewGameButton = new JButton("New Game");
		NewGameButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				GameStatusMessage.setText("Start A New Game");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				GameStatusMessage.setText("");
			}
		});

		NewGameButton.addActionListener(new ActionListener() {
			int ct = 0;
			public void actionPerformed(ActionEvent e) {
				ct++;

				if (ct >= 2) {
					MovementButtonUp.setEnabled(true);
					MovementButtonDown.setEnabled(true);
					MovementButtonRight.setEnabled(true);
					MovementButtonLeft.setEnabled(true);

					GameStatusMessage.setText("New Game Started");
					goodFormat = true;
					ct= 0;
					int nOgres = 0;
					try {
						nOgres = Integer.parseInt(OggreCounter.getText());
					} catch (NumberFormatException a) {
						JOptionPane.showMessageDialog(frmDungeonKeep, "Formato não valido");
						MovementButtonUp.setEnabled(false);
						MovementButtonDown.setEnabled(false);
						MovementButtonRight.setEnabled(false);
						MovementButtonLeft.setEnabled(false);
						goodFormat = false;
						ct=0;
					}
					if (nOgres > 5) {
						JOptionPane.showMessageDialog(frmDungeonKeep, "Limite de ogres excedido");
						MovementButtonUp.setEnabled(false);
						MovementButtonDown.setEnabled(false);
						MovementButtonRight.setEnabled(false);
						MovementButtonLeft.setEnabled(false);
						ct=0;
					}
					if(goodFormat){
						String personality;
						personality = GuardPersonalitySelector.getSelectedItem().toString();
						map1Guard = new Guard(map1, personality);
						System.out.println(personality);
						Enemy[] map2Enemies = new  Enemy[nOgres];
						map1Enemies[0]=map1Guard;
				        map1Levers[0]=map1Lever;
				        map1Doors[0]=new Door(0,5,map1Lever);
				        map1Doors[1]=new Door(0,6,map1Lever);
				        oggreMap2Weapons[0]=map2Club;
				        map2Oggre.setWeapons(oggreMap2Weapons);
				        for(int i = 0; i < nOgres; i++)
				        map2Enemies[i]= map2Oggre;
				        map2Keys[0]=map2Key;
				        map2Doors[0]=new Door(0,1,map2Key);

					Map1 = new Map(map1, referenceMap1, map1Dimension, ma1Hero, map1Enemies, map1Levers, true);
					Map1.setDoor(map1Doors);
					Map2 = new Map(map2, referenceMap2, map2Dimension, map2Hero, map2Enemies, map2Keys, true);
					Map2.setDoor(map2Doors);
					Map1.setNextMap(Map2);
					panel = new ImagePanel(Map1, map2Club);
					panel.setBackground(Color.WHITE);
					panel.setBounds(10, 95, 300, 300);
					frmDungeonKeep.getContentPane().add(panel);
					panel.repaint();
					//Map1.SwingDrawMap();
					
					JButton btnSave = new JButton("Save");
					btnSave.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {
//							Map1.writeExternal(Map1);
							panel.requestFocusInWindow();
							try {
								// write object to file
								FileOutputStream fos = null;
								ObjectOutputStream oos = null;
								fos = new FileOutputStream(new File("test.ser"));
								oos = new ObjectOutputStream(fos);
//								oos.writeObject(Map1);
								if(!Map1.hasWon()){
								Enemy G = Map1.getEnemies().get(0);
								Hero H1 = Map1.getHero();
								Hero H2 = Map2.getHero();
								Enemy O = Map2.getEnemies().get(0);
								oos.writeObject(G);
								oos.writeObject(H1);
								oos.writeObject(H2);
								oos.writeObject(O);
								oos.close();
								fos.close();
								}
								else
								{
									nextLevel = true;
									Enemy G = new Guard(map1, "rookie");
									Hero H1 = Map1.getHero();
									Hero H2 = Map2.getHero();
									Enemy O = Map2.getEnemies().get(0);
									oos.writeObject(G);
									oos.writeObject(H1);
									oos.writeObject(H2);
									oos.writeObject(O);
									oos.close();
									fos.close();
								}
//								// read object from file
//								FileInputStream fis = new FileInputStream("mybean.ser");
//								ObjectInputStream ois = new ObjectInputStream(fis);
//								MyBean result = (MyBean) ois.readObject();
//								ois.close();

							} catch (FileNotFoundException e) {
								System.out.println("File not found");
							} catch (IOException e) {
								System.out.println("Error initializing stream");
							}
						}
					});
					btnSave.setBounds(389, 155, 89, 23);
					frmDungeonKeep.getContentPane().add(btnSave);
					panel.repaint();
					}
				}
			}
		});

		NewGameButton.setBounds(389, 87, 89, 23);
		frmDungeonKeep.getContentPane().add(NewGameButton);
		
		MovementButtonUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(Map2.getEnemies().get(0).getXPos());
				System.out.println(Map2.getEnemies().get(0).getYPos());
				if(!panel.getnextStage()) {
				Map1.SwingmapLogic(1);
				panel.playerDirection(1);
				panel.repaint();
				if(Map1.hasLost()){
					panel.repaint();
					//Map1.SwingDrawMap();
					MovementButtonUp.setEnabled(false);
					MovementButtonDown.setEnabled(false);
					MovementButtonRight.setEnabled(false);
					MovementButtonLeft.setEnabled(false);
					JOptionPane.showMessageDialog(null, "You Lost!");
					System.exit(0);
				}
				if(Map1.hasWon()&&Map1.hasNextMap()){
					panel.setnextStage(true);
				}else if(Map1.hasWon()){
					panel.repaint();
					MovementButtonUp.setEnabled(false);
					MovementButtonDown.setEnabled(false);
					MovementButtonRight.setEnabled(false);
					MovementButtonLeft.setEnabled(false);
					JOptionPane.showMessageDialog(null, "You Won!");
					System.exit(0);
				}
			}
				else
				{
					Map1.getNextMap().SwingmapLogic(1);
					System.out.println(Map1.getNextMap().getEnemies().get(0).getXPos());
					System.out.println(Map1.getNextMap().getEnemies().get(0).getYPos());
					panel.playerDirection(1);
					panel.repaint();
					if(Map1.getNextMap().hasWon()){
						panel.repaint();
						MovementButtonUp.setEnabled(false);
						MovementButtonDown.setEnabled(false);
						MovementButtonRight.setEnabled(false);
						MovementButtonLeft.setEnabled(false);
						JOptionPane.showMessageDialog(null, "You Won!");
						System.exit(0);
					}
					else if(Map1.getNextMap().hasLost()){
						panel.repaint();
						MovementButtonUp.setEnabled(false);
						MovementButtonDown.setEnabled(false);
						MovementButtonRight.setEnabled(false);
						MovementButtonLeft.setEnabled(false);
						JOptionPane.showMessageDialog(null, "You Lose!");
						System.exit(0);
					}
				}
				System.out.println(Map1.getNextMap().getEnemies().get(0).getXPos());
				System.out.println(Map1.getNextMap().getEnemies().get(0).getYPos());
			}
		});
		MovementButtonUp.setEnabled(false);
		MovementButtonUp.setBounds(389, 202, 89, 23);
		frmDungeonKeep.getContentPane().add(MovementButtonUp);
		
		MovementButtonDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!panel.getnextStage()) {
				Map1.SwingmapLogic(2);
				panel.playerDirection(2);
				panel.repaint();
				if(Map1.hasLost()){
					panel.repaint();
					//Map1.SwingDrawMap();
					MovementButtonUp.setEnabled(false);
					MovementButtonDown.setEnabled(false);
					MovementButtonRight.setEnabled(false);
					MovementButtonLeft.setEnabled(false);
					JOptionPane.showMessageDialog(null, "You Lost!");
					System.exit(0);
				}
				if(Map1.hasWon()&&Map1.hasNextMap()){
					panel.setnextStage(true);
				}
				else if(Map1.hasWon()&&(!Map1.hasNextMap())){
					panel.repaint();
					MovementButtonUp.setEnabled(false);
					MovementButtonDown.setEnabled(false);
					MovementButtonRight.setEnabled(false);
					MovementButtonLeft.setEnabled(false);
					JOptionPane.showMessageDialog(null, "You Won!");
					System.exit(0);
				}
			}
				else
				{
					Map1.getNextMap().SwingmapLogic(2);
					panel.playerDirection(2);
					panel.repaint();
					if(Map1.getNextMap().hasWon()){
						panel.repaint();
						MovementButtonUp.setEnabled(false);
						MovementButtonDown.setEnabled(false);
						MovementButtonRight.setEnabled(false);
						MovementButtonLeft.setEnabled(false);
						JOptionPane.showMessageDialog(null, "You Won!");
						System.exit(0);
					}
					else if(Map1.getNextMap().hasLost()){
						panel.repaint();
						MovementButtonUp.setEnabled(false);
						MovementButtonDown.setEnabled(false);
						MovementButtonRight.setEnabled(false);
						MovementButtonLeft.setEnabled(false);
						JOptionPane.showMessageDialog(null, "You Lose!");
						System.exit(0);
					}
				}
			}
		});
		MovementButtonDown.setEnabled(false);
		MovementButtonDown.setBounds(389, 270, 89, 23);
		frmDungeonKeep.getContentPane().add(MovementButtonDown);

		MovementButtonLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!panel.getnextStage()) {
				Map1.SwingmapLogic(3);
				panel.playerDirection(3);
				panel.repaint();
				if(Map1.hasLost()){
					panel.repaint();
					//Map1.SwingDrawMap();
					MovementButtonUp.setEnabled(false);
					MovementButtonDown.setEnabled(false);
					MovementButtonRight.setEnabled(false);
					MovementButtonLeft.setEnabled(false);
					JOptionPane.showMessageDialog(null, "You Lost!");
					System.exit(0);
				}
				if(Map1.hasWon()&&Map1.hasNextMap()){
					panel.setnextStage(true);
				}else if(Map1.hasWon()){
					panel.repaint();
					MovementButtonUp.setEnabled(false);
					MovementButtonDown.setEnabled(false);
					MovementButtonRight.setEnabled(false);
					MovementButtonLeft.setEnabled(false);
					JOptionPane.showMessageDialog(null, "You Won!");
					System.exit(0);
				}
			}
				else
				{
					Map1.getNextMap().SwingmapLogic(3);
					panel.playerDirection(3);
					panel.repaint();
					if(Map1.getNextMap().hasWon()){
						panel.repaint();
						MovementButtonUp.setEnabled(false);
						MovementButtonDown.setEnabled(false);
						MovementButtonRight.setEnabled(false);
						MovementButtonLeft.setEnabled(false);
						JOptionPane.showMessageDialog(null, "You Won!");
						System.exit(0);
					}
					else if(Map1.getNextMap().hasLost()){
						panel.repaint();
						MovementButtonUp.setEnabled(false);
						MovementButtonDown.setEnabled(false);
						MovementButtonRight.setEnabled(false);
						MovementButtonLeft.setEnabled(false);
						JOptionPane.showMessageDialog(null, "You Lose!");
						System.exit(0);
					}
				}
			}
		});
		MovementButtonLeft.setEnabled(false);
		MovementButtonLeft.setBounds(340, 236, 89, 23);
		frmDungeonKeep.getContentPane().add(MovementButtonLeft);

		MovementButtonRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!panel.getnextStage()) {
				Map1.SwingmapLogic(4);
				panel.playerDirection(4);
				panel.repaint();
				if(Map1.hasLost()){
					panel.repaint();
					//Map1.SwingDrawMap();
					JOptionPane.showMessageDialog(null, "You Lost!");
					System.exit(0);
				}
				if(Map1.hasWon()&&Map1.hasNextMap()){
					panel.setnextStage(true);
				}else if(Map1.hasWon()){
					panel.repaint();
					MovementButtonUp.setEnabled(false);
					MovementButtonDown.setEnabled(false);
					MovementButtonRight.setEnabled(false);
					MovementButtonLeft.setEnabled(false);
					JOptionPane.showMessageDialog(null, "You Won!");
					System.exit(0);
				}
			}
				else
				{
					Map1.getNextMap().SwingmapLogic(4);
					panel.playerDirection(4);
					panel.repaint();
					if(Map1.getNextMap().hasWon()){
						panel.repaint();
						MovementButtonUp.setEnabled(false);
						MovementButtonDown.setEnabled(false);
						MovementButtonRight.setEnabled(false);
						MovementButtonLeft.setEnabled(false);
						JOptionPane.showMessageDialog(null, "You Won!");
						System.exit(0);
					}
					else if(Map1.getNextMap().hasLost()){
						panel.repaint();
						MovementButtonUp.setEnabled(false);
						MovementButtonDown.setEnabled(false);
						MovementButtonRight.setEnabled(false);
						MovementButtonLeft.setEnabled(false);
						JOptionPane.showMessageDialog(null, "You Lose!");
						System.exit(0);
					}
				}
			}
		});
		MovementButtonRight.setEnabled(false);
		MovementButtonRight.setBounds(437, 236, 89, 23);
		frmDungeonKeep.getContentPane().add(MovementButtonRight);

		GameStatusMessage.setBounds(10, 406, 320, 14);
		frmDungeonKeep.getContentPane().add(GameStatusMessage);


		JButton ExitButton = new JButton("Exit");
		ExitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				GameStatusMessage.setText("Exit Game");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				GameStatusMessage.setText("");
			}
		});
		ExitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		ExitButton.setBounds(389, 373, 89, 23);
		frmDungeonKeep.getContentPane().add(ExitButton);
		
	
		
	}
}
