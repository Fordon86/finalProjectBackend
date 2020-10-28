package com.kodilla.covid_back.restController;

import com.kodilla.covid_back.client.AccuweatherClient;
import com.kodilla.covid_back.client.CovidClient;
import com.kodilla.covid_back.domain.Country;
import com.kodilla.covid_back.domain.User;
import com.kodilla.covid_back.dto.*;
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

    @Autowired
    private CovidClient covidClient;

    @Autowired
    private AccuweatherClient accuweatherClient;

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
    @GetMapping(value = "getUserFullView")
    public UserFullViewDto getUserFullView(@RequestParam(value = "userId", required = true) String userId){
        Optional<User> user = userDbService.getUser(Long.valueOf(userId));
        UserFullViewDto userFullViewDto = new UserFullViewDto();
        userFullViewDto.setUserId(userId);
        if (user.isPresent()) {
            for (Country country: user.get().getCountries()) {

                List<CovidDto> covidGrowList = covidClient.getCovidGrow(country);
                userFullViewDto.getMapCountryCovidGrow().put(country.getCountryName(),covidGrowList);
//                AccuweatherDto temperatureList  = accuweatherClient.getTemperature(country);
//                userFullViewDto.getMapCountryTemperature().put(country.getCountryNumber(),temperatureList);
            }
        }
        return userFullViewDto;
    }

    @GetMapping(value = "deleteCountry")
    public Boolean deleteCountry (@RequestParam(value = "userId", required = true) String userId,
                               @RequestParam(value = "countryId", required = true) String countryId) {
        Optional<User> user = userDbService.getUser(Long.valueOf(userId));
        if (user.isPresent()) {
            user.get().deleteCountry(countryDbService.getCountry(Long.valueOf(countryId)).get());
            userDbService.saveUser(user.get());
            return true;
        }
        return false;
    }

}