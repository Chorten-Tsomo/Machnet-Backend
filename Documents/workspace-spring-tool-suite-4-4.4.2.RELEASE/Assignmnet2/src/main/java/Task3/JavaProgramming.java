package Task3;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class JavaProgramming implements Programming {
	@Override
	public void programming() {
		System.out.println("Welcome to programming world");
	}
	

}
