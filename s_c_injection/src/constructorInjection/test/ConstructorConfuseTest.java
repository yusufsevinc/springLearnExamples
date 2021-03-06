package constructorInjection.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import constructorInjection.model.ConstructorConfuse;
import constructorInjection.model.Employee;

public class ConstructorConfuseTest {
public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("constructorInjection.xml");
		
		ConstructorConfuse constructorConfuse = context.getBean("idConstructorConfuse", ConstructorConfuse.class);
		
		System.out.println(constructorConfuse);

	}
}
