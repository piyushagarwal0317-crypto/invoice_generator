package B2bAgencyClientPortal.firstProject.Service.impl;

import B2bAgencyClientPortal.firstProject.Entity.Client;
import B2bAgencyClientPortal.firstProject.Repository.ClientRepository;
import B2bAgencyClientPortal.firstProject.Service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    // Spring automatically injects our repository here because of @RequiredArgsConstructor
    private final ClientRepository clientRepository;

    @Override
    public Client createClient(Client client) {
        // Business Rule: Don't allow duplicate emails
        Optional<Client> existingClient = clientRepository.findByEmail(client.getEmail());
        if (existingClient.isPresent()) {
            throw new RuntimeException("A client with this email already exists!");
        }
        return clientRepository.save(client);
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client getClientById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found with id: " + id));
    }

    @Override
    public Client updateClient(Long id, Client clientDetails) {
        Client existingClient = getClientById(id); // Reuses the method above!

        // Update the fields
        existingClient.setName(clientDetails.getName());
        existingClient.setCompanyName(clientDetails.getCompanyName());
        existingClient.setContactNumber(clientDetails.getContactNumber());
        existingClient.setEmail(clientDetails.getEmail());

        return clientRepository.save(existingClient);
    }

    @Override
    public void deleteClient(Long id) {
        Client existingClient = getClientById(id);
        clientRepository.delete(existingClient);
    }
}
