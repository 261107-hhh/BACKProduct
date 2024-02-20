package com.example.product.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.product.Entity.Category;
import com.example.product.Entity.Product;
import java.util.List;
import java.util.Optional;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	List<Product> findByName(String name);
	
	List<Product> findByCategory(Optional<Category> category);
	
}
