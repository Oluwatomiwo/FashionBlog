package com.example.fashionblog8.Controller;

import com.example.fashionblog8.Model.User;
import com.example.fashionblog8.Service.UserService;
import com.example.fashionblog8.dto.CreateUserRequestDto;
import com.example.fashionblog8.dto.CreateUserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }


    @GetMapping("/{id}/readUser")
    public String readUser(@PathVariable Long id, @RequestBody CreateUserRequestDto createUserRequestDto) throws Exception {
        System.out.println("I HAVE ENTERED CONTROLLER SUCCESSFULLY.......");

        return "Your profile updated successfully";
    }

    @PostMapping("/create")
    public ResponseEntity<CreateUserResponseDto> createUser(@RequestBody CreateUserRequestDto createUserRequestDto) throws Exception {
        System.out.println("I AM HITTING THIS ENDPOINT..............");

        CreateUserResponseDto createdUser = userService.createUser(createUserRequestDto);
        return ResponseEntity.ok(createdUser);
    }

    @PutMapping("/{id}/updatedUser")
    public String updateUser(@PathVariable Long id, @RequestBody CreateUserRequestDto createUserRequestDto) throws Exception {
        System.out.println("I HAVE ENTERED CONTROLLER SUCCESSFULLY.......");
          userService.updateUser(id, createUserRequestDto);
        return "Your profile updated successfully";
    }

    @DeleteMapping("/{id}/deleteUser")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) throws Exception {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/getUser")
    public ResponseEntity<User> getUser(@PathVariable Long id) throws Exception {
        System.out.println("I HAVE ENTERED CONTROLLER SUCCESSFULLY.......");
        userService.getUserById(id);
        User user = userService.getUserById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }

    }
}
