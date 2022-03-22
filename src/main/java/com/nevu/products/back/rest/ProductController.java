package com.nevu.products.back.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nevu.products.back.entities.Product;
import com.nevu.products.back.services.ProductService;

@RestController
@CrossOrigin
public class ProductController {

	private ProductService prodServ;
	
	@Autowired
	public ProductController(ProductService prodServ) {
		this.prodServ=prodServ;
	}
	
	@GetMapping("/product/{productId}")
	public Product getProduct(@PathVariable long productId) {
		return prodServ.readProduct(productId);
	}
	
	@GetMapping("/product/user/{userId}")
	public List<Product> getAllProduct(@PathVariable long userId) {
		return prodServ.readAllProductByUserId(userId);
	}
	
	@DeleteMapping("/product/{productId}")
	public void deleteProduct(@PathVariable long productId) {
		prodServ.deleteProduct(productId);
	}
	
	@PostMapping("/product")
	public Product createProduct(@RequestBody Product product) {
		return prodServ.createProduct(product);
	}
	
	@PutMapping("/product/{productId}")
	public void deleteProduct(@PathVariable long productId, @RequestBody Product product) {
		product.setProductId(productId);
		prodServ.updateProduct(product);
	}
	
}
