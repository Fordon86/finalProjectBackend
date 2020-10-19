package com.kodilla.covid_back.restController;

import com.kodilla.covid_back.domain.User;
import com.kodilla.covid_back.dto.UserDto;
import com.kodilla.covid_back.mapper.UserMapper;
import com.kodilla.covid_back.service.CountryDbService;
import com.kodilla.covid_back.service.UserDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class UserRestController {

    @Autowired
    private UserDbService userDbService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CountryDbService countryDbService;

    @RequestMapping(value = "getUser")
    public List<UserDto> getUser () {
        return userMapper.mapToUserDtoList(userDbService.getUsers());
    }

    @GetMapping(value = "checkUser")
    public UserDto checkUser (@RequestParam(value = "userName", required = true) String userName,
                              @RequestParam(value = "userPassword", required = true) String userPassword) {
        User user = userDbService.findUser(userName, userPassword);
        if(user != null) {
            return userMapper.mapToUserDto(user);
        }
        else
            return null;
    }

    @GetMapping(value = "addCountry")
    public UserDto addCountry (@RequestParam(value = "userId", required = true) String userId,
                              @RequestParam(value = "countryId", required = true) String countryId) {
        Optional<User> user = userDbService.getUser(Long.valueOf(userId));
        if(user.isPresent()) {
            user.get().addCountry(countryDbService.getCountry(Long.valueOf(countryId)).get());
        }
        return userMapper.mapToUserDto(userDbService.saveUser(user.get()));
    }

}
