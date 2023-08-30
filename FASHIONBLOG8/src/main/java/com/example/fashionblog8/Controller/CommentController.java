package com.example.fashionblog8.Controller;

import com.example.fashionblog8.Model.Comment;
import com.example.fashionblog8.Repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;



    @GetMapping
    public List<Comment> getAllComment(){

        return commentRepository.findAll();

    }


    @PostMapping ("/comment")
    public Comment CreateComment(@RequestBody Comment commentb) {

        return commentRepository.save(commentb);
    }




    @PutMapping("{id}/commentUpdate")
    public  ResponseEntity<Comment> UpdateComment(@PathVariable Long id, @RequestBody Comment updateCommeny)throws Exception{

        Comment comment1 = commentRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);

        comment1.setText(updateCommeny.getText());

        Comment comment2 = commentRepository.save(updateCommeny);

        return ResponseEntity.ok(comment2);
    }


    @GetMapping("/{id}/readComment")
    public ResponseEntity<Comment>getComment(@PathVariable Long id) {


        Comment comment = commentRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);

        return  ResponseEntity.ok(comment);

    }



    @DeleteMapping("{id}/deleteComment")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id)  {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);

        commentRepository.delete(comment);

        return ResponseEntity.noContent().build();
    }







}
