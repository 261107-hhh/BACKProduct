package com.example.product.Service.Impl;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.product.Dto.ProductDto;
import com.example.product.Entity.Category;
import com.example.product.Entity.Product;
import com.example.product.Exception.ResourceNotFoundException;
import com.example.product.Payload.ProductResponse;
import com.example.product.Repo.CategoryRepository;
import com.example.product.Repo.ProductRepository;
import com.example.product.Service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository repo;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ModelMapper mapper;
	
	@Override
	public ProductDto createProduct(ProductDto productDto, int categoryID) {
		// TODO Auto-generated method stub
		Category cat = categoryRepository.findById(categoryID).orElseThrow(() -> new ResourceNotFoundException("'"+categoryID+" is not Found"));
		System.out.println("This is category: " +cat.getName());
		Product prod = this.mapper.map(productDto, Product.class);
		prod.setCategory(cat);
		try {
			Product res = this.repo.save(prod);
			System.out.println(prod.getCategory().getName()+" Name");
			System.out.println(prod.getCategory().getSrno()+" Srno");
			System.out.println("THis is try");
			return this.mapper.map(res, ProductDto.class);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("THis is handeled");
			return productDto;
		}
		
	}
	
	@Override
	public String removeProduct(int productID) {
		Product product = repo.findById(productID).orElseThrow(() -> new ResourceNotFoundException("Product Not found"));
		System.out.println("this is found Prod : "+ product.getName());
		try {
			repo.deleteById(productID);
			return "Product Removed";
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception is : "+ e);
			return "Product cannot be removed";
		}
	}

	@Override
	public String getProduct(int id, ProductDto productDto) {
		// TODO Auto-generated method stub
		Product product = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("No Product Present"));
		Product updateData = mapper.map(productDto, Product.class);
		product.setName(updateData.getName());
		product.setDescription(updateData.getDescription());
		product.setImages(updateData.getImages());
		product.setStock(updateData.isStock());
		product.setAvailable(updateData.isAvailable());
		product.setPrice(updateData.getPrice());
		product.setCategory(updateData.getCategory());
		product.setQuantity(updateData.getQuantity());
		product.setVendor(updateData.getVendor());
		try {
			repo.save(product);
			return "Product Updated";
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception is : "+ e);
			return "Product cannot be updated";
		}
//		return "null";
	}
	
	@Override
	public ProductResponse getAllProducts() {
		List<Product> products = repo.findAll();
		ProductResponse res = new ProductResponse();
		List<ProductDto> data = products.stream().map((e) -> mapper.map(e, ProductDto.class)).collect(Collectors.toList());
		res.setProducts(data);
		return res;
	}
	
	
	@Override
	public ProductDto getProductById(int prodID) {
		Optional<Product> prod = repo.findById(prodID);
		
		ProductDto data = mapper.map(prod, ProductDto.class);
		
		return data;
	}

	@Override
	public ProductResponse getAllProductsByCategory(int catID) {
		// TODO Auto-generated method stub
		Optional<Category> category = categoryRepository.findById(catID);
		List<Product> prod = repo.findByCategory(category);
		List<ProductDto> res = prod.stream().map(e -> mapper.map(e, ProductDto.class)).collect(Collectors.toList());
//				.toList();
		ProductResponse data = new ProductResponse();
		data.setProducts(res);
		return data;
	}

}
