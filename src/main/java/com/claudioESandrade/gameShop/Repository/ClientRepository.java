package com.claudioESandrade.gameShop.Repository;

import com.claudioESandrade.gameShop.Entity.Client;
import com.claudioESandrade.gameShop.Entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {

    @Transactional
    @Modifying
    @Query(value = "SELECT * FROM clients c WHERE c.name_client=?1", nativeQuery = true)
    List<Client> findClientByName(String name);

}
