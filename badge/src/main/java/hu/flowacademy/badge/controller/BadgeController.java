package hu.flowacademy.badge.controller;

import hu.flowacademy.badge.domain.Badge;
import hu.flowacademy.badge.service.BadgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/badge")
public class BadgeController {

    @Autowired
    private BadgeService badgeService;

    @PostMapping("/add")
    public ResponseEntity<Badge> addBadge(@RequestBody Badge badge) {
        return ResponseEntity.ok(badgeService.save(badge));
    }

    @PutMapping("/update")
    public ResponseEntity<Badge> updateBadge(@RequestBody Badge badge) {
        return ResponseEntity.ok(badgeService.save(badge));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBadgeById (@PathVariable Long id) {
        badgeService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/list-badges")
    public ResponseEntity<List<Badge>> listBadge() {
        return ResponseEntity.ok(badgeService.listUsers());
    }

    @GetMapping("/find-badges/{id}")
    public ResponseEntity<Badge> findOneBadge(@PathVariable Long id) {
        return ResponseEntity.ok(badgeService.getOneBadge(id));
    }
}
