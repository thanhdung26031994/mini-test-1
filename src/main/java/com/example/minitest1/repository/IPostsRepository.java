package com.example.minitest1.repository;

import com.example.minitest1.model.Posts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPostsRepository extends CrudRepository<Posts, Integer> {

}
