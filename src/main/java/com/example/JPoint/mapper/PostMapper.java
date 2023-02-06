package com.example.JPoint.mapper;

import com.example.JPoint.dto.UserDto;
import com.example.JPoint.model.Post;
import org.springframework.stereotype.Component;

@Component
public class PostMapper {
    public UserDto convertPostToDto(Post post) {
        return UserDto.builder()
                .id(post.getId())
                .name(post.getName())
                .description(post.getDescription())
                .personId(post.getId())
                .build();
    }

    public Post convertDtoToPost(UserDto userDto) {
        return Post.builder()
                .id(userDto.getId())
                .name(userDto.getName())
                .description(userDto.getDescription())
                //person(postDto- приодит Long
                .build();
    }
}
