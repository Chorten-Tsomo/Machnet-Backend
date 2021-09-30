package Task3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {
	
	 @Value("${studentid}")
	  private int studentid;

	  @Value("${studentName}")
	  private String studentName;

	   @Value("${company}")
	   private String company;

	   @Autowired
	   private Address address;

	   @Autowired
	   @Qualifier("javaScriptProgramming")
	   private Programming programming;

	    public void displayStudentInfo() {
	        System.out.println("Student id and name is" + "" +studentid+ "" +studentName);
	        
	        address.addressInfo();
	        programming.programming();
	    }
	
	

	
	
	
	

}
