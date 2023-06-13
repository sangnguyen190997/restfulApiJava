package com.rest.api.utils.request;

import com.rest.api.entity.Post;
import lombok.Data;

@Data
public class CommentDTO {

    private String email;

    private String name;

    private String body;

    private Long postId;
}
