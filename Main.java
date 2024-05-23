package finalProject;

import java.util.ArrayList;

public class Main {
	static ArrayList<PlayerData> players = new ArrayList<PlayerData>();
	
	public static void addPlayer(int game) {
		PlayerData newPlayer = GUI.EnterPlayerData();
		players.add(newPlayer);
	}
}
