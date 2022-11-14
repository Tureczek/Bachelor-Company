package bachelor.company.controller;

import bachelor.company.model.Field;
import bachelor.company.service.FieldService.FieldService;
import bachelor.company.service.departmentService.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/field")
public class FieldController {

    @Autowired
    FieldService fieldService;

    @GetMapping("/")
    public List<Field> getAllFields(){
        return fieldService.getAllFields();
    }

    @GetMapping("/{fieldId}")
    public ResponseEntity<Object> getFieldsById(@PathVariable UUID fieldId) throws Exception {
        return fieldService.getFieldById(fieldId);
    }

    @PutMapping("/fieldId")
    public ResponseEntity<Object> updateField(@RequestBody Field field, @PathVariable UUID fieldId){
        return fieldService.updateFields(field, fieldId);
    }

    @PostMapping("/")
    public ResponseEntity<Object> createNewField(@RequestBody Field field){
        return fieldService.createField(field);
    }

    @DeleteMapping("/{fieldId}")
    public ResponseEntity<Object> deleteField(@PathVariable UUID fieldId){
        return fieldService.deleteFields(fieldId);
    }

}
