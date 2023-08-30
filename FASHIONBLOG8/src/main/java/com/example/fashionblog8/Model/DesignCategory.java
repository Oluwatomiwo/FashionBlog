package com.example.fashionblog8.Model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
//@Table(name = "design_categories")
public class DesignCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

}