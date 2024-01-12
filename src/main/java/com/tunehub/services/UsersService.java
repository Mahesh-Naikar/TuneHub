package com.tunehub.services;

import com.tunehub.entities.Users;

public interface UsersService {
	
	public void addUser(Users user);
	
	public boolean emailExist(String email);
	public boolean validateUser(String email,String password);
	public String getRole(String email);

	public Users getUser(String email);
	public void updateUser(Users user);
	
}
