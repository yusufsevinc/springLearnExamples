package autowire.test;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import autowire.model.Employee;



public class AutowireTest {
	public static void main(String[] arg) {
	ApplicationContext context = new ClassPathXmlApplicationContext("autowire.xml");

	Employee collectionBean = context.getBean("idEmployee", Employee.class);

	System.out.println(collectionBean);
}
}
