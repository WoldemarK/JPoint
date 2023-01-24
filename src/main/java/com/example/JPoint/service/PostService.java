package com.example.JPoint.service;

import com.example.JPoint.model.Post;
import com.example.JPoint.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public Post createPosts(Post post){
        return postRepository.save(post);
    }
}
