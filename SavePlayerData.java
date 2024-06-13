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
    
    public int writePlayerData(PlayerData player, int game, boolean overwrite, boolean isNewFile) {
        Exception e = null;
        File f = new File(filepath + player.getName() + ".txt");
        if(f.exists() && !f.isDirectory() && !overwrite) { 
            System.out.println("File already exists");
            return 2; // failed - file already exists error 
        }
        else {
            try {
                FileWriter playerData = new FileWriter(filepath + player.getName() + ".txt");// all player data files will be the player's name
                BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filepath + player.getName() + ".txt")));
                int[] fileScore = StringArrayToIntArray(reader.readLine().split("\n")[0].split("\\|"));
                long[] fileTime = StringArrayToLongArray(reader.readLine().split("\n")[0].split("\\|"));
                int[] fileDifficulty = StringArrayToIntArray(reader.readLine().split("\n")[0].split("\\|"));
                System.out.println("File found.");

                if(this.name == null) {
                    name = "";
                }
                if(this.score == null) {
                    score = new int[2];
                }
                if(this.time == null) {
                    time = new long[2];
                }
                if(this.difficulty == null) {
                    difficulty = new int[2];
                }
                if(!isNewFile) { // file will be blank, there will be nothing to compare
                	if(player.getScore(game) > fileScore[game]) {
                    	playerData.write(this.score[game] + "|" + this.score[game] + "\n"); System.out.println("Saved score: " + this.score[game]);
                    }
                    if(player.getTime(game) > fileTime[game]) {
                    	playerData.write(this.time[game] + "|" + this.time[game] + "\n"); System.out.println("Saved time: " + this.time[game]);
                    }
                    if(player.getDifficulty(game) > fileDifficulty[game]) {
                    	playerData.write(player.getDifficulty(game) + "|" + this.difficulty[game] + "\n"); System.out.println("Saved difficulty: " + this.getDifficulty(game));
                    }
                }
                else if(isNewFile) { 
                	playerData.write(this.name + "|" + this.name + "\n");
                	playerData.write(this.score[game] + "|" + this.score[game] + "\n"); System.out.println("Saved score: " + this.score[game]);
                	playerData.write(this.time[game] + "|" + this.time[game] + "\n"); System.out.println("Saved time: " + this.time[game]);
                	playerData.write(player.getDifficulty(game) + "|" + this.difficulty[game] + "\n"); System.out.println("Saved difficulty: " + this.getDifficulty(game));
                }

                playerData.close();
                reader.close();
                
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
