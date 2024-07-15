package com.claudioESandrade.gameShop.Repository;

import com.claudioESandrade.gameShop.Entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    @Transactional
    @Modifying
    @Query("SELECT i FROM Invoice i WHERE i.invoiceClientName=?1")
    Optional<List<Invoice>> findInvoiceByName(String name);

}
