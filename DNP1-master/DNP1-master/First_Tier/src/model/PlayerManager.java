package model;

import java.io.IOException;
import model.PlayerRequest;
import model.Player;
import ServerConnection.*;

public class PlayerManager implements ModelManager {

	private Connection clientConnection;
	private Player player;
	Player requestPlayer = new Player("username", "email", "password");
	int i = 0;
	private Player replyPlayer;
	

	public PlayerManager(Connection clientConnection) {
		this.clientConnection = clientConnection;
		this.player = new Player();

	}

	@Override
	public void sendUserRequest(String type, Player player) throws IOException {
		clientConnection.send(new PlayerRequest(type, player));
	}

	@Override
	public void sendUserRequest(String type, Player player, String answer) throws IOException {
		clientConnection.send(new PlayerRequest(type, player, answer));
	}

	@Override
	public Player getReply() throws IOException {
		player = (Player) (clientConnection.receive());
		return player;
	}

	@Override
	public Player getUser(String email, String password) {
		player = new Player(email, password);
		return player;
	}

	@Override
	public Player getUser(int score, int stage) {
		player.getUsername();
		player.getEmail();
		player.getPassword();
		player.setScore(score);
		player.setStage(stage);

		return player;

	}

	@Override
	public Player getUser(String username, String regEmail, String regPassword) {
		Player regPlayer = new Player();
		regPlayer.setUserName(username);
		regPlayer.setEmail(regEmail);
		regPlayer.setPassword(regPassword);

		return regPlayer;
	}

	@Override
	public String[] doWork(String[] getdata) {

		System.out.println("got the data");
		;
		try {
			switch (getdata[0]) {
			case "login":

				requestPlayer.setEmail(getdata[1]);
				requestPlayer.setPassword(getdata[2]);
				this.sendUserRequest(getdata[0], requestPlayer);
				
				replyPlayer = getReply();
				
				requestPlayer=replyPlayer;
				
//				requestPlayer.setEmail(replyPlayer.getEmail());
//				requestPlayer.setPassword(replyPlayer.getPassword());
//				requestPlayer.setStage(replyPlayer.getStage());
//				requestPlayer.setScore(replyPlayer.getScore());
//				requestPlayer.setUserName(replyPlayer.getUsername());
//				
				
				// working
				;
				return new String[] { "menu", requestPlayer.getUsername(), "" + requestPlayer.getScore(),
						"" + requestPlayer.getStage() };
			case "newGame":
				requestPlayer.setScore(0);
				requestPlayer.setStage(0);
				return new String[] { "play", "" + requestPlayer.getScore(), "" + requestPlayer.getStage() };

			case "resume":
				return new String[] { "play", "" + requestPlayer.getScore(), "" + requestPlayer.getStage() };

				// working
			case "play":
				String answer = getdata[3];
				this.sendUserRequest("validate", requestPlayer, answer);
				replyPlayer = getReply();
				requestPlayer=replyPlayer;
				return new String[] { "play", "" + requestPlayer.getScore(), "" + requestPlayer.getStage() };

			
			case "register":
				String username = "" + getdata[1];
				String regEmail = "" + getdata[2];
				String regPassword = "" + getdata[3];
				// working
				requestPlayer.setUserName(username);
				requestPlayer.setEmail(regEmail);
				requestPlayer.setPassword(regPassword);
				this.sendUserRequest(getdata[0], requestPlayer);
				requestPlayer.setNull();
				return new String[] { "login", "", "" };
			case "exit":
				return new String[] { "exit" };
			case "doRegistration":
				return new String[] { "register", "", "" };
			case "logout":
				getUser().setNull();
				return new String[] { "login", "", "" };
			default:
				break;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public Player getUser() {
		// TODO Auto-generated method stub
		return this.player;
	}

}
