package com.example.product.Entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Size;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer srno;
	
	@Column(unique = true)
	@Size(min = 3, max = 255)
	private String name;
	
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
//	private Set<Product> product = new HashSet<>();

	public Category() {
		super();
	}

	public Category(int srno, String name) {
//		, Set<Product> product
		super();
		this.srno = srno;
		this.name = name;
//		this.product = product;
	}

	public int getSrno() {
		return srno;
	}

	public void setSrno(int srno) {
		this.srno = srno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public Set<Product> getProduct() {
//		return product;
//	}
//
//	public void setProduct(Set<Product> product) {
//		this.product = product;
//	}
	
	

}
