package com.rest.api.service.impl;

import com.rest.api.entity.Comment;
import com.rest.api.utils.request.CommentDTO;
import com.rest.api.repository.CommentRepository;
import com.rest.api.service.CommentService;
import com.rest.api.utils.response.CommentResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Override
    public List<CommentResponseDTO> getAll() {
       List<Comment> comments = commentRepository.findAll();
       return comments.stream().map(c -> mapperToDTO(c)).collect(Collectors.toList());
    }

    @Override
    public Optional<CommentResponseDTO> findById(Long id) {
        Comment comment = commentRepository.findById(id).get();
        return Optional.of(mapperToDTO(comment));
    }

    @Override
    public CommentResponseDTO save(CommentDTO dto) {
        Comment cmt = new Comment();
        cmt.setName(dto.getName());
        cmt.setEmail(dto.getEmail());
        cmt.setBody(dto.getBody());
        Comment savedComment = commentRepository.save(cmt);
        return mapperToDTO(savedComment);
    }

    @Override
    public CommentResponseDTO update(CommentDTO dto, Long id) {
        Comment comment = commentRepository.findById(id).get();
        comment.setName(dto.getName());
        comment.setBody(dto.getBody());
        comment.setEmail(dto.getEmail());
        return mapperToDTO(commentRepository.save(comment));
    }

    @Override
    public String delete(Long id) {
        commentRepository.deleteById(id);
        return "Success";
    }


    private CommentResponseDTO mapperToDTO(Comment comment){
        CommentResponseDTO dto = new CommentResponseDTO();
        dto.setId(comment.getId());
        dto.setBody(comment.getBody());
        dto.setEmail(comment.getEmail());
        dto.setName(comment.getName());
        dto.setPost(comment.getPost());
        return dto;
    }
}
