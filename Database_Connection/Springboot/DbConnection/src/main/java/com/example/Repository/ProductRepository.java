package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Pojo.Product;

public interface ProductRepository extends JpaRepository<Product,Integer>{

	Product findByName(String name);
  
}
