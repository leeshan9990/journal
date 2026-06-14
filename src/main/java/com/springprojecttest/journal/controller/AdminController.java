package com.springprojecttest.journal.controller;

import com.springprojecttest.journal.entity.User;
import com.springprojecttest.journal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserService userService;

    @GetMapping("/all-users")
    public ResponseEntity<List<User>> gerAllUsers(){
        userService.getAll();
        List<User> all=userService.getAll();
if(all!=null && !all.isEmpty()){
    return new ResponseEntity<>(all, HttpStatus.OK);

}
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
    @PostMapping("/create-new-admin")
    public  void createUser(@RequestBody User user){
        userService.saveAdmin(user);
    }


}
