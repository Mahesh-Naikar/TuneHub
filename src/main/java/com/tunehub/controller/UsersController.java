package com.tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tunehub.entities.Song;
import com.tunehub.entities.Users;
import com.tunehub.services.SongService;
import com.tunehub.services.UsersService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UsersController {
	
	@Autowired
	UsersService userService;
	
	@PostMapping("/register")
	public String addUser(@ModelAttribute Users user) {
		
		boolean emailStatus=userService.emailExist(user.getEmail());
		if(emailStatus==false) {
			userService.addUser(user);
			System.out.println("User added Successfully.");
		}
		else {
			System.out.println("E-mail : '"+user.getEmail()+"' is already exists.");
		}
		
		return "home";
		
	}
	
	@PostMapping("/validate")
	public String validateUser(@RequestParam String email,@RequestParam String password,HttpSession session,Model model) {
		
		if(userService.validateUser(email, password)==true) {
			String role=userService.getRole(email);
			
			session.setAttribute("email", email);
			if(role.equals("admin")) {
				return "adminHome";
			}
			else{
				Users user=userService.getUser(email);
				boolean userStatus=user.isPremium();
				model.addAttribute("isPremium", userStatus);
				return "customerHome";
			}
		}
		else {
			return "login";
		}
	}
	
	@GetMapping("/logout")
	public String logut(HttpSession session) {
		session.invalidate();
		return "login";
	}
	
	
}
