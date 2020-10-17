package com.kodilla.covid_back.mapper;

import com.kodilla.covid_back.domain.Country;
import com.kodilla.covid_back.domain.User;
import com.kodilla.covid_back.dto.UserDto;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public User mapToUser (final UserDto userDto) {
        return User.builder()
                .userId(userDto.getUserId())
                .userName(userDto.getUserName())
                .userPassword(userDto.getUserPassword())
                .build();
    }

    public UserDto mapToUserDto (final User user) {
        return new UserDto(
                user.getUserId(),
                user.getUserName(),
                user.getUserPassword());
    }

    public List<UserDto> mapToUserDtoList (final List<User> userList) {
        return userList.stream()
                .map(t -> new UserDto(t.getUserId(),
                        t.getUserName(),
                        t.getUserPassword()))
                .collect(Collectors.toList());
    }

}
