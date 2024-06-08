package finalProject;

public class PlayerData {	
	protected String name;
    protected int[] score = new int[2];
    protected long[] time = new long[2];
    protected int[] difficulty = new int[2];

    public PlayerData(String name, int[] score, long[] time, int[] difficulty) {
        this.name = name;
        this.score = score;
        this.time = time;
        this.difficulty = difficulty;
    }
    
    public PlayerData(){}
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore(int game) {
        return score[game];
    }

    public void setScore(int score, int game) {
        this.score[game] = score;
    }

    public long getTime(int game) {
        return time[game];
    }

    public void setTime(long time, int game) {
        this.time[game] = time;
    }

    public int getDifficulty(int game) {
        return difficulty[game];
    }

    public void setDifficulty(int difficulty, int game) {
        this.difficulty[game] = difficulty;
    }
    
    public String toString() {
        return "Name: " + name 
                + " \nMemorization game score: " + score[0] 
                + " \nDifficulty completed: " + difficulty[0] 
                + " \nTime taken to complete: " + time[0]/1000 + " seconds" 
//              + " \nSorting game score: " + score[1]
//              + " \nDifficulty completed: " + difficulty[1] 
//              + " \nTime taken to complete: " + time[1]/1000 + " seconds" 
                ;
    }
}
