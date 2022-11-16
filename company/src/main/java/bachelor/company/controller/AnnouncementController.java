package bachelor.company.controller;

import bachelor.company.model.Announcement;
import bachelor.company.service.announcementService.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/announcements")
public class AnnouncementController {

    @Autowired
    AnnouncementService announcementService;

    @GetMapping("/")
    public List<Announcement> getAllAnnouncements(){
        return announcementService.getAllAnnouncements();
    }

    @GetMapping("/{announcementId}")
    public ResponseEntity<Object> getAnnouncementById(@PathVariable UUID announcementId) throws Exception{
        return announcementService.getAnnouncementById(announcementId);
    }

    @PutMapping("/{announcementId}")
    public Optional<Object> updateAnnouncement(@RequestBody Announcement announcement, @PathVariable UUID announcementId){
        return announcementService.updateAnnouncement(announcement, announcementId);
    }

    @PostMapping("/")
    public ResponseEntity<Object> createAnnouncement(@RequestBody Announcement announcement){
        return  announcementService.createAnnouncement(announcement);
    }

    @DeleteMapping("/{announcementId}")
    public ResponseEntity<Object> deleteAnnouncement(@PathVariable UUID announcementId){
        return announcementService.deleteAnnouncement(announcementId);
    }
}
