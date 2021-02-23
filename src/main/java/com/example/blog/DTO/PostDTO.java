package com.example.blog.DTO;

import java.time.LocalDateTime;

public class PostDTO {

    private String title;
    private String content;
    private String image;
    private String category;
    private LocalDateTime creationDate;

    public PostDTO() {
    }

    public PostDTO(String title, String content, String image, String category, LocalDateTime creationDate) {
        this.title = title;
        this.content = content;
        this.image = image;
        this.category = category;
        this.creationDate = creationDate;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getImage() {
        return image;
    }

    public String getCategory() {
        return category;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
}
