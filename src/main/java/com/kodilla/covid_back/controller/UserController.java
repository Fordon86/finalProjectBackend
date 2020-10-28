package com.kodilla.covid_back.controller;

import com.kodilla.covid_back.domain.User;
import com.kodilla.covid_back.dto.UserDto;
import com.kodilla.covid_back.mapper.UserMapper;
import com.kodilla.covid_back.service.UserDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserDbService userDbService;

    @GetMapping(value = "createUser")
    public UserDto createUser (@RequestParam(value = "userName", required = true) String userName,
                               @RequestParam(value = "userPassword", required = true) String userPassword) {
        UserDto userDto = UserDto.builder().userName(userName).userPassword(userPassword).build();
        User user = userDbService.saveUser(userMapper.mapToUser(userDto));
        return userMapper.mapToUserDto(user);
    }

}