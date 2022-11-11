package bachelor.company.controller;

import bachelor.company.model.Company;
import bachelor.company.repository.CompanyRepository;
import bachelor.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


//@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @GetMapping("/")
    public List<Company> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    @GetMapping("/{companyId}")
    public ResponseEntity<Object> getCompanyById(@PathVariable UUID companyId) throws Exception {
        return  companyService.getCompanyById(companyId);
    }

    @PatchMapping("/{companyId}")
    public Optional<Company> updateCompany (@RequestBody Company company, @PathVariable UUID companyId) {
        return companyService.updateCompany(company, companyId);
    }

}
