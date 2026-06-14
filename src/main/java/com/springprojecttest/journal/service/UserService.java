package com.springprojecttest.journal.service;

import com.springprojecttest.journal.controller.JournalEntryController;
import com.springprojecttest.journal.entity.User;
import com.springprojecttest.journal.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@Component
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;



    private static final PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();

//    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public boolean saveNewUser    (User user){
        log.debug("Trying to save user: {}", user.getUserName());
       try {
           user.setPassword(passwordEncoder.encode(user.getPassword()));
           user.setRoles(Arrays.asList("User"));
           userRepository.save(user);
           return true;
       }catch (Exception e){
           log.error("cant save the user error occurf for {}:",user.getUserName());
           log.debug("cant save the user error occurf for {}:",user.getUserName());
           log.info("1");
           log.debug("2");


           return false;
       }
    }

    public void saveAdmin    (User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("User","King"));
        userRepository.save(user);
    }

    public void saveUser(User user){
        userRepository.save(user);
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }
    public Optional<User> findById(ObjectId id){
        return userRepository.findById(id);
    }
    public void DeleteById(ObjectId id){
        userRepository.deleteById(id);

    }
    public User findByUserName(String userName){
        return userRepository.findByUserName(userName);
    }
}
