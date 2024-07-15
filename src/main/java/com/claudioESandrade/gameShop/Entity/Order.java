package com.claudioESandrade.gameShop.Entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrder;

    private int qty;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "id_game")
    private Game game;

    // Constructors

    public Order() { }

    public Order(Long idOrder, int qty, Client client, Game game) {
        this.idOrder = idOrder;
        this.qty = qty;
        this.client = client;
        this.game = game;
    }

    // Getters and Setters


    public Long getIdOrder() {
        return idOrder;
    }

    public int getQty() {
        return qty;
    }

    public Client getClient() {
        return client;
    }

    public Game getGame() {
        return game;
    }

    public void setIdOrder(Long idOrder) {
        this.idOrder = idOrder;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order order)) return false;
        return getIdOrder() == order.getIdOrder() && getQty() == order.getQty() && Objects.equals(getClient(), order.getClient()) && Objects.equals(getGame(), order.getGame());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdOrder(), getQty(), getClient(), getGame());
    }

    @Override
    public String toString() {
        return "Order { \n" +
                " idOrder = " + idOrder +
                ", qty = " + qty +
                ", client = " + client +
                ", game = " + game +
                "} \n";
    }
}
