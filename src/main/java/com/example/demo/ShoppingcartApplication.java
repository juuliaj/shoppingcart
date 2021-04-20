package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.domain.Category;
import com.example.demo.domain.CategoryRepository;
import com.example.demo.domain.Item;
import com.example.demo.domain.ItemRepository;
import com.example.demo.domain.User;
import com.example.demo.domain.UserRepository;

@SpringBootApplication
public class ShoppingcartApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingcartApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(ItemRepository iRepo, CategoryRepository catRepo, UserRepository userRepo) {
	return (args) -> {
	
		
		Category c1 = new Category("HeVi-osasto");
		Category c2 = new Category("Maitotuotteet");
		Category c3 = new Category("Leivät");
		
		catRepo.save(c1);
		catRepo.save(c2);
		catRepo.save(c3);
		
		Item item1 = new Item("Banaani", 2, 1.00, "Keltainen banaaninippu", catRepo.findByName("HeVi-osasto").get(0));
		Item item2 = new Item("Ruisleipä", 1, 2.99, "Vaasan tumma ruisleipä", catRepo.findByName("Leivät").get(0));
		Item item3 = new Item("Kauramaito", 2, 1.99, "Oatly Kauramaito", catRepo.findByName("Maitotuotteet").get(0));
		
		iRepo.save(item1);
		iRepo.save(item2);
		iRepo.save(item3);
		
		User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6",  "user@user.fi", "USER");
		User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C",  "admin@admin.fi", "ADMIN");
		
		userRepo.save(user1);
		userRepo.save(user2);
		
	};
	}

}
