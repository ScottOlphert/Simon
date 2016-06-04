package Simon;

public class Player {
	
	private String Username, Forename, Surname  ;
	private int Level, Highest, Win, Lose;
	
	public Player() {
		
		this.Username = "";
		this.Forename = "";
		this.Surname = "";
		this.Level = 0;
		this.Highest = 0;
		this.Win = 0;
		this.Lose = 0;
	}
	
	public Player(String username, String forename, String surname, int level,
			int highest, int win, int lose) {
		
		this.Username = username;
		this.Forename = forename;
		this.Surname = surname;
		this.Level = level;
		this.Highest = highest;
		this.Win = win;
		this.Lose = lose;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getForename() {
		return Forename;
	}

	public void setForename(String forename) {
		Forename = forename;
	}

	public String getSurname() {
		return Surname;
	}

	public void setSurname(String surname) {
		Surname = surname;
	}

	public int getLevel() {
		return Level;
	}

	public void setLevel(int level) {
		Level = level;
	}

	public int getHighest() {
		return Highest;
	}

	public void setHighest(int highest) {
		Highest = highest;
	}

	public int getWin() {
		return Win;
	}

	public void setWin(int win) {
		Win = win;
	}

	public int getLose() {
		return Lose;
	}

	public void setLose(int lose) {
		Lose = lose;
	}
	
	public void compareTo(int lvl)
	{
		if(lvl > this.Highest)
			this.Highest = lvl;
	}

	
	public String toString() {
		return String.format("%-20s        %-40s %16d %23d %15d %9d",Username, Forename.concat(Surname), Highest, Level, Win, Lose);
	
	}
	
	public String LeaderBoard() {
		return String.format("%-30s\t %9d %15d",Username, Highest, Win);
	
	}
	
	
	
	
	

}

