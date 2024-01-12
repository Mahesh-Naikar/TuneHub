package com.tunehub.services;

import java.util.List;

import com.tunehub.entities.Playlist;

public interface PlaylistService {

	public void addPlaylist(Playlist playlist);

	public List<Playlist> fetchAllPlaylist();

}
