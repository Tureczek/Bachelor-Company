package bachelor.company.model;

import com.fasterxml.jackson.annotation.*;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "fieldId", scope = Field.class)
@Table(name = "fields")
public class Field {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "field_id", nullable = false, columnDefinition = "UUID default gen_random_uuid()")
    private UUID fieldId;

    private String code;
    private String name;


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "business_fields",
            joinColumns = {@JoinColumn(name = "field_id")},
            inverseJoinColumns = {@JoinColumn(name = "company_id")}
    )
    private Set<Company> companies;
}
