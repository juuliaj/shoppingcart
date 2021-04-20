package com.example.shoppingcart;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.example.demo.ShoppingcartApplication;
import com.example.demo.domain.ItemRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ShoppingcartApplicationTests {
	
	@Autowired
	private ItemRepository controller;

	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

}
