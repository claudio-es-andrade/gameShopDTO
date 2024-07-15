package com.claudioESandrade.gameShop.Repository;

import com.claudioESandrade.gameShop.Entity.Client;
import com.claudioESandrade.gameShop.Entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface GameRepository extends JpaRepository<Game, Long> {
    @Transactional
    @Modifying
    @Query(value = "SELECT * FROM games g WHERE g.name_game=?1", nativeQuery = true)
    List<Game> findGameByName(String name);

    @Transactional
    @Modifying
    @Query(value = "SELECT * FROM games g WHERE g.price=?1", nativeQuery = true)
    List<Game> findGameByPrice(float price);

}
