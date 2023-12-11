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
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(length = 111, nullable = false, unique = true)
    String name;

    public Category(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "categories", cascade = CascadeType.ALL)
    Set<Book> books = new HashSet<>();
}
