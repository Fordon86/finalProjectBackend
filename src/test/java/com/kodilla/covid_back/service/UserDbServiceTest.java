package com.kodilla.covid_back.service;

import com.kodilla.covid_back.domain.User;
import com.kodilla.covid_back.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Matchers.any;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDbServiceTest {


    @InjectMocks
    private UserDbService userDbService;

    @Mock
    private UserRepository userRepository;

    @Test
    public void getUsersTest() {
        //Given
        List<User> userList = new ArrayList<>();
        User user1 = mock(User.class);
        User user2 = mock(User.class);
        User user3 = mock(User.class);
        User user4 = mock(User.class);

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);

        when(userRepository.findAll()).thenReturn(userList);
        List<User> result = userDbService.getUsers();

        //When & Then
        assertEquals(4, result.size());

        //CleanUp
        userRepository.deleteAll();

    }

    @Test
    public void saveUserTest() {
        //Given
        User user1 = new User();

        when(userRepository.save(user1)).thenReturn(user1);
        //When
        User result = userDbService.saveUser(user1);

        //Then
        assertEquals(user1, result);

        //CleanUp

    }

    @Test
    public void getUserTest() {
        //Given
        User user1 = mock(User.class);

        when(userRepository.findById(2L)).thenReturn(Optional.of(user1));
        Optional<User> result = userDbService.getUser(2L);

        //When & Then
        assertEquals(user1, result.get());
    }

    @Test
    public void findUserTest() {
        //Given
        User user1 = mock(User.class);
        List<User> userList = new LinkedList<>();
        userList.add(user1);

        when(userRepository.findAll(any(Example.class))).thenReturn(userList);
        User result = userDbService.findUser("Rene", "Papaj");

        //When & Then
        assertEquals(user1, result);
    }

}