package bachelor.company.API;

import net.minidev.json.JSONObject;
import org.apache.http.client.methods.HttpPost;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;

public class ApiHandler {

    private static final String getBasicAuthenticationHeader(String username, String password) {
        String valueToEncode = username + password;
        return "Basic" + Base64.getEncoder().encodeToString(valueToEncode.getBytes());
    }

    public static void main(String[] args) {


        try {

            URL url = new URL ("http://distribution.virk.dk/cvr-permanent/virksomhed/_search");
            String encoding = Base64.getEncoder().encodeToString(("Martin_Seest_Holmqvist_CVR_I_SKYEN:4297596c-dcf6-4ddc-84b8-082fc4b4b5b3").getBytes("UTF-8"));

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty  ("Authorization", "Basic " + encoding);
            InputStream content = (InputStream)connection.getInputStream();
            BufferedReader in   =
                    new BufferedReader (new InputStreamReader(content));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
