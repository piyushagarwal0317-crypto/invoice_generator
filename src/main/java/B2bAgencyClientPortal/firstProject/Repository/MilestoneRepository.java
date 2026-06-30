package B2bAgencyClientPortal.firstProject.Repository;

import B2bAgencyClientPortal.firstProject.Entity.Milestone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MilestoneRepository extends JpaRepository<Milestone, Long> {
    // Automatically writes SQL: SELECT * FROM milestone WHERE project_id = ?
    List<Milestone> findByProjectId(Long projectId);
}