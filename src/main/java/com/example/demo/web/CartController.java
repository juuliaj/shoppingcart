package com.example.demo.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.domain.CategoryRepository;
import com.example.demo.domain.Item;
import com.example.demo.domain.ItemRepository;


@Controller
public class CartController {
	@Autowired ItemRepository iRepo;
	
	@Autowired CategoryRepository catRepo;
	
	@RequestMapping(value = { "/main", "/" })
	public String itemlist(Model model) {
		model.addAttribute("items", iRepo.findAll());
		return "itemlist";
	}
	
	@RequestMapping(value="/login")
		public String login() {
			return "login";
	} 
	
	@RequestMapping(value="/items", method = RequestMethod.GET)
	public @ResponseBody List<Item> itemListRest(){
		return (List<Item>) iRepo.findAll();
	}
	
	@RequestMapping(value="/item/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Item> findBookRest(@PathVariable("id") Long itemid) {
		return iRepo.findById(itemid);
	}
	
	@RequestMapping(value="/add")
	public String addItem(Model model) {
		model.addAttribute("item", new Item());
		model.addAttribute("categories", catRepo.findAll());
		return "additem";
	}
	
	
	@RequestMapping(value="/save", method= RequestMethod.POST)
	public String save(Item item) {
		iRepo.save(item);
		return "redirect:main";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/delete/{id}") 
	public String deleteItem(@PathVariable("id") Long itemid, Model model) {
		iRepo.deleteById(itemid);
		return "redirect:/main";
	}

	@RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
	public String editItem(@PathVariable("id") Long itemid, Model model) {
		model.addAttribute("item", iRepo.findById(itemid));
		model.addAttribute("categories", catRepo.findAll());
		return "edititem";
	}

}
