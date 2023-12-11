package com.example.CourseLibraryProj.repository;

import com.example.CourseLibraryProj.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book, Integer> {
}
