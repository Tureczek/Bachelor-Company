package bachelor.company.service.departmentService;

import bachelor.company.model.Department;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface DepartmentService {

    List<Department> getAllDepartments();
    ResponseEntity<Object> getDepartmentById(UUID departmentId) throws Exception;
    ResponseEntity<Object> createDepartment(Department department);
    ResponseEntity<Object> updateDepartment(Department department, UUID departmentId);
    ResponseEntity<Object> deleteDepartment(UUID departmentId);

}
