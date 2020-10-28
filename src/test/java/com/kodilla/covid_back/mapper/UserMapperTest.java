package com.kodilla.covid_back.mapper;

import com.kodilla.covid_back.domain.User;
import com.kodilla.covid_back.dto.CountryDto;
import com.kodilla.covid_back.dto.UserDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class UserMapperTest {

    private UserMapper userMapper = new UserMapper();
    private CountryMapperTest countryMapper = new CountryMapperTest();

    @Test
    public void mapToUserTest() {
        //Given
        List<CountryDto> countryListDto = new ArrayList<>();
        CountryDto countryDto = mock(CountryDto.class);
        countryListDto.add(countryDto);
        UserDto userDto = new UserDto (1L, "d", "a", countryListDto);

        //When
        User user = userMapper.mapToUser(userDto);

        //Then
        assertEquals(userDto.getUserId(), user.getUserId());
        assertEquals(userDto.getUserName(), user.getUserName());
        assertEquals(userDto.getUserPassword(), user.getUserPassword());
        assertEquals(userDto.getUserCountryList(), user.getCountries());
    }

    @Test
    public void mapToUserDtoTest() {
/*
        //Given
        List<Country> countryList = new ArrayList<>();
        Country country = mock(Country.class);
        countryList.add(country);
        User user = new User (1L, "d", "a", countryList);

        //When
        UserDto userDto = userMapper.mapToUserDto(user);

        //Then
        assertEquals(user.getUserId(), userDto.getUserId());
        assertEquals(user.getUserName(), userDto.getUserName());
        assertEquals(user.getUserPassword(), userDto.getUserPassword());
        //assertEquals(user.getCountries(), userDto.getUserCountryList());*/
    }

    @Test
    public void mapToUserDtoListTest() {
        //Given
        List<User> users = new ArrayList<>();
        User user = new User (1L, "d", "a", null);
        users.add(user);

        //When
        List<UserDto> userDtos = userMapper.mapToUserDtoList(users);

        //Then
        assertEquals(userDtos.get(0).getUserId(), users.get(0).getUserId());
        assertEquals(userDtos.get(0).getUserName(), users.get(0).getUserName());
        assertEquals(userDtos.get(0).getUserPassword(), users.get(0).getUserPassword());
        assertEquals(userDtos.get(0).getUserCountryList(), users.get(0).getCountries());
    }


}
