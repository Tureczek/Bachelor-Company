package bachelor.company.service.announcementService;

import bachelor.company.model.Announcement;
import bachelor.company.repository.AnnouncementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AnnouncementServiceImpl implements AnnouncementService{

    @Autowired
    AnnouncementRepository announcementRepository;

    @Override
    public List<Announcement> getAllAnnouncements() {
        return announcementRepository.findAll();
    }

    @Override
    public ResponseEntity<Object> getAnnouncementById(UUID announcementId) throws Exception {
        Optional<Announcement> announcement = announcementRepository.findById(announcementId);
        if (announcement.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(announcement.get());
    }

    @Override
    public ResponseEntity<Object> createAnnouncement(Announcement announcement) {
        try {
            Announcement newAnnouncement = announcementRepository.save(announcement);
            return ResponseEntity.status(200).body(newAnnouncement);
        }catch (Exception e) {
            return ResponseEntity.status(500).body("Error in creating a new announcement.");
        }
    }
    }

    @Override
    public Optional<Object> updateAnnouncement(Announcement announcement, UUID announcementId) {
        return Optional.empty();
    }

    @Override
    public ResponseEntity<Object> deleteAnnouncement(UUID announcementId) {
        return null;
    }
}
