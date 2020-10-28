package com.kodilla.covid_back.controller;

import com.kodilla.covid_back.domain.User;
import com.kodilla.covid_back.dto.UserDto;
import com.kodilla.covid_back.mapper.UserMapper;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserMapper userMapper;

    @Test
    public void createUserTest() throws Exception {
        //Given
        UserDto userDto = mock(UserDto.class);

        Gson gson =new Gson();
        String jsonContent = gson.toJson(userDto);

        when(userMapper.mapToUser(any(UserDto.class))).thenReturn(mock(User.class));

        //When
        mockMvc.perform(get("createUser")
                .content(jsonContent)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200));
    }

}
