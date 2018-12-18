package socket_server;
import restful_client.Get;
import restful_client.HttpRequest;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain
    {

        public static void main(String args[]) throws IOException
            {
                HttpRequest getRequest = new Get();
              //  System.out.println("Testing GET method to verify user: " + ((Get) getRequest).verify("a@gmail.com", "password1"));
                final int PORT = 6789;
                System.out.println("starting server");

                @SuppressWarnings("resource")
                ServerSocket serverSocket = new ServerSocket(PORT);
                while (true)
                    {
                        System.out.println("waiting for client");
                        Socket clientSocket = serverSocket.accept();
                        Thread clientThread = new Thread(new ClientHandler(clientSocket));
                        System.out.println(clientThread);
                        clientThread.start();
                        System.out.println("client connected");
                    }

            }

    }
