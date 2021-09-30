package Task3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String [] args) {
		ApplicationContext applicationcontext = new AnnotationConfigApplicationContext(AppConfig.class);
		
		Student student = applicationcontext.getBean(Student.class);
		student.displayStudentInfo();
	}

}
