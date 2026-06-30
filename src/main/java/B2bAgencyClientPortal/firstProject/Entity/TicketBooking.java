package B2bAgencyClientPortal.firstProject.Entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity // This creates the "ticket_booking" table in PostgreSQL
@Data
public class TicketBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // The permanent database ID

    // 1. Agency Meta Data
    private String agencyName;
    private String bookingDate;

    // 2. Flight Details (Kept flat for simplicity in the database)
    private String airline;
    private String flightNumber;
    private String origin;
    private String destination;
    private String pnr;
    private String passengerName;

    private String grandTotal;
}