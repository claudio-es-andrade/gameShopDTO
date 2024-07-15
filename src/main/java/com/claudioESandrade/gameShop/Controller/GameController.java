package com.claudioESandrade.gameShop.Controller;

import com.claudioESandrade.gameShop.Entity.Game;
import com.claudioESandrade.gameShop.Service.Implementations.GameServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Game")
public class GameController {

    @Autowired
    private GameServiceImpl gameService;

    public GameController(GameServiceImpl gameService) {
        this.gameService = gameService;
    }

    @PostMapping(value = "/save")
    public ResponseEntity<String> createGame(@RequestBody Game game) {
        try {
            gameService.save( game );
            return new ResponseEntity<>("Game details were created successfully.", HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping(value = "/get/All")
    public ResponseEntity<List<Game>> getAll() {
        return ResponseEntity.ok().body(gameService.getAll() );
    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<Optional<Game>> getGameById(@PathVariable Long id) {
        return ResponseEntity.ok(gameService.getGameById( id ) );
    }

//    @GetMapping(value = "/get/{name}")
//    public ResponseEntity<List<Game>> getGameByName(@PathVariable String name) {
//        return ResponseEntity.ok( gameService.findGameByName(name) );
//    }
//
//    @GetMapping(value = "/get/{price}")
//    public ResponseEntity<List<Game>> getGameByPrice(@PathVariable float price) {
//        return ResponseEntity.ok( gameService.findGameByPrice( price ) );
//    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Game> updateGame(@PathVariable Long id, @RequestBody Game game) {
        gameService.update( id, game);
        return ResponseEntity.ok( ).build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteGame(@PathVariable Long id) {
        gameService.delete( id );
        return ResponseEntity.ok().build();
    }


}
