package bachelor.company.controller;

import bachelor.company.model.Announcement;
import bachelor.company.service.announcementService.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/announcements")
public class AnnouncementController {

    @Autowired
    AnnouncementService announcementService;

    @GetMapping("/")
    public List<Announcement> getAllAnnouncements(){
        return announcementService.getAllAnnouncements();
    }

}
