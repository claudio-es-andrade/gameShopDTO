package com.claudioESandrade.gameShop.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "games")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGame;

    private String nameGame;

    private float price;

    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category category;

    // Constructors

    public Game() { }

    public Game(Long idGame, String nameGame, float price, Category category) {
        this.idGame = idGame;
        this.nameGame = nameGame;
        this.price = price;
        this.category = category;
    }

    // Getters and Setters


    public Long getIdGame() {
        return idGame;
    }

    public String getNameGame() {
        return nameGame;
    }

    public float getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    public void setIdGame(Long idGame) {
        this.idGame = idGame;
    }

    public void setNameGame(String nameGame) {
        this.nameGame = nameGame;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Game game)) return false;
        return Float.compare(getPrice(), game.getPrice()) == 0 && Objects.equals(getIdGame(), game.getIdGame()) && Objects.equals(getNameGame(), game.getNameGame()) && Objects.equals(getCategory(), game.getCategory());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdGame(), getNameGame(), getPrice(), getCategory());
    }

    @Override
    public String toString() {
        return "Game { \n" +
                " idGame = " + idGame +
                ", nameGame = '" + nameGame + '\'' +
                ", price = " + price +
                ", category = " + category +
                "} \n";
    }
}
