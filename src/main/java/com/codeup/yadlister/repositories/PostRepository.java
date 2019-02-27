package com.codeup.yadlister.repositories;

import com.codeup.yadlister.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
}