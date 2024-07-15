package com.claudioESandrade.gameShop.Service.Implementations;

import com.claudioESandrade.gameShop.Entity.Client;
import com.claudioESandrade.gameShop.Entity.Invoice;
import com.claudioESandrade.gameShop.Repository.ClientRepository;
import com.claudioESandrade.gameShop.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    @Override
    public Optional<Client> getClientById(Long id) {
        Optional<Client> clientFound = clientRepository.findById(id);
        Client clientFull = null;
        if(clientFound.isPresent()){
            clientFull = clientFound.get();
        }else {
            throw new RuntimeException("Client: " + id + " wasn't found.");
        }
        return Optional.of(clientFull);
    }

    @Override
    public void update(Long id, Client client) {
        Optional<Client> clientOptional = clientRepository.findById(id);
        if (clientOptional.isPresent())
            save(client);
        else
            throw new RuntimeException("Client: " + id + " wasn't found.");
    }

    @Override
    public void delete(Long id) {

        Optional<Client> optionalClient = clientRepository.findById(id);
        Client clientFull = null;
        if(optionalClient.isPresent()) {
            clientFull = optionalClient.get();
            clientRepository.delete( clientFull );
        }else {
            throw new RuntimeException("Client: " + id + " wasn't found.");
        }
    }

    // FROM REPOSITORY
    public List<Client> findClientByName(String name) {
        return clientRepository.findClientByName(name);
    }
}
