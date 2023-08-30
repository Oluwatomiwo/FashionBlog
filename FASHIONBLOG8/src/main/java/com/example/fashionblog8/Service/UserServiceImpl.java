package com.example.fashionblog8.Service;

import com.example.fashionblog8.Model.User;
import com.example.fashionblog8.Repository.UserRepository;
import com.example.fashionblog8.dto.CreateUserRequestDto;
import com.example.fashionblog8.dto.CreateUserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Override
    public User getUserById(Long id) throws Exception {
       Optional<User>optionalUser= this.userRepository.findById(id);


        if(optionalUser.isEmpty()){
            throw new Exception("User not found");
        }

        return optionalUser.get();

    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public CreateUserResponseDto createUser(CreateUserRequestDto createUserRequestDto) throws Exception {
        System.out.println("THIS IS MY SERVICE CLASS");
        Optional<User> optionalUser = this.userRepository.findByEmail(createUserRequestDto.getEmail());
//        User user2=optionalUser.get();
        if (optionalUser.isPresent()){
            throw new Exception();
        }

        User user = new User();
        user.setEmail(createUserRequestDto.getEmail());
        user.setFirstName(createUserRequestDto.getFirstName());
        user.setLastName(createUserRequestDto.getLastName());
        user.setPassword(createUserRequestDto.getPassword());

        User user1 = userRepository.save(user);

        return new CreateUserResponseDto(user1.getId(), user1.getFirstName(), user1.getLastName());
    }

    @Override
    public String updateUser(Long id, CreateUserRequestDto createUserRequestDto) throws Exception {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isEmpty()){
            throw new Exception("The user with id " + id + " is not found");
        }

        User user = optionalUser.get();
        user.setFirstName(createUserRequestDto.getFirstName());
        user.setLastName(createUserRequestDto.getLastName());
        userRepository.save(user);

        return "Your profile updated successfully";
    }

    @Override
    public void deleteUser(Long id) throws Exception {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isEmpty()){
            throw new Exception("The user with id " + id + " is not found");
        }

        User user = optionalUser.get();
        userRepository.delete(user);
    }

    public String getUserById(Long id, CreateUserRequestDto createUserRequestDto) throws Exception {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isEmpty()){
            throw new Exception("The user with id " + id + " is not found");
        }

        User user = optionalUser.get();
        user.setFirstName(createUserRequestDto.getFirstName());
        user.setLastName(createUserRequestDto.getLastName());
        userRepository.save(user);

        return "Your profile updated successfully";
    }

}
