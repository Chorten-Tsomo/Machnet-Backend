package SetterInjection;


public class Student {
	private int id;
	private String name;
	

	//setters and getter
	public void displayInfo() {
		System.out.println(toString());
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
	 

}
