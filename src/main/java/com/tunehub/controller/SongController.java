package com.tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tunehub.entities.Song;
import com.tunehub.services.SongService;

@Controller
public class SongController {
	
	@Autowired
	SongService service;
	
	@PostMapping("/addSong")
	public String addSong(@ModelAttribute Song song) {
		
		boolean songStatus=service.songExist(song.getName());
		if(songStatus==false) {
			service.addSong(song);
			System.out.println("Song is added Successfully.");
		}
		else {
			System.out.println("Song '"+song.getName()+"' is already Exist.");
		}
		return "adminHome";
	}
	
	@GetMapping("/viewSong")
	public String viewSong(Model model) {
		List<Song> songsList=service.fetchAllSongs();
//		System.out.println(songsList);
		model.addAttribute("songs", songsList);
		return "displaySong";
	}
	
	@GetMapping("/viewSongC")
	public String viewSongC(Model model) {
		List<Song> songsList=service.fetchAllSongs();
//		System.out.println(songsList);
		model.addAttribute("songs", songsList);
		return "displaySongC";
	}
}
