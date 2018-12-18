package ServerConnection;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.Request;
import model.Player;

public class ClientConnection implements Connection {

	private Socket clientSocket;
	final int PORT = 6789;
	final String HOST = "localhost";
	private DataInputStream fromServer;
	private DataOutputStream toServer;

	public ClientConnection() throws UnknownHostException, IOException {
		clientSocket = new Socket(HOST, PORT);
		fromServer = new DataInputStream(clientSocket.getInputStream());
		toServer = new DataOutputStream(clientSocket.getOutputStream());

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see controller.IClientConnection#send(model.IUser)
	 */
	@Override
	public void send(Request request) throws IOException {
		Gson gson = new GsonBuilder().create();
		String clientMessage = gson.toJson(request);
		System.out.println("message from client to server :"+clientMessage);
		
		toServer.writeUTF(clientMessage);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see controller.IClientConnection#receive()
	 */
	@Override
	public Player receive() throws IOException {
		Gson gson = new Gson();
		String serverMessage = null;
		serverMessage = fromServer.readUTF();
		System.out.println("message from server to client :"+serverMessage);
		
		Player player = gson.fromJson(serverMessage, Player.class);
		return player;

	}

}
