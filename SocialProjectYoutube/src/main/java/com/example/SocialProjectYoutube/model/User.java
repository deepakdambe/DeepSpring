package com.example.SocialProjectYoutube.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private Integer id;
    private String name;
    private String email;
    private String password;
    private List<Integer> followers = new ArrayList<>();
    private List<Integer> followings = new ArrayList<>();
//    private List<Post> savedPosts = new ArrayList<>();

    public List<Integer> getFollowers() {
        if (null == followers)
        {
            followers = new ArrayList<>();
        }
        return followers;
    }

    public List<Integer> getFollowings() {
        if (followings == null)
        {
            followings = new ArrayList<>();
        }
        return followings;
    }

    public void cloneNonNullPropertyObject(User dest)
    {
        if (id > 0) {
            dest.id = id;
        }

        if (null != name) {
            dest.name = name;
        }

        if (null != email) {
            dest.email = email;
        }

        if (null != password) {
            dest.password = password;
        }
    }
}
