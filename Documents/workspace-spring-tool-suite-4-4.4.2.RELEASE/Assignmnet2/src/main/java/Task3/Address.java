package Task3;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Address {
	 @Value("${addressId}")
	  private int addressId;
	  @Value("${addressName}")
	   private String addressName;

	    public void addressInfo(){
	        System.out.println("The address id and name is" + " " + addressId + " " + addressName);
	    }
}
