package com.springprojecttest.journal.service;

import com.springprojecttest.journal.entity.User;
import com.springprojecttest.journal.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static  org.mockito.Mockito.*;
public class UserDetailsServiceImplTest {

    @InjectMocks
    private UserDetailsServiceImpl userDetailsService;
@Mock
    private UserRepository userRepository;
@BeforeEach
void setup(){
    MockitoAnnotations.initMocks(this);
    }
    @Disabled
    @Test
    void loadUserByUserNameTest(){
        when(userRepository.findByUserName(ArgumentMatchers.anyString())).thenReturn(User.builder().userName("admin").password("inrinrick").build());
        UserDetails user =userDetailsService.loadUserByUsername("admin");
    }
}
