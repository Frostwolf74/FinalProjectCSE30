package finalProject;

import java.util.ArrayList;

public class Main {
	static ArrayList<PlayerData> players = new ArrayList<PlayerData>();
	
	public static void main(String[] args) {
		GUI.mainMenu();
	}
	
	public static void addPlayer(int game) {
		GUI.EnterPlayerData(game);
	}
	
	public static void addNewPlayer(PlayerData newPlayer, int game) {
		players.add(newPlayer);
		GUI.difficulty(game);
	}
	
	public static void setPlayerScores(long time, int score, int difficulty, int game) {
		// TODO complete
	}
}
