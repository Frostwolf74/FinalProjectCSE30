
package finalProject;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.AbstractButton;
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
	
	public static void main(String[] args) throws Exception {
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
		
		testGUI(3);
	}
	
	public static int random() { // pre-generate the symbols then randomize them 
		Random rand = new Random();
		int num = rand.nextInt(12);	    
		return num;
	}
	
	public static void testGUI(int inputDifficulty) throws Exception {		
		frame.setSize(1920,1080);
		mainLabel.setBounds(10, 10, 1920-35, 1080-90);
		panel.add(mainLabel);
		mainLabel.setText(null);
		
		int columns = 0;
		int rows = 0;		
		int totalButtons = 0;
		
		// pre-generate the symbols the shuffle them randomly
        String[] symbols = new String[42]; 
        if(inputDifficulty == 1) {
        	symbols = new String[]{"!","!","@","@","#","#","$","$","%","%","&","&"};
        	columns = 3;
			rows = 4;
			totalButtons = 12;
        }
        else if(inputDifficulty == 2) {
        	symbols = new String[]{"!","!","@","@","#","#","$","$","%","%","&","&","*","*","+","+","~","~","=","="};
        	columns = 4;
			rows = 5;
			totalButtons = 20;
        }
        else if(inputDifficulty == 3) {
        	symbols = new String[]{"!","!","@","@","#","#","$","$","%","%","&","&","*","*","+","+","~","~","=","=","♦","♦","•","•","○","○","►","►","◄","◄","§","§","▬","▬","▲","▲","▼","▼","▓","▓","×","×"}; 
        	columns = 6;
        	rows = 7;
        	totalButtons = 42;
        }
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
				default:
					throw new Exception("Out of bounds for length 7");
				}
			}
		}
		
		int baseX = 40;
        int baseY = 40;
        int width = 90;
        int height = 90;
        int offsetX = 110;
        int offsetY = 110;

        for(int i = 0; i < totalButtons; i++) {
            int x = baseX + (i % columns) * offsetX;
            int y = baseY + (i / columns) * offsetY;
            optionButton.get(i).setBounds(x, y, width, height);
        }
        
        for(int i = 0; i < totalButtons; ++i) {
        	panel.add(optionButton.get(i));
        }
        
        frame.setSize(((optionButton.get(optionButton.size()-1).getBounds().x - optionButton.get(0).getBounds().x)+optionButton.get(0).getWidth())+110, (optionButton.get(optionButton.size()-1).getBounds().y - optionButton.get(0).getBounds().y)+40+110+90);
        frame.setLocation(((1920/2)-(frame.getBounds().x)/2)-130, ((frame.getBounds().y)/2)-80);
        
        mainLabel.setBounds(20, 20, (optionButton.get(optionButton.size()-1).getBounds().x - optionButton.get(0).getBounds().x)+optionButton.get(0).getWidth()+40, (optionButton.get(optionButton.size()-1).getBounds().y - optionButton.get(0).getBounds().y)+40+90);
        
        Random rand = new Random();
        String temp;
        for (int i = 0; i < symbols.length - 1; ++i) {
            int j = rand.nextInt(i+1);

            temp = symbols[i];
            symbols[i] = symbols[j];
            symbols[j] = temp;
        }
        
        for(int i = 0; i < totalButtons; ++i) {
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
        
        String lastButtonPressed[] = new String[2];
        
        for (int i = 0; i < totalButtons; ++i) { // instantiated action listeners to shorten code, when a user clicks a button the symbol assigned to it will reappear 
        	final int final_i = i;
        	optionButton.get(i).addActionListener(new ActionListener() {
        		public static int totalButtonPresses=0;
        		public static int totalMatches=0;

        		public void actionPerformed(ActionEvent e) {
        			optionButton.get(final_i).setText(symbols1[final_i]);
        			optionButton.get(final_i).setEnabled(false);

        			lastButtonPressed[totalButtonPresses] = optionButton.get(final_i).getText(); 
        			++totalButtonPresses;

        			if((lastButtonPressed[0] != null) && (lastButtonPressed[1] != null)) {
        				if(lastButtonPressed[0] == lastButtonPressed[1]) {
        					System.out.println("matched");
        					++totalMatches;
        				}
        				else {
        					System.out.println("no match");
        				}
        				totalButtonPresses=0;
        				lastButtonPressed[0] = null;
        				lastButtonPressed[1] = null;
        			}
        			
        			if(inputDifficulty == 1) { // 1 match required to pass
        				
        			}
        			else if(inputDifficulty == 2) { // 
        				
        			}
        			else if(inputDifficulty == 3) {
        				
        			}
        		}
        	});
        }
	}
}
