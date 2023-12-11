package com.example.CourseLibraryProj.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(length = 111, nullable = false, unique = true)
    String name;

    public Author(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Column(length = 111, nullable = false)
    String description;

    @ManyToMany(mappedBy = "authors", cascade = CascadeType.ALL)
    Set<Book> books = new HashSet<>();
}
