package com.example.minitest1.service.impl;

import com.example.minitest1.model.Posts;
import com.example.minitest1.repository.IPostsRepository;
import com.example.minitest1.service.IPostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class PostsService implements IPostsService {
    @Autowired
    private IPostsRepository postsRepository;

    @Override
    public Iterable<Posts> findAll() {
        return postsRepository.findAll();
    }

    @Override
    public void save(Posts posts) {
        postsRepository.save(posts);
    }

    @Override
    public Optional<Posts> findById(Integer id) {
        return postsRepository.findById(id);
    }

    @Override
    public void remove(Integer id) {
        postsRepository.deleteById(id);
    }
}
