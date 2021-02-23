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
                .map(subject -> new SubjectDTO(subject.getId(), subject.getName(), subject.getTime(), subject.getTeacher(), subject.getAvailability())).collect(toList());
    }

}