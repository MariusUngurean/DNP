package restful_client;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class Post implements HttpRequest
    {
        public Post()
            {

            }

        public boolean register(String user_Object_In_Json_Going_To_Database)
            {
                try
                    {
                        URL url = new URL("https://localhost:5001/api/users/create/");
                        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
                        conn.setDoOutput(true);
                        conn.setRequestMethod("POST");
                        conn.setRequestProperty("Content-Type", "application/json");

                        OutputStream os = conn.getOutputStream();
                        os.write(user_Object_In_Json_Going_To_Database.getBytes());
                        os.flush();

                        if (conn.getResponseCode() != 201)
                            {
                                throw new RuntimeException("Failed: HTTP error code : " + conn.getResponseCode());
                            }
                        else
                            {
                                conn.disconnect();
                                return true;
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

                return false;

            }
    }
