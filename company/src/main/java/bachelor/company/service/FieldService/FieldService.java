package bachelor.company.service.FieldService;

import bachelor.company.model.Department;
import bachelor.company.model.Field;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;


public interface FieldService {

    List<Field> getAllFields();
    ResponseEntity<Object> getFieldById(UUID fieldId) throws Exception;
    ResponseEntity<Object> createField(Field field);
    ResponseEntity<Object> updateFields(Field field, UUID fieldId);
    ResponseEntity<Object> deleteFields(UUID fieldId);
}
