package bachelor.company.controller;


import bachelor.company.API.ErhvervsstyrelsenApi;
import bachelor.company.DTO.CompanyDTO;
import bachelor.company.model.Company;
import bachelor.company.service.companyService.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.script.ScriptException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    CompanyService companyService;
    @Autowired
    ErhvervsstyrelsenApi erhvervsstyrelsenApi;

    @GetMapping("/insert")
    public String insertAllCompanies(){

        try {
            CompanyDTO[] companyDTO = erhvervsstyrelsenApi.fetchCompanyData();

            List<Company> companyList = new ArrayList<>();

            for (CompanyDTO dto : companyDTO) {
                Company company = new Company();
                company.setCompanyName(dto.getNavn().trim());
                company.setCvr(dto.getCvr());
                companyList.add(company);
            }
            companyService.saveMultipleCompanies(companyList);
            System.out.println("Antal companies: "+companyList.size());

        } catch (ScriptException e) {
            throw new RuntimeException(e);
        }
        return "insert complete";
    }
}
