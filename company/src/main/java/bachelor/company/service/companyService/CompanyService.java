package bachelor.company.service.companyService;

import bachelor.company.model.Company;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface CompanyService {
    List<Company> getAllCompanies();

    ResponseEntity<Object> getCompanyById(UUID companyId) throws Exception;

    ResponseEntity<Object> createCompany(Company company);

    void saveMultipleCompanies(List<Company> companies);

    Optional<Company> updateCompany(Company company, UUID companyId);

    ResponseEntity<Object> deleteCompany(UUID companyId);

}
