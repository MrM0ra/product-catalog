package com.nevu.products.back.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nevu.products.back.entities.ModelUser;
import com.nevu.products.back.repositories.UserRepository;

@Service
public class UserService {

	private UserRepository userRepo;
	
	@Autowired
	public UserService(UserRepository userRep) {
		this.userRepo=userRep;
	}
	
	public ModelUser createUser(ModelUser user) {
		return userRepo.save(user);
	}
	
	public ModelUser getUser(String email) {
		return userRepo.findByEmail(email);
	}
	
	public void deleteUser(long userId) {
		userRepo.deleteById(userId);
	}
	
}
