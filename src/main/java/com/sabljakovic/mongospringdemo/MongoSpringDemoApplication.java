package com.sabljakovic.mongospringdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MongoSpringDemoApplication {

	Logger log = LoggerFactory.getLogger(MongoSpringDemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MongoSpringDemoApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(final ProductsRepository productsRepository){
		return args -> {
			log.info("Cleaning existing products from the database");
			productsRepository.deleteAll();
			log.info("Creating a new product");
			productsRepository.insert(new Product("A new product"));
			log.info("Products in the database: {}", productsRepository.findAll());
			log.info("Total number of products in the database: {}", productsRepository.count());

			log.info("Find by name: {}", productsRepository.findByName("A new product"));
			log.info("Find by name (non-existing): {}", productsRepository.findByName("A new "));

			log.info("Find by name (@Query): {}", productsRepository.findAllProductWithASpecificName("A new product"));
		};
	}
}
