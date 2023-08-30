package com.example.fashionblog8.Model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity

public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private LocalDateTime publicationDate;


    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

//    public Post(long l, String s, String s1) {
//    }
//
//    public Post() {
//
//    }
    // Other fields, getters, setters
}