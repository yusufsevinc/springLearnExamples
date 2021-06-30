package javabased.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javabased.configration.JavaBasedConfigration;
import javabased.model.Employee;

public class JavaBasedTest {

	public static void main(String[] args) {
		
		ApplicationContext context = new  AnnotationConfigApplicationContext(JavaBasedConfigration.class);
		
		Employee employee = context.getBean(Employee.class);
		
		
		System.out.println(employee);
	}

}
