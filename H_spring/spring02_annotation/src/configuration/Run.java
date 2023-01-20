package configuration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Run {
	
	public static void main(String[] args) {
		ApplicationContext context= new AnnotationConfigApplicationContext("configuration");
		Book harryPoter = context.getBean("lon", Book.class);
		System.out.println(harryPoter);
		
		System.out.println("------------------------------------");
		Rent rent = context.getBean("rent",Rent.class);
		rent.info();
		
	}
}
