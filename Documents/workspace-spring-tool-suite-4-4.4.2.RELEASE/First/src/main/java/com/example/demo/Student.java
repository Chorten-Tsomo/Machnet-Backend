package com.example.demo;

public class Student {
private int id;
private String name;
private Address address;

//setters and getter
public void displayInfo() {
	System.out.println(toString());
	System.out.println(address.toString());
}

@Override
public String toString() {
	return "Student details -> id "+id+"name"+name;
}

public void setId(int id) {
	this.id=id;
}

public void setName(String name) {
	this.name=name;
}
 public void setAddress(Address address) {
	 this.address=address;
 }



}
