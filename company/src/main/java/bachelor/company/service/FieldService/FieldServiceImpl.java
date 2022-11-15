package bachelor.company.service.FieldService;

import bachelor.company.model.Department;
import bachelor.company.model.Field;
import bachelor.company.repository.FieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FieldServiceImpl implements FieldService{

    @Autowired
    FieldRepository fieldRepository;

    @Override
    public List<Field> getAllFields() {
        return fieldRepository.findAll();
    }

    @Override
    public ResponseEntity<Object> getFieldById(UUID fieldId) throws Exception {
        Optional<Field> field = fieldRepository.findById(fieldId);
        if (field.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(field.get());
    }

    @Override
    public ResponseEntity<Object> createField(Field field) {
        try {
            Field newField = fieldRepository.save(field);
            return ResponseEntity.status(200).body(newField);
        }catch (Exception e) {
            return ResponseEntity.status(500).body("Error in creating a new field.");
        }
    }

    @Override
    public Optional<Object> updateFields(Field field, UUID fieldId) {
        Optional<Field> fieldExists = fieldRepository.findById(fieldId);
        if (fieldExists.isEmpty())
            return Optional.empty();
        field.setFieldId(fieldId);
        fieldRepository.save(field);
        return Optional.of(field);
    }

    @Override
    public ResponseEntity<Object> deleteFields(UUID fieldId) {
        try {
            fieldRepository.deleteById(fieldId);
            return ResponseEntity.status(200).body("Deleted field successfully");
        } catch (Exception e) {
            return ResponseEntity.status(404).body("Item not found");
        }
    }
}
