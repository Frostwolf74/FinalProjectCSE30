package finalProject;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class SavePlayerData	extends PlayerData implements Serializable {
	private static final long serialVersionUID = 1L;
    private static final String[] filepath = {"C:\\Users\\16128011\\Documents\\Java Minigames\\PlayerData"};
    
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
		try {
			FileOutputStream playerData = new FileOutputStream(filepath[filepath.length+1] + player.getName());
			ObjectOutputStream savePlayerData = new ObjectOutputStream(playerData);
			
			savePlayerData.writeObject(player);
			savePlayerData.close();			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}	
	
	public void readPlayerData(PlayerData player) {
		// TODO
	}
}
