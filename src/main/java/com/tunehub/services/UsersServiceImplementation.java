package com.tunehub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tunehub.entities.Users;
import com.tunehub.repositories.UsersRepository;

@Service
public class UsersServiceImplementation implements UsersService {

	@Autowired
	UsersRepository repo;
	
	@Override
	public void addUser(Users user) {
		repo.save(user);
	}

	@Override
	public boolean emailExist(String email) {
		if(repo.findByEmail(email)==null) {
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public boolean validateUser(String email, String password) {
		Users user=repo.findByEmail(email);
		String db_password=user.getPassword();
		
		return db_password.equals(password);
	}

	@Override
	public String getRole(String email) {
		Users user=repo.findByEmail(email);
		return user.getRole();
	}
	@Override
	public Users getUser(String email) {
		return repo.findByEmail(email);
	}

	@Override
	public void updateUser(Users user) {
		repo.save(user);
	}
}
