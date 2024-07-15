package com.claudioESandrade.gameShop.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategory;

    private String nameCategory;

    // Constructors

    public Category() { }

    public Category(Long idCategory, String nameCategory) {
        this.idCategory = idCategory;
        this.nameCategory = nameCategory;
    }

    // Getters and Setters

    public Long getIdCategory() {
        return idCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category category)) return false;
        return Objects.equals(getIdCategory(), category.getIdCategory()) && Objects.equals(getNameCategory(), category.getNameCategory());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdCategory(), getNameCategory());
    }

    @Override
    public String toString() {
        return "Category { \n " +
                " idCategory = " + idCategory +
                ", nameCategory = '" + nameCategory + '\'' +
                "} \n";
    }
}
