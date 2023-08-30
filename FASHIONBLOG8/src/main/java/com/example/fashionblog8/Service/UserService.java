package com.example.fashionblog8.Service;

import com.example.fashionblog8.Model.User;
import com.example.fashionblog8.dto.CreateUserRequestDto;
import com.example.fashionblog8.dto.CreateUserResponseDto;

import java.util.List;

public interface UserService {
    User getUserById(Long id) throws Exception;
    List<User> getAllUsers();
    CreateUserResponseDto createUser(CreateUserRequestDto createUserRequestDto) throws Exception;
    String updateUser(Long id, CreateUserRequestDto user) throws Exception;
    void deleteUser(Long id) throws Exception;
}
