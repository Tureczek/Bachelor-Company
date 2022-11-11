package bachelor.company.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "fields")
public class Field {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "field_id", nullable = false, columnDefinition = "UUID default gen_random_uuid()")
    private UUID fieldId;

    private String code;
    private String name;

    @ManyToMany(mappedBy = "fields")
    Set<Company> companies;
}
