package finalProject;

import java.util.ArrayList;

public class PlayerData {
	private String name;
	private int highScoreGame1;
	private int highScoreGame2;

	public PlayerData(String name, int highScoreGame1, int highScoreGame2) {
		this.name = name;
		this.highScoreGame1 = highScoreGame1;
		this.highScoreGame2 = highScoreGame2;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHighScoreGame1() {
		return highScoreGame1;
	}

	public void setHighScoreGame1(int highScore) {
		this.highScoreGame1 = highScore;
	}
	
	public int getHighScoreGame2() {
		return highScoreGame2;
	}

	public void setHighScoreGame2(int highScore) {
		this.highScoreGame2 = highScore;
	}
}
