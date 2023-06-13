package com.rest.api.controller;

import com.rest.api.utils.request.CommentDTO;
import com.rest.api.service.CommentService;
import com.rest.api.utils.response.CommentResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentService commentService;

    @GetMapping("/getAll")
    public ResponseEntity<List<CommentResponseDTO>> getAllComment(){
        return new ResponseEntity<>(commentService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/createComment")
    public ResponseEntity<CommentResponseDTO> create(@RequestBody CommentDTO dto){
        return new ResponseEntity<>(commentService.save(dto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<CommentResponseDTO>> findById(@PathVariable("id") Long id){
        return new ResponseEntity<>(commentService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommentResponseDTO> update(@PathVariable("id") Long id, @RequestBody CommentDTO commentDTO){
        return new ResponseEntity<>(commentService.update(commentDTO, id), HttpStatus.OK);
    }

    @DeleteMapping("/deleted")
    public ResponseEntity<String> delete(@RequestParam("id") Long id){
        return new ResponseEntity<>(commentService.delete(id), HttpStatus.OK);
    }
}
