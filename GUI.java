// run in JavaSE-17 system library 
package finalProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
	static Font Title = new Font("Arial", Font.PLAIN, 50);
	static Font SubTitle = new Font("Arial", Font.PLAIN, 25);
	static Font NormalText = new Font("Arial", Font.PLAIN, 15);
	static Font SubText = new Font("Arial", Font.PLAIN, 10);
	
	static JFrame frame = new JFrame("Java Minigames");
	static JPanel panel = new JPanel();
	static JLabel mainMenu = new JLabel();
	static JLabel mainLabel = new JLabel(); 
	
	static JButton optionOne = new JButton("Option 1");
	static JButton optionTwo = new JButton("Option 2");
	
	static JButton yesButton = new JButton();
	static JButton noButton = new JButton();
	static JButton exit = new JButton("Exit"); 
	static JButton proceed = new JButton("Continue");
	
	public static void main(String[] args) {
		int h = 990, w = 610; 
		
		frame.setSize(h,w); // window size
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // default operation when it closes
		frame.setVisible(true);
		frame.add(panel);
		panel.setLayout(null);
		mainMenu.setBounds(20, 10, 950, 510);
		mainLabel.setVerticalAlignment(JLabel.TOP);
		mainLabel.setBounds(20, 10, 950, 510); // 950x510, border +10 px 
		
		yesButton.setBounds(460,535,85,25);
		noButton.setBounds(560,535,85,25);
		
		panel.add(mainLabel);
		mainLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		startGui();
	}
	
	public static void startGui() {
		mainLabel.setFont(Title);		
		mainLabel.setText ("<html> Java Minigames </html>");
		mainLabel.setHorizontalAlignment(JLabel.CENTER);
		proceed.setBounds(460,535,85,25);
		
		panel.add(proceed);
		panel.revalidate();
		panel.repaint(); 
		
		proceed.addActionListener //adding an action to the press of this button
		(
			new ActionListener() 
			{
				public void actionPerformed(ActionEvent e) //the action to be completed when button action is completed
				{	
					panel.remove(mainLabel);
					panel.remove(proceed);
					mainLabel.setFont(NormalText);
					
				}
			}
		);
	}
}
