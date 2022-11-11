package bachelor.company.repository;

import bachelor.company.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CompanyRepository extends JpaRepository<Company, UUID> {
    Optional<Company> findById(UUID companyId);

    List<Company> findByCompanyNameContaining(String companyName);

}
