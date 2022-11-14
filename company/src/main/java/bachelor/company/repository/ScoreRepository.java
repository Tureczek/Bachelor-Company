package bachelor.company.repository;

import bachelor.company.model.Company;
import bachelor.company.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ScoreRepository extends JpaRepository<Score, UUID> {
    List<Score> getScoresByCompany(Company company);
}
