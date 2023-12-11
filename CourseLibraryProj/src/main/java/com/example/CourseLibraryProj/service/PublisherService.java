package com.example.CourseLibraryProj.service;

import com.example.CourseLibraryProj.entity.Publisher;
import com.example.CourseLibraryProj.repository.PublisherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class PublisherService {

    @Autowired
    PublisherRepo publisherRepo;

    public List<Publisher> getAllPublishers()
    {
        return publisherRepo.findAll();
    }

    public Publisher getPublisher(int id)
    {
        return publisherRepo.findById(id).orElseThrow(() -> new RuntimeException("Publisher not found."));
    }

    public void savePublisher(Publisher publisher)
    {
        publisherRepo.save(publisher);
    }

    public void updatePublisher(Publisher publisher)
    {
        publisherRepo.save(publisher);
    }

    public void deletePublisher(@PathVariable int id)
    {
        publisherRepo.deleteById(id);
    }
}
