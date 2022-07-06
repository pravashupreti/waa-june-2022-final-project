package edu.miu.amp.service;

import edu.miu.amp.dto.CommentDto;

import java.util.List;

public interface CommentService {

    List<CommentDto> getAllComment();

    CommentDto getComment(Integer id);

    CommentDto addComment(CommentDto data);

    CommentDto updateComment(Integer id, CommentDto data);

    void deleteComment(Integer id);

}
