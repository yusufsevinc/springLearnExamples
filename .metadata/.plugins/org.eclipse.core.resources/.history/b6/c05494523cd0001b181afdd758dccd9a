package setterInjection.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import setterInjection.model.Employee;

public class EmployerSetterInjectionTest {
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("setterInjection.xml");
		Employee employee = context.getBean("idEmployee", Employee.class);
		System.out.println(employee.getAddress());

	}

}
