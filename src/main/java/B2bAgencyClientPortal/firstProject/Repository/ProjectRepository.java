package B2bAgencyClientPortal.firstProject.Repository;

import B2bAgencyClientPortal.firstProject.Entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    // Automatically writes SQL: SELECT * FROM project WHERE client_id = ?
    List<Project> findByClientId(Long clientId);
}
