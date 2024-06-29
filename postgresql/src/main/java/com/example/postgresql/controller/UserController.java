package com.example.postgresql.controller;

import com.example.postgresql.model.User;
import com.example.postgresql.payload.response.ApiResponse;
import com.example.postgresql.service.UserService.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/addUser")
    public ResponseEntity addUserController(@Valid @RequestBody User user){
        userService.addUser(user);
        return ResponseEntity.ok(new ApiResponse<>(true, "User created successfully"));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity getUserByIdController(@PathVariable Long userId){
        User u=userService.getUserById(userId);

        return u==null? ResponseEntity.ok(new ApiResponse<>(false, "User not found")):
                ResponseEntity.ok(new ApiResponse<>(true, "User details",u));
    }

    @GetMapping("/users")
    public ResponseEntity getUsersController(){
        List<User> users=userService.getAllUsers();
        return new ResponseEntity(new ApiResponse<>(true,"List of Users", users), HttpStatus.OK);
    }

    @PutMapping("/updateUser")
    public ResponseEntity updateUserController(@RequestBody User user){
        return userService.updateUser(user);
    }

    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity deleteUserByIdController(@PathVariable Long userId){
        userService.deleteUserById(userId);
        return ResponseEntity.ok(new ApiResponse<>(true, "User deleted successfullt"));
    }

}
