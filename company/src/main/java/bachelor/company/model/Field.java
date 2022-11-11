package bachelor.company.model;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "fieldId")
@Entity
@Table(name = "fields")
public class Field {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "field_id", nullable = false, columnDefinition = "UUID default gen_random_uuid()")
    private UUID fieldId;

    private String code;
    private String name;


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    //@EqualsAndHashCode.Exclude
    @JoinTable(
            name = "business_fields",
            joinColumns = {@JoinColumn(name = "field_id")},
            inverseJoinColumns = {@JoinColumn(name = "company_id")}
    )
    @JsonBackReference
    private Set<Company> companies;
}
