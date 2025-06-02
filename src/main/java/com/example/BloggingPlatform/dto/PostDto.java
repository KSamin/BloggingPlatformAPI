package com.example.BloggingPlatform.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
public class PostDto {
    @NotBlank(message = "title is required")
    private String title;

    @NotBlank(message = "title is required")
    private String content;

    @NotBlank(message = "title is required")
    private String category;

    @NotBlank(message = "title is required")
    private List<String> tags;

    public PostDto(){}

    public PostDto(String title, String content, String category, List<String> tags) {
        this.title = title;
        this.content = content;
        this.category = category;
        this.tags = tags;
    }
    public String getTitle() {
        return title;
    }
    public String getContent() {
        return content;
    }
    public String getCategory() {
        return category;
    }
    public List<String> getTags() {
        return tags;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
