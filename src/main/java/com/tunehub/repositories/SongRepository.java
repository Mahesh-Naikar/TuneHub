package com.tunehub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tunehub.entities.Song;

public interface SongRepository extends JpaRepository<Song, Integer>{
	
	public Song findByName(String name);

}
