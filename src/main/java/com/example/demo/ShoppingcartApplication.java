package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.domain.Category;
import com.example.demo.domain.CategoryRepository;
import com.example.demo.domain.Item;
import com.example.demo.domain.ItemRepository;

@SpringBootApplication
public class ShoppingcartApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingcartApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(ItemRepository iRepo, CategoryRepository catRepo) {
	return (args) -> {
	
		
		Category c1 = new Category("HeVi-osasto");
		Category c2 = new Category("Maitotuotteet");
		Category c3 = new Category("Leivät");
		
		catRepo.save(c1);
		catRepo.save(c2);
		catRepo.save(c3);
		
		Item item1 = new Item("Banaani", 2, 0.70, "Keltainen banaaninippu", catRepo.findByName("HeVi-osasto").get(0));
		Item item2 = new Item("Ruisleipä", 1, 2.99, "Vaasan tumma ruisleipä", catRepo.findByName("Leivät").get(0));
		Item item3 = new Item("Kauramaito", 2, 1.99, "Oatly Kauramaito", catRepo.findByName("Maitotuotteet").get(0));
		
		iRepo.save(item1);
		iRepo.save(item2);
		iRepo.save(item3);
		
	};
	}

}
