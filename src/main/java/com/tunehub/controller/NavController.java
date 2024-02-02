package com.tunehub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavController {
	
	@GetMapping("/register")
    public String register() {
        return "register";
    }
	@GetMapping("/login")
    public String login() {
        return "login";
    }
	
	@GetMapping("/newSong")
    public String newSong() {
        return "newSong";
    }
	@GetMapping("/forgotPassword")
    public String forgotPassword() {
        return "resetPassword";
    }
	
	
	//--------------
	@GetMapping("/adminHome")
    public String adminHome() {
        return "adminHome";
    }
	@GetMapping("/customerHome")
    public String customerHome() {
        return "customerHome";
    }
	@GetMapping("/index")
    public String Home() {
        return "index";
    }
}
