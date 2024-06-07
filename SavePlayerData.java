package finalProject;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class SavePlayerData	extends PlayerData implements Serializable {
	private static final long serialVersionUID = 1L;
    private static final String filepath = "C:\\Temp\\";
    int[] saveSlotStatus = {0,0,0,0,0};
    
    private String name;
	private int[] score = new int[2];
	private long[] time = new long[2];
	private int[] difficulty = new int[2];
    
    public SavePlayerData(String name, int[] score, long[] time, int[] difficulty) {
		super(name, score, time, difficulty);
		this.name = name;
		this.score = score;
		this.time = time;
		this.difficulty = difficulty;
    }
    
    public void writePlayerData(PlayerData player) {
    	int openSaveSlots = 0;
    	for(int i = 0; i < 5; ++i) {
    		if(saveSlotStatus[i] == 0) {
    			openSaveSlots = i;
    		}
    	}
		try {
			FileOutputStream playerData = new FileOutputStream(filepath + player.getName() + ".txt");
			ObjectOutputStream savePlayerData = new ObjectOutputStream(playerData);
			
			savePlayerData.writeObject(player);
			savePlayerData.close();			
			
			System.out.println("Player data saved successfully.");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}	
	
	public void readPlayerData(PlayerData player) {
		// TODO create player data reader and implement reader into GUI
	}
}
