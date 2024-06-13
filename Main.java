package finalProject;

public class Main {	
	public static void main(String[] args) {
        GUI.mainMenu();
    }
    
    public static void addPlayer(int game) {
        GUI.EnterPlayerData(game);
    }
    
    public static void addNewPlayer(PlayerData newPlayer, SavePlayerData newPlayerData, int game) {
        GUI.difficulty(game, newPlayer, newPlayerData);
    }
    
    public static void getPlayer(int game, String playerName) {
        SavePlayerData playerData = new SavePlayerData(null, null, null, null); // blank player is created and save data is written to the blank
        PlayerData player = playerData.readPlayerData(playerName);
        
        GUI.difficulty(game, player, playerData);
    }
    
    public static void setPlayerScores(PlayerData player, SavePlayerData playerData, long time, int score, int difficulty, int game) {
        player.setScore(score, game);
        player.setDifficulty(difficulty, game);
        player.setTime(time, game);
        playerData.setName(player.getName());
        playerData.setScore(score, game);
        playerData.setTime(time, game);
        playerData.writePlayerData(player, game, true, false);
    }
}
