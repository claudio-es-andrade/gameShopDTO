package com.claudioESandrade.gameShop.Service;

import com.claudioESandrade.gameShop.Entity.Invoice;

import java.util.List;
import java.util.Optional;

public interface InvoiceService {

    List<Invoice> getAll();

    // FROM THE REPOSITORY
    Optional<List<Invoice>> findInvoiceByName(String name);

}
