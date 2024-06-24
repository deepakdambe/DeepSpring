package com.example.SocialProjectYoutube.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String caption;
    private String imageLink;
    private String videoLink;
//    @ManyToOne
//    private User user;
    private LocalDateTime createdAt;
//    private List<User> liked = new ArrayList<>();
}
