package com.example.product.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.product.Dto.CategoryDto;
import com.example.product.Payload.CategoryResponse;
import com.example.product.Service.CategoryService;

@CrossOrigin
@RestController
@RequestMapping("/api/v2/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@PostMapping(path = "/add")
	public ResponseEntity<CategoryDto> addCategory(@RequestBody CategoryDto category){
		
		CategoryDto res = categoryService.createCategory(category);
		
		return new ResponseEntity<CategoryDto>(res, HttpStatus.ACCEPTED);
	}
	
	@PostMapping(path = "/remove/{categoryID}")
	public ResponseEntity<String> removeCategory(@PathVariable int categoryID){
		String result = categoryService.removeCategory(categoryID);
//		if(result == "Product Removed")
		return new ResponseEntity<String>(result, HttpStatus.ACCEPTED);
	}

	@PatchMapping(path = "/update/{categoryID}")
	public ResponseEntity<String> updateCategory(@PathVariable int categoryID, @RequestBody CategoryDto catDto){
		String result = categoryService.updateCategory(categoryID, catDto);
//		if(result == "Product Removed")
		return new ResponseEntity<String>(result, HttpStatus.ACCEPTED);
	}
	
	@GetMapping(path = "/getAll/Categories")
	public ResponseEntity<CategoryResponse> getAllCategories(){
		CategoryResponse res = categoryService.getAllCategory();
		return new ResponseEntity<CategoryResponse>(res, HttpStatus.OK);
	}
	
//	@GetMapping(path = "/get/Categories/{categoryID}")
//	public ResponseEntity<CategoryResponse> getByCategoryId(@PathVariable int categoryID){
//		System.out.println(categoryID+" get by Id");
//		CategoryResponse res = categoryService.getByCategoryId();
//		return new ResponseEntity<CategoryResponse>(res, HttpStatus.OK);
//	}
//	
}
