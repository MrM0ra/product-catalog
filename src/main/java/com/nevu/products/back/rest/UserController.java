package com.nevu.products.back.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.crypto.bcrypt.BCrypt;

import com.nevu.products.back.entities.ModelUser;
import com.nevu.products.back.entities.dto.UserLoginDTO;
import com.nevu.products.back.services.UserService;

@RestController
@CrossOrigin
public class UserController {

	private UserService userServ;
	
	@Autowired
	public UserController(UserService userServ) {
		this.userServ=userServ;
	}
	
	@PostMapping("/login")
	public String login(@RequestBody UserLoginDTO userLogin) {
		ModelUser user = userServ.getUser(userLogin.getEmail());
		if(user != null) {
			if(user.getPassword().equals(BCrypt.hashpw(userLogin.getPassword(), user.getSalt()))) {
				return user.toString();
			}else {
				return "Wrong password";
			}
		} else {
			return "please register";
		}
	}
	
	@PostMapping("/signup")
	public String signUp(@RequestBody ModelUser user) {
		if(userServ.getUser(user.getEmail())!=null) {
			return "User already exists";
		}
		String salt = BCrypt.gensalt(12);
		String hashed = BCrypt.hashpw(user.getPassword(), salt);
		user.setSalt(salt);
		user.setPassword(hashed);
		return userServ.createUser(user).toString();
	}
	
	
}
