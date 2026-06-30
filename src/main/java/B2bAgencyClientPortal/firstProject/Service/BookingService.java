package B2bAgencyClientPortal.firstProject.Service;


import B2bAgencyClientPortal.firstProject.Entity.TicketBooking;
import B2bAgencyClientPortal.firstProject.Repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final PdfService pdfService; // We inject the PDF service here!

    @Transactional // Ensures the database save happens safely
    public byte[] processBooking(TicketBooking booking) throws Exception {

        // 1. Save to Database
        bookingRepository.save(booking);

        // 2. Generate PDF (assuming you adapt PdfService to accept TicketBooking)
        return pdfService.generateTravelTicketPdf(booking);
    }
}
