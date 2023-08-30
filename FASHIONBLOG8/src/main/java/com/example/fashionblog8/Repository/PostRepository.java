package com.example.fashionblog8.Repository;

import com.example.fashionblog8.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post,Long> {
    @Override
    Optional<Post> findById(Long aLong);
}

