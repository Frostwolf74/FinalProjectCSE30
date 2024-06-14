package finalProject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SavePlayerData	extends PlayerData {
private static String filepath = "C:\\Temp\\";
    
    public SavePlayerData(String name, int[] score, long[] time, int[] difficulty) {
        super(name, score, time, difficulty);
        this.name = name;
        this.score = score;
        this.time = time;
        this.difficulty = difficulty;
    }
    
    public int writePlayerData(PlayerData player, int game, boolean overwrite, boolean isNewFile, boolean writeBackup) {
//        if(writeBackup) {
//        	filepath = "C:\\Temp\\GameBackups\\";
//        }
//        else {
//        	filepath = "C:\\Temp\\";
//        }
    	Exception e = null;
        File f = new File(filepath + player.getName());
        if(f.exists() && !f.isDirectory() && !overwrite) { 
            System.out.println("File already exists.");
            return 2; // failed - file already exists error 
        }
        else {
            try {
                int[] fileScore = null;
                long[] fileTime = null;
                int[] fileDifficulty = null;
                if(!isNewFile) {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filepath + player.getName())));
                    name = reader.readLine().split("\n")[0];
                    fileScore = StringArrayToIntArray(reader.readLine().split("\n")[0].split("\\|"));
                    fileTime = StringArrayToLongArray(reader.readLine().split("\n")[0].split("\\|"));
                    fileDifficulty = StringArrayToIntArray(reader.readLine().split("\n")[0].split("\\|"));
                    reader.close();
                }
                
                FileWriter playerData = new FileWriter(filepath + player.getName());// all player data files will be the player's name
                System.out.println("File found. " + filepath + player.getName());

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
                    playerData.write(name + "\n"); System.out.println("Saved name: " + name);
                    if(player.getScore(game) >= fileScore[game]) {
                        playerData.write(this.score[0] + "|" + this.score[1] + "\n"); System.out.println("Saved score: " + this.score[0]);
                    }
                    else {
                    	playerData.write(fileScore[0] + "|" + fileScore[1] + "\n"); System.out.println("Saved score: " + fileScore[0]);
                    }
                    if(player.getTime(game) >= fileTime[game]) {
                        playerData.write(this.time[0] + "|" + this.time[1] + "\n"); System.out.println("Saved time: " + this.time[0]);
                    }
                    else {
                    	playerData.write(fileTime[0] + "|" + fileTime[1] + "\n"); System.out.println("Saved time: " + fileTime[0]);
                    }
                    if(player.getDifficulty(game) >= fileDifficulty[game]) {
                        playerData.write(this.difficulty[0] + "|" + this.difficulty[1] + "\n"); System.out.println("Saved difficulty: " + this.difficulty[0]);
                    }
                    else {
                    	playerData.write(fileDifficulty[0] + "|" + fileDifficulty[1] + "\n"); System.out.println("Saved difficulty: " + fileDifficulty[0]);
                    }
                }
                else if(isNewFile) {
                    playerData.write(this.name + "\n"); System.out.println("Saved name: " + name);
                    playerData.write(this.score[0] + "|" + this.score[1] + "\n"); System.out.println("Saved score: " + this.score[0]);
                    playerData.write(this.time[0] + "|" + this.time[1] + "\n"); System.out.println("Saved time: " + this.time[0]);
                    playerData.write(player.getDifficulty(0) + "|" + player.getDifficulty(1) + "\n"); System.out.println("Saved difficulty: " + player.getDifficulty(0));
                }

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
    	filepath = "C:\\Temp\\";
        PlayerData player = new PlayerData(null, null, null, null);
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filepath + inputName)));
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
