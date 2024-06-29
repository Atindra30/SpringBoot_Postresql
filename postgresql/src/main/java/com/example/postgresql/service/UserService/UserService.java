package com.example.postgresql.service.UserService;

import com.example.postgresql.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    void addUser(User user);

    User getUserById(Long userId);

    List<User> getAllUsers();

    ResponseEntity updateUser(User user);

    void deleteUserById(Long userId);

}
