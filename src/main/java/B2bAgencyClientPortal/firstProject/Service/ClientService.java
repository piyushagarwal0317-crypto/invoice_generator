package B2bAgencyClientPortal.firstProject.Service;

import B2bAgencyClientPortal.firstProject.Entity.Client;
import java.util.List;

public interface ClientService {

    Client createClient(Client client);

    List<Client> getAllClients();

    Client getClientById(Long id);

    Client updateClient(Long id, Client clientDetails);

    void deleteClient(Long id);

}
