package com.fst.graphqldemo;

import com.fst.graphqldemo.entities.Category;
import com.fst.graphqldemo.entities.Product;
import com.fst.graphqldemo.repositories.CategoryRepository;
import com.fst.graphqldemo.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@SpringBootApplication
public class GraphQlDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphQlDemoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CategoryRepository categoryRepository,
										ProductRepository productRepository) {
		return args -> {
			Random random = new Random();
			List.of("Computer", "Printer", "Smartphone").forEach(cat -> {
				Category category = Category.builder().name(cat).build();
				categoryRepository.save(category);
			});
			categoryRepository.findAll().forEach(category -> {
				for (int i = 0; i < 10; i++) {
					Product product = Product.builder()
							.id(UUID.randomUUID().toString())
							.name("Product " + i)
							.price(100 + Math.random() * 50000)
							.quantity(random.nextInt(100))
							.category(category)
							.build();
					productRepository.save(product);
				}
			});
		};
	}
}
