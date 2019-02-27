package com.codeup.yadlister.quotes;

import org.springframework.data.repository.CrudRepository;

// comes with findAll, findOne, save, delete methods out of the box.
public interface QuoteRepository extends CrudRepository<Quote, Long> {

}
