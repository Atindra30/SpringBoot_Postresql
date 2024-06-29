package com.example.postgresql.service.UserService;

import com.example.postgresql.model.User;
import com.example.postgresql.payload.response.ApiResponse;
import com.example.postgresql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public ResponseEntity updateUser(User user) {
        return userRepository.findById(user.getId())
                .map(u -> {
                    u.setName(user.getName());
                    u.setEmail(user.getEmail());
                    u.setAddress(user.getAddress());
                    userRepository.save(u);
                    return ResponseEntity.ok(new ApiResponse(true,"User updated successfully"));
                })
                .orElseGet(()->ResponseEntity.ok(new ApiResponse(false,"User not found")));
    }

    @Override
    public void deleteUserById(Long userId) {
        userRepository.deleteById(userId);
    }


}
