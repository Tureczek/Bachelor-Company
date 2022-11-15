package bachelor.company.service.fieldService;

import bachelor.company.model.Field;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface FieldService {

    List<Field> getAllFields();
    ResponseEntity<Object> getFieldById(UUID fieldId) throws Exception;
    ResponseEntity<Object> createField(Field field);
    Optional<Object> updateFields(Field field, UUID fieldId);
    ResponseEntity<Object> deleteFields(UUID fieldId);
}
