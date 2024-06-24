package com.example.SocialProjectYoutube.service;

import com.example.SocialProjectYoutube.model.User;
import com.example.SocialProjectYoutube.repo.UserRepo;
import com.example.SocialProjectYoutube.utils.BeanCopyUtils;
import com.example.SocialProjectYoutube.utils.ReturnValue;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Log
@Service
public class UserService {

    @Autowired
    UserRepo userRepo;


    public List<User> getAllUsers()
    {
        return userRepo.findAll();
    }


    public User getUserById(int id)
    {
        Optional<User> user = userRepo.findById(id);
        if (user.isPresent())
            return user.get();

        log.severe("User not found log");
        return user.orElseThrow(() -> new RuntimeException("User not found"));
    }


    public ReturnValue addUser(User user)
    {
        userRepo.save(user);
        return ReturnValue.RV_SUCCESS;
    }


    public ReturnValue updateUserById(int id, User user) throws IllegalAccessException {
        Optional<User> existingUser = userRepo.findById(id);
        if (existingUser.isEmpty())
        {
            log.severe("User not exist");
            return ReturnValue.RV_FAIL;
        }

        User temp = existingUser.get();

        BeanCopyUtils.copyNonNullProperties(user, temp, "id");

        userRepo.save(temp);
        return ReturnValue.RV_SUCCESS;
    }


    public ReturnValue deleteUserById(int id)
    {
        userRepo.deleteById(id);
        return ReturnValue.RV_SUCCESS;
    }


    public ReturnValue followUser(int userId1, int userId2)
    {
        User user1 = getUserById(userId1);
        User user2 = getUserById(userId2);

        user1.getFollowings().add(user2.getId());
        user2.getFollowers().add(user1.getId());

        userRepo.save(user1);
        userRepo.save(user2);

        return ReturnValue.RV_SUCCESS;
    }


    public List<User> searchUser(@RequestParam String query)
    {
        return userRepo.searchUsers(query);
    }
}
