package bachelor.company.API;
import bachelor.company.DTO.CompanyDTO;
import bachelor.company.model.Company;
import bachelor.company.service.companyService.CompanyService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import javax.script.ScriptException;
import java.util.UUID;

@Service
public class ErhvervsstyrelsenApi {



    public CompanyDTO[] fetchCompanyData() throws ScriptException {
        try {
            CompanyDTO[] companyDTOS;

            RestTemplate restTemplate = new RestTemplate();
            String jsonArray = restTemplate.getForObject("http://localhost:8007/companies/search", String.class);

            ObjectMapper objectMapper = new ObjectMapper();
            companyDTOS = objectMapper.readValue(jsonArray, CompanyDTO[].class);
            return companyDTOS;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
/*
    public void insertIntoCompany() {
        ErhvervsstyrelsenApi erhvervsstyrelsenApi = new ErhvervsstyrelsenApi();
        try {
            CompanyDTO[] company = erhvervsstyrelsenApi.fetchCompanyData();

            for (int i = 0; i < company.length; i++) {
                System.out.println(company[i].getNavn().trim());
                System.out.println(company[i].getCvr());
                System.out.println(company[i].getHovedBarnchekode());
                System.out.println(company[i].getHovedBarnchetekst());
                System.out.println(company[i].getPenhederList());
                System.out.println("bibrancher = " + company[i].getBibrancheList());
                System.out.println(company[i].getVejkode());
                System.out.println(company[i].getPostnummer());
                System.out.println("\n");

                Company com = new Company();
                com.setCompanyName(company[i].getNavn());
                com.setCvr(company[i].getCvr());

                companyService.createCompany(com);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

 */
}


