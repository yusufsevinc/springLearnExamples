package stereotype.test;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import stereotype.model.Employee;
import stereotype.service.EmployeeService;
import stereotype.service.EmployeeServiceImpl;



public class EmployeeAutowireTest {
	public static void main(String[] arg) {
	ApplicationContext context = new ClassPathXmlApplicationContext("stereotype.xml");

    EmployeeService emp = context.getBean("employeeServiceImpl" , EmployeeServiceImpl.class);
    
	Employee employee = context.getBean("idEmployee" , Employee.class);
	
	emp.saveEmployee(employee);
	System.out.println(employee.getSurname());

	}
}
