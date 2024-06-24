package com.example.SocialProjectYoutube.service;

import com.example.SocialProjectYoutube.model.Post;
import com.example.SocialProjectYoutube.model.User;
import com.example.SocialProjectYoutube.repo.PostRepo;
import com.example.SocialProjectYoutube.repo.UserRepo;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Log
@Service
public class PostService {

    @Autowired
    PostRepo postRepo;

    @Autowired
    UserService userService;

    @Autowired
    UserRepo userRepo;

    public Post createNewPost(Post post, Integer userId)
    {
        post.setCreatedAt(LocalDateTime.now());
        postRepo.save(post);
        return post;
    }

    public void deletePost(Integer postId, Integer userId) throws Exception {
        Post post = findPostById(postId);

//        if (post.getUser().getId() != userId)
//            throw new Exception("Can't delete other user's post");

        postRepo.delete(post);
    }

    public List<Post> findPostByUserId(Integer userId)
    {
        return postRepo.findPostByUserId(userId);
    }

    public Post findPostById(Integer postId)
    {
        Optional<Post> post = postRepo.findById(postId);
        if (post.isPresent())
            return post.get();

        log.severe("Post not found log");
        return post.orElseThrow(() -> new RuntimeException("Post not found"));
    }

    public List<Post> findAllPost()
    {
        return postRepo.findAll();
    }

    public Post savePost(Post post, Integer postId, Integer userId)
    {
        //Post tempPost = findPostById(postId);
        User user = userService.getUserById(userId);

//        if (user.getSavedPosts().contains(post))
//            user.getSavedPosts().remove(post);
//        else
//            user.getSavedPosts().add(post);

        userRepo.save(user);

        return postRepo.save(post);
    }

    public Post likePost(Integer postId, Integer userId)
    {
        Post post = findPostById(postId);
        User user = userService.getUserById(userId);

//        if (post.getLiked().contains(user))
//            post.getLiked().remove(user);
//        else
//            post.getLiked().add(user);

        return postRepo.save(post);
    }

}
