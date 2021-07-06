package com.org.schoolsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.org.schoolsystem.entities.User;
import com.org.schoolsystem.services.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	

	@GetMapping("/users")
	public String showUserPage(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		model.addAttribute("users", userService.listAllUsers());
		model.addAttribute("listRoles", userService.listAllRoles());
		return "users";
	}
	
	@PostMapping("/users/addNew")
	public String addNewUserPage(User user,RedirectAttributes redirectAttribute) {
		
		user.setEnabled(true);
		userService.createUser(user);
		redirectAttribute.addFlashAttribute("message", "New user created succesfully.");
		return "redirect:/users";
	}
	
	/*
	 * @GetMapping("/users/editUser/{id}") public String editUser(User
	 * user,@PathVariable(name = "id") Integer id,Model model) {
	 * 
	 * model.addAttribute("user", userService.getUserById(id)); return
	 * "redirect:/users"; }
	 */
	
}
