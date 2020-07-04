package com.ajahi.blackjack.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void addMultipleUsers(List<User> users) {
        userRepository.saveAll(users);
    }

    public User findUser(String username) {
        return userRepository.findByUsername(username);
    }

    public User findUserById(UUID uuid) {
        return userRepository.findById(uuid).orElseThrow(NullPointerException::new);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
}
