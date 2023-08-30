package com.example.fashionblog8.Service;

import com.example.fashionblog8.Model.Comment;
import com.example.fashionblog8.Repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{


    private final CommentRepository commentRepository;

    @Override
    public Comment getCommentById(Long id) throws Exception {
        return null;
    }

    @Override
    public Comment getComment(Long id) throws Exception {
        Optional<Comment>optionalComment = this.commentRepository.findById(id);
        if(optionalComment.isEmpty()){
            throw new Exception();
        }

        return optionalComment.get();
    }

    @Override
    public List<Comment> getAllComment() {
        return null;
    }

    @Override
    public Comment CreateComment(Comment comment) throws Exception {
//        Optional<Comment>optionalComment = this.commentRepository.findById(comment.getId());
//        if (optionalComment.isEmpty()){
//            throw new Exception();
//        }
//
//        Comment comment1 = new Comment();
//
//        comment1.setId(comment.getId());
//        comment1.setText(comment.getText());
//        Comment comment2 = commentRepository.save(comment1);
//
//        return new Comment(comment2.getId(),comment2.getText());

            Comment savedComment = commentRepository.save(comment);
            return savedComment;
        }



    @Override
    public String UpdateComment(Long id, Comment comment) throws Exception {
        Optional<Comment>optionalComment = commentRepository.findById(id);

        if (optionalComment.isEmpty()){
            throw new Exception();
        }

        Comment comment1 = optionalComment.get();
        commentRepository.save(comment1);
        return "your comment has been updated";
    }

    @Override
    public void deleteComment(Long id) throws Exception {

        Optional<Comment>optionalComment = this.commentRepository.findById(id);
        if(optionalComment.isEmpty()){
            throw new Exception();
        }

        Comment comment = optionalComment.get();
        commentRepository.delete(comment);

        System.out.println("successfully deleted your comment");

    }
}


