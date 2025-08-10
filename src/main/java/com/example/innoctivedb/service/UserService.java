package com.example.innoctivedb.service;

import com.example.innoctivedb.model.User;
import com.example.innoctivedb.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> updateUser(Long id, User updatedUser) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setCompanyName(updatedUser.getCompanyName());
            user.setEmployeeName(updatedUser.getEmployeeName());
            user.setEmail(updatedUser.getEmail());
            user.setPhone(updatedUser.getPhone());
            user.setPassword(updatedUser.getPassword());
            user.setDescription(updatedUser.getDescription());
            user.setVoluneer(updatedUser.getVoluneer());
            user.setCategory(updatedUser.getCategory());
            userRepository.save(user);
            return Optional.of(user);
        }
        return Optional.empty();
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}
