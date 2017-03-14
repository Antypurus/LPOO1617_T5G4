package SWING_COMPONENTS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
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

public class Main_Window {

	private JFrame frmDungeonKeep;
	private JTextField OggreCounter;

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
	 */
	private void initialize() {
		frmDungeonKeep = new JFrame();
		frmDungeonKeep.setResizable(false);
		frmDungeonKeep.setTitle("Dungeon Keep");
		frmDungeonKeep.setBounds(100, 100, 532, 460);
		frmDungeonKeep.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDungeonKeep.getContentPane().setLayout(null);
		
		JLabel OggreCounterLabel = new JLabel("Number Of Oggres");
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
		GuardPersonalitySelector.setModel(new DefaultComboBoxModel(new String[] {"Novice", "Drunken", "Suspicious"}));
		GuardPersonalitySelector.setBounds(134, 33, 86, 20);
		frmDungeonKeep.getContentPane().add(GuardPersonalitySelector);
		
		
		JTextArea GameDisplayArea = new JTextArea();
		GameDisplayArea.setEditable(false);
		GameDisplayArea.setBounds(10, 86, 320, 310);
		frmDungeonKeep.getContentPane().add(GameDisplayArea);
		
		JButton MovementButtonUp = new JButton("Up");
		MovementButtonUp.setEnabled(false);
		MovementButtonUp.setBounds(389, 202, 89, 23);
		frmDungeonKeep.getContentPane().add(MovementButtonUp);
		
		JButton MovementButtonLeft = new JButton("Left");
		MovementButtonLeft.setEnabled(false);
		MovementButtonLeft.setBounds(340, 236, 89, 23);
		frmDungeonKeep.getContentPane().add(MovementButtonLeft);
		
		JButton MovementButtonRight = new JButton("Right");
		MovementButtonRight.setEnabled(false);
		MovementButtonRight.setBounds(437, 236, 89, 23);
		frmDungeonKeep.getContentPane().add(MovementButtonRight);
		
		JButton MovementButtonDown = new JButton("Down");
		MovementButtonDown.setEnabled(false);
		MovementButtonDown.setBounds(389, 270, 89, 23);
		frmDungeonKeep.getContentPane().add(MovementButtonDown);
		
		JLabel GameStatusMessage = new JLabel("");
		GameStatusMessage.setBounds(10, 406, 320, 14);
		frmDungeonKeep.getContentPane().add(GameStatusMessage);
		
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
			public void actionPerformed(ActionEvent e) {	
				
				MovementButtonUp.setEnabled(true);
				MovementButtonDown.setEnabled(true);
				MovementButtonRight.setEnabled(true);
				MovementButtonLeft.setEnabled(true);
				
				GameStatusMessage.setText("New Game Started");
				
			}
		});
		
		NewGameButton.setBounds(389, 87, 89, 23);
		frmDungeonKeep.getContentPane().add(NewGameButton);
		
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
