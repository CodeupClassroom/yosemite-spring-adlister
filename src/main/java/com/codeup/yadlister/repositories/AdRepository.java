package com.codeup.yadlister.repositories;

import com.codeup.yadlister.models.Ad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdRepository extends CrudRepository<Ad, Long> {
}