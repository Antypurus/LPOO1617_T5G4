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

public class Main_Window {

	private JFrame frmDungeonKepp;
	private JTextField OggreCounter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_Window window = new Main_Window();
					window.frmDungeonKepp.setVisible(true);
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
		frmDungeonKepp = new JFrame();
		frmDungeonKepp.setResizable(false);
		frmDungeonKepp.setTitle("Dungeon Keep");
		frmDungeonKepp.setBounds(100, 100, 532, 460);
		frmDungeonKepp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDungeonKepp.getContentPane().setLayout(null);
		
		JLabel OggreCounterLabel = new JLabel("Number Of Oggres");
		OggreCounterLabel.setBounds(10, 11, 98, 14);
		frmDungeonKepp.getContentPane().add(OggreCounterLabel);
		
		OggreCounter = new JTextField();
		OggreCounter.setBounds(106, 8, 86, 20);
		frmDungeonKepp.getContentPane().add(OggreCounter);
		OggreCounter.setColumns(10);
		
		JLabel GuardPersonalityLabel = new JLabel("Guard Personality");
		GuardPersonalityLabel.setBounds(10, 36, 86, 14);
		frmDungeonKepp.getContentPane().add(GuardPersonalityLabel);
		
		JComboBox GuardPersonalitySelector = new JComboBox();
		GuardPersonalitySelector.setModel(new DefaultComboBoxModel(new String[] {"Novice", "Drunken", "Suspicious"}));
		GuardPersonalitySelector.setBounds(106, 36, 86, 20);
		frmDungeonKepp.getContentPane().add(GuardPersonalitySelector);
		
		JButton NewGameButton = new JButton("New Game");
		NewGameButton.setBounds(403, 86, 89, 23);
		frmDungeonKepp.getContentPane().add(NewGameButton);
		
		JButton ExitButton = new JButton("Exit");
		ExitButton.setBounds(403, 373, 89, 23);
		frmDungeonKepp.getContentPane().add(ExitButton);
		
		JTextArea GameDisplayArea = new JTextArea();
		GameDisplayArea.setEditable(false);
		GameDisplayArea.setBounds(10, 86, 320, 310);
		frmDungeonKepp.getContentPane().add(GameDisplayArea);
		
		JButton MovementButtonUp = new JButton("Up");
		MovementButtonUp.setEnabled(false);
		MovementButtonUp.setBounds(389, 202, 89, 23);
		frmDungeonKepp.getContentPane().add(MovementButtonUp);
		
		JButton MovementButtonLeft = new JButton("Left");
		MovementButtonLeft.setEnabled(false);
		MovementButtonLeft.setBounds(340, 236, 89, 23);
		frmDungeonKepp.getContentPane().add(MovementButtonLeft);
		
		JButton MovementButtonRight = new JButton("Right");
		MovementButtonRight.setEnabled(false);
		MovementButtonRight.setBounds(437, 236, 89, 23);
		frmDungeonKepp.getContentPane().add(MovementButtonRight);
		
		JButton MovementButtonDown = new JButton("Down");
		MovementButtonDown.setEnabled(false);
		MovementButtonDown.setBounds(389, 270, 89, 23);
		frmDungeonKepp.getContentPane().add(MovementButtonDown);
		
		JLabel GameStatusMessage = new JLabel("Message");
		GameStatusMessage.setBounds(10, 406, 320, 14);
		frmDungeonKepp.getContentPane().add(GameStatusMessage);
	}
}
