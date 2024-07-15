package com.claudioESandrade.gameShop.Service.Implementations;

import com.claudioESandrade.gameShop.Entity.Category;
import com.claudioESandrade.gameShop.Repository.CategoryRepository;
import com.claudioESandrade.gameShop.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> getCategoryById(Long id) {
        Optional<Category> categoryFound = categoryRepository.findById(id);
        Category categoryFull = null;
        if(categoryFound.isPresent()){
            categoryFull = categoryFound.get();
        }else {
            throw new RuntimeException("Category: " + id + " wasn't found.");
        }
        return Optional.of(categoryFull);
    }

    @Override
    public void update(Long id, Category category) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isPresent())
            save(category);
        else
            throw new RuntimeException("Category: " + id + " wasn't found.");
    }

    @Override
    public void delete(Long id) {

        Optional<Category> optionalCategory = categoryRepository.findById(id);
        Category categoryFull = null;
        if(optionalCategory.isPresent()) {
            categoryFull = optionalCategory.get();
            categoryRepository.delete( categoryFull );
        }else {
            throw new RuntimeException("Category: " + id + " wasn't found.");
        }
    }

    // FROM REPOSITORY
    public List<Category> findCategoryByName(String name){
        return categoryRepository.findCategoryByName(name);
    }

}
