package finalProject;

public class PlayerData {
	private String name;
	private int scoreGame1;
	private int scoreGame2;

	public PlayerData(String name, int[] score, long[] time, int[] difficultyCompleted, int[] gameCompleted) {
		this.name = name;
		this.scoreGame1 = scoreGame1;
		this.scoreGame2 = scoreGame2;
	}
	
	public PlayerData(){}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHighScoreGame1() {
		return scoreGame1;
	}

	public void setHighScoreGame1(int score) {
		this.scoreGame1 = score;
	}
	
	public int getHighScoreGame2() {
		return scoreGame2;
	}

	public void setHighScoreGame2(int score) {
		this.scoreGame2 = score;
	}
}
