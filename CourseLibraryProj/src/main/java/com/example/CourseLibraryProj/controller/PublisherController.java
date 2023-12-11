package com.example.CourseLibraryProj.controller;

import com.example.CourseLibraryProj.entity.Publisher;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class PublisherController {

    @GetMapping("/publishers")
    public List<Publisher> getAllPublishers()
    {
        return null;
    }

    @GetMapping("/publishers/{id}")
    public Publisher getPublisher(@PathVariable int id)
    {
        return null;
    }

    @PostMapping("/save_publisher")
    public void savePublisher(@RequestBody Publisher publisher)
    {
    }

    @PutMapping("/update_publisher/{id}")
    public void updatePublisher(@PathVariable int id,@RequestBody Publisher publisher)
    {
    }

    @DeleteMapping("/delete_publisher/{id}")
    public void deletePublisher(@PathVariable int id)
    {
    }
}
