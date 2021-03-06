package pkg.java.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtil {

    public String Get(String link) {
        String result = "{}";

        try {
            URL url = new URL(link);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.getResponseCode();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
            StringBuffer response = new StringBuffer();
            String inputLine;

            while ((inputLine = bufferedReader.readLine()) != null)  {
                response.append(inputLine);
            }

            result = response.toString();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public String Post(String link, String parameters) {
        String result = "{}";

        try {
            URL url = new URL (link);

            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json; utf-8");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);

            try(OutputStream os = connection.getOutputStream()) {

                // String parameters = "{\"username\":\"spg1101\", \"password\":\"1111\"}";

                if(parameters != null) {
                    byte[] input = parameters.getBytes("utf-8");
                    os.write(input, 0, input.length);
                }

                try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"))) {
                    StringBuilder response = new StringBuilder();
                    String responseLine = null;

                    while ((responseLine = bufferedReader.readLine()) != null) {
                        response.append(responseLine.trim());
                    }

                    result = response.toString();
                }
                catch (Exception e) {}
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
