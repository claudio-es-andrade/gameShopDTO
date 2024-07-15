package com.claudioESandrade.gameShop.Repository;

import com.claudioESandrade.gameShop.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import com.claudioESandrade.gameShop.Entity.Order;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Transactional
    @Modifying
    @Query(value = "SELECT * FROM orders ord WHERE ord.qty=?1", nativeQuery = true)
    List<Order> findOrderByQuantity(int orderQty);

}
