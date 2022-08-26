package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.entity.Product;
import com.product.service.UserService;

@RestController
public class Controller {
	
	@Autowired
	private UserService service;
	
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product product) {
		return service.saveProduct(product);
	}
	
	@PostMapping("/addProducts")
	public List<Product> addProducts(@RequestBody List<Product> products){
		return service.saveproducts(products);
	}
	
	@GetMapping("/product")
	public List<Product> findAllProduct(){
		return service.getProducts();
	}
	@GetMapping("/product/{id}")
	public Product findByid(@PathVariable int id) {
		return service.getProdutById(id);
	}

	@PostMapping("/update")
	public Product updateProduct(@RequestBody Product product) {
		return service.updateProduct(product);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleProduct(@PathVariable int id) {
		return service.delproduct(id);
	}
}
