package com.kodilla.covid_back.service;

import com.kodilla.covid_back.domain.User;
import com.kodilla.covid_back.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public class UserDbService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers () {
        return userRepository.findAll();
    }

    public Optional<User> getUser (final Long userId) {
        return userRepository.findById(userId);
    }

    public User saveUser (User user) {
        return userRepository.save(user);
    }

    public User findUser (String userName, String userPassword) {
        User user1 = new User();
        user1.setUserName(userName);
        user1.setUserPassword(userPassword);

        Example example = Example.of(user1);
        List <User> users = userRepository.findAll(example);
        if (users != null && users.size()==1) {
            return users.get(0);
        }
        else
            return null;
    }

}
