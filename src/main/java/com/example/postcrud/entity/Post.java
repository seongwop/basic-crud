package com.example.postcrud.entity;


import com.example.postcrud.dto.PostRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Post extends TimeStamped {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String content;

    public Post(PostRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.author = requestDto.getAuthor();
        this.password = requestDto.getPassword();
        this.content = requestDto.getContent();
    }

    public void update(PostRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.author = requestDto.getAuthor();
        this.content = requestDto.getContent();
    }
}
