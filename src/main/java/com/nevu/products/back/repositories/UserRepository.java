package com.nevu.products.back.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nevu.products.back.entities.ModelUser;

@Repository
public interface UserRepository extends CrudRepository<ModelUser, Long>{
	
	public ModelUser findByEmail(String email);
	
}
