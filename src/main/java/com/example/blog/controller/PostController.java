package com.example.blog.controller;

import com.example.blog.DTO.PostDTO;
import com.example.blog.Post;
import com.example.blog.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;


@RequestMapping("/post")

@RestController
public class PostController {

    @Autowired
    private PostRepository postRepository;

   /* @GetMapping("/new")
    public String index(Post post ,Model model){
        model.addAttribute("post",post);
        return "index";
    }*/

    @GetMapping
    public List<PostDTO> getAll() {
    return postRepository
    .findAll()
    .stream().map(post -> new PostDTO(post.getId(), post.getTitle(), post.getImage(), post.getCategory(), post.getCreationDate())).collect(toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getPostById(@PathVariable Long id){

        Optional<Post> post = postRepository.findById(id);
        if(post.isEmpty()){
            return new ResponseEntity<>("no such post", HttpStatus.FORBIDDEN);
        }
        return ResponseEntity.ok().body(post);
    }

    @PostMapping
    public ResponseEntity<Object> createPost(@RequestBody PostDTO postDTO ){

        if (postDTO.getTitle() == "" ||  postDTO.getContent() == "" || postDTO.getImage() == "" || postDTO.getCategory() == "") {
            return new ResponseEntity<>("error missing data",HttpStatus.FORBIDDEN);
        }
        Post newPost = new Post(postDTO.getId(), postDTO.getTitle(), postDTO.getContent(),postDTO.getImage(),postDTO.getCategory());
        postRepository.save(newPost);
        return new ResponseEntity<>("post created", HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> parcialUpdate(@PathVariable("Id") Long id, @RequestBody PostDTO postDTO){

        Optional<Post> validPost = postRepository.findById(id);
        if(validPost.isEmpty()){
            return new ResponseEntity<>( "wrong id",HttpStatus.FORBIDDEN );
        }
        Post post = postRepository.getOne(id);

        post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());
        post.setImage(postDTO.getImage());
        post.setCategory(postDTO.getCategory());
        post.setCreationDate(postDTO.getCreationDate());

        postRepository.save(post);
        return new ResponseEntity<>( "post was edited", HttpStatus.CREATED);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePost(@PathVariable("id") Long id){

        Optional<Post> post = postRepository.findById(id);
        if(post.isEmpty()){
            return new ResponseEntity<>( "wrong id",HttpStatus.FORBIDDEN );
        }
        postRepository.deleteById(id);
        return new ResponseEntity<>("post deleted", HttpStatus.OK );
    }

}