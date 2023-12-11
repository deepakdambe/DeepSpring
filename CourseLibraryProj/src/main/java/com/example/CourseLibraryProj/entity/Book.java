package com.example.CourseLibraryProj.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(length = 111, nullable = false, unique = true)
    String name;

    @Column(length = 55, nullable = false)
    String isbn;

    @Column(length = 111, nullable = false)
    String description;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable( name = "books_authors",
        joinColumns = {@JoinColumn(name = "book_id")},
        inverseJoinColumns = {@JoinColumn(name = "author_id")}
    )
    Set<Author> authors = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable( name = "books_categories",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id")}
    )
    Set<Category> categories = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable( name = "books_publishers",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "publisher_id")}
    )
    Set<Publisher> publishers = new HashSet<>();

    public Book(String name, String isbn, String description) {
        this.name = name;
        this.isbn = isbn;
        this.description = description;
    }

    public void removePublisher(Publisher publisher)
    {
        publishers.remove(publisher);
        publisher.getBooks().remove(publisher);
    }

    public void addPublisher(Publisher publisher)
    {
        publishers.add(publisher);
        publisher.getBooks().add(this);
    }

    public void removeAuthor(Author author)
    {
        authors.remove(author);
        author.getBooks().remove(author);
    }

    public void addAuthor(Author author)
    {
        authors.add(author);
        author.getBooks().add(this);
    }

    public void removeCategory(Category category)
    {
        categories.remove(category);
        category.getBooks().remove(category);
    }

    public void addCategory(Category category)
    {
        categories.add(category);
        category.getBooks().add(this);
    }


}
