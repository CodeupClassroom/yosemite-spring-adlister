package com.codeup.yadlister.repositories;

import com.codeup.yadlister.models.User;
import org.springframework.data.repository.CrudRepository;

public interface Users extends CrudRepository<User, Long> {
    User findByUsername(String username);
}