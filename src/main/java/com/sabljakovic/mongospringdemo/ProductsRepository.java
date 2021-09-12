package com.sabljakovic.mongospringdemo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends MongoRepository<Product, String> {

    List<Product> findByName(String name);

    @Query("{ 'name' : ?0 }")
    List<Product> findAllProductWithASpecificName(String name);
}
