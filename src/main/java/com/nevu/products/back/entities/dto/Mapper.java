package com.nevu.products.back.entities.dto;

import org.springframework.stereotype.Component;

import com.nevu.products.back.entities.ModelUser;

@Component
public class Mapper {
	
	public UserStdOutDTO toStdOutDTO(ModelUser user) {
		return new UserStdOutDTO(user.getUserId(), user.getName(), user.getLastName(), user.getDocument(), user.getEmail());
	}
	
	
}
