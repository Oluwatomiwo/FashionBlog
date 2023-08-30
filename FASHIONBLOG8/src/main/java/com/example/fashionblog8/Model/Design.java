package com.example.fashionblog8.Model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "designs")
public class Design {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private DesignCategory category;

}