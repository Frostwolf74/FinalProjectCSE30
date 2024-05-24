package finalProject;

import java.util.ArrayList;

public class Main {
	static ArrayList<PlayerData> players = new ArrayList<PlayerData>();
	
	public static void addPlayer(int game) {
		GUI.EnterPlayerData();
	}
	
	public static void addNewPlayer(PlayerData newPlayer) {
		players.add(newPlayer);
		System.out.println("Player: " + newPlayer.getName() + "\nMemorization game high score: " + newPlayer.getHighScoreGame1() + "\nSorting game high score: " + newPlayer.getHighScoreGame2());
	}
}
