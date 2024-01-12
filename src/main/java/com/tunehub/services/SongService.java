package com.tunehub.services;

import java.util.List;

import com.tunehub.entities.Song;

public interface SongService {
	
	public void addSong(Song song);

	public boolean songExist(String name);
	public List<Song> fetchAllSongs();

	public void updateSong(Song song);
	


}
