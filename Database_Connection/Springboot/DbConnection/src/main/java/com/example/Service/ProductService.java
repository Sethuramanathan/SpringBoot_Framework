package com.example.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Pojo.Product;
import com.example.Repository.ProductRepository;

@Service
public class ProductService {

	
	@Autowired
	private ProductRepository repo;
	
//                  POST MAPPING
//postmapping saving or posting  a single product 	
public Product saveProduct(Product product) {
	return repo.save(product);
}

//postmapping saving or posting many products
public List<Product> saveProducts(List<Product> products){
	return repo.saveAll(products);
}

//                   GET MAPPING

//GETTING MULTIPLE PRODUCTS
public List<Product> getProducts(){
	return repo.findAll();
}

//GETTING SINGLE PRODUCT BY CHOOSING THEIR NAME
public Product getProductbyId(int id) {
	return repo.findById(id).orElse(null);
}

public Product getProductbyName(String Name) {
	return repo.findByName(Name);
}

//                     Delete Mapping

public String deleteProduct(int id) {
	repo.deleteById(id);
	return "the item is deleted suceessfully"+id ;
}
//						Put Mapping

public Product updateProduct(Product productz) {
	Product Existing=repo.findById(productz.getId()).orElse(null);
	Existing.setName(productz.getName());
	Existing.setQty(productz.getQty());
	Existing.setPrice(productz.getPrice());
	return repo.save(Existing);
	
	
}
}
