package ServerConnection;

import java.io.IOException;

import model.Request;
import model.User;

public interface Connection {

	void send(Request request) throws IOException;

	User receive() throws IOException;

}