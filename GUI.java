// run in JavaSE-17 system library 
package finalProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

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
	
	static JButton optionOne = new JButton("Choose");
	static JButton optionTwo = new JButton("Choose");
	
	static JButton proceed = new JButton("Continue");
	static JButton returnButton = new JButton("Return");
	static JButton exit = new JButton("Exit"); 
	
	static JFormattedTextField textField = new JFormattedTextField();
	
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
		
		proceed.setBounds(460,535,85,25);
		returnButton.setBounds(560,535,85,25);
		
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
		
//		int boundX = ((frame.getBounds().x)/2)-proceed.getBounds().x; this doesnt work for some reason?
		
		exit.setBounds(460,535,85,25);
		panel.add(exit);
		
		optionOne.setBounds(230, 425, 85, 25);
		panel.add(optionOne);
		
		optionTwo.setBounds(690, 425, 85, 25);
		panel.add(optionTwo);
		
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
		
		optionOne.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panel.remove(mainLabel);
					panel.remove(secondaryLabel);
					panel.remove(tertiaryLabel);
					panel.remove(exit);
					panel.remove(optionOne);
					panel.remove(optionTwo);
					panel.repaint(); 
					Main.addPlayer(1);
				}
			}
		);
		
		optionTwo.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panel.remove(mainLabel);
					panel.remove(secondaryLabel);
					panel.remove(tertiaryLabel);
					panel.remove(exit);
					panel.remove(optionOne);
					panel.remove(optionTwo);
					panel.repaint(); 
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
		
		proceed.setBounds(455,535,85,25);
		panel.add(proceed);
		
		panel.add(textField);
		textField.setBounds(455, 325, 85, 25);
		
		panel.repaint();
		panel.revalidate();
		
		proceed.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panel.remove(mainLabel);
					panel.remove(proceed);
					panel.remove(textField);
					panel.repaint();
					panel.revalidate();
					
					String name = textField.getText();
					newPlayer.setName(name);
					newPlayer.setHighScoreGame1(0);
					newPlayer.setHighScoreGame2(0);
					Main.addNewPlayer(newPlayer);
				}
			}
		);
	}
}
