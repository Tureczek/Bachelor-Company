package bachelor.company.service.companyService;

import bachelor.company.model.Company;
import bachelor.company.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public ResponseEntity<Object> getCompanyById(UUID companyId) throws Exception {
        Optional<Company> company = companyRepository.findById(companyId);
        if (company.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(company.get());
    }

    @Override
    public ResponseEntity<Object> createCompany(Company company) {
        try {
            Company newCompany = companyRepository.save(company);
            return ResponseEntity.status(200).body(newCompany);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error in creating company.");
        }
    }

    @Override
    public Optional<Company> updateCompany(Company company, UUID companyId) {
        Optional<Company> companyExists = companyRepository.findById(companyId);
        if (companyExists.isEmpty())
            return Optional.empty();
        company.setCompanyId(companyId);
        companyRepository.save(company);
        return Optional.of(company);
    }

    @Override
    public ResponseEntity<Object> deleteCompany(UUID companyId) {
        try {
            companyRepository.deleteById(companyId);
            return ResponseEntity.status(200).body("Company succesfully deleted");
        } catch (Exception e) {
            return ResponseEntity.status(404).body("Company not found");
        }
    }
}
