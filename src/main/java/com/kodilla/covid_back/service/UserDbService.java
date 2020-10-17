package com.kodilla.covid_back.service;

import com.kodilla.covid_back.domain.User;
import com.kodilla.covid_back.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserDbService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers (final Long userId) {
        return userRepository.findAll();
    }

    public void deleteUser (final Long userId) {
        userRepository.deleteById(userId);
    }

    public Optional<User> getUser (final Long userId) {
        return userRepository.findById(userId);
    }

    public User saveUser (User user) {
        return userRepository.save(user);
    }

}
