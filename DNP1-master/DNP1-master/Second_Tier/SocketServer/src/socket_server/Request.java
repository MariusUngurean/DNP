package socket_server;

public interface Request {

	String getType();

	Player getUser();

	String getAnswer();

}