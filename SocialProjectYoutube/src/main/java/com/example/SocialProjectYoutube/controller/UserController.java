package com.example.SocialProjectYoutube.controller;


import com.example.SocialProjectYoutube.annotations.MeasureExecutionTime;
import com.example.SocialProjectYoutube.service.UserService;
import com.example.SocialProjectYoutube.utils.BeanCopyUtils;
import com.example.SocialProjectYoutube.utils.ReturnValue;
import com.example.SocialProjectYoutube.model.User;
import com.example.SocialProjectYoutube.repo.UserRepo;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/user/")
public class UserController {

    @Autowired
    UserService userService;

    //Logger logger = Logger.getLogger(UserController.class.getName());

    @GetMapping("/getAllUsers")
    @MeasureExecutionTime
    public List<User> getAllUsers()
    {
        return userService.getAllUsers();
    }


    @GetMapping("/getUserById/{id}")
    @MeasureExecutionTime
    public User getUserById(@PathVariable int id)
    {
        return userService.getUserById(id);
    }


    @PostMapping("/addUser")
    public ReturnValue addUser(@RequestBody User user)
    {
        return userService.addUser(user);
    }


    @PutMapping("/updateUserById/{id}")
    public ReturnValue updateUserById(@PathVariable int id, @RequestBody User user) throws IllegalAccessException {
        return userService.updateUserById(id, user);
    }


    @DeleteMapping("/deleteUserById/{id}")
    public ReturnValue deleteUserById(@PathVariable int id)
    {
        return userService.deleteUserById(id);
    }


    @PutMapping("/follow/{uid1}/{uid2}")
    public ReturnValue followUser(@PathVariable Integer uid1, @PathVariable Integer uid2)
    {
        return userService.followUser(uid1, uid2);
    }


    @GetMapping("/search")
    public List<User> searchUser(@RequestParam String query)
    {
        return userService.searchUser(query);
    }

}
