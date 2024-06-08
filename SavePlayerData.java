package finalProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class SavePlayerData	extends PlayerData implements Serializable {
	private static final long serialVersionUID = 1L;
    private static final String filepath = "C:\\Temp\\";
    
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
    
    public int writePlayerData(PlayerData player, boolean overwrite) {
    	Exception e = null;
    	File f = new File(filepath + player.getName() + ".txt");
    	if(f.exists() && !f.isDirectory() && !overwrite) { 
    	    System.out.println("File already exists");
    	    return 2; // failed - file already exists error 
    	}
    	else {
    		try {
    			FileOutputStream playerData = new FileOutputStream(filepath + player.getName() + ".txt"); // all player data files will be the player's name
    			System.out.println("File found.");
    			ObjectOutputStream savePlayerData = new ObjectOutputStream(playerData);
    			
    			savePlayerData.writeObject(player);
    			savePlayerData.close();			
    			
    			System.out.println("Player data saved successfully.");
    		}catch(Exception e1) {
    			e = e1;
    			e.printStackTrace();
    		}
    		if(e == null) {
    			return 1; // passed
    		}
    		else {
    			return 0; // failed
    		}
    	}
	}	
	
	public PlayerData readPlayerData(String inputName) {
		PlayerData player = null;
		try {
			FileInputStream playerData = new FileInputStream(filepath + inputName + ".txt");
			ObjectInputStream readPlayerData = new ObjectInputStream(playerData);
			
			player = (PlayerData) readPlayerData.readObject();
			readPlayerData.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return player;
	}
}
