package com.example.fashionblog8.Service;

import com.example.fashionblog8.Model.Post;
import com.example.fashionblog8.dto.CreatePostRequestDto;
import com.example.fashionblog8.dto.CreatePostResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PostServiceImpl implements PostService {
    @Override
    public Post getPostById(Long id) {
        return null;
    }

    @Override
    public List<Post> getAllPost() {
        return null;
    }

    @Override
    public CreatePostResponseDto createPost(CreatePostRequestDto createPostRequestDto) throws Exception {
        return null;
    }

    @Override
    public String updatePost(Long id, CreatePostRequestDto createPostRequestdto) throws Exception {
        return null;
    }

    @Override
    public void deletePost(Long id) throws Exception {

    }


}
