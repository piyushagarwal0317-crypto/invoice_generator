package B2bAgencyClientPortal.firstProject.Controller;

import B2bAgencyClientPortal.firstProject.Entity.Project;
import B2bAgencyClientPortal.firstProject.Service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    // POST: /api/clients/1/projects
    @PostMapping("/{clientId}/projects")
    public ResponseEntity<Project> createProject(
            @PathVariable Long clientId,
            @RequestBody Project project) {

        Project savedProject = projectService.createProject(clientId, project);
        return new ResponseEntity<>(savedProject, HttpStatus.CREATED);
    }

    // GET: /api/clients/1/projects
    @GetMapping("/{clientId}/projects")
    public ResponseEntity<List<Project>> getProjectsByClient(@PathVariable Long clientId) {
        return ResponseEntity.ok(projectService.getProjectsByClient(clientId));
    }
}