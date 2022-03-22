package com.nevu.products.back.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nevu.products.back.entities.Product;
import com.nevu.products.back.repositories.ProductRepository;

@Service
public class ProductService {

	private ProductRepository productRepo;
	
	@Autowired
	public ProductService(ProductRepository productRepo) {
		this.productRepo=productRepo;
	}
	
	public Product createProduct(Product productModel) {
		return productRepo.save(productModel);
	}
	
	public Product readProduct(long prodId) {
		return productRepo.findById(prodId).get();
	}
	
	public Product updateProduct(Product prod) {
		return productRepo.save(prod);
	}
	
	public void deleteProduct(long prodId) {
		productRepo.deleteById(prodId);
	}
	
	public List<Product> readAllProducts(){
		return (List<Product>) productRepo.findAll();
	}
	
	public List<Product> readAllProductByUserId(long userId){
		return productRepo.findByUserId(userId);
	}
	
}
