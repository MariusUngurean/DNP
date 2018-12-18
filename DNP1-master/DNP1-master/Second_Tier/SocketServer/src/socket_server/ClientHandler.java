
package socket_server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.print.attribute.standard.RequestingUserName;
import javax.swing.JEditorPane;

import code_validator.UpdateUser;
import code_validator.Validator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import restful_client.Get;
import restful_client.HttpRequest;
import restful_client.Post;
import restful_client.Put;

public class ClientHandler implements Runnable {

	private DataInputStream inFromClient;
	private DataOutputStream outToClient;
	private Gson gson;
	private Socket socket;

	public ClientHandler(Socket socket) throws IOException {
		this.socket = socket;

	}

	@Override
	public void run() {

		try {
			inFromClient = new DataInputStream(socket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			outToClient = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}

		String clientMessage = "I am empty!!!";
		String jsonTestUser = "{\"email\":\"a@gmail.com\",\"password\":\"pasword1\",\"score\":100,\"stage\":3,\"username\":\"John1\"}";
		System.out.println(clientMessage);
		gson = new GsonBuilder().create();
		try {

			clientMessage = "I am not empty!!!";
			clientMessage = inFromClient.readUTF();

			System.out.println(clientMessage);
			Request request = gson.fromJson(clientMessage, PlayerRequest.class);
			System.out.println("Client message: " + clientMessage);

			String action = getAction(clientMessage);
			while (action != "Exit") {
				String userAsJson = gson.toJson(request.getUser());
				switch (action) {
				case "login":
					System.out.println("case : login");
					// userAsJson = null;
					HttpRequest getRequest = new Get();
					// userAsJson=jsonTestUser;
					userAsJson = ((Get) getRequest).verify(getUserFromRequest(request).getEmail(),
							getUserFromRequest(request).getPassword());
					// userAsJson=gson.toJson( request.getUser());
					System.out.println("Login request response from server: " + userAsJson);
					reply(userAsJson);
					break;
				case "validate":

					// Player updatedUser=request.getUser();
					UpdateUser updateUser = new UpdateUser();
					userAsJson = updateUser.update(userAsJson, request.getAnswer());

					// userAsJson = null;
					// for real:
					// Validator assesor = new Validator();
					// int newScore = updatedUser.getScore()+
					// assesor.validate(updatedUser.getStage(), request.getAnswer());
					// int newStage = updatedUser.getStage();
					// if (newScore>updatedUser.getScore()) {
					// newStage++;
					// }
					// updatedUser.setScore(newScore);
					// updatedUser.setStage(newStage);
					//
					// for testing:

					/*
					 * updatedUser.setScore(updatedUser.getScore()+12);
					 * updatedUser.setStage(updatedUser.getStage()+1); userAsJson =
					 * gson.toJson(updatedUser);
					 */
					System.out.println("Updated user: " + userAsJson);
					reply(userAsJson);
					// updatedUser=null;
					break;
				case "register":
					userAsJson = null;
					// for testing:
					userAsJson = gson.toJson(request.getUser());

					System.out.println("\"type\":\"register\"" + userAsJson);

					HttpRequest postRequest = new Post();
					if (((Post) postRequest).register(getUserFromRequestAsJson(request))) {
						userAsJson = getUserFromRequestAsJson(request);
					}
					reply(userAsJson);
					break;

				default:
					break;
				}
				clientMessage = inFromClient.readUTF();
				request = gson.fromJson(clientMessage, PlayerRequest.class);
				action = getAction(clientMessage);
			}

			// if (getAction(clientMessage).equals("Login")) {
			// System.out.println("I am inside of if statement!");
			// IRequest login = gson.fromJson(clientMessage, Request.class);
			// HttpRequest getRequest = new Get(); // Creating get request for 3rd tier
			//
			// System.out.println("Request user: " + "");
			// //
			// {"email":"a@gmail.com","username":"John","password":"password1","score":5,"stage":0}
			// // outToClient.writeUTF(getRequest.verify( login.getLoginPassword(),
			// // login.getLoginEmail()));
			// outToClient.writeUTF(
			// "{\"email\":\"a@gmail.com\",\"username\":\"John\",\"password\":\"password1\",\"score\":5,\"stage\":0}");
			//
			// // POST method for creating a user in the database
			// // HttpRequest postRequest = new Post();
			// // ((Post) postRequest).register("user_Object_In_Json_Going_To_Database"); //
			// // The return type of this method is boolean
			//
			// // PUT method to update a user in database
			// // HttpRequest putRequest = new Put();
			// // ((Put)
			// //
			// putRequest).update("{\"email\":\"2\",\"username\":\"UPDATED\",\"password\":\"password1\",\"score\":5,\"stage\":0}");
			// // // The return type of this method is boolean
			// }
			//
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private String getAction(String clientMessage) {
		String[] firstSplit = clientMessage.split("type\":\"");
		String[] secondSplit = firstSplit[1].split("\"");
		String action = secondSplit[0];
		System.out.println("Requested action is :" + action);
		return action;
	}

	private void reply(String reply) throws IOException {
		outToClient.writeUTF(reply);
		// outToClient.flush();

	}

	private String getUserFromRequestAsJson(Request request) {
		return gson.toJson(request.getUser());

	}

	private User getUserFromRequest(Request request) {
		return request.getUser();

	}

}
