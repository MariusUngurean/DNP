package restful_client;

import com.google.gson.Gson;
import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import socket_server.Player;

public class Put implements HttpRequest
    {
        public Put()
            {

            }

        public String update(String user_Object_In_Json_To_Be_Updated_In_Database)
            {
                System.out.println("Is the user updated?: " + user_Object_In_Json_To_Be_Updated_In_Database);
                Gson gson = new Gson();
                Player testUser = gson.fromJson(user_Object_In_Json_To_Be_Updated_In_Database, Player.class);
                try
                    {
                        URL url = new URL("https://localhost:5001/api/users/update/" + testUser.getEmail());
                        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
                        conn.setDoOutput(true);
                        conn.setRequestMethod("PUT");
                        conn.setRequestProperty("Content-Type", "application/json");

                        OutputStream os = conn.getOutputStream();
                        os.write(user_Object_In_Json_To_Be_Updated_In_Database.getBytes());
                        os.flush();

                        if (conn.getResponseCode() != 204)
                            {
                                throw new RuntimeException("Failed: HTTP error code : " + conn.getResponseCode());
                            }
                        else
                            {
                                conn.disconnect();
                                return user_Object_In_Json_To_Be_Updated_In_Database;
                            }
                    }

                    catch (MalformedURLException e)
                        {
                            e.printStackTrace();
                        }

                    catch (IOException e)
                        {
                            e.printStackTrace();
                        }

                return user_Object_In_Json_To_Be_Updated_In_Database;
            }
    }
