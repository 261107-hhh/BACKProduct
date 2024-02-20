package com.example.product.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.product.Entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

	
}
