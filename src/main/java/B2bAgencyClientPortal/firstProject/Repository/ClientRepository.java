package B2bAgencyClientPortal.firstProject.Repository;

import B2bAgencyClientPortal.firstProject.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    // Spring Boot is smart enough to write the SQL for this just based on the method name!
    Optional<Client> findByEmail(String email);
}
