package com.example.CourseLibraryProj.service;

import com.example.CourseLibraryProj.entity.Category;
import com.example.CourseLibraryProj.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepo categoryRepo;

    public List<Category> getAllCategories()
    {
        return categoryRepo.findAll();
    }

    public Category getCategory(int id)
    {
        return categoryRepo.findById(id).orElseThrow(() -> new RuntimeException("Category not found."));
    }

    public void saveCategory(Category category)
    {
        categoryRepo.save(category);
    }

    public void updateCategory(Category category)
    {
        categoryRepo.save(category);
    }

    public void deleteCategory(@PathVariable int id)
    {
        categoryRepo.deleteById(id);
    }
}
