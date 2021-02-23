package com.example.blog.controller;

import com.example.blog.DTO.PostDTO;
import com.example.blog.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
public class PostController {

    @Autowired
    private PostRepository postRepository;


    @GetMapping
    public List<PostDTO> getAll() {
    return postRepository
    .findAll()
    .stream()
    .map(post -> new PostDTO(post.getId(), post.getTitle(), post.getContent(), post.getImage(), post.getCategory(), post.getCreationDate())).collect(toList());
    }

}