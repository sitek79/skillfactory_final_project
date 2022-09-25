package hm.sitek.controller;

import hm.sitek.exception.ResourceNotFoundException;
import hm.sitek.model.Client;
import hm.sitek.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/terminal/v1")
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/clients")
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @GetMapping("/clients/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable(value = "id") Long clientId)
            throws ResourceNotFoundException {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new ResourceNotFoundException("Client с данным Id не найден :: " + clientId));
        return ResponseEntity.ok().body(client);
    }

    @PostMapping("/clients")
    public Client createEmployee(@Valid @RequestBody Client client) {
        return clientRepository.save(client);
    }

    @PutMapping("/clients/{id}")
    public ResponseEntity<Client> updateEmployee(@PathVariable(value = "id") Long clientId,
                                                   @Valid @RequestBody Client clientDetails) throws ResourceNotFoundException {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new ResourceNotFoundException("Client с данным Id не найден :: " + clientId));
        client.setBalance(clientDetails.getBalance());
        //client.setLastName(employeeDetails.getLastName());
        //client.setFirstName(employeeDetails.getFirstName());
        final Client updatedClient = clientRepository.save(client);
        return ResponseEntity.ok(updatedClient);
    }

    @DeleteMapping("/clients/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long clientId)
            throws ResourceNotFoundException {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + clientId));

        clientRepository.delete(client);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
