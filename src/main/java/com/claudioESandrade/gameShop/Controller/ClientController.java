package com.claudioESandrade.gameShop.Controller;

import com.claudioESandrade.gameShop.Entity.Client;
import com.claudioESandrade.gameShop.Entity.Invoice;
import com.claudioESandrade.gameShop.Service.Implementations.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Client")
public class ClientController {

    @Autowired
    private ClientServiceImpl clientService;

    public ClientController(ClientServiceImpl clientService) {
        this.clientService = clientService;
    }

    @PostMapping(value = "/save")
    public ResponseEntity<String> createClient(@RequestBody Client client) {
        try {
            clientService.save( client );
            return new ResponseEntity<>("Client was created successfully.", HttpStatus.CREATED);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/get/All")
    public ResponseEntity<List<Client>> getAll() {
        return ResponseEntity.ok().body(clientService.getAll() );
    }

//    @GetMapping(value = "/get/{id}")
//    public ResponseEntity<Optional<Client>> getClientById(@PathVariable Long id) {
//        return ResponseEntity.ok(clientService.getClientById( id ) );
//    }

    @GetMapping(value = "/get/{name}")
    public ResponseEntity <Optional<List<Client>>> getClientByName(@PathVariable String name) {
        return ResponseEntity.ok(Optional.ofNullable(clientService.findClientByName(name)));
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client client) {
        clientService.update( id, client);
        return ResponseEntity.ok( ).build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        clientService.delete( id );
        return ResponseEntity.ok().build();
    }


}
