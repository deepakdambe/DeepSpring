package com.example.CourseLibraryProj.controller;

import com.example.CourseLibraryProj.entity.Category;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CategoryController {

    @GetMapping("/categories")
    public List<Category> getAllCategories()
    {
        return null;
    }

    @GetMapping("/categories/{id}")
    public Category getCategory(@PathVariable int id)
    {
        return null;
    }

    @PostMapping("/save_category")
    public void saveCategory(@RequestBody Category category)
    {
    }

    @PutMapping("/update_category/{id}")
    public void updateCategory(@PathVariable int id,@RequestBody Category category)
    {
    }

    @DeleteMapping("/delete_category/{id}")
    public void deleteCategory(@PathVariable int id)
    {
    }
}
