package com.claudioESandrade.gameShop.Service.Implementations;

import com.claudioESandrade.gameShop.Entity.Game;
import com.claudioESandrade.gameShop.Repository.GameRepository;
import com.claudioESandrade.gameShop.Service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameRepository gameRepository;

    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public Game save(Game game) {
        return gameRepository.save(game);
    }

    @Override
    public List<Game> getAll() {
        return gameRepository.findAll();
    }

    @Override
    public Optional<Game> getGameById(Long id) {
        Optional<Game> gameFound = gameRepository.findById(id);
        Game gameFull = null;
        if(gameFound.isPresent()){
            gameFull = gameFound.get();
        }else {
            throw new RuntimeException("Game: " + id + " wasn't found.");
        }
        return Optional.of(gameFull);
    }

    @Override
    public void update(Long id, Game game) {
        Optional<Game> gameOptional = gameRepository.findById(id);
        if ( gameOptional.isPresent())
            save(game);
        else
            throw new RuntimeException("Game: " + id + " wasn't found.");
    }

    @Override
    public void delete(Long id) {

        Optional<Game> optionalGame = gameRepository.findById(id);
        Game gameFull = null;
        if(optionalGame.isPresent()) {
            gameFull = optionalGame.get();
            gameRepository.delete( gameFull );
        }else {
            throw new RuntimeException("Game: " + id + " wasn't found.");
        }
    }

    // FROM REPOSITORY

    public List<Game> findGameByName(String name){ return gameRepository.findGameByName(name); }
    public List<Game> findGameByPrice(float price){ return gameRepository.findGameByPrice(price); }

}
