package collectionInjection.test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import collectionInjection.model.CollectionInjection;
import collectionInjection.model.CollectionInjectionAnnotation;
import collectionInjection.model.Employee;

public class CollectionInjectionAnnotationTest {

	public static void main(String[] arg) {

		ApplicationContext context = new ClassPathXmlApplicationContext("collectionInjectionAnnotation.xml");

		CollectionInjectionAnnotation collectionBean = context.getBean("collectionInjectionAnnotation1",
				CollectionInjectionAnnotation.class);
		
		
		List<String> myList = collectionBean.getMyList();

		myList.forEach(System.out::println);
		System.out.println();

		Set<Integer> mySet = collectionBean.getMySet();
		mySet.forEach(System.out::println);

}
}