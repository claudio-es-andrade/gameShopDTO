package com.claudioESandrade.gameShop.Service;

import com.claudioESandrade.gameShop.Entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    Category save(Category category);
    List<Category> getAll();
    Optional<Category> getCategoryById(Long id);
    void update(Long id, Category category);
    void delete(Long id);

}
