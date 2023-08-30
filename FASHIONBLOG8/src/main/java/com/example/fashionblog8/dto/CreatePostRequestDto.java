package com.example.fashionblog8.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreatePostRequestDto {
    private String title;
    private String content;
    private LocalDateTime publicationDate;
    private int likesCount;

}
