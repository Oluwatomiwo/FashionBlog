package com.example.fashionblog8.Controller;

import com.example.fashionblog8.Model.Post;
import com.example.fashionblog8.Model.User;
import com.example.fashionblog8.Service.PostService;

import com.example.fashionblog8.dto.CreatePostRequestDto;
import com.example.fashionblog8.dto.CreatePostResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping
    public ResponseEntity<List<Post>> getAllPost() {
        List<Post> post = postService.getAllPost();
        return ResponseEntity.ok(post);
    }


    @PostMapping("/createPost")
    public ResponseEntity<CreatePostResponseDto> createPost(@RequestBody CreatePostRequestDto createPostRequestDto) throws Exception {
        System.out.println("I making my first post..............");

        CreatePostResponseDto createdPost = postService.createPost(createPostRequestDto);

        return ResponseEntity.ok(createdPost);
    }

    @PutMapping("/{id}/updatePost")
    public String updatePost(@PathVariable Long id, @RequestBody CreatePostRequestDto createPostRequestdto) throws Exception {
        System.out.println("I HAVE ENTERED CONTROLLER SUCCESSFULLY.......");
        postService.updatePost(id, createPostRequestdto);

        return "Your post updated successfully";
    }

    @DeleteMapping("/{id}/deletePost")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) throws Exception {
        postService.deletePost(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/getpost")
    public ResponseEntity<User> getPost(@PathVariable Long id) throws Exception {
        System.out.println("I AM ENTERED CONTROLLER SUCCESSFULLY.......");
        postService.getPostById(id);
        Post post = postService.getPostById(id);
        if (post != null) {
            return ResponseEntity.ok(post.getAuthor());
        } else {
            return ResponseEntity.notFound().build();
        }

    }
}



//package com.example.fashionblog8.Controller;
//
//import com.example.fashionblog8.Model.Comment;
//import com.example.fashionblog8.Model.Post;
//
//import com.example.fashionblog8.Service.PostService;
//import com.example.fashionblog8.dto.CreatePostRequestDto;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.relational.core.sql.Like;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/posts")
//public class PostController {
//
//
//
//    @Autowired
//    private  PostService postService;
//
//    private List<Post> posts = new ArrayList<>();
//    public List<Comment>comments = new ArrayList<>();
//    public List<Like>likes = new ArrayList<>();
//    private long nextPostId = 1;
//
//
//    @GetMapping
//    public  ResponseEntity<List<Post>>getAllPost(){
//
//        List<Post>posts1 = postService.getAllPosts();
//        return ResponseEntity.ok(posts1);
//
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Post> getPostById(@PathVariable Long id) {
//        for (Post post : posts) {
//            if (post.getId().equals(id)) {
//                return ResponseEntity.ok(post);
//            }
//        }
//        return ResponseEntity.notFound().build();
//    }
//
//    @PostMapping
//    public ResponseEntity<CreatePostRequestDto> createPost(@RequestBody Post post) {
//        post.setId(nextPostId);
//        nextPostId++;
//        posts.add(post);
////        return ResponseEntity.ok(post);
//        return null;
//    }
//
//    @PutMapping("/postUpdate/{id}")
//    public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody Post updatedPost) {
//        for (int i = 0; i < posts.size(); i++) {
//            Post post = posts.get(i);
//            if (post.getId().equals(id)) {
//                updatedPost.setId(id);
//                posts.set(i, updatedPost);
//                return ResponseEntity.ok(updatedPost);
//            }
//        }
//        return ResponseEntity.notFound().build();
//    }
//
//    @DeleteMapping("/postdelete")
//    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
//        for (int i = 0; i < posts.size(); i++) {
//            Post post = posts.get(i);
//            if (post.getId().equals(id)) {
//                posts.remove(i);
//                return ResponseEntity.noContent().build();
//            }
//        }
//        return ResponseEntity.notFound().build();
//    }
//
//    {
//        posts.add(new Post(1L, "Title 1", "Content 1"));
//        posts.add(new Post(2L, "Title 2", "Content 2"));
//    }
//
//
//}
