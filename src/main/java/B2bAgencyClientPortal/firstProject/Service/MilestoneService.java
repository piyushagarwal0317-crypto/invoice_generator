package B2bAgencyClientPortal.firstProject.Service;

import B2bAgencyClientPortal.firstProject.Entity.Milestone;
import B2bAgencyClientPortal.firstProject.Entity.Project;
import B2bAgencyClientPortal.firstProject.Repository.MilestoneRepository;
import B2bAgencyClientPortal.firstProject.Repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MilestoneService {

    private final MilestoneRepository milestoneRepository;
    private final ProjectRepository projectRepository;

    public Milestone createMilestone(Long projectId, Milestone milestone) {
        // 1. Find the project
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project not found!"));

        // 2. Link the project to the milestone
        milestone.setProject(project);

        // 3. Save to database
        return milestoneRepository.save(milestone);
    }

    public List<Milestone> getMilestonesByProject(Long projectId) {
        return milestoneRepository.findByProjectId(projectId);
    }
}