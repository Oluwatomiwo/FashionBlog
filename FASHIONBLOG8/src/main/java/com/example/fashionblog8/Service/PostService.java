package com.example.fashionblog8.Service;


import com.example.fashionblog8.Model.Post;
import com.example.fashionblog8.dto.CreatePostRequestDto;

import com.example.fashionblog8.dto.CreatePostResponseDto;
import java.util.List;


public interface PostService {


    Post getPostById(Long id) throws Exception;
    List<Post> getAllPost();
    CreatePostResponseDto createPost(CreatePostRequestDto createPostRequestDto) throws Exception;


    String updatePost(Long id, CreatePostRequestDto createPostRequestdto) throws Exception;

    void deletePost(Long id) throws Exception;
}