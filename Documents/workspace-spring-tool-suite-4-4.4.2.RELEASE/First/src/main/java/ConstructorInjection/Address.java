package ConstructorInjection;

public class Address {
	private String name;
	
	public Address( String name) {
		super();
		this.name=name;
	}
	
	
	@Override
	public String toString() {
		return "Address details -> name"+name;
		
	}
	

}
