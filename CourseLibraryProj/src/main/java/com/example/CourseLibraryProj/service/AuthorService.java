package com.example.CourseLibraryProj.service;

import com.example.CourseLibraryProj.entity.Author;
import com.example.CourseLibraryProj.repository.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    AuthorRepo authorRepo;

    public List<Author> getAllAuthors()
    {
        return authorRepo.findAll();
    }

    public Author getAuthor(int id)
    {
        return authorRepo.findById(id).orElseThrow(() -> new RuntimeException("Author not found."));
    }

    public void saveAuthor(Author author)
    {
        authorRepo.save(author);
    }

    public void updateAuthor(Author author)
    {
        authorRepo.save(author);
    }

    public void deleteAuthor(@PathVariable int id)
    {
        authorRepo.deleteById(id);
    }
}
