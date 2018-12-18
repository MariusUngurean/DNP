package code_validator;

import com.google.gson.Gson;
import restful_client.HttpRequest;
import restful_client.Put;
import socket_server.Player;;

public class UpdateUser
    {
        private Player user;
        private Validator validator;
        private HttpRequest put;
        Gson gson;

        public UpdateUser()
            {
                validator = new Validator();
                put = new Put();
                gson = new Gson();
            }

        public String update(String userInJson, String answer)
            {
                user = gson.fromJson(userInJson, Player.class);
                user.setStage( user.getStage() + 1);
                user.setScore( user.getScore() + validator.validate(user.getStage(), answer));
                System.out.println("Earned points: " + validator.validate(user.getStage(), answer));
                return ((Put) put).update(gson.toJson(user));
            }
    }
