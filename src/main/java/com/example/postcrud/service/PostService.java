package com.example.postcrud.service;


import com.example.postcrud.dto.PostRequestDto;
import com.example.postcrud.entity.Post;
import com.example.postcrud.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    @Transactional(readOnly = true)
    public List<Post> getPosts() {
        return postRepository.findAllByOrderByCreatedAtDesc();

    }

    @Transactional
    public Post createPost(PostRequestDto requestDto) {
        Post post = new Post(requestDto);
        postRepository.save(post);
        return post;
    }

    @Transactional(readOnly = true)
    public Post getPost(Long id) {
        return postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
    }

    @Transactional
    public Long updatePost(Long id, PostRequestDto requestDto) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        if (post.getPassword().equals(requestDto.getPassword())) {
            post.update(requestDto);
        }
        return post.getId();
    }

    @Transactional
    public int deletePost(Long id, PostRequestDto requestDto) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        if (post.getPassword().equals(requestDto.getPassword())) {
            postRepository.deleteById(id);
            return HttpStatus.OK.value();
        }
        return HttpStatus.NOT_FOUND.value();
    }
}
