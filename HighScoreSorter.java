package finalProject;

public class HighScoreSorter implements Comparable<PlayerData> {
	public int score=0;

	HighScoreSorter(int score){  
		this.score = score;  
	}  
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public int compareTo(PlayerData o){  
		if(score == o.score[0])  
			return 0;  
		else if(score > o.score[0])  
			return 1;  
		else  
			return -1;  
	}  
}
