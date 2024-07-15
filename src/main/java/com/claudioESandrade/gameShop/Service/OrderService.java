package com.claudioESandrade.gameShop.Service;

import com.claudioESandrade.gameShop.Entity.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    Order save(Order order);
    List<Order> getAll();
    Optional<Order> getOrderById(Long id);
    void update(Long id, Order order);
    void delete(Long id);

}
