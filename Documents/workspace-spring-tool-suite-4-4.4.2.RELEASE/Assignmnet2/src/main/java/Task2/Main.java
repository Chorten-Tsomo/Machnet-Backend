package Task2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Main {
	public static void main(String [] args) {
		AbstractApplicationContext applicationcontext = new AnnotationConfigApplicationContext(AppConfig.class);
		Student details1 = applicationcontext.getBean("student",Student.class);
		Student details2 = applicationcontext.getBean("student",Student.class);
		
		if (details1.hashCode() == details2.hashCode()) {
            System.out.println("Objects are same with hash code respectively: details1-> " + details1.hashCode() + "  details2->   " + details2.hashCode());
        } else {
            System.out.println("Objects are different with hash code respectively: details1-> " + details1.hashCode() + "   details2->   " + details2.hashCode());
        }
	}

}
