package restful_client;
import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Get implements HttpRequest
    {
        public Get()
            {

            }

        public String verify(String email, String password)
            {
                try
                    {
                        URL url = new URL("https://localhost:5001/api/users/verify/email/" + email + "/password/" + password);
                        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
                        conn.setRequestMethod("GET");
                        conn.setRequestProperty("key", "value");

                        if (conn.getResponseCode() != 200)
                            {
                                throw new RuntimeException("Failed: HTTP error code : " + conn.getResponseCode());
                            }
                        else
                            {
                                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                                String user_object_in_json;
                                while ((user_object_in_json = br.readLine()) != null)
                                    {
                                        System.out.println("response from 3rd Tier......\n" + "Verified user: " + user_object_in_json);
                                        return user_object_in_json;
                                    }

                                conn.disconnect();
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
                return null;
            }
    }
