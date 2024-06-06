package finalProject;

import java.util.ArrayList;

public class Main {
	static ArrayList<PlayerData> players = new ArrayList<PlayerData>();
	
	public static void addPlayer(int game) {
		GUI.EnterPlayerData(game);
	}
	
	public static void addNewPlayer(PlayerData newPlayer, int game) {
		players.add(newPlayer);
		GUI.difficulty(game);
	}
}
