package edu.miu.amp.controller;

import edu.miu.amp.dto.CommentDto;
import edu.miu.amp.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/api/comments")
@CrossOrigin
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService CommentService) {
        this.commentService = CommentService;
    }

    @GetMapping
    @RolesAllowed("student")

    public ResponseEntity<List<CommentDto>> getAllComment() {
        var res = commentService.getAllComment();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping
    @RolesAllowed("faculty")

    public ResponseEntity<CommentDto> addComment(@Valid @RequestBody CommentDto data) {
        var res = commentService.addComment(data);

        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @RolesAllowed("faculty")

    public ResponseEntity<CommentDto> getComment(@PathVariable(name = "id") Integer id) {

        var res = commentService.getComment(id);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @RolesAllowed("faculty")

    public ResponseEntity<CommentDto> updateComment(@PathVariable(name = "id") Integer id, @RequestBody CommentDto data) {

        var res = commentService.updateComment(id, data);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @RolesAllowed("faculty")

    public void deleteComment(@PathVariable(name = "id") Integer id) {

        commentService.deleteComment(id);
    }


}
