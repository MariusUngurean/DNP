package model;

import java.io.IOException;

import model.Player;

public interface ModelManager {

	Player getUser();

	Player getUser(String email, String password);

	Player getUser(int score, int stage);

	Player getUser(String username, String regEmail, String regPassword);

	Player getReply() throws IOException;

	void sendUserRequest(String type, Player player) throws IOException;

	void sendUserRequest(String type, Player player, String answer) throws IOException;

	String[] doWork(String[] args);


}