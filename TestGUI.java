package finalProject;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TestGUI {
	static Font Title = new Font("Arial", Font.PLAIN, 50);
	static Font SubTitle = new Font("Arial", Font.PLAIN, 25);
	static Font NormalText = new Font("Arial", Font.PLAIN, 15);
	static Font SubText = new Font("Arial", Font.PLAIN, 10);
	
	static JFrame frame = new JFrame("Java Minigames");
	static JPanel panel = new JPanel();
	static JLabel mainLabel = new JLabel(); 
	
	static JButton proceed = new JButton("Continue");
	static JButton returnButton = new JButton("Return");
	static JButton exit = new JButton("Exit"); 
	
	static JFormattedTextField textField = new JFormattedTextField();
	static JFormattedTextField textField2 = new JFormattedTextField();
	
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
		
		testGUI();
	}
	
	public static String buttonSymbolRandomizer() {
		Random rand = new Random(); // TODO fix, not random enough
	    int num = rand.nextInt(6);
		String sym = "skipped";
		
		if(num == 0) {
			sym = "!";
		}
		else if(num == 1) {
			sym = "@";
		}
		else if(num == 2) {
			sym = "#";
		}
		else if(num  == 3) {
			sym = "$";
		}
		else if(num  == 4) {
			sym = "%";
		}
		else if(num  == 5) {
			sym = "&";
		}
		System.out.println(num);
		return sym;
	}
	
	public static void testGUI() {
		ArrayList<JButton> button = new ArrayList<JButton>();
		
		button.add(new JButton("A1"));
		button.add(new JButton("A2"));
		button.add(new JButton("A3"));
		button.add(new JButton("A4"));
		button.add(new JButton("B1"));
		button.add(new JButton("B2"));
		button.add(new JButton("B3"));
		button.add(new JButton("B4"));
		button.add(new JButton("C1"));
		button.add(new JButton("C2"));
		button.add(new JButton("C3"));
		button.add(new JButton("C4"));
		button.get(0).setBounds((1000/3),(610/3)-(610/4),90,90);           
		button.get(1).setBounds((1000/3)+110,(610/3)-(610/4),90,90);                
		button.get(2).setBounds((1000/3)+110+110,(610/3)-(610/4),90,90);              
		button.get(3).setBounds((1000/3)+110+110+110,(610/3)-(610/4),90,90);
		button.get(4).setBounds((1000/3),((610/3)-(610/4))+110,90,90);     
		button.get(5).setBounds((1000/3)+110,((610/3)-(610/4))+110,90,90);          
		button.get(6).setBounds((1000/3)+110+110,((610/3)-(610/4))+110,90,90);        
		button.get(7).setBounds((1000/3)+110+110+110,((610/3)-(610/4))+110,90,90);
		button.get(8).setBounds((1000/3),((610/3)-(610/4))+110+110,90,90); 
		button.get(9).setBounds((1000/3)+110,((610/3)-(610/4))+110+110,90,90);     
		button.get(10).setBounds((1000/3)+110+110,((610/3)-(610/4))+110+110,90,90);   
		button.get(11).setBounds((1000/3)+110+110+110,((610/3)-(610/4))+110+110,90,90);
		
		
		for(int i = 0; i < 12; ++i) {			
			button.get(i).setText(buttonSymbolRandomizer());
			panel.add(button.get(i));
		}
	}
}
