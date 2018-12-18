package socket_server;

public interface User {
	String getEmail();

	String getPassword();

	int getScore();

	int getStage();

	void setScore(int score);

	void setStage(int stage);

	String toString();

}