package bachelor.company.service.departmentService;

import bachelor.company.model.Department;
import bachelor.company.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public ResponseEntity<Object> getDepartmentById(UUID departmentId) throws Exception {
        Optional<Department> department = departmentRepository.findById(departmentId);
        if (department.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(department.get());
    }

    @Override
    public ResponseEntity<Object> createDepartment(Department department) {
        try {
            Department newDepartment = departmentRepository.save(department);
            return ResponseEntity.status(200).body(newDepartment);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error in creating department");
        }
    }

    @Override
    public ResponseEntity<Object> updateDepartment(Department department, UUID departmentId) {
        Optional<Department> departmentExists = departmentRepository.findById(departmentId);
        if (departmentExists.isEmpty())
            return ResponseEntity.status(404).body("Not Found");
        department.setDepartmentId(departmentId);
        departmentRepository.save(department);
        return ResponseEntity.status(200).body(department);
    }

    @Override
    public ResponseEntity<Object> deleteDepartment(UUID departmentId) {
        try {
            departmentRepository.deleteById(departmentId);
            return ResponseEntity.status(200).body("Company succesfully deleted");
        } catch (Exception e) {
            return ResponseEntity.status(404).body("Company not found");
        }
    }
}
