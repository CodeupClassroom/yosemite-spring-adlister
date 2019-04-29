package com.codeup.yadlister.repositories;

import com.codeup.yadlister.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Users extends CrudRepository<User, Long> {
    User findByUsername(String username);
}