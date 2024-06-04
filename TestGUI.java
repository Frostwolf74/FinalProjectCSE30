package finalProject;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;
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
	
	static ArrayList<JButton> optionButton = new ArrayList<JButton>();
	
	static JButton proceed = new JButton("Continue");
	static JButton returnButton = new JButton("Return");
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
		
		proceed.setBounds(460,535,85,25);
		returnButton.setBounds(560,535,85,25);
		
		panel.add(mainLabel);
		mainLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		testGUI();
	}
	
	public static int random() { // pre-generate the symbols then randomize them 
		Random rand = new Random();
		int num = rand.nextInt(12);	    
		return num;
	}
	
	public static void testGUI() {		
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
		
		System.out.println("Total JButtons: " + optionButton.size());
		optionButton.get(0).setBounds((1000/3)-75,(610/3)-(610/4),90,90);           
		optionButton.get(1).setBounds(((1000/3)+110)-75,(610/3)-(610/4),90,90);                
		optionButton.get(2).setBounds(((1000/3)+110+110)-75,(610/3)-(610/4),90,90);              
		optionButton.get(3).setBounds(((1000/3)+110+110+110)-75,(610/3)-(610/4),90,90);
		optionButton.get(4).setBounds((1000/3)-75,((610/3)-(610/4))+110,90,90);     
		optionButton.get(5).setBounds(((1000/3)+110)-75,((610/3)-(610/4))+110,90,90);          
		optionButton.get(6).setBounds(((1000/3)+110+110)-75,((610/3)-(610/4))+110,90,90);        
		optionButton.get(7).setBounds(((1000/3)+110+110+110)-75,((610/3)-(610/4))+110,90,90);
		optionButton.get(8).setBounds((1000/3)-75,((610/3)-(610/4))+110+110,90,90); 
		optionButton.get(9).setBounds(((1000/3)+110)-75,((610/3)-(610/4))+110+110,90,90);     
		optionButton.get(10).setBounds(((1000/3)+110+110)-75,((610/3)-(610/4))+110+110,90,90);   
		optionButton.get(11).setBounds(((1000/3)+110+110+110)-75,((610/3)-(610/4))+110+110,90,90);
		
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
	}
}
