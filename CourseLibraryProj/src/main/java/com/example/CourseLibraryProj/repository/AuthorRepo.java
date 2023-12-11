package com.example.CourseLibraryProj.repository;

import com.example.CourseLibraryProj.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepo extends JpaRepository<Author, Integer> {
}
