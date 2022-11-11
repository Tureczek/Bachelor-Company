package bachelor.company.service;

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
    public Company createCompany(Company company) {
        return null;
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
    public String deleteCompany(UUID companyId) {
        companyRepository.deleteById(companyId);
        return "Delete successful";
    }
}
