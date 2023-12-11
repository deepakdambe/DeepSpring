package com.example.CourseLibraryProj.service;

import com.example.CourseLibraryProj.entity.Book;
import com.example.CourseLibraryProj.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepo bookRepo;

    public List<Book> getAllBooks()
    {
        return bookRepo.findAll();
    }

    public Book getBook(int id)
    {
        return bookRepo.findById(id).orElseThrow(() -> new RuntimeException("Book not found."));
    }

    public void saveBook(Book book)
    {
        bookRepo.save(book);
    }

    public void updateBook(Book book)
    {
        bookRepo.save(book);
    }

    public void deleteBook(@PathVariable int id)
    {
        bookRepo.deleteById(id);
    }

}
