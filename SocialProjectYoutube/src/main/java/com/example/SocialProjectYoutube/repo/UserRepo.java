package com.example.SocialProjectYoutube.repo;

import com.example.SocialProjectYoutube.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    public User findByEmail(String email);

    @Query("select u from User u where name like %:query% OR email like %:query%")
    public List<User> searchUsers(@Param("query") String query);
}
