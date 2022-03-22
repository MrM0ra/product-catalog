package com.nevu.products.back.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nevu.products.back.entities.Product;

@Repository
public interface ProductRepository  extends CrudRepository<Product, Long> {

	public List<Product> findByUserId(long userId);
	
}
