package edu.miu.amp.service.impl;

import edu.miu.amp.domain.Comment;
import edu.miu.amp.dto.CommentDto;

import edu.miu.amp.exception.ResourceNotFoundException;
import edu.miu.amp.repository.CommentRepo;
import edu.miu.amp.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<CommentDto> getAllComment() {
        var commentList = commentRepo.findAll();
        var resList = commentList.stream().map(comment -> modelMapper.map(comment, CommentDto.class)).collect(Collectors.toList());
        return resList;
    }

    @Override
    public CommentDto getComment(Integer id) {
        var comment = commentRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Comment", "id", id));
        ;
        return modelMapper.map(comment, CommentDto.class);
    }

    @Override
    public CommentDto addComment(CommentDto data) {
        var Comment = modelMapper.map(data,Comment.class);
        var CommentSaved = commentRepo.save(Comment);
        return modelMapper.map(CommentSaved, CommentDto.class);
    }

    @Override
    public CommentDto updateComment(Integer id, CommentDto data) {
        var existingComment = commentRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Comment", "id", id));

        existingComment.setComment(data.getComment());

        var updatedComment = commentRepo.save(existingComment);

        return modelMapper.map(updatedComment, CommentDto.class);

    }

    @Override
    public void deleteComment(Integer id) {
        commentRepo.deleteById(id);
    }
}
