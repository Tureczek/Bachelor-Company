package bachelor.company.controller;

import bachelor.company.model.Department;
import bachelor.company.service.departmentService.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @GetMapping("/")
    public List<Department> getAllDepartments(){
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{departmentId}")
    public ResponseEntity<Object> getDepartmentById(@PathVariable UUID departmentId) throws Exception{
        return departmentService.getDepartmentById(departmentId);
    }

    @PutMapping("/{departmentId}")
    public ResponseEntity<Object> updateDepartment(@RequestBody Department department, @PathVariable UUID departmentId){
        return departmentService.updateDepartment(department, departmentId);
    }

    @PostMapping("/")
    public ResponseEntity<Object> createDepartment(@RequestBody Department department) {
        return departmentService.createDepartment(department);
    }

    @DeleteMapping("/{departmentId}")
    public ResponseEntity<Object> deleteDepartment(@PathVariable UUID departmentId){
        return departmentService.deleteDepartment(departmentId);
    }
}
