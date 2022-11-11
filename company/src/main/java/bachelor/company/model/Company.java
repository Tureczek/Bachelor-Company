package bachelor.company.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "company_id", nullable = false, columnDefinition = "UUID default gen_random_uuid()")
    private UUID companyId;


    @Column(name = "company_name")
    private String companyName;

    @Column(name = "cvr")
    private int cvr;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "logo_link")
    private String logoLink;

    @Column(name = "webpage_link")
    private String webpageLink;


    @OneToOne(mappedBy = "company", cascade = CascadeType.DETACH)
    @JsonManagedReference
    @PrimaryKeyJoinColumn
    private Score score;

    @OneToMany(mappedBy = "fkCompany", fetch = FetchType.LAZY)
    private List<Department> department;

    @ManyToMany
            @JoinTable(
                    name = "work_fields",
                    joinColumns = @JoinColumn(name = "company_id"),
                    inverseJoinColumns = @JoinColumn(name = "field_id"))
    Set<Field> fields;
}
