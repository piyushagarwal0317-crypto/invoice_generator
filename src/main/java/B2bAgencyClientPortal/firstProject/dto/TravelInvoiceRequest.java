package B2bAgencyClientPortal.firstProject.dto;

import lombok.Data;
import java.util.List;

@Data
public class TravelInvoiceRequest {

    // 1. Agency Meta Data
    private String agencyName;       // e.g., "Kanhaiya Tours & Travels"
    private String bookingDate;      // e.g., "18/Feb/2026"
    private String supportEmail;     // e.g., "info.kanhaiyatravels72@gmail.com"
    private String supportPhone;     // e.g., "+91 6002914620"

    // Complex nested objects
    private FlightDetails flightDetails;
    private List<Passenger> passengers;
    private FareBreakup fareBreakup;

    // 2. Flight Details Block
    @Data
    public static class FlightDetails {
        private String airline;       // e.g., "IndiGo"
        private String flightNumber;  // e.g., "6E-6416"
        private String origin;        // e.g., "GAU-Guwahati"
        private String destination;   // e.g., "DEL-New Delhi"
        private String departureTime; // e.g., "4 Mar'26-06:30"
        private String arrivalTime;   // e.g., "4 Mar'26-09:15"
        private String pnr;           // e.g., "YBD15Q"
    }

    // 3. Passenger List Block
    @Data
    public static class Passenger {
        private String name;          // e.g., "Mr SHUBHAM SHARMA (A)"
        private String ticketNumber;  // e.g., "(YBD15Q)"
        private String baggage;       // e.g., "15 KG | 7 KG"
    }

    // 4. Fare Breakup Block
    @Data
    public static class FareBreakup {
        private String baseFare;         // e.g., "14,520 INR"
        private String taxAndSurcharges; // e.g., "3,480"
        private String grandTotal;       // e.g., "18,000 INR"
    }
}
