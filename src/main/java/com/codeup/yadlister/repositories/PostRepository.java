package com.codeup.yadlister.repositories;

import com.codeup.yadlister.models.Post;
import com.codeup.yadlister.quotes.Quote;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {

    // get a post at random
    @Query(value="SELECT * FROM posts ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Post getRandom();


}