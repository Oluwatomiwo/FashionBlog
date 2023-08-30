package com.example.fashionblog8.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserResponseDto {

    private Long Id;
    private String firstName;
    private String lastName;
}
