package finalProject;

import java.util.ArrayList;

public class Main {	
	static ArrayList<PlayerData> players = new ArrayList<PlayerData>();
	
	public static void main(String[] args) {
		GUI.mainMenu();
	}
	
	public ArrayList<PlayerData> getPlayers() {
		return players;
	}
	
	public void addPlayer(PlayerData player) {
		players.add(player);
	}
	
	public static void addPlayer(int game) {
		GUI.EnterPlayerData(game);
	}
	
	public static void addNewPlayer(PlayerData newPlayer, int game) {
		players.add(newPlayer);
		SavePlayerData playerData = new SavePlayerData(newPlayer.getName(), newPlayer.getScore(), ));
		GUI.difficulty(game);
	}
	
	public static void setPlayerScores(PlayerData player, long time, int score, int difficulty, int game) {
		player.setScore(score, game);
		player.setDifficulty(difficulty, game);
		player.setTime(time, game);
	}
}
