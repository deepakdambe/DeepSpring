package com.example.CourseLibraryProj.repository;

import com.example.CourseLibraryProj.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
}
