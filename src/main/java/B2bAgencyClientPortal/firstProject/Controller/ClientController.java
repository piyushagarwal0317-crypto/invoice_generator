package B2bAgencyClientPortal.firstProject.Controller;

import B2bAgencyClientPortal.firstProject.Entity.Client;
import B2bAgencyClientPortal.firstProject.Service.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {

    // Injects the service layer
    private final ClientService clientService;

    // POST: Handles requests to add a new client
    @PostMapping
    public ResponseEntity<Client> createClient(@Valid @RequestBody Client client) {
        Client savedClient = clientService.createClient(client);
        // Returns the saved data along with a 201 Created HTTP status
        return new ResponseEntity<>(savedClient, HttpStatus.CREATED);
    }

    // GET: Handles requests to fetch your entire client list
    @GetMapping
    public ResponseEntity<List<Client>> getAllClients() {
        List<Client> allClients = clientService.getAllClients();
        // Returns the list with a standard 200 OK HTTP status
        return ResponseEntity.ok(allClients);
    }
}