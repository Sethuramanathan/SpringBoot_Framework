package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Pojo.Product;
import com.example.Service.ProductService;

@RestController
public class Control {
	@Autowired
	private	ProductService service;
	
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product product) {
		return service.saveProduct(product);
	}
	
	@PostMapping("/addproducts")
	public List<Product> addProducts(@RequestBody List<Product> products){
		return service.saveProducts(products);
	}
	
	
    @GetMapping("/products/{id}")
    public Product findProductById(@PathVariable int id) {
	return service.getProductbyId(id);
}

    @GetMapping("/products/{name}") 
    public Product findProductByName(@PathVariable String name) {
	return service.getProductbyName(name);

}
    
    @PutMapping("/update")
    	public Product updateProduct(@RequestBody Product product) {
    	return service.updateProduct(product);
    }
    
    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
    	return service.deleteProduct(id);
    }
}