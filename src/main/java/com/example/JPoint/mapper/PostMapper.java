package com.example.JPoint.mapper;

import com.example.JPoint.dto.PostDto;
import com.example.JPoint.model.Post;
import org.springframework.stereotype.Component;

@Component
public class PostMapper {
    public PostDto convertPostToDto(Post post) {
        PostDto postDto = new PostDto();
        post.setId(post.getId());
        post.setName(post.getName());
        post.setDescription(post.getDescription());
        post.setCustom(post.isCustom()); /// тут верно?
        post.setUser(post.getUser());// тут верно? или User user = post.getUser(); post.setUser(user)
        return postDto;

    }

    public Post convertDtoToPost(PostDto postDto) {
        Post post = new Post();
        post.setId(postDto.getId());
        post.setName(post.getName());
        post.setDescription(post.getDescription());
        post.setCustom(postDto.isCustom()); /// тут верно?
        post.setUser(postDto.getUser());// тут верно? или User user = post.getUser(); post.setUser(user)
        return post;

    }
}
