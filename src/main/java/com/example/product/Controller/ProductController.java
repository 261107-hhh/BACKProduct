package com.example.product.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.product.Dto.ProductDto;
import com.example.product.Payload.ProductResponse;
import com.example.product.Service.ProductService;

@CrossOrigin
@RestController
@RequestMapping("api/v2/product")
public class ProductController {
	
//	@Autowired
//	private ModelMapper mapper;
	
//	@Autowired
//	private CategoryService categoryService;
	
	@Autowired
	private ProductService productService;
	
	@PostMapping(path = "/{categoryID}/createProduct")
	public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto, @PathVariable int categoryID){
		System.out.println("THis is add Product");
		ProductDto createProduct = productService.createProduct(productDto, categoryID);
		System.out.println(productDto+" : a");
		System.out.println(createProduct+" : b");
		System.out.println(createProduct.getCategory().getSrno()+" : b Sr");
		System.out.println(createProduct.getCategory().getName()+" : b Name");
		return new ResponseEntity<ProductDto>(createProduct, HttpStatus.CREATED);
			
	}
	

//	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping(path = "/{productID}/deleteProduct")
	public ResponseEntity<String> deleteProduct(@PathVariable int productID){
		String result = productService.removeProduct(productID);
		if(result == "Product Removed")
		return new ResponseEntity<String>(result, HttpStatus.OK);
		else if(result == "Product Not found")	
			return new ResponseEntity<String>(result, HttpStatus.NO_CONTENT);
		else {
			return new ResponseEntity<String>(result, HttpStatus.METHOD_NOT_ALLOWED);
		}
	}
	
	
	@PatchMapping(path = "/{productID}/updateProduct")
	public ResponseEntity<String> updateProduct(@RequestBody ProductDto productDto, @PathVariable int productID){
		String result = productService.getProduct(productID, productDto);
		if(result == "Product Updated")
		return new ResponseEntity<String>(result, HttpStatus.OK);
		else if(result == "No Product Present")	
			return new ResponseEntity<String>(result, HttpStatus.NO_CONTENT);
		else {
			return new ResponseEntity<String>(result, HttpStatus.METHOD_NOT_ALLOWED);
		} 
	}
	
//	@GetMapping("product/")
//	public ProductResponse viewAllProduct(
//
//			@RequestParam(value = "pageNumber", defaultValue = "1", required = false) int pageNumber,
//			@RequestParam(value = "pageSize", defaultValue = "2", required = false) int pageSize,
//			@RequestParam(value = "sortBy", defaultValue = AppConstants.SORT_BY_STRING, required = false) String sortBy,
//			@RequestParam(value = "sortDir", defaultValue = AppConstants.SORT_DIR_STRING, required = false) String sortDir
//
//	) {
//		ProductResponse allproduct = productService.getAllProducts(pageNumber, pageSize, sortBy, sortDir);
//		return allproduct;
//	}
	
	@GetMapping(path = "/getAll/Products")
	public ProductResponse getAllProductList(){
		ProductResponse res = productService.getAllProducts();
		return res;
	}
	
	@GetMapping(path = "/get/Product/{prodID}")
	public ProductDto getProductByID(@PathVariable int prodID){
		ProductDto res = productService.getProductById(prodID);
		return res;
	}
	
	
	@GetMapping(path = "/getAll/{catID}/Products")
	public ProductResponse getAllProductByCategory(@PathVariable int catID){
		ProductResponse res = productService.getAllProductsByCategory(catID);
		return res;
	}
	

}
