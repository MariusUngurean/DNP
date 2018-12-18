package socket_server;

public class PlayerRequest implements Request {

	private String type;
	private Player player;
	private String answer;

	public PlayerRequest(String type, Player player) {
		this.type = type;
		this.player = player;

	}

	public PlayerRequest(String type, Player player, String answer) {
		this.type = type;
		this.setAnswer(answer);
		this.player = player;
	}

	@Override
	public String getType() {
		return type;
	}

	@Override
	public Player getUser() {
		return this.player;
	}

	@Override
	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

}
