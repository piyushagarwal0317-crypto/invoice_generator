package B2bAgencyClientPortal.firstProject.Controller;

import B2bAgencyClientPortal.firstProject.Entity.TicketBooking;
import B2bAgencyClientPortal.firstProject.Service.BookingService;
import B2bAgencyClientPortal.firstProject.Service.PdfService;
import B2bAgencyClientPortal.firstProject.dto.TravelInvoiceRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/travel")
@RequiredArgsConstructor
public class TravelInvoiceController {

    private final BookingService bookingService;

    @PostMapping("/generate-ticket")
    public ResponseEntity<byte[]> generateTicket(@RequestBody TicketBooking request) {
        try {
            // 1. Generate the raw PDF bytes
            byte[] pdfBytes = bookingService.processBooking(request);

            // 2. Build the strict PDF headers
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("attachment", "Client-Ticket.pdf");
            headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");

            // 3. Return the raw binary file
            return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace(); // Prints the exact error in your terminal if it fails
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}