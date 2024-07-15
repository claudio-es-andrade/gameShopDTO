package com.claudioESandrade.gameShop.Repository;

import com.claudioESandrade.gameShop.Entity.Category;
import com.claudioESandrade.gameShop.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Transactional
    @Modifying
    @Query(value = "SELECT * FROM categories cat WHERE cat.name_category=?1", nativeQuery = true)
    List<Category> findCategoryByName(String name);

}