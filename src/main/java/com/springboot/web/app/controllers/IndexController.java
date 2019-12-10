package com.springboot.web.app.controllers;

import java.util.List;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.web.app.models.User;

@Controller
@RequestMapping("/api") // Ruta de primer nivel
public class IndexController {
	
	@Value("${text.indexcontroller.index.title}")
	private String textIndex;
	
	@Value("${text.indexcontroller.profile.title}")
	private String textProfile;
	
	@Value("${text.indexcontroller.list.title}")
	private String textList;
	
	/**
	 * Method for Index view 
	 */
	@GetMapping({"/index", "/", "", "/home"}) // Ruta de segundo nivel
	public String index(Model model) {
		model.addAttribute("title", textIndex);
		return "index"; // Nombre de la vista
	}
	
	/**
	 * Method for Profile's view 
	 */
	@RequestMapping("/profile")
	public String profile(Model model) {
		User user = new User();
		user.setName("Mercer");
		user.setSurname("Takedown");
		user.setEmail("user@user.com");
		
		model.addAttribute("user", user);
		model.addAttribute("title", textProfile.concat(user.getName()));
		return	"profile";
	}
	
	/**
	 * Method for List's view 
	 */
	@RequestMapping("/list")
	public String list(Model model) {
		model.addAttribute("title", textList);
		
		return "list";
	}
	
	@ModelAttribute("users")
	public List<User> poblarUser() {
		List<User> users = Arrays.asList(new User("Alex", "Mercer", "mercer@email.com"),
				new User("Armin", "Van Buuren", "armin@email.com"),
				new User("Chris", "Switzer", "chris@email.com"),
				new User("Dash", "Berlin", "dash@email.com"));
		return users;
	}
}
