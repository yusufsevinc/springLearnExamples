package constructorInjection.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import constructorInjection.model.Employee;



public class EmployerConstructorInjectionTest {
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("constructorInjection.xml");
		Employee employee = context.getBean("idEmployee", Employee.class);
		System.out.println(employee);

	}

}
