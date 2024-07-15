package com.claudioESandrade.gameShop.Controller;

import com.claudioESandrade.gameShop.Entity.Category;
import com.claudioESandrade.gameShop.Service.Implementations.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Category")
public class CategoryController {

    @Autowired
    private CategoryServiceImpl categoryService;

    public CategoryController(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping(value = "/save")
    public ResponseEntity<String> createCategory(@RequestBody Category category) {
        try{
            categoryService.save( category );
            return  new ResponseEntity<>("Category was created successfully", HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping(value = "/get/All")
    public ResponseEntity<List<Category>> getAll() {
        return ResponseEntity.ok().body(categoryService.getAll() );
    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<Optional<Category>> getCategoryById(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.getCategoryById( id ) );
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category category) {
        categoryService.update( id, category );
        return ResponseEntity.ok( ).build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.delete( id );
        return ResponseEntity.ok().build();
    }

}
