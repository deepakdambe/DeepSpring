package com.example.CourseLibraryProj.controller;

import com.example.CourseLibraryProj.entity.Author;
import com.example.CourseLibraryProj.entity.Author;
import com.example.CourseLibraryProj.service.AuthorService;
import com.example.CourseLibraryProj.service.AuthorService;
import com.example.CourseLibraryProj.service.CategoryService;
import com.example.CourseLibraryProj.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @GetMapping("/authors")
    public String getAllAuthors(Model model)
    {
        List<Author> authors = authorService.getAllAuthors();
        model.addAttribute("authors", authors);
        return "authors";
    }

//    @GetMapping("/authors/{id}")
//    public String getAuthor(@PathVariable int id, Model model)
//    {
//        Author author = authorService.getAuthor(id);
//        model.addAttribute("author", author);
//        return "list-author";
//    }

    @GetMapping("/add-author")
    public String addAuthor(Author author, Model model)
    {
        return "add-author";
    }

    @PostMapping("/save-author")
    public String saveAuthor(Author author, Model model)
    {
        authorService.saveAuthor(author);
        model.addAttribute("authors", authorService.getAllAuthors());

        return "redirect:/authors";
    }

    @GetMapping("/update-author/{id}")
    public String updateAuthor(@PathVariable int id, Model model)
    {
        Author author = authorService.getAuthor(id);
        model.addAttribute("author", author);

        return "update-author";
    }

    @PostMapping("/save-author/{id}")
    public String saveAuthor(@PathVariable int id, Author author, BindingResult result, Model model)
    {
        if (result.hasErrors()) {
            return "update-author";
        }

        authorService.saveAuthor(author);
        model.addAttribute("authors", authorService.getAllAuthors());

        return "redirect:/authors";
    }

    @GetMapping("/remove-author/{id}")
    public String deleteAuthor(@PathVariable int id, Model model)
    {
        authorService.deleteAuthor(id);
        model.addAttribute("authors", authorService.getAllAuthors());
        return "authors";
    }

}
