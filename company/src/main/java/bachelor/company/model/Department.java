package bachelor.company.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "department_id", nullable = false, columnDefinition = "UUID default gen_random_uuid()")
    private UUID departmentId;
    private int pNumber;
    private UUID fkCompany;
    private UUID fkAddress;
    private String departmentName;
    private String email;
    private UUID userId;
    private String phoneNumber;



}
