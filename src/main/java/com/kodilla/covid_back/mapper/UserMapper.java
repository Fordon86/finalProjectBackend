package com.kodilla.covid_back.mapper;

import com.kodilla.covid_back.domain.Country;
import com.kodilla.covid_back.domain.User;
import com.kodilla.covid_back.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    @Autowired
    private CountryMapper countryMapper;

    public User mapToUser (final UserDto userDto) {
        return User.builder()
                .userId(userDto.getUserId())
                .userName(userDto.getUserName())
                .userPassword(userDto.getUserPassword())
                .build();
    }

    public UserDto mapToUserDto (final User user) {
        return UserDto.builder()
                .userId(user.getUserId())
                .userName(user.getUserName())
                .userPassword(user.getUserPassword())
                .userCountryList(countryMapper.mapToCountryDtoList(user.getCountries()))
                .build();
    }

    public List<UserDto> mapToUserDtoList (final List<User> userList) {
        return userList.stream()
                .map(user -> UserDto.builder()
                        .userId(user.getUserId())
                        .userName(user.getUserName())
                        .userPassword(user.getUserPassword())
                        .build())
                        .collect(Collectors.toList());
    }

}
