package com.example.blog;

import com.example.blog.Repository.PostRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class BlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}
	@Bean
	public CommandLineRunner initData(PostRepository postRepository) {
		return (args) -> {
			Post post1 = new Post(1l, "saludo", "hola","https://www.google.com/img","general");
			postRepository.save(post1);

			Post post2 = new Post(2l, "saludo", "chau","https://www.google.com/img/fxdgcfhvgjbh","general");
			postRepository.save(post2);

			Post post3 = new Post(3l, "saludo", "hasta luego","https://www.bing.com/img","general");
			postRepository.save(post3);

		};
	}
}
