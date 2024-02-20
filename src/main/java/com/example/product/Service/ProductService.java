package com.example.product.Service;

import com.example.product.Dto.ProductDto;
import com.example.product.Entity.Product;
import com.example.product.Payload.ProductResponse;

public interface ProductService {

	public ProductDto createProduct(ProductDto productDto, int categoryID);
	
	public String removeProduct(int id);
	
	public String getProduct(int id, ProductDto productDto);
	
	public ProductResponse getAllProducts();
	
	public ProductDto getProductById(int prodID);

	public ProductResponse getAllProductsByCategory(int catID);
	
}
