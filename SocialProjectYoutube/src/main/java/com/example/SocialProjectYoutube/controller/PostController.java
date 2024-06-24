package com.example.SocialProjectYoutube.controller;

import com.example.SocialProjectYoutube.model.Post;
import com.example.SocialProjectYoutube.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping("/post/{userId}")
    public ResponseEntity<Post> createPost(@RequestBody Post post, @PathVariable Integer userId)
    {
        Post createdPost = postService.createNewPost(post, userId);

        return new ResponseEntity<>(createdPost, HttpStatus.OK);
    }

    @DeleteMapping("/post/{postId}/{userId}")
    public ResponseEntity<String> deletePost(@PathVariable Integer postId, @PathVariable Integer userId) throws Exception {
        postService.deletePost(postId, userId);
        return new ResponseEntity<>("Post Deleted", HttpStatus.OK);
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<Post> getPostById(@PathVariable Integer postId)
    {
        return new ResponseEntity<>(postService.findPostById(postId), HttpStatus.OK);
    }

    @GetMapping("/post/user/{userId}")
    public ResponseEntity<List<Post>> findPostByUserId(@PathVariable Integer userId)
    {
        return new ResponseEntity<>(postService.findPostByUserId(userId), HttpStatus.OK);
    }

    @GetMapping("/posts")
    public ResponseEntity<List<Post>> findAllPost()
    {
        return new ResponseEntity<>(postService.findAllPost(), HttpStatus.OK);
    }

    @PutMapping("/post/{postId}/{userId}")
    public ResponseEntity<Post> savePostHandler(@PathVariable Integer postId, @PathVariable Integer userId) throws Exception {
        Post post = postService.findPostById(postId);
        post = postService.savePost(post, postId, userId);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @PutMapping("/post/like/{postId}/{userId}")
    public ResponseEntity<Post> likePostHandler(@PathVariable Integer postId, @PathVariable Integer userId) throws Exception {
        Post post = postService.likePost (postId, userId);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

}
