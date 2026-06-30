package B2bAgencyClientPortal.firstProject.Controller;

import B2bAgencyClientPortal.firstProject.Entity.Milestone;
import B2bAgencyClientPortal.firstProject.Service.MilestoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
public class MilestoneController {

    private final MilestoneService milestoneService;

    // POST: /api/projects/1/milestones
    @PostMapping("/{projectId}/milestones")
    public ResponseEntity<Milestone> createMilestone(
            @PathVariable Long projectId,
            @RequestBody Milestone milestone) {

        Milestone savedMilestone = milestoneService.createMilestone(projectId, milestone);
        return new ResponseEntity<>(savedMilestone, HttpStatus.CREATED);
    }

    // GET: /api/projects/1/milestones
    @GetMapping("/{projectId}/milestones")
    public ResponseEntity<List<Milestone>> getMilestonesByProject(@PathVariable Long projectId) {
        return ResponseEntity.ok(milestoneService.getMilestonesByProject(projectId));
    }
}
