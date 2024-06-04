// run in JavaSE-17 system library 
package finalProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class GUI {
	static Font Title = new Font("Arial", Font.PLAIN, 50);
	static Font SubTitle = new Font("Arial", Font.PLAIN, 25);
	static Font NormalText = new Font("Arial", Font.PLAIN, 15);
	static Font SubText = new Font("Arial", Font.PLAIN, 10);
	
	static JFrame frame = new JFrame("Java Minigames");
	static JPanel panel = new JPanel();
	
	static JLabel mainLabel = new JLabel();
	static JLabel label2 = new JLabel();
	static JLabel label3 = new JLabel();
	static JLabel label4 = new JLabel();
	static JLabel label5 = new JLabel();
	
	static ArrayList<JButton> optionButton = new ArrayList<JButton>(); // saves memory and prevents bugs, all buttons are deleted after a function is completed 

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
		
		label2.setFont(SubTitle);
		label2.setText("<html> Memorization Game </html>");
		label2.setHorizontalAlignment(JLabel.LEFT);
		label2.setBounds(180, 300, 300, 200);
		panel.add(label2);
		
		label3.setFont(SubTitle);
		label3.setText("<html> Sorting Game </html>");
		label3.setHorizontalAlignment(JLabel.RIGHT);
		label3.setBounds(510, 300, 300, 200);
		panel.add(label3);
		
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
		frame.getRootPane().setDefaultButton(optionButton.get(0));
		optionButton.get(0).requestFocusInWindow(); 
		
		textField.add(new JFormattedTextField());
		textField.get(0).setBounds(455, 325, 85, 25);
		panel.add(textField.get(0));
		textField.get(0).requestFocus();
		
		label2.setText("<html> Enter a name </html>");
		label2.setFont(new Font("Arial", Font.ITALIC, 20));
		label2.setBounds(440, 265, 300, 200);
		label2.setForeground(Color.RED);
		
		panel.repaint();
		panel.revalidate();
		
		optionButton.get(0).addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (textField.get(0).getText().isEmpty()) {
						panel.add(label2); // inform the user that they have not entered any text
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

		label2.setText("Easy: 3x4 square, no time limit, mistake limit is 10");
		label2.setBounds(910/4, 300, 300, 200);
		label3.setText("Medium: 4x5 square, no time limit, mistake limit is 5");
		label3.setBounds((910/4)+250, 300, 300, 200);
		label4.setText("Hard: 6x7 square, no time limit, mistake limit is 3");
		label4.setBounds((910/4)+500, 300, 300, 200);
//		label5.setText("Hardcore: 8x8 square, time limit is 6 seconds and is increased by 3 seconds each time a pair is located, no mistake limit");
//		label5.setBounds();


		
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

        String[] symbols = {"!","!","@","@","#","#","$","$","%","%","&","&"}; // pre-generate the symbols the shuffle them randomly
        Random rand = new Random();
        String temp;
        for (int i = 0; i < symbols.length - 1; ++i) {
            int j = rand.nextInt(i+1);

            temp = symbols[i];
            symbols[i] = symbols[j];
            symbols[j] = temp;
        }
        
        for(int i = 0; i < 12; ++i) {
            optionButton.get(i).setText(symbols[i]);
            panel.add(optionButton.get(i));
        }
        
        Timer timer = new Timer();
        
        timer.schedule(new TimerTask() { // hide all of the text after a second and half
        	@Override
        	public void run() {
        		for(JButton i: optionButton) {
        			i.setText(null);
        			panel.repaint();
        			panel.revalidate();
        		}
        	}
        }, 1500);        
        
        final ArrayList<ActionEvent> buttonPressed = new ArrayList<ActionEvent>(); 
        
        for (int i = 0; i < 12; i++) { // instantiated action listeners to shorten code, when a user clicks a button the symbol assigned to it will reappear 
            final int final_i = i;
            optionButton.get(i).addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    optionButton.get(final_i).setText(symbols[final_i]);
                    buttonPressed.add(e);
                    System.out.println(buttonPressed.get(final_i).getSource()); // XXX debug
                    System.out.println("\nbuttonPressed length: " + buttonPressed.size() + "\n"); // XXX debug
                }
            });
        }
        
	}

	private static void sortingGame(int inputDifficulty) {
		// TODO complete
	}
}
