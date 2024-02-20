package com.example.product.Dto;

public class CategoryDto {

	private int srno;
	private String name;
	
	public CategoryDto() {
		super();
	}
	
	public CategoryDto(int srno, String name) {
		super();
		this.srno = srno;
		this.name = name;
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
	
}
