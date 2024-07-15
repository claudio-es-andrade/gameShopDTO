package com.claudioESandrade.gameShop.Controller;

import com.claudioESandrade.gameShop.Entity.Invoice;
import com.claudioESandrade.gameShop.Service.Implementations.InvoiceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Invoice")
public class InvoiceController {

    @Autowired
    private InvoiceServiceImpl invoiceService;

    public InvoiceController(InvoiceServiceImpl invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping(value = "/get/All")
    public ResponseEntity<List<Invoice>> getAll() {
        return ResponseEntity.ok().body(invoiceService.getAll() );
    }

    @GetMapping(value = "/get/{clientName}")
    public ResponseEntity<Optional<List<Invoice>>> getInvoiceByName(@PathVariable String clientName) {
        return ResponseEntity.ok( invoiceService.findInvoiceByName(clientName) );
    }

//    @GetMapping(value = "/get/{id}")
//    public ResponseEntity<Optional<List<Invoice>>> getInvoiceById(@PathVariable Long id ) {
//        return ResponseEntity.ok(Optional.ofNullable(invoiceService.findInvoiceById(id)));
//    }

}


