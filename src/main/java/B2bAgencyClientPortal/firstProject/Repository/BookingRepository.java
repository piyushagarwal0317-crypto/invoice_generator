package B2bAgencyClientPortal.firstProject.Repository;

import B2bAgencyClientPortal.firstProject.Entity.TicketBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<TicketBooking, Long> {
    // Spring Boot automatically implements all save/delete/find methods here!
}