package code_validator;

import com.google.gson.Gson;

import socket_server.Player;
import socket_server.User;

import java.util.ArrayList;

public class Test
    {
        public static void main(String [] args)
            {
                Gson gson = new Gson();
                User user = new Player("username_2","10", "password_2");
                UpdateUser updateUser = new UpdateUser();
                String userInJson = gson.toJson(user);
                System.out.println(updateUser.update(userInJson, "System.out.println(\"Hello World\")"));
            }
    }
