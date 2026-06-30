package B2bAgencyClientPortal.firstProject.Service;

import B2bAgencyClientPortal.firstProject.Entity.Client;
import B2bAgencyClientPortal.firstProject.Entity.Milestone;
import B2bAgencyClientPortal.firstProject.Entity.Project;
import B2bAgencyClientPortal.firstProject.Entity.TicketBooking;
import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PdfService {

    // Spring Boot automatically configures and injects this for us
    private final TemplateEngine templateEngine;

    /**
     * Generates a PDF proposal/invoice for Custom Development Projects.
     * Uses the "invoice.html" Thymeleaf template.
     */
    public byte[] generateInvoicePdf(Client client, Project project, List<Milestone> milestones) throws Exception {

        // 1. Set up the Thymeleaf Data Context
        Context context = new Context();
        context.setVariable("client", client);
        context.setVariable("project", project);
        context.setVariable("milestones", milestones);

        // 2. Process the HTML template
        String htmlContent = templateEngine.process("invoice", context);

        // 3. Convert the populated HTML into a PDF file
        try (ByteArrayOutputStream os = new ByteArrayOutputStream()) {
            PdfRendererBuilder builder = new PdfRendererBuilder();
            builder.useFastMode();
            builder.withHtmlContent(htmlContent, "/");
            builder.toStream(os);
            builder.run();

            return os.toByteArray();
        }
    }

    /**
     * Generates an Airline E-Ticket PDF for the Travel Agency client.
     * Uses the "ticket.html" Thymeleaf template.
     */
    public byte[] generateTravelTicketPdf(TicketBooking invoice) throws Exception {

        // 1. Set up the Thymeleaf Context
        Context context = new Context();
        // This links the word "invoice" in HTML to our Java DTO object
        context.setVariable("invoice", invoice);

        // 2. Process the HTML template named "ticket.html"
        String htmlContent = templateEngine.process("ticket", context);

        // 3. Convert HTML to PDF
        try (ByteArrayOutputStream os = new ByteArrayOutputStream()) {
            PdfRendererBuilder builder = new PdfRendererBuilder();
            builder.useFastMode();
            builder.withHtmlContent(htmlContent, "/");
            builder.toStream(os);
            builder.run();

            return os.toByteArray();
        }
    }
}