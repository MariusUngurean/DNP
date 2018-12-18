package socket_server;

public class Player implements User {
	private String email;
	private String password;
	private int score, stage;
	private String username;

	public Player(String email, String password) {
		this.email = email;
		this.password = password;
		username = "";
		score = 0;
		stage = 0;

	}

	public Player() {
		email = "";
		password = "";
		username = "";
		score = 0;
		stage = 0;

		

	}

	public Player(String username, String regEmail, String regPassword) {
		this.email = regEmail;
		this.password = regPassword;
		this.username = username;
		score = 0;
		stage = 0;
	}

	public String getEmail() {
		return this.email;
	}

	// get and set password
	public String getPassword() {
		return this.password;
	}

	// get and set score
	public int getScore() {
		return this.score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	// get and set stage
	public int getStage() {
		return this.stage;
	}

	public void setStage(int stage) {
		this.stage = stage;
	}

	// to string
	public String toString() {
		return getEmail() + " " + getPassword() + " " + getUsername() + " " + getScore() + " " + getStage();
	}

	public String getUsername() {
		return username;
	}

	public void setUserName(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;

	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setNull() {
		setEmail("");
		setPassword("");
		setUserName("");
		setScore(0);
		setStage(0);

	}

}
