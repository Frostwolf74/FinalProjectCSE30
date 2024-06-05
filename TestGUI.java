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
        
        for (int i = 0; i < 12; ++i) { // instantiated action listeners to shorten code, when a user clicks a button the symbol assigned to it will reappear 
            final int final_i = i;
            optionButton.get(i).addActionListener(new ActionListener() {
            	public static int totalButtonPresses=0;
            	
            	public void actionPerformed(ActionEvent e) {
                    optionButton.get(final_i).setText(symbols[final_i]);
                    optionButton.get(final_i).setEnabled(false);

                    lastButtonPressed[totalButtonPresses] = optionButton.get(final_i).getText(); 
                    ++totalButtonPresses;
                    
                    if((lastButtonPressed[0] != null) && (lastButtonPressed[1] != null)) {
                    	if(lastButtonPressed[0] == lastButtonPressed[1]) {
                    		System.out.println("matched");
                    	}
                    	else {
                    		System.out.println("no match");
                    	}
                    	totalButtonPresses=0;
                    	lastButtonPressed[0] = null;
                    	lastButtonPressed[1] = null;
                    }
            	}
            });
        }
     }
}
