package ConstructorInjection;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;




@SpringBootApplication
public class Main {
	public static void main(String[] args) {
	    ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
			
			
			Student e =(Student)context.getBean("student2");
			e.displayInfo();
		}

}
