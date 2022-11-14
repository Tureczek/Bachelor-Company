package bachelor.company.service.scoreService;

import bachelor.company.model.Department;
import bachelor.company.model.Score;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface ScoreService {
    ResponseEntity<Object> getScoreByCompanyId(UUID companyId) throws Exception;
    ResponseEntity<Object> createScore(Score score);
    ResponseEntity<Object> updateScore(Score score, UUID departmentId);
    ResponseEntity<Object> deleteDepartment(UUID departmentId);
}
