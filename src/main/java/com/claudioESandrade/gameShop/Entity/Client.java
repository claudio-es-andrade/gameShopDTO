package com.claudioESandrade.gameShop.Entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient;

    private String nameClient;

    // Constructors

    public Client() {  }

    public Client(Long idClient, String nameClient) {
        this.idClient = idClient;
        this.nameClient = nameClient;
    }

    // Getters and Setters

    public Long getIdClient() {
        return idClient;
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client client)) return false;
        return Objects.equals(getIdClient(), client.getIdClient()) && Objects.equals(getNameClient(), client.getNameClient());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdClient(), getNameClient());
    }

    @Override
    public String toString() {
        return "Client { \n" +
                " idClient = " + idClient +
                ", nameClient = '" + nameClient + '\'' +
                "}\n";
    }
}
