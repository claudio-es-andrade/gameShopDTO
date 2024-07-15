package com.claudioESandrade.gameShop.Service.Implementations;

import com.claudioESandrade.gameShop.Entity.*;
import com.claudioESandrade.gameShop.Repository.InvoiceRepository;
import com.claudioESandrade.gameShop.Service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private final InvoiceRepository invoiceRepository;

    @Autowired
    private final CategoryServiceImpl categoryServiceImpl;
    @Autowired
    private final ClientServiceImpl clientServiceImpl;

    @Autowired
    private final  GameServiceImpl gameServiceImpl;

    @Autowired
    private final OrderServiceImpl orderServiceImpl;



    public InvoiceServiceImpl(InvoiceRepository invoiceRepository, CategoryServiceImpl categoryServiceImpl,
                              ClientServiceImpl clientServiceImpl, GameServiceImpl gameServiceImpl,
                              OrderServiceImpl orderServiceImpl) {

        this.invoiceRepository   = invoiceRepository;
        this.categoryServiceImpl = categoryServiceImpl;
        this.clientServiceImpl = clientServiceImpl;
        this.gameServiceImpl = gameServiceImpl;
        this.orderServiceImpl = orderServiceImpl;

    }
    // (ID_INVOICE, INV_CLIENT, INV_QTY, INV_GAME, INV_PRICE, INV_CATEGORY)
    public void creatingInvoices() {

        List<Order> orderList             = orderServiceImpl.getAll();
        List<Category> categoryList       = categoryServiceImpl.getAll();
        List<Client> clientList           = clientServiceImpl.getAll();
        List<Game> gameList               = gameServiceImpl.getAll();
        List<Invoice> invoiceList         = new ArrayList<>();

        Category category                 = new Category();
        Client client                     = new Client();
        Game game                         = new Game();




        for (Order ord : orderList){
            client                        = ord.getClient();
            game                          = ord.getGame();
            category                      = game.getCategory();

            Invoice invoice = new Invoice( ord.getIdOrder(), client.getNameClient(), ord.getQty(), game.getNameGame(), (game.getPrice() * ord.getQty()), category.getNameCategory());

            invoiceList.add(invoice);
        }

        invoiceRepository.saveAll(invoiceList);
    }

    @Override
    public List<Invoice> getAll() {

        creatingInvoices();
        return invoiceRepository.findAll();

    }
    // FROM REPOSITORY
    public Optional<List<Invoice>> findInvoiceByName(String name) {

        creatingInvoices();
        return invoiceRepository.findInvoiceByName(name);

    }


}
