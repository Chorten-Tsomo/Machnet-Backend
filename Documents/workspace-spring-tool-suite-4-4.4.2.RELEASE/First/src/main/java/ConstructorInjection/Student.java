package ConstructorInjection;

import com.example.demo.Address;

public class Student {
	private int id;
	private String name;
	private Address address;
	
	public int getId() {
		return id;
	}
	
	public Student(int id, String name, Address address) {
		super();
		this.id=id;
		this.name=name;
		this.address=address;
	}

	
	@Override
	public String toString() {
		return "Student details -> id "+id+"name"+name;
	}

	public void displayInfo() {
		System.out.println(toString());
		System.out.println(address.toString());
	}

}
