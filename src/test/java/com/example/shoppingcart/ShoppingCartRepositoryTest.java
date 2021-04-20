package com.example.shoppingcart;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.domain.Category;
import com.example.demo.domain.CategoryRepository;
import com.example.demo.domain.Item;
import com.example.demo.domain.ItemRepository;
import com.example.demo.domain.User;
import com.example.demo.domain.UserRepository;

class ShoppingCartRepositoryTest {

	@Autowired
	private ItemRepository itemRepo;
	
	@Autowired
	private CategoryRepository catrepository;
	
	@Autowired
	private UserRepository userRepository;

	@Test
	public void findItemByName() {
		List<Item> items =itemRepo.findByName("Banaani");
		assertThat(items).hasSize(1);
		assertThat(items.get(0).getInfo()).isEqualTo("Keltainen banaaninippu");
	}
	
	@Test
	public void createNewItem() {
		Item item = new Item("Tofu", 1, 2.00, "Jalotofu", new Category("Muu"));
		itemRepo.save(item);
		assertThat(item.getId()).isNotNull();
	}
	
	@Test
	public void findCatByName() {
		List<Category> category = catrepository.findByName("Leivät");
		
		assertThat(category).hasSize(1);
	}
	
	@Test
	public void deleteItem() {
		List<Item> item = itemRepo.findByName("Banaani");
		itemRepo.deleteAll(item);
		assertThat(item.isEmpty());
	}
	
	@Test
	public void createNewCategory() {
		Category category = new Category("Muu");
		catrepository.save(category);
		assertThat(category.getCategoryid()).isNotNull();
	}
	
	@Test
	public void deleteCategory() {
		List<Category> category = catrepository.findByName("Leivät");
		catrepository.deleteAll(category);
		assertThat(category.isEmpty());
	}
	
	@Test
	public void findByUsername() {
		User user = userRepository.findByUsername("user");
		assertThat(user.getEmail()).isEqualTo("user@user.fi");
	}
	
	@Test
	public void createNewUser() {
		User user = new User("user2", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "user2@user.fi", "USER");
		userRepository.save(user);
		assertThat(user.getId()).isNotNull();
	}

	@Test
	public void deleteUser() {
		User user = userRepository.findByUsername("user");
		userRepository.deleteById(user.getId());
		assertThat(userRepository.findByUsername("user")).isNull();
	}

}
