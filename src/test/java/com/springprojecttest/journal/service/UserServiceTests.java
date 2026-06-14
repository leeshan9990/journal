package com.springprojecttest.journal.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import com.springprojecttest.journal.entity.User;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.springprojecttest.journal.repository.UserRepository;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;
@Disabled
    @ParameterizedTest
    @ArgumentsSource(UserArgumentProvider.class)
    public void testSaveNewUser(User user ){
       assertTrue(userService.saveNewUser(user));

    }
    @Disabled
    @ParameterizedTest
    @CsvSource(
            {
                    "1,2,3",
                    "2,10,12",
                    "3,3,12"
            }
    )
    public void test(int a, int b, int c){
assertEquals(c,a+b);
    }
}
