package com.example.postcrud.controller;


import com.example.postcrud.dto.PostRequestDto;
import com.example.postcrud.entity.Post;
import com.example.postcrud.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("api/posts")
    public List<Post> getPosts() {
        return postService.getPosts();
    }

    @PostMapping("api/post")
    public Post createPost(@RequestBody PostRequestDto postRequestDto) {

        return postService.createPost(postRequestDto);
    }

    @GetMapping("api/post/{id}")
    public Post getPost(@PathVariable Long id) {
        return postService.getPost(id);
    }

    @PutMapping("api/post/{id}")
    public Long updatePost(@PathVariable Long id, @RequestBody PostRequestDto postRequestDto) {
        return postService.updatePost(id, postRequestDto);
    }

    @DeleteMapping("api/post/{id}")
    public int deletePost(@PathVariable Long id, @RequestBody PostRequestDto postRequestDto) {
        return postService.deletePost(id, postRequestDto);
    }

}
