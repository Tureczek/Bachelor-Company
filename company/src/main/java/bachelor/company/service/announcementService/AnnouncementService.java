package bachelor.company.service.announcementService;

import bachelor.company.model.Announcement;
import bachelor.company.model.Field;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AnnouncementService{
    List<Announcement> getAllAnnouncements();
    ResponseEntity<Object> getAnnouncementById(UUID announcementId) throws Exception;
    ResponseEntity<Object> createAnnouncement(Announcement announcement);
    Optional<Object> updateAnnouncement(Announcement announcement, UUID announcementId);
    ResponseEntity<Object> deleteAnnouncement(UUID announcementId);
}
