package com.nevu.products.back.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nevu.products.back.entities.ModelUser;
import com.nevu.products.back.entities.dto.Mapper;
import com.nevu.products.back.entities.dto.UserStdInDTO;
import com.nevu.products.back.entities.dto.UserStdOutDTO;
import com.nevu.products.back.services.UserService;

@RestController
@CrossOrigin
public class UserController {

	private UserService userServ;
	
	@Autowired
	private Mapper mapper;
	
	@Autowired
	public UserController(UserService userServ) {
		this.userServ=userServ;
	}
	
	@PostMapping("/login")
	public UserStdOutDTO login(@RequestBody UserStdInDTO userLogin) {
		ModelUser user = userServ.getUser(userLogin.getEmail());
		if(user != null) {
			if(user.getPassword().equals(BCrypt.hashpw(userLogin.getPassword(), user.getSalt()))) {
				UserStdOutDTO out = mapper.toStdOutDTO(user);
				return out;
			}else {
				return null;
			}
		} else {
			return null;
		}
	}
	
	@PostMapping("/signup")
	public UserStdOutDTO signUp(@RequestBody ModelUser user) {
		user.setEmail(user.getEmail().toLowerCase());
		if(userServ.getUser(user.getEmail())!=null) {
			return null;
		}
		String salt = BCrypt.gensalt(12);
		String hashed = BCrypt.hashpw(user.getPassword(), salt);
		user.setSalt(salt);
		user.setPassword(hashed);
		return mapper.toStdOutDTO(userServ.createUser(user));
	}
	
	
}
