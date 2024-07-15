package com.claudioESandrade.gameShop.Service;

import com.claudioESandrade.gameShop.Entity.Game;


import java.util.List;
import java.util.Optional;

public interface GameService {

    Game save(Game game);
    List<Game> getAll();
    Optional<Game> getGameById(Long id);
    void update(Long id, Game Game);
    void delete(Long id);

}
