package bachelor.company.service;

import bachelor.company.model.Company;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface CompanyService {
    List<Company> getAllCompanies();

    ResponseEntity<Object> getCompanyById(UUID companyId) throws Exception;

    Company createCompany(Company company);

    Optional<Company> updateCompany(Company company, UUID companyId);

    String deleteCompany(UUID companyId);

}
