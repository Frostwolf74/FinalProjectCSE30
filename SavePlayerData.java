package finalProject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SavePlayerData	extends PlayerData {
private static final String filepath = "C:\\Temp\\";
    
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
                FileWriter playerData = new FileWriter(filepath + player.getName() + ".txt");// all player data files will be the player's name
                System.out.println("File found.");

                if(name == null) {
                    name = "";
                }
                if(score == null) {
                    score = new int[2];
                }
                if(time == null) {
                    time = new long[2];
                }
                if(difficulty == null) {
                    difficulty = new int[2];
                }

                playerData.write(this.name+"\n");
                playerData.write(this.score[0] + "|" + this.score[1] + "\n");
                playerData.write(this.time[0] + "|" + this.time[1] + "\n");
                playerData.write(this.difficulty[0] + "|" + this.difficulty[1] + "\n");

                playerData.close();
                
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
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filepath + inputName + ".txt")));
            String name = reader.readLine().split("\n")[0];
            int[] score = StringArrayToIntArray(reader.readLine().split("\n")[0].split("\\|"));
            long[] time = StringArrayToLongArray(reader.readLine().split("\n")[0].split("\\|"));
            int[] difficulty = StringArrayToIntArray(reader.readLine().split("\n")[0].split("\\|"));
            System.out.println("Player data read successfully.");

            System.out.println("Name: " + name);
            System.out.println("Score: " + Arrays.toString(score));
            System.out.println("Time: " + Arrays.toString(time));
            System.out.println("Difficulty: " + Arrays.toString(difficulty));

            player = new PlayerData(name, score, time, difficulty);
            
            reader.close();

        }catch(Exception e){
            e.printStackTrace();
        }
        return player;
    }
    public int[] StringArrayToIntArray(String[] input) {
        int[] output = new int[input.length];
        for(int i = 0; i < input.length; ++i) {
            output[i] = Integer.parseInt(input[i]);
        }
        return output;
    }
    public long[] StringArrayToLongArray(String[] input) {
        long[] output = new long[input.length];
        for(int i = 0; i < input.length; ++i) {
            output[i] = Long.parseLong(input[i]);
        }
        return output;
    }
}
