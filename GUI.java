// run in JavaSE-17 system library 
package finalProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

public class GUI {
	static Font Title = new Font("Arial", Font.PLAIN, 50);
	static Font SubTitle = new Font("Arial", Font.PLAIN, 25);
	static Font NormalText = new Font("Arial", Font.PLAIN, 15);
	static Font SubText = new Font("Arial", Font.PLAIN, 10);
	
	static JFrame frame = new JFrame("Java Minigames");
	static JPanel panel = new JPanel();
	
	static ArrayList<JLabel> label = new ArrayList<JLabel>();
	
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
		optionButton.requestFocus(); // sets focus on button so enter key can be used to activate it 
		
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

		label.add(new JLabel());
		label.add(new JLabel());
		label.add(new JLabel());
//		label.add(new JLabel());
		label.get(0).setText("Easy: 3x4 square, no time limit, mistake limit is 10");
		label.get(0).setBounds(910/4, 300, 300, 200);
		label.get(1).setText("Medium: 4x5 square, no time limit, mistake limit is 5");
		label.get(1).setBounds((910/4)+250, 300, 300, 200);
		label.get(2).setText("Hard: 6x7 square, no time limit, mistake limit is 3");
		label.get(2).setBounds((910/4)+500, 300, 300, 200);
//		label.get(3).setText("Hardcore: 8x8 square, time limit is 6 seconds and is increased by 3 seconds each time a pair is located, no mistake limit");
//		label.get(3).setBounds();


		
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
		panel.add(mainLabel);
		mainLabel.setText(null);
		
		for(int i = 0; i < 3; ++i) {
			for(int j = 0; j < 4; ++j) {
				if(i == 0) {
					optionButton.add(new JButton("A" + (j+1)));
				}
				else if(i == 1) {
					optionButton.add(new JButton("B" + (j+1)));
				}
				else if(i == 2) {
					optionButton.add(new JButton("C" + (j+1)));
				}
			}
		}

		int baseX = (1000/3)-25;
        int baseY = (610/3)-(610/4);
        int width = 90;
        int height = 90;
        int offsetX = 110;
        int offsetY = 110;

        for(int i = 0; i < 12; i++) {
            int x = baseX + (i % 4) * offsetX;
            int y = baseY + (i / 4) * offsetY;
            optionButton.get(i).setBounds(x, y, width, height);
        }
		
		optionButton.get(0).setText("!"); 
		optionButton.get(1).setText("!");
		optionButton.get(2).setText("@");
		optionButton.get(3).setText("@");
		optionButton.get(4).setText("#");
		optionButton.get(5).setText("#");
		optionButton.get(6).setText("$");
		optionButton.get(7).setText("$");
		optionButton.get(8).setText("%");
		optionButton.get(9).setText("%");
		optionButton.get(10).setText("&");
		optionButton.get(11).setText("&");

        String[] symbols = {"!","!","@","@","#","#","$","$","%","%","&","&"};
        Random rand = new Random();
        String temp;
        for (int i = symbols.length - 1; i > 0; i--) {
            // Generate a random index between 0 and i (inclusive)
            int j = rand.nextInt(i + 1);

            // Swap the elements at indices i and j
            temp = symbols[i];
            symbols[i] = symbols[j];
            symbols[j] = temp;
        }
        
        for(int i = 0; i < 12; ++i) {
            optionButton.get(i).setText(symbols[i]);
            panel.add(optionButton.get(i));
        }
        
        // create a timer that when finished hides the buttons
	}
	
	private static void sortingGame(int inputDifficulty) {
		// TODO complete
	}
}
