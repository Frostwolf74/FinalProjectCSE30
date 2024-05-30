package finalProject;

import java.util.ArrayList;

public class Main {
	static ArrayList<PlayerData> players = new ArrayList<PlayerData>();
	static int game=0;
	
	public static void addPlayer(int game1) {
		GUI.EnterPlayerData();
		game = game1;
	}
	
	public static void addNewPlayer(PlayerData newPlayer) {
		players.add(newPlayer);
		GUI.difficulty(game);
	}
}
