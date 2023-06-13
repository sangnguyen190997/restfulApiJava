package com.rest.api.utils.response;

import com.rest.api.entity.Post;
import lombok.Data;

@Data
public class CommentResponseDTO {

    private Long id;

    private String email;


    private String name;


    private String body;

    private Post post;
}
