package bachelor.company.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "announcements")
public class Announcement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "announcement_id", nullable = false, columnDefinition = "UUID default gen_random_uuid()")
    private UUID announcementId;

    private UUID fkDepartment;
    private String title;
    private String description;
    private Date createdDate;
    private Date validFrom;

}
