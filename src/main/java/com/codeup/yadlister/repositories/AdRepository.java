package com.codeup.yadlister.repositories;

import com.codeup.yadlister.models.Ad;
import org.springframework.data.repository.CrudRepository;

public interface AdRepository extends CrudRepository<Ad, Long> {
}