package com.claudioESandrade.gameShop.Service.Implementations;

import com.claudioESandrade.gameShop.Entity.Order;
import com.claudioESandrade.gameShop.Repository.OrderRepository;
import com.claudioESandrade.gameShop.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> getOrderById(Long id) {
        Optional<Order> orderFound = orderRepository.findById(id);
        Order orderFull = null;
        if(orderFound.isPresent()){
            orderFull = orderFound.get();
        }else {
            throw new RuntimeException("Order: " + id + " wasn't found.");
        }
        return Optional.of(orderFull);
    }

    @Override
    public void update(Long id, Order order) {
        Optional<Order> orderOptional = orderRepository.findById(id);
        if (orderOptional.isPresent())
            save(order);
        else
            throw new RuntimeException("Order: " + id + " wasn't found.");
    }

    @Override
    public void delete(Long id) {

        Optional<Order> optionalOrder = orderRepository.findById(id);
        Order orderFull = null;
        if(optionalOrder.isPresent()) {
            orderFull = optionalOrder.get();
            orderRepository.delete( orderFull );
        }else {
            throw new RuntimeException("Order: " + id + " wasn't found.");
        }
    }

    // FROM REPOSITORY
    public List<Order> findOrderByQuantity(int orderQty) {
        return orderRepository.findOrderByQuantity(orderQty) ;
    }

}
