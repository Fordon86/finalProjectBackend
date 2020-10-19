package com.kodilla.covid_back.controller;

import com.kodilla.covid_back.dto.UserDto;
import com.kodilla.covid_back.mapper.UserMapper;
import com.kodilla.covid_back.service.UserDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("/v1/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserDbService userDbService;

    @PostMapping(value = "createUser")
    public UserDto createUser (@RequestBody UserDto userDto) {
        return userMapper.mapToUserDto(userDbService.saveUser(userMapper.mapToUser(userDto)));
    }

}

