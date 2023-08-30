package com.example.fashionblog8.Service;

import com.example.fashionblog8.Model.Comment;


import java.util.List;



public interface CommentService {
    Comment getCommentById(Long id) throws  Exception;
    Comment getComment(Long id) throws Exception;

    List<Comment>getAllComment();

    Comment CreateComment(Comment comment)throws Exception;

    String UpdateComment(Long id, Comment comment) throws Exception;

    void deleteComment(Long id)throws  Exception;
}
