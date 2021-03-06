package collectionInjection.test;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import collectionInjection.model.CollectionInjection;
import collectionInjection.model.Employee;

public class CollectionInjectionTest {

	public static void main(String[] arg) {

		ApplicationContext context = new ClassPathXmlApplicationContext("collectionInjection.xml");

		CollectionInjection collectionBean = context.getBean("myList", CollectionInjection.class);

		for (String element : collectionBean.getMyListi()) {

			System.out.println(element);

		}

		//CollectionInjection mySet = context.getBean("mySet", CollectionInjection.class);

		for (int element : collectionBean.getMySet()) {

			System.out.println(element);

		}
		
		

		CollectionInjection myMap = context.getBean("myMap", CollectionInjection.class);

		for (Map.Entry<String, Object> element : myMap.getMyMap().entrySet()) {
			
			System.out.println(element.getKey() + " : " + element.getValue());


		}
		
		CollectionInjection myProperties = context.getBean("myProperties", CollectionInjection.class);

		System.out.println(myProperties.getMyProperties());
		
		
		List<Employee> employeess = collectionBean.getEmployeeList();
		employeess.stream().forEachOrdered(System.out::println);
	}

}
