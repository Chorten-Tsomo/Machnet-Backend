package com.example.demo;

public class Address {
	
	private String name;
	
	
	@Override
	public String toString() {
		return "Address details -> name"+name;
		
	}
	
	
	
	public void setName(String name) {
		this.name=name;
		
	}

}
