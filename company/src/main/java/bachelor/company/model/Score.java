package bachelor.company.model;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "scoreId", scope = Score.class)
@Table(name = "scores")
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "score_id", nullable = false, columnDefinition = "UUID default gen_random_uuid()")
    private UUID scoreId;

    @Column(name = "fk_company", insertable = false, updatable = false)
    private UUID fkCompany;

    @Column(name = "management_score")
    private Double managementScore;

    @Column(name = "coworker_score")
    private Double coworkerScore;

    @Column(name = "facilities_score")
    private Double facilityScore;

    @Column(name = "workhour_score")
    private Double workhourScore;

    @Column(name = "flexibility_score")
    private Double flexibilityScore;

    @Column(name = "workload_score")
    private Double workloadScore;

    private Double salaryScore;
    private Double pensionScore;
    private Double fringeBenefitsScore;

/*
    @OneToOne
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "fk_company")
    private Company company;
*/
    private int reviewCount;

}


