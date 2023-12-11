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
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(length = 55, nullable = false, unique = true)
    String name;

    public Publisher(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "publishers", cascade = CascadeType.ALL)
    Set<Book> books = new HashSet<>();
}
