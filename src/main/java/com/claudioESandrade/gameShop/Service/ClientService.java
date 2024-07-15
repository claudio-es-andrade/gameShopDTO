package com.claudioESandrade.gameShop.Service;

import com.claudioESandrade.gameShop.Entity.Client;


import java.util.List;
import java.util.Optional;

public interface ClientService {

    Client save(Client client);
    List<Client> getAll();
    Optional<Client> getClientById(Long id);
    void update(Long id, Client client);
    void delete(Long id);

}
