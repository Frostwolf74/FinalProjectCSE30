// run in JavaSE-17 system library 
package finalProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class GUI {
	static Font Title = new Font("Arial", Font.PLAIN, 50);
	static Font SubTitle = new Font("Arial", Font.PLAIN, 25);
	static Font NormalText = new Font("Arial", Font.PLAIN, 15);
	static Font SubText = new Font("Arial", Font.PLAIN, 10);
	
	static JFrame frame = new JFrame("Java Minigames");
	static JPanel panel = new JPanel();
	static JLabel mainLabel = new JLabel(); 
	static JLabel secondaryLabel = new JLabel();
	static JLabel tertiaryLabel = new JLabel();
	
	static ArrayList<JButton> optionButton = new ArrayList<JButton>(); // saves memory and prevents bugs

	static JButton exit = new JButton("Exit"); 
	
	static ArrayList<JFormattedTextField> textField = new ArrayList<JFormattedTextField>();
	
	public static void main(String[] args) {
		int h = 610, w = 1000; 

		frame.setSize(w,h); // window size
		frame.setLocation(500,250); // center
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frame.setVisible(true);
		frame.add(panel);
		panel.setLayout(null);
		mainLabel.setVerticalAlignment(JLabel.TOP);
		mainLabel.setBounds(10, 10, w-35, h-90); // border +10 px in
		
		panel.add(mainLabel);
		mainLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		mainMenu();
	}
	
	public static void mainMenu() { 
		mainLabel.setFont(Title);		
		mainLabel.setText ("<html> Java Minigames </html>");
		mainLabel.setHorizontalAlignment(JLabel.CENTER);
		
		secondaryLabel.setFont(SubTitle);
		secondaryLabel.setText("<html> Memorization Game </html>");
		secondaryLabel.setHorizontalAlignment(JLabel.LEFT);
		secondaryLabel.setBounds(180, 300, 300, 200);
		panel.add(secondaryLabel);
		
		tertiaryLabel.setFont(SubTitle);
		tertiaryLabel.setText("<html> Sorting Game </html>");
		tertiaryLabel.setHorizontalAlignment(JLabel.RIGHT);
		tertiaryLabel.setBounds(510, 300, 300, 200);
		panel.add(tertiaryLabel);
		
		exit.setBounds(460,535,85,25);
		panel.add(exit);
		
		optionButton.add(new JButton("Choose"));
		optionButton.get(0).setBounds(230, 425, 85, 25);
		panel.add(optionButton.get(0));
		
		optionButton.add(new JButton("Choose"));
		optionButton.get(1).setBounds(690, 425, 85, 25);
		panel.add(optionButton.get(1));
		
		panel.revalidate();
		panel.repaint(); 
		
		exit.addActionListener (
			new ActionListener() 
			{
				public void actionPerformed(ActionEvent e)
				{	
					System.exit(0);
				}
			}
		);
		
		optionButton.get(0).addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panel.removeAll(); // shortcut to clearing the panel
					panel.repaint(); 
					optionButton.clear(); // clear the arraylist after each function to save memory and reset buttons
					Main.addPlayer(1);
				}
			}
		);
		
		optionButton.get(1).addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panel.removeAll();
					panel.repaint(); 
					optionButton.clear();
					Main.addPlayer(2);
				}
			}
		);
	}

	public static void EnterPlayerData() {
		PlayerData newPlayer = new PlayerData();
		
		mainLabel.setFont(SubTitle);		
		mainLabel.setText ("<html> Enter player name </html>");
		mainLabel.setHorizontalAlignment(JLabel.CENTER);
		panel.add(mainLabel);
		
		
		optionButton.add(new JButton("proceed"));
		optionButton.get(0).setBounds(455,535,85,25);
		panel.add(optionButton.get(0));
		
		textField.add(new JFormattedTextField());
		panel.add(textField.get(0));
		textField.get(0).setBounds(455, 325, 85, 25);
		
		secondaryLabel.setText("<html> Enter a name </html>");
		secondaryLabel.setFont(new Font("Arial", Font.ITALIC, 20));
		secondaryLabel.setBounds(440, 265, 300, 200);
		secondaryLabel.setForeground(Color.RED);
		
		panel.repaint();
		panel.revalidate();
		
		optionButton.get(0).addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (textField.get(0).getText().isEmpty()) {
						panel.add(secondaryLabel); // inform the user that they have not entered any text
						panel.repaint();
						panel.revalidate();
					}
					else {
						panel.removeAll();
						panel.repaint();
						panel.revalidate();
						
						String name = textField.get(0).getText();
						newPlayer.setName(name);
						newPlayer.setHighScoreGame1(0);
						newPlayer.setHighScoreGame2(0);
						optionButton.clear();
						textField.clear();
						Main.addNewPlayer(newPlayer);
					}
				}
			}
		);		
	}
	
	static int difficulty = 0;
	
	public static void difficultyEasy(int game) {
		difficulty = 1;
		startGame(game); // forced to do it like this due to java swing's non-asynchronous nature 
	}
	
	public static void difficultyMedium(int game) {
		difficulty = 2;
		startGame(game);
	}
	
	public static void difficultyHard(int game) {
		difficulty = 3;
		startGame(game);
	}
	
	public static void difficulty(int game) {
		// TODO add information about each game mode

		mainLabel.setFont(SubTitle);		
		mainLabel.setText ("<html> Select Difficulty </html>");
		mainLabel.setHorizontalAlignment(JLabel.CENTER);
		panel.add(mainLabel);
		
		optionButton.add(new JButton("Easy"));
		optionButton.get(0).setBounds(355, 325, 85, 25);
		panel.add(optionButton.get(0));
		
		optionButton.add(new JButton("Medium"));
		optionButton.get(1).setBounds(455, 325, 85, 25);
		panel.add(optionButton.get(1));
		
		optionButton.add(new JButton("Hard"));
		optionButton.get(2).setBounds(555, 325, 85, 25);
		panel.add(optionButton.get(2));
		
		panel.repaint();
		panel.revalidate();
		
		optionButton.get(0).addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panel.removeAll();
					panel.repaint();
					panel.revalidate();
					optionButton.clear();
					difficultyEasy(game);
				}
			}
		);
		
		optionButton.get(1).addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panel.removeAll();
					panel.repaint();
					panel.revalidate();
					optionButton.clear();
					difficultyMedium(game);
				}
			}
		);
		
		optionButton.get(2).addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panel.removeAll();
					panel.repaint();
					panel.revalidate();
					optionButton.clear();
					difficultyHard(game);
				}
			}
		);
	}
	
	public static void startGame(int game) {
		switch(game) {
		case 1:
			memorizationGame(difficulty);
			break;
		case 2:
			sortingGame(difficulty);
			break;
		}			
	}

	private static void memorizationGame(int inputDifficulty) {
		for(int i = 0; i < 3; ++i) {
			for(int j = 0; j < 4; ++j) {
				if(i == 1) {
					optionButton.add(new JButton("A" + j));
				}
				else if(i == 2) {
					optionButton.add(new JButton("B" + j));
				}
				else if(i == 3) {
					optionButton.add(new JButton("C" + j));
				}
			}
		}
	}
	
	private static void sortingGame(int inputDifficulty) {
		// TODO complete
	}
}
