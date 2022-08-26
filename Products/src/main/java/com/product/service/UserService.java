package com.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.entity.Product;
import com.product.repository.ProductRepository;

@Service
public class UserService {

	@Autowired
	private ProductRepository repo;
	
	public Product saveProduct(Product product) {
		return repo.save(product);
	}
	
	public List<Product> saveproducts(List<Product> products) {
		return  repo.saveAll(products);
	}
	
	public List<Product> getProducts(){
		return repo.findAll();
	}
	
	public Product getProdutById(int id){
		return repo.findById(id).orElseThrow(() -> new RuntimeException("CONNOT FOUND"));
	}
	
	public String delproduct(int id) {
		repo.deleteById(id);
		return "Product deleted";
	}
	
	public Product updateProduct(Product product) {
		Product existing=repo.findById(product.getId()).orElse(null);
		existing.setName(product.getName());
		existing.setPrice(product.getPrice());
		existing.setQuantity(product.getQuantity());
		return repo.save(existing);
		
	}
}
