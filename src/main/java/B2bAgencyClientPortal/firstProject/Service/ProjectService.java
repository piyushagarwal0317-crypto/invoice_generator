package B2bAgencyClientPortal.firstProject.Service;

import B2bAgencyClientPortal.firstProject.Entity.Client;
import B2bAgencyClientPortal.firstProject.Entity.Project;
import B2bAgencyClientPortal.firstProject.Repository.ClientRepository;
import B2bAgencyClientPortal.firstProject.Repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final ClientRepository clientRepository;

    public Project createProject(Long clientId, Project project) {
        // 1. Find the client
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found!"));

        // 2. Link the client to the project
        project.setClient(client);

        // 3. Save to database
        return projectRepository.save(project);
    }

    public List<Project> getProjectsByClient(Long clientId) {
        return projectRepository.findByClientId(clientId);
    }
}
