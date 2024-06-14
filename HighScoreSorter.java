package finalProject;

public class HighScoreSorter implements Comparable<HighScoreSorter> {
	public PlayerData player;

	HighScoreSorter(PlayerData testPlayer){  
		this.player = testPlayer;  
	}  
	
	public void setPlayer(PlayerData newPlayer) {
		this.player = newPlayer;
	}
	
	public PlayerData getPlayer() {
		return player;
	}
	 @Override
	public int compareTo(HighScoreSorter o){  
		if(player.getScore(0) == o.player.getScore(0))  
			return 0;  
		else if(player.getScore(0) > o.player.getScore(0))  
			return 1;  
		else  
			return -1;  
	}  
}
