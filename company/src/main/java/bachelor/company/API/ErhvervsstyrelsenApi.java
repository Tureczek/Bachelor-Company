package bachelor.company.API;

import bachelor.company.DTO.CompanyDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import javax.script.ScriptException;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class ErhvervsstyrelsenApi {

    public CompanyDTO[] fetchCompanyData() throws ScriptException {
        try {

            CompanyDTO[] companyDTOS;

            RestTemplate restTemplate = new RestTemplate();
            String jsonArray = restTemplate.getForObject("http://localhost:8007/companies/search", String.class);

            ObjectMapper objectMapper = new ObjectMapper();
            companyDTOS = objectMapper.readValue(jsonArray, CompanyDTO[].class);
            System.out.println("Company name: " + companyDTOS[0].getNavn());
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static void main(String[] args) throws ScriptException {
         ErhvervsstyrelsenApi erhvervsstyrelsenApi = new ErhvervsstyrelsenApi();
         erhvervsstyrelsenApi.fetchCompanyData();
/*
        try {

            URL url = new URL("http://localhost:8007/companies/_search");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            InputStream content = connection.getInputStream();
            String line;
            StringBuilder sb = new StringBuilder();
            BufferedReader in = new BufferedReader(new InputStreamReader(content));
            while ((line = in.readLine()) != null) {
                sb.append(line);
            }

            System.out.println(sb);

        } catch (Exception e) {
            e.printStackTrace();
        }
*/
    }

}


