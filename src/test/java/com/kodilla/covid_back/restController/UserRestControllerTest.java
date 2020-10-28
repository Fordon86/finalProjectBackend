package com.kodilla.covid_back.restController;

import com.kodilla.covid_back.domain.Country;
import com.kodilla.covid_back.domain.User;
import com.kodilla.covid_back.dto.CountryDto;
import com.kodilla.covid_back.dto.UserDto;
import com.kodilla.covid_back.mapper.UserMapper;
import com.kodilla.covid_back.service.CountryDbService;
import com.kodilla.covid_back.service.UserDbService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserRestControllerTest {

    @InjectMocks
    private UserRestController userRestController;

    @Mock
    private UserDbService userDbService;

    @Mock
    private UserMapper userMapper;

    @Mock
    private CountryDbService countryDbService;

    @Test
    public void getUserTest() {
        //Given
        List<Country> countryList = new ArrayList<>();
        List<User> userList = new ArrayList<>();
        List<UserDto> userListDto = new ArrayList<>();

        User user = new User (1L,"Jon", "Jon", countryList);
        userList.add(user);

        Country country = new Country(1L," Poland", "Pl", 222, userList);
        countryList.add(country);

        UserDto userDto = mock(UserDto.class);
        userListDto.add(userDto);

        when(userDbService.getUsers()).thenReturn(userList);
        when(userMapper.mapToUserDtoList(userList)).thenReturn(userListDto);

        //When
        List<UserDto> result = userRestController.getUser();

        //Then
        assertEquals(result, userListDto);
    }

    @Test
    public void checkUserTest() {
        //Given
        List<CountryDto> userCountryDtoList1 = new ArrayList<>();
        CountryDto countryDto = new CountryDto(1L," Poland", "Pl", 222);
        userCountryDtoList1.add(countryDto);
        UserDto userDto1 = new UserDto(1L,"dsa","dsad", userCountryDtoList1);
        User user1 = mock(User.class);

        when(userMapper.mapToUserDto(user1)).thenReturn(userDto1);
        when(userDbService.findUser("Asa","da")).thenReturn(user1);

        //When
        UserDto result = userRestController.checkUser("Asa","da");

        //Given
        assertEquals(result, userDto1);
    }

    @Test
    public void addCountryTest() {
        //Given
        UserDto userDto1 = mock(UserDto.class);
        User user1 = new User();

        when(userMapper.mapToUserDto(user1)).thenReturn(userDto1);
        when(userDbService.getUser(1L)).thenReturn(Optional.of(user1));
        when(countryDbService.getCountry(any())).thenReturn(Optional.of(mock(Country.class)));
        when(userDbService.saveUser(user1)).thenReturn(user1);

        //When
        UserDto result = userRestController.addCountry("1","2");

        //Then
        assertEquals(result, userDto1);
    }

}
