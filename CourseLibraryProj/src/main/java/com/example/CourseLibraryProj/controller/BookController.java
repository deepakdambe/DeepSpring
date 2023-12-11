package com.example.CourseLibraryProj.controller;

import com.example.CourseLibraryProj.entity.Book;
import com.example.CourseLibraryProj.service.AuthorService;
import com.example.CourseLibraryProj.service.BookService;
import com.example.CourseLibraryProj.service.CategoryService;
import com.example.CourseLibraryProj.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    BookService bookService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    AuthorService authorService;

    @Autowired
    PublisherService publisherService;

    @GetMapping("/books")
    public String getAllBooks(Model model)
    {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("/books/{id}")
    public String getBook(@PathVariable int id, Model model)
    {
        Book book = bookService.getBook(id);
        model.addAttribute("book", book);
        return "list-book";
    }

    @GetMapping("/add-book")
    public String addBook(Book book, Model model)
    {
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("authors", authorService.getAllAuthors());
        model.addAttribute("publishers", publisherService.getAllPublishers());

        return "add-book";
    }

    @PostMapping("/save-book")
    public String saveBook(Book book, Model model)
    {
        bookService.saveBook(book);
        model.addAttribute("books", bookService.getAllBooks());

        return "redirect:/books";
    }

    @GetMapping("/update_book/{id}")
    public String updateBook(@PathVariable int id, Model model)
    {
        Book book = bookService.getBook(id);
        model.addAttribute("book", book);
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("authors", authorService.getAllAuthors());
        model.addAttribute("publishers", publisherService.getAllPublishers());

        return "update-book";
    }

    @PostMapping("/save-book/{id}")
    public String saveBook(@PathVariable int id, Book book, BindingResult result, Model model)
    {
        if (result.hasErrors()) {
            return "update-book";
        }

        bookService.saveBook(book);
        model.addAttribute("books", bookService.getAllBooks());

        return "redirect:/books";
    }

    @GetMapping("/remove-book/{id}")
    public String deleteBook(@PathVariable int id, Model model)
    {
        bookService.deleteBook(id);
        model.addAttribute("books", bookService.getAllBooks());
        return "books";
    }

}
