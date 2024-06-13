// run in JavaSE-17 system library 
package finalProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
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
	static JButton returnMenu = new JButton("Return");
	
	static ArrayList<JFormattedTextField> textField = new ArrayList<JFormattedTextField>();
	
	static PlayerData currentPlayer;
	static SavePlayerData currentPlayerData;
	static int currentGame;
	
	public static void mainMenu() { 
		int h = 610, w = 1000; 

		frame.setSize(w,h); // window size
		frame.setLocation(500,250); // center
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {
		    public void windowClosing(WindowEvent event) {
		    	exitSavePlayerData(currentPlayer, currentPlayerData); // automatically save progress when window closes
		        frame.dispose();
		        System.exit(0);
		    }
		});
		frame.setVisible(true);
		frame.add(panel);
		panel.setLayout(null);
		
		mainLabel.setVerticalAlignment(JLabel.TOP);
		mainLabel.setHorizontalAlignment(JLabel.CENTER);
		mainLabel.setBounds(10, 10, w-35, h-90); // border +10 px in
		mainLabel.setFont(Title);		
		mainLabel.setText ("<html> Java Minigames </html>");
		
		panel.add(mainLabel);
		mainLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		
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
		returnMenu.setBounds(460,535,85,25);
		
		optionButton.add(new JButton("Choose"));
		optionButton.get(0).setBounds(230, 425, 85, 25);
		panel.add(optionButton.get(0));
		
		optionButton.add(new JButton("Choose"));
		optionButton.get(1).setBounds(690, 425, 85, 25);
		panel.add(optionButton.get(1));
		
		optionButton.add(new JButton("Purge player data"));
		optionButton.get(2).setBounds(20, 20, 170, 25);
		panel.add(optionButton.get(2));
		
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
					Main.addPlayer(1); // input number is game ID
				}
			}
		);
		
		optionButton.get(1).addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panel.removeAll();
					panel.repaint(); 
					optionButton.clear();
					Main.addPlayer(2); // input number is game ID
				}
			}
		);
		
		optionButton.get(2).addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					File file = new File("C:\\Temp");
					String[] files = file.list();
					for(int i = 0; i < files.length; ++i) {
						try {
						file = new File("C:\\Temp\\" + files[i]);
						file.delete();
						}catch(Exception e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		);	
	}

	public static void EnterPlayerData(int game) {		
		mainLabel.setFont(SubTitle);		
		mainLabel.setText ("<html> Enter new player name or load player save </html>");
		mainLabel.setHorizontalAlignment(JLabel.CENTER);
		panel.add(mainLabel);
		
		
		optionButton.add(new JButton("proceed"));
		optionButton.get(0).setBounds(255,535,85,25);
		panel.add(optionButton.get(0)); 
		
		optionButton.add(new JButton("proceed"));
		optionButton.get(1).setBounds(655,535,85,25);
		panel.add(optionButton.get(1));
		
		textField.add(new JFormattedTextField());
		textField.get(0).setBounds(255, 325, 85, 25);
		panel.add(textField.get(0));
		
		textField.add(new JFormattedTextField());
		textField.get(1).setBounds(655,325,85,25);
		panel.add(textField.get(1));
		
		label2.setText("<html> Enter a name </html>");
		label2.setFont(new Font("Arial", Font.ITALIC, 20));
		label2.setBounds(440, 265, 300, 200);
		label2.setForeground(Color.RED);
		
		label3.setText("Add new player");
		label3.setFont(NormalText);
		label3.setBounds(45, 200, 300, 200);
		panel.add(label3);
		
		label4.setText("Load player by name (not case sensitive)");
		label4.setFont(NormalText);
		label4.setBounds(575,200,300,200);
		panel.add(label4);
		
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
						String name = textField.get(0).getText();
						PlayerData newPlayer = new PlayerData();
						int[] blankArray = {0,0}; // need this because the console freaks out when something is null
						long[] longBlankArray = {0,0};
						SavePlayerData playerData = new SavePlayerData(name, blankArray, longBlankArray, blankArray);
						newPlayer = playerData;
						
						int e1 = playerData.writePlayerData(newPlayer, currentGame, false, true);

						if(e1 == 2) {
							label2.setText("Player already exists");
							panel.add(label2);
							panel.repaint();
							panel.revalidate();
						}
						else {
							optionButton.clear();
							textField.clear();
							label2.setForeground(Color.BLACK);
							panel.removeAll();
							panel.repaint();
							panel.revalidate();
							Main.addNewPlayer(newPlayer, playerData, game);
						}
					}
				}
			}
		);
		
		optionButton.get(1).addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {						
						if(textField.get(1).getText().isEmpty()) {
							panel.add(label2);
							panel.repaint();
							panel.revalidate();
						}
						else {
							String name = textField.get(1).getText();					
							SavePlayerData playerData = new SavePlayerData(null, null, null, null);
							PlayerData player = playerData.readPlayerData(name);
							if(player == null) {
								label2.setText("Player does not exist");
								label2.setBounds(440, 265, 300, 200);
								panel.add(label2);
								panel.repaint();
								panel.revalidate();
							}
							else {
								panel.removeAll();
								optionButton.clear();
								textField.clear();
								label2.setForeground(Color.BLACK);
								
								panel.repaint();
								panel.revalidate();
								player = null;
								Main.getPlayer(currentGame, name);
							}
						}
					}
				}
		);
	}
	
	public static void exitSavePlayerData(PlayerData player, SavePlayerData playerData) { 
		if(player != null) {
			playerData.writePlayerData(player, currentGame, true, false);
		}
		else {
			System.out.println("Player data does not currently exist, exiting program without saving.");
			System.exit(0);
		}
	}
	
	public static void difficulty(int game, PlayerData player, SavePlayerData playerData) {
		currentPlayer = player; // sending player data to global variable from previous function where player data was first defined 
		currentPlayerData = playerData;
		currentGame = game;
		
		playerData.writePlayerData(player, currentGame, true, true);
		
		frame.setTitle("Java Minigames" + " (" + player.getName() + ")");
		label5.setFont(SubText);
		label5.setText(String.format("Player information: " + currentPlayer.toString()));
		label5.setBounds(10,470,1000,100);
		panel.add(label5);

		label2.setText("Easy: 3x4 square, no time limit, mistake limit is 10");
		label2.setHorizontalAlignment(JLabel.CENTER);
		label2.setFont(NormalText);
		label2.setBounds(10, 100+25, 965, 520);
		label3.setText("Medium: 4x5 square, no time limit, mistake limit is 18");
		label3.setHorizontalAlignment(JLabel.CENTER);
		label3.setFont(NormalText);
		label3.setBounds(10, 100+25+25, 965, 520);
		label4.setText("Hard: 6x7 square, no time limit, mistake limit is 39");
		label4.setHorizontalAlignment(JLabel.CENTER);
		label4.setFont(NormalText);
		label4.setBounds(10, 100+25+25+25, 965, 520);
		panel.add(label2);
		panel.add(label3);
		panel.add(label4);
		
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
					startGame(game, 1);
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
					startGame(game, 2);
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
					startGame(game, 3);
				}
			}
		);
	}
	
	public static void startGame(int game, int difficulty) {
		switch(game) {
		case 1:
			memorizationGame(difficulty);
			break;
		case 2:
			sortingGame(difficulty);
			break;
		}			
	}

	public static void memorizationGame(int inputDifficulty) {
		frame.setSize(1920,1080);
		mainLabel.setBounds(10, 10, 1920-35, 1080-90);
		panel.add(mainLabel);
		mainLabel.setText(null);
		
		int columns = 0;
		int rows = 0;		
		
		// pre-generate the symbols the shuffle them randomly
        String[] symbols = new String[42]; 
        if(inputDifficulty == 1) {
        	symbols = new String[]{"!","!","@","@","#","#","$","$","%","%","&","&"};
        	columns = 3;
			rows = 4;
        }
        else if(inputDifficulty == 2) {
        	symbols = new String[]{"!","!","@","@","#","#","$","$","%","%","&","&","*","*","+","+","~","~","=","="};
        	columns = 4;
			rows = 5;
        }
        else if(inputDifficulty == 3) {
        	symbols = new String[]{"!","!","@","@","#","#","$","$","%","%","&","&","*","*","+","+","~","~","=","=","♦","♦","•","•","○","○","►","►","◄","◄","§","§","▬","▬","▲","▲","▼","▼","▓","▓","×","×"}; 
        	columns = 6;
        	rows = 7;
        }
        final int totalButtonsFinal = columns*rows;
        String[] symbols1 = symbols; // making string effectively final
		
		for(int i = 0; i < columns; ++i) {
			for(int j = 0; j < rows; ++j) {
				switch(i) {
				case 0:
					optionButton.add(new JButton("A" + (j+1)));
					break;
				case 1:
					optionButton.add(new JButton("B" + (j+1)));
					break;
				case 2:
					optionButton.add(new JButton("C" + (j+1)));
					break;
				case 3:
					optionButton.add(new JButton("D" + (j+1)));
					break;
				case 4:
					optionButton.add(new JButton("E" + (j+1)));
					break;
				case 5:
					optionButton.add(new JButton("F" + (j+1)));
					break;
				case 6:
					optionButton.add(new JButton("G" + (j+1)));
					break;
				}
			}
		}
		
		int baseX = 40;
        int baseY = 40;
        int width = 90;
        int height = 90;
        int offsetX = 110;
        int offsetY = 110;

        for(int i = 0; i < totalButtonsFinal; i++) {
            int x = baseX + (i % columns) * offsetX;
            int y = baseY + (i / columns) * offsetY;
            optionButton.get(i).setBounds(x, y, width, height);
        }
        
        for(int i = 0; i < totalButtonsFinal; ++i) {
        	panel.add(optionButton.get(i));
        }
        
        frame.setSize(((optionButton.get(optionButton.size()-1).getBounds().x - optionButton.get(0).getBounds().x)+optionButton.get(0).getWidth())+110, (optionButton.get(optionButton.size()-1).getBounds().y - optionButton.get(0).getBounds().y)+40+110+90);
        frame.setLocation(500,250);
        
        mainLabel.setBounds(20, 20, (optionButton.get(optionButton.size()-1).getBounds().x - optionButton.get(0).getBounds().x)+optionButton.get(0).getWidth()+40, (optionButton.get(optionButton.size()-1).getBounds().y - optionButton.get(0).getBounds().y)+40+90);
        
        returnMenu.setBounds(230,435,85,25);
        returnMenu.addActionListener(
        		new ActionListener() {
        			public void actionPerformed(ActionEvent e) {
        				mainMenu();
        			}
        		}
        );
        
        Random rand = new Random();
        String temp;
        for (int i = 0; i < symbols.length - 1; ++i) {
            int j = rand.nextInt(i+1);

            temp = symbols[i];
            symbols[i] = symbols[j];
            symbols[j] = temp;
        }
        
        for(int i = 0; i < totalButtonsFinal; ++i) {
            optionButton.get(i).setText(symbols[i]);
            optionButton.get(i).setEnabled(false);
            panel.add(optionButton.get(i));
        }
        
        Timer timer = new Timer();
        
        timer.schedule(new TimerTask() { // hide all of the text after a second and half
        	@Override
        	public void run() {
        		for(JButton i: optionButton) {
        			i.setText(null);
        			i.setEnabled(true);
        			panel.repaint();
        			panel.revalidate();
        		}
        	}
        }, 1500);    
        
        long startTime = System.currentTimeMillis(); // game time
        
        String lastButtonPressed[] = new String[2];
        
        for (int i = 0; i < totalButtonsFinal; ++i) { // instantiated action listeners to shorten code, when a user clicks a button the symbol assigned to it will reappear 
        	final int final_i = i;
        	final long startTime1 = startTime;
        	optionButton.get(i).addActionListener(new ActionListener() {
        		public static int totalButtonPresses=0;
        		public static int buttonPresses=0;
        		public static int totalMatches=0;

        		public void actionPerformed(ActionEvent e) {
        			optionButton.get(final_i).setText(symbols1[final_i]);
        			optionButton.get(final_i).setEnabled(false);

        			lastButtonPressed[buttonPresses] = optionButton.get(final_i).getText(); 
        			++totalButtonPresses;
        			++buttonPresses;

        			if((lastButtonPressed[0] != null) && (lastButtonPressed[1] != null)) { // gets the last two buttons pressed and compares them 
        				if(lastButtonPressed[0] == lastButtonPressed[1]) {
        					System.out.println("matched"); // console debug
        					++totalMatches;
        				}
        				else {
        					System.out.println("no match"); // console debug
        				}
        				buttonPresses=0;
        				lastButtonPressed[0] = null;
        				lastButtonPressed[1] = null;
        			}
        			
        			if(inputDifficulty == 1 || inputDifficulty == 2) { // 2 matches required to pass
        				if(totalMatches >= 2 && totalButtonPresses == totalButtonsFinal) {
        					panel.removeAll();
        					optionButton.clear();
        					panel.add(mainLabel);
        					mainLabel.setText("You win");
        					panel.add(returnMenu);
        					totalMatches=0;
        					buttonPresses=0;
        					totalButtonPresses=0;
        					panel.repaint();
        					panel.revalidate();
        					
        					Main.setPlayerScores(currentPlayer, currentPlayerData, (System.currentTimeMillis()-startTime1), totalMatches, inputDifficulty, 1);
        				}
        				else if(totalButtonPresses == totalButtonsFinal && totalMatches < 2) {
        					panel.removeAll();
        					optionButton.clear();
        					panel.add(mainLabel);
        					mainLabel.setText("You lose");
        					panel.add(returnMenu);
        					totalMatches=0;
        					buttonPresses=0;
        					totalButtonPresses=0;
        					panel.repaint();
        					panel.revalidate();
        					
        					Main.setPlayerScores(currentPlayer, currentPlayerData, System.currentTimeMillis()-startTime1, totalMatches, inputDifficulty, 1);
        				}
        			}
        			else if(inputDifficulty == 3) { // 3 matches required to pass
        				if(totalMatches >= 3 && totalButtonPresses == totalButtonsFinal) {
        					panel.removeAll();
        					optionButton.clear();
        					panel.add(mainLabel);
        					mainLabel.setText("You win");
        					panel.add(returnMenu);
        					totalMatches=0;
        					buttonPresses=0;
        					totalButtonPresses=0;
        					panel.repaint();
        					panel.revalidate();
        					
        					Main.setPlayerScores(currentPlayer, currentPlayerData, System.currentTimeMillis()-startTime1, totalMatches, inputDifficulty, 1);
        				}
        				else if(totalButtonPresses == totalButtonsFinal && totalMatches < 3) {
        					panel.removeAll();
        					optionButton.clear();
        					panel.add(mainLabel);
        					mainLabel.setText("You lose");
        					panel.add(returnMenu);
        					totalMatches=0;
        					buttonPresses=0;
        					totalButtonPresses=0;
        					panel.repaint();
        					panel.revalidate();
        					
        					Main.setPlayerScores(currentPlayer, currentPlayerData, System.currentTimeMillis()-startTime1, totalMatches, inputDifficulty, 1);
        				}
        			}
        		}
        	});
        }
	}

	public static void sortingGame(int inputDifficulty) {
		// TODO complete
	}
}
