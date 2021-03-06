package jsr330.test;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import jsr330.model.Employee;
import jsr330.service.EmployeeService;
import jsr330.service.EmployeeServiceImpl;



public class EmployeeJsr330Test {
	public static void main(String[] arg) {
	ApplicationContext context = new ClassPathXmlApplicationContext("jsr330.xml");

    EmployeeService emp = context.getBean("employeeServiceImpl" , EmployeeServiceImpl.class);
    
	Employee employee = context.getBean("idEmployee" , Employee.class);
	
	emp.saveEmployee(employee);
	System.out.println(employee.getSurname());

	}
}
