package com.example.JPoint.mapper;

import com.example.JPoint.dto.PersonDto;
import com.example.JPoint.dto.PostDto;
import com.example.JPoint.model.Person;
import com.example.JPoint.model.Post;
import org.springframework.stereotype.Component;

@Component
public class PostMapper {
    public PostDto convertPostToDto(Post post) {
        return PostDto.builder()
                .id(post.getId())
                .name(post.getName())
                .description(post.getDescription())
                .personId(post.getId())
                .build();
    }

    public Post convertDtoToPost(PostDto postDto) {
        return Post.builder()
                .id(postDto.getId())
                .name(postDto.getName())
                .description(postDto.getDescription())
                //person(postDto- приодит Long
                .build();
    }
}